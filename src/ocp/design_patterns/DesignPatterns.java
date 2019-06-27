package ocp.design_patterns;

import java.util.Arrays;

public class DesignPatterns {

    public static void main(String[] args) {
        DesignPatterns dp = new DesignPatterns();
        dp.usingImmutableClasses();
        dp.usingBuilders();
    }

    private void usingImmutableClasses() {
        System.out.println("----- Using immutable classes -----");
        Animal dog = new Animal("Mammal", 5, Arrays.asList("Cookies", "Meet"));
        System.out.println(String.format("Dog is a %s is %s years old and loves %s and %s other kinds of food", dog.getSpecies(), dog.getAge(), dog.getFavouriteFood().get(0), dog.getFavouriteFood().size() - 1));
        // Even if we clear the list, that won't affect the Animal object since Animal is an immutable class.
        // dog.getFavouriteFood() gets a copy of the favouriteFood list in the Animal instance
        dog.getFavouriteFood().clear();
        System.out.println(String.format("Dog still loves %s kinds of food ", dog.getFavouriteFood().size()));
        System.out.println("-----------------------------------");
    }

    private void usingBuilders() {
        System.out.println("----- Using builder classes -----");
        Animal.AnimalBuilder builder = new Animal.AnimalBuilder();
        Animal cat = builder.setSpecies("Mammal").setAge(3).setFavouriteFood(Arrays.asList("tuna", "milk")).build();
        System.out.println(String.format("cat is a %s is %s years old and loves %s and %s other kinds of food", cat.getSpecies(), cat.getAge(), cat.getFavouriteFood().get(0), cat.getFavouriteFood().size() - 1));
        // Even if we clear the list, that won't affect the Animal object since Animal is an immutable class.
        // dog.getFavouriteFood() gets a copy of the favouriteFood list in the Animal instance
        cat.getFavouriteFood().clear();
        System.out.println(String.format("cat still loves %s kinds of food ", cat.getFavouriteFood().size()));
        System.out.println("-----------------------------------");
    }
}

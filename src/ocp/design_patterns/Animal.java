package ocp.design_patterns;

// Immutable classes:
// are classes that won't change their attribute's values after it is created.
// A read only class

import java.util.ArrayList;
import java.util.List;

// We apply the final modifier in order to not allow other classes to extend from it and modify its behavior.
final class Animal {

    //All attributes should be private
    private String species;
    private Integer age;
    private List<String> favouriteFood;

    // The constructor it's the only mean to set the attribute's values
    // If we use a builder to create immutable classes instances, it is recommended to define the constructor as private or default access
    Animal(String species, Integer age, List<String> favouriteFood) {
        this.species = species;
        this.age = age;
        // In order to avoid having external references to objects used to initialize an Immutable class, we should make copies of non immutable objects before setting them to immutable classes attributes.
        this.favouriteFood = new ArrayList<>(favouriteFood); // Doesn't use the reference given in favouriteFood argument
        // this.favouriteFood = favouriteFood; // Not an immutable class. This allows external access to favouriteFood attribute
    }

    // Immutable classes has no setters

    // Getters

    String getSpecies() {
        return species;
    }

    Integer getAge() {
        return age;
    }

    List<String> getFavouriteFood() {
        // return favouriteFood; // Not an immutable classes. This allows external access to favoriteFooudd attribute
        // Returning a copy of the list  will assure that no modification should affect the current state of the Animal instance
        return new ArrayList<>(this.favouriteFood);
    }



    // Builder is another creational pattern that allows us to create more properly instances of immutable classes
    static class AnimalBuilder{

        private String species;
        private Integer age;
        private List<String> favouriteFood;

        AnimalBuilder() {
        }

        public AnimalBuilder setSpecies(String species) {
            this.species = species;
            return this;
        }

        public AnimalBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public AnimalBuilder setFavouriteFood(List<String> favouriteFood) {
            this.favouriteFood = favouriteFood;
            return this;
        }

        // This will interact directly with the Animal (immutable) class constructor
        public Animal build(){
            // Validations go here

            if(this.age <0){
                throw new IllegalArgumentException("Age should be a positive integer");
            }

            if(this.favouriteFood == null || this.favouriteFood.isEmpty()){
                throw new IllegalArgumentException("A list of food should be provided");
            }

            return new Animal(this.species, this.age, this.favouriteFood);
        }
    }

}

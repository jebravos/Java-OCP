package ocp.design_patterns;

import ocp.utils.CommonUtils;

import static ocp.utils.CommonUtils.println;

public class UsingFactoryPattern{


    public static void main(String[] args) {
        // The program delegates the complexity of creating objects to the factory.
        final Food food = FoodFactory.getFood("Lion");
        food.consumed();

    }
}

abstract class Food {

    private Integer quantity;

    // Using default (package) access modifier forces any class outside the package to use our factory class for creating nex instances of Food.
    Food(Integer quantity) {
        this.quantity = quantity;
    }

    Integer getQuantity() {
        return quantity;
    }

    public abstract void consumed();
}

class Tuna extends Food{

    Tuna(Integer quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        CommonUtils.println("Tuna eaten: " + getQuantity());
    }
}

class Milk extends Food{

    Milk(Integer quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        println("Milk drunk: {}", getQuantity());
    }
}

class Meet extends Food{

     Meet(Integer quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        println("Meet eaten: {}",  getQuantity());
    }
}


// Factory pattern is used to encapsulate object creation to deal with complexity of object creation such as selecting the subclass to use as well as loosly coupling the underlying creation implementation
class FoodFactory{

    // Factory classes usually use an static method to return the requested instance depending on the used parameters.
    // The complexity of object creation is managed inside this method.
    static Food getFood(String animalName){
        switch(animalName){
            case "cat":
                return new Tuna(3);
            case "Lion":
                return new Meet(10);
            case "dog":
                return new Meet(4);
                default:
                    throw new UnsupportedOperationException("Animal " + animalName + " not supported");
        }
    }

}




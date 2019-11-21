package com.bravo.ocp.collections_and_generics;

import static com.bravo.ocp.utils.PrintUtils.println;

public class TestsGenerics {
    public static void main(String[] args) {
        TestsGenerics test = new TestsGenerics();
        test.testGenericClasses();

        test.testGenericMethods();


    }

    private void testGenericClasses() {
        Crate<Elephant> crateForElephant = new Crate<>();
        crateForElephant.packCrate(new Elephant("Dumbo"));
        println(crateForElephant.emptyCrate().getName() + " is leaving its crate");
        // The following wont work since Giraffe is not a Elephant
        // CrateForElephant.packCrate(new Giraffe("Giffy"));
        Crate<Giraffe> crateForGiraffe = new Crate<>();
        crateForGiraffe.packCrate(new Giraffe("Giphy"));
        println(crateForGiraffe.emptyCrate().getName() + " is leaving its crate");
        // In the same way; the following doesn(t work since Elephant is not a Giraffe
        // crateForGiraffe.packCrate(new Elephant("Dumbo2"));

        //
        SizeLimitedCrate<Elephant, Long> limitedElephantCrate = new SizeLimitedCrate<>(new Elephant("Dumbo3"), 15_000L);
        //
        ShippableRobotCrate robotCrate = new ShippableRobotCrate();
        robotCrate.ship(new Robot("R2D2"));
        //
        ShippableAbstractCrate<Robot> abstractRobotCrate = new ShippableAbstractCrate<>();
        abstractRobotCrate.ship(new Robot("C3PO"));

    }

    private void testGenericMethods(){
        ship(new Elephant("Elly"));
    }

    // Generic methods
    // <T> it declares the formal type parameter that is going to be used. If not present, code won't compile
    private static <T> Crate<T> ship(T t){
        println("shipping " + t);
        Crate<T> crate = new Crate<>();
        crate.packCrate(t);
        return crate;
    }
}

class Elephant {
    private String name;

    Elephant(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Giraffe {
    private String name;

    Giraffe(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class Robot {
    private String name;

    Robot(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

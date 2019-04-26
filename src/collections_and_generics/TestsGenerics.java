package collections_and_generics;

public class TestsGenerics {
    public static void main(String[] args) {
        TestsGenerics test = new TestsGenerics();
        test.testGenericClasses();

        test.testGenericMethods();


    }

    public void testGenericClasses() {
        Crate<Elephant> crateForElephant = new Crate<>();
        crateForElephant.packCrate(new Elephant("Dumbo"));
        System.out.println(crateForElephant.emptyCrate().getName() + " is leaving its crate");
        // The following wont work since Giraffe is not a Elephant
        // CrateForElephant.packCrate(new Giraffe("Giffy"));
        Crate<Giraffe> crateForGiraffe = new Crate<>();
        crateForGiraffe.packCrate(new Giraffe("Giphy"));
        System.out.println(crateForGiraffe.emptyCrate().getName() + " is leaving its crate");
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

    public void testGenericMethods(){
        ship(new Elephant("Elly"));
    }

    // Generic methods
    // <T> it is declare the formal type parameter that is going to be used. If not present, code won't compile
    public static <T> Crate<T> ship(T t){
        System.out.println("shipping " + t);
        Crate<T> crate = new Crate<>();
        crate.packCrate(t);
        return crate;
    }
}

class Elephant {
    private String name;

    public Elephant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Giraffe {
    private String name;

    public Giraffe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Robot {
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

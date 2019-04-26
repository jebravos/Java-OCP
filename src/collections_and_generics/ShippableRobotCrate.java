package collections_and_generics;

// Classes can implements generic interfaces and specify a generic type in class
public class ShippableRobotCrate implements Shippable<Robot> {
    @Override
    public void ship(Robot robot) {
        System.out.println("Shipping " + robot.getName()  + "...");
    }
}

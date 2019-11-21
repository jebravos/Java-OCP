package com.bravo.ocp.collections_and_generics;

import static com.bravo.ocp.utils.PrintUtils.println;

// Classes can implements generic ocp.interfaces and specify a generic type in class
public class ShippableRobotCrate implements Shippable<Robot> {
    @Override
    public void ship(Robot robot) { println("Shipping {} ..." , robot.getName());
    }
}

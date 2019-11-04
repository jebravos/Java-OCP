package com.bravo.ocp.filosophers;

public class DinningSeat {

    private final Stick leftStick;
    private final Stick rightStick;

    public DinningSeat(Stick leftStick, Stick rightStick) {
        this.leftStick = leftStick;
        this.rightStick = rightStick;
    }

    public Stick getLeftStick() {
        return leftStick;
    }

    public Stick getRightStick() {
        return rightStick;
    }

    @Override
    public String toString() {
        return "DinningSeat{" +
                "leftStick=" + leftStick +
                ", rightStick=" + rightStick +
                '}';
    }
}

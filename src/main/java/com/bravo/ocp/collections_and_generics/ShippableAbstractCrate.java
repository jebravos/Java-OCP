package com.bravo.ocp.collections_and_generics;

// Classes can implement Generic interfaced
public class ShippableAbstractCrate<T> implements Shippable<T> {
    @Override
    public void ship(T t) {
        System.out.println("Shipping generically " + toString() + "...");
    }
}

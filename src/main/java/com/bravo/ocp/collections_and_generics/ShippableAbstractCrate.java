package com.bravo.ocp.collections_and_generics;

import static com.bravo.ocp.utils.PrintUtils.println;

// Classes can implement Generic interfaced
public class ShippableAbstractCrate<T> implements Shippable<T> {
    @Override
    public void ship(T t) {
        println("Shipping generically {} ...", toString());
    }
}

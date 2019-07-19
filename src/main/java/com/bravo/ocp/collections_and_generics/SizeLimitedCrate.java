package com.bravo.ocp.collections_and_generics;

// Generic classes can specify multiple generic types
class SizeLimitedCrate<T, U> {

    private T content;
    private U sizeLimit;

    SizeLimitedCrate(T content, U sizeLimit) {
        this.content = content;
        this.sizeLimit = sizeLimit;
    }
}

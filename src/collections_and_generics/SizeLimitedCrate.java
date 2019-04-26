package collections_and_generics;

// Generic classes can specify multiple generic types
public class SizeLimitedCrate<T, U> {

    private T content;
    private U sizeLimit;

    public SizeLimitedCrate(T content, U sizeLimit) {
        this.content = content;
        this.sizeLimit = sizeLimit;
    }
}

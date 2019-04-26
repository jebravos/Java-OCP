package collections_and_generics;

// Generic classes declare a formal type parameter in <>
// the generic type T will be available anywhere in the class
// Naming conventions:
// ■ ■ E for an element
// ■ ■ K for a map key
// ■ ■ V for a map value
// ■ ■ N for a number
// ■ ■ T for a generic data type
// ■ ■ S , U , V , and so forth for multiple generic types
public class Crate<T> {

    // T could represent any type of object
    private T content;

    // You can't call a constructor on T
    // private T content =  new T();

    // You cannot create a static variable as a generic type parameter. Not allowed because type is linked to the instance of the class
    // public static T s;


    public void packCrate(T content) {
        this.content = content;
    }

    public T emptyCrate(){
        T gettingOut = content;
        content = null;
        return  gettingOut;
    }

}

//    Type Erasure
//    Specifying a generic type allows the compiler to enforce proper use of the generic type.
//        For example, specifying the generic type of Crate as Robot is like replacing the T in the
//        Crate class with Robot . However, this is just for compile time.
//        Behind the scenes, the compiler replaces all references to T in Crate with Object . In other
//        words, after the code compiles, your generics are actually just Object types.
//
//    This process of removing the generics syntax from your code is referred to as type
//        erasure. Type erasure allows your code to be compatible with older versions of Java
//        that do not contain generics
//    The compiler adds the relevant casts for your code to work with this type of erased
//        class. For example, you type


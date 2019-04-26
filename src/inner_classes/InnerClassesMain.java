package inner_classes;

// Static inner classes can be imported with a regular import or with an  import static since the class is static
//import inner_classes.ClassWithInnersClasses.StaticMemberClass; // This will work if it is uncomented
import static inner_classes.ClassWithInnersClasses.StaticMemberClass;

public class InnerClassesMain {

    public static void main(String[] args) {

        ClassWithInnersClasses cwic = new ClassWithInnersClasses();
        System.out.println(cwic.getHello());

        // We access to the class type though the outer class
        // We create the inner class instance through the new operator in the Outer class instance
        ClassWithInnersClasses.MemberInnerClass innerClass =  cwic.new MemberInnerClass();
        System.out.println(innerClass.getHello());
        // Member inner classes can access outer members
        System.out.println(innerClass.getOuterHello());
        System.out.println(innerClass.getOtherMember());

        // Anonymous inner classes
        System.out.println(cwic.methodWithAnonymousInnerClass());

        //Static inner classes does not need an instance of the outer class in order to be instantiated
        StaticMemberClass smc = new StaticMemberClass();
        System.out.println(smc.sayHello());
        //Outher classes can access to static inner classes members even they're definend as private
        System.out.println(cwic.accesToStaticInnerClassMembers());
    }
}

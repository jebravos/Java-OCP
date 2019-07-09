package ocp.inner_classes;

// Static inner classes can be imported with a regular import or with an  import static since the class is static
//import ocp.inner_classes.ClassWithInnersClasses.StaticMemberClass; // This will work if it is uncommented
import static ocp.inner_classes.ClassWithInnersClasses.StaticMemberClass;
import static ocp.utils.PrintUtils.println;

public class InnerClassesMain {

    public static void main(String[] args) {

        ClassWithInnersClasses classWithInnersClasses = new ClassWithInnersClasses();
        println(classWithInnersClasses.getHello());

        // We access to the class type through the outer class
        // We create the inner class instance through the new operator in the Outer class instance
        // ClassWithInnersClasses instance is required to create a MemberInnerClass instance
        ClassWithInnersClasses.MemberInnerClass innerClass =  classWithInnersClasses.new MemberInnerClass();
        println(innerClass.getHello());
        // Member inner classes can access outer members
        println(innerClass.getOuterHello());
        println(innerClass.getOtherMember());

        // Anonymous inner classes
        println(classWithInnersClasses.methodWithAnonymousInnerClass());

        //Static inner classes does not need an instance of the outer class in order to be instantiated
        StaticMemberClass smc = new StaticMemberClass();
        println(smc.sayHello());
        //Outer classes can access to static inner classes members even they're defined as private
        println(classWithInnersClasses.accessToStaticInnerClassMembers());

        //
        classWithInnersClasses.methodWithLocalInnerClass();
    }
}

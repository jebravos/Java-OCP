package com.bravo.ocp.inner_classes;

// Static inner classes can be imported with a regular import or with an  import static since the class is static
//import ClassWithInnersClasses.StaticMemberClass; // This will work if it is uncommented
import com.bravo.ocp.utils.PrintUtils;

import static com.bravo.ocp.utils.PrintUtils.println;

public class InnerClassesMain {

    public static void main(String[] args) {

        ClassWithInnersClasses classWithInnersClasses = new ClassWithInnersClasses();
        PrintUtils.println(classWithInnersClasses.getHello());

        // We access to the class type through the outer class
        // We create the inner class instance through the new operator in the Outer class instance
        // ClassWithInnersClasses instance is required to create a MemberInnerClass instance
        ClassWithInnersClasses.MemberInnerClass innerClass =  classWithInnersClasses.new MemberInnerClass();
        PrintUtils.println(innerClass.getHello());
        // Member inner classes can access outer members
        PrintUtils.println(innerClass.getOuterHello());
        PrintUtils.println(innerClass.getOtherMember());

        // Anonymous inner classes
        PrintUtils.println(classWithInnersClasses.methodWithAnonymousInnerClass());

        //Static inner classes does not need an instance of the outer class in order to be instantiated
        ClassWithInnersClasses.StaticMemberClass smc = new ClassWithInnersClasses.StaticMemberClass();
        PrintUtils.println(smc.sayHello());
        //Outer classes can access to static inner classes members even they're defined as private
        PrintUtils.println(classWithInnersClasses.accessToStaticInnerClassMembers());

        //
        classWithInnersClasses.methodWithLocalInnerClass();
    }
}

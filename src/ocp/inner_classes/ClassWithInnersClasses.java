package ocp.inner_classes;


import static ocp.utils.PrintUtils.println;

public class ClassWithInnersClasses {


    private final static String staticVariable = "STATIC";
    private String hello = "hello from outer class";
    private String otherMember = "This is other outer member";

    // This method contains a local inner class
    public String methodWithLocalInnerClass() {
        int nonFinalInt = 0;
        nonFinalInt = 1;
        // Local inner class are defined within a method
        class LocalInnerClass {
            private String hello = "hello from local inner class";

            private void useOuterStaticVariable() {
                println("Outer static variable being used from an inner class: {}", staticVariable);
            }

            private void useNonFinalLocalVariable() {
                println("Local inner classes can't use non final or non effectively final local variables");
//                println("this is not a final nor effectively final variable: {}", nonFinalInt);
            }
        }

        //A local inner class cannot be created outside the method where it was defined
        LocalInnerClass lic = new LocalInnerClass();
        lic.useOuterStaticVariable();
        lic.useNonFinalLocalVariable();
        return lic.hello;
    }

    static String staticMethodWithInnerClass(){
        int nonFinalInt = 0;
        nonFinalInt = 1;
        // Local inner class are defined within a method
        class LocalInnerClassInStaticMethod {
            private String hello = "hello from local inner class";

            private void useOuterStaticVariable() {
                println("Outer static variable being used from a local inner class: {}", staticVariable);
            }

            private void useNonStaticOuterVariable(){
                println("Non static field otherMember cannot be referenced form a static context");
//                println("Non static outer variable being used from a local inner class{}", otherMember);
            }

            private void useNonFinalLocalVariable() {
                println("Local inner classes can't use non final or non effectively final local variables");
//                println("this is not a final nor effectively final variable: {}", nonFinalInt);
            }
        }

        //A local inner class cannot be created outside the method where it was defined
        LocalInnerClassInStaticMethod lic = new LocalInnerClassInStaticMethod();
        lic.useOuterStaticVariable();
        lic.useNonFinalLocalVariable();
        lic.useNonStaticOuterVariable();
        return lic.hello;
    }

    String methodWithAnonymousInnerClass() {
        // Anonymous inner classes are  used to extend abstract classes or implement instances. They're useful when we have short implementations that will not be used anywhere else
        OtherInnerClass ic = new OtherInnerClass() {

            @Override
            String sayHello() {
                return "Hello from Anonymous inner class inside ClassWithInnersClasses method ";
            }
        };

        return ic.sayHello();
    }

    String accessToStaticInnerClassMembers() {
        StaticMemberClass simc = new StaticMemberClass();
        // The outer class can access to the StaticMemberClass ever they are defined as private
        return simc.hello;
    }

    public String getHello() {
        return hello;
    }

    // Static inner class does not need an instance of the outer class in order to be instantiated
    static class StaticMemberClass {
        private String hello = "Hello from static inner class";

        public String sayHello() {
            return hello;
        }

    }

    // The next line does not work since the  LocalInnerClass is a local inner class defined inside the methodWithLocalInnerClass method.
//    private  LocalInnerClass lic;

    // An inner class can extends from the outer class
    class ExtendsFromClassWithInnerClasses extends ClassWithInnersClasses {
    }

    // Member inner classes are not static
    class MemberInnerClass {

        private String hello = "hello from inner class";

        public String getHello() {
            return hello;
        }

        // Member Inner classes can access outer members even if these are defined as private
        String getOtherMember() {
            return otherMember;
        }

        String getOuterHello() {
            // This is how it is done when inner member has a common name with an outer member
            return ClassWithInnersClasses.this.hello;
        }

    }

    abstract class OtherInnerClass {
        abstract String sayHello();
    }
}

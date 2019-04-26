package inner_classes;


public class ClassWithInnersClasses {

    private String hello = "hello from outer class";
    private String otherMember = "This is other outer member";

    // Member inner classes are not static
    class MemberInnerClass {

        private String hello = "hello from inner class";

        public String getHello() {
            return hello;
        }

        // Member Inner classes can access outer members even if these are defined as private
        public String getOtherMember() {
            return otherMember;
        }

        public String getOuterHello() {
            // This is how it is done when inner member has a common name with an outer member
            return ClassWithInnersClasses.this.hello;
        }

    }

    abstract class OtherInnerClass {
        abstract String sayHello();
    }

    // Static inner class does not need an instance of the outer class in order to instantiated
    static class StaticMemberClass {
        private String hello = "Hello from static inner class";

        public String sayHello() {
            return hello;
        }

    }

    // This method contains a local inner class
    public String methodWithLocalInnerClass() {

        // Local inner class are defined within a method
        class LocalInnerClass {
            private String hello = "hello from local inner class";
        }

        //A local inner class cannot be created outside the method where it was defined
        LocalInnerClass lic = new LocalInnerClass();
        return lic.hello;
    }

    // The next line does not work since the  LocalInnerClass is a local inner class defined inside the methodWithLocalInnerClass method.
//    private  LocalInnerClass lic;


    public String methodWithAnonymousInnerClass() {
        // Anonymous inner classes are  used to extend abstract classes or implement instances. They're useful when we have short implementations that will not be used anywhere else
        OtherInnerClass ic = new OtherInnerClass() {

            @Override
            String sayHello() {
                return "Hello from Anonymous inner class inside ClassWithInnersClasses method ";
            }
        };

        return ic.sayHello();
    }

    public String accesToStaticInnerClassMembers() {
        StaticMemberClass simc = new StaticMemberClass();
        // The outer class can access to the StaticMemberClass ever theyr are defined as private
        return simc.hello;
    }

    public String getHello() {
        return hello;
    }
}

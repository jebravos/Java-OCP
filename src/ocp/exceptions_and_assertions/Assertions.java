package ocp.exceptions_and_assertions;

public class Assertions {

    public static void main(String[] args) {
        Assertions assertions = new Assertions();
        assertions.tryWithoutCatchBlock();
        assertions.tryCatchingAnException();
    }


    private void  tryWithoutCatchBlock() {
        // a try block without a catch block requires a finally block
        // otherwise compilation error
        try {
            System.out.println("hello from exceptions");
        } finally {
            System.out.println("hello from finally");
        }
    }

    private void tryCatchingAnException(){
        try {
            throwAnException();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void throwAnException() throws Exception {
        throw new Exception("new exception!");
    }

}

package ua.ithillel.exception;

public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            //do job
            throw new RuntimeException();
        } catch (NumberFormatException e) {

        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("я завжди викликаюсь");
        }
    }

    public void demo() {
//        throw new MyException("My exception");
    }

}

import org.junit.Test;

public class TryCatchFinallly {

    @Test
    public void name() throws Exception {

        try {
            System.out.println("try");
            somemethod();
            throwRuntimeException();
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }

    }

    @Test
    public void autoclosableTest() {
//        TryWithReources tryWithReources = new TryWithReources();
        try (TryWithReources tryWithReources = new TryWithReources()) {
            System.out.println("try");
//            return;
//            throwRuntimeException();
        }
        catch (Exception e) {
            System.out.println("catch");
        }
//        finally {
//            System.out.println("finally");
//        }
    }

    void somemethod() {
        try {
            System.out.println("somemethod - try");
//            throwRuntimeException();
            return;
        } catch (Exception e) {
            System.out.println("somemethod - catch");
            return;
        } finally {
            System.out.println("somemethod - finally");
            return;
        }

    }

    void throwRuntimeException() {
        throw new RuntimeException();
    }

    class TryWithReources implements AutoCloseable {
        private long id;

        @Override
        public void close() throws Exception {
            System.out.println("close");
        }

    }

}

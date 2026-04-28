package di;

public final class TestContextHolder {

    private static final ThreadLocal<TestContext> CTX =
            ThreadLocal.withInitial(TestContext::new);

    private TestContextHolder() {}

    public static TestContext get() {
        return CTX.get();
    }

    public static void clear() {
        CTX.remove();
    }
}
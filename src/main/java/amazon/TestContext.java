package amazon;

public class TestContext {
    public static ThreadLocal<Boolean> isMobile = ThreadLocal.withInitial(() -> false);
}

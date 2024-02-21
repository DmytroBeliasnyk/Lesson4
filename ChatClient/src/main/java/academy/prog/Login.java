package academy.prog;

public class Login {
    private static String to = null;

    public static String get() {
        return to;
    }

    public static void set(String to) {
        Login.to = to;
    }
}

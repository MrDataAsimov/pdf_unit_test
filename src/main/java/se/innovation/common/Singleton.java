package se.innovation.common;

public class Singleton {

    private static Singleton singleton;
    private static Boolean isFalseStatic;
    private boolean isFalse;

    private Singleton() {
        isFalse = false;
    }

    public static Singleton instance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static Boolean isIsFalseStatic() {
        if (isFalseStatic == null) {
            isFalseStatic = new Boolean(false);
        }
        return isFalseStatic;
    }

    public static void setIsFalseStatic(boolean isFalseStatic) {
        Singleton.isFalseStatic = isFalseStatic;
    }

    public boolean isFalse() {
        return isFalse;
    }
}

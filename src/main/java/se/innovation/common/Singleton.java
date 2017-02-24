package se.innovation.common;

public class Singleton {

    private Singleton singleton;

    private boolean isFalse;

    private Singleton() {
        isFalse = false;
    }

    public Singleton instance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }

    public boolean isFalse() {
        return isFalse;
    }
}

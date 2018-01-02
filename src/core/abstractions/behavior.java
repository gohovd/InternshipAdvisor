package core.abstractions;

public enum behavior {
    Excellent, Good, Moderate, Low, Very_Low;

    @Override
    public String toString() {
        switch(this) {
            case Excellent: return "9-10";
            case Good: return "7-8";
            case Moderate: return "5-6";
            case Low: return "3-4";
            case Very_Low: return "1-2";
            default: throw new IllegalArgumentException();
        }
    }
}

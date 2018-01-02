package core;

public enum Priority {
    Critical, High, Medium, Low, Negligible;

    @Override
    public String toString() {
        switch(this) {
            case Critical: return "Absolutely essential, cannot be left out.";
            case High: return "Very important, but can in special cases be left out.";
            case Medium: return "Of importance, but neither essential nor negligible.";
            case Low: return "Does not carry much importance.";
            case Negligible: return "Not really important at all, can be left out.";
            default: throw new IllegalArgumentException();
        }
    }
}

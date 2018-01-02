package core.abstractions;

/**
 * IQ Classifications in Educational Use
 * (http://www.assessmentpsychology.com/iqclassifications.htm)
 */
public enum iq {
    Very_Superior, Superior, High_Average, Average,
    Low_Average, Borderline, Extremely_Low;

    @Override
    public String toString() {
        switch(this) {
            case Very_Superior: return "130 and above";
            case Superior: return "120-129";
            case High_Average: return "110-119";
            case Low_Average: return "80-89";
            case Borderline: return "70-79";
            case Extremely_Low: return "69 and below";
            default: throw new IllegalArgumentException();
        }
    }
}
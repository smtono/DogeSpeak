package Interpreter;

public class GenericNumber {
    private final double value;

    public GenericNumber() {this.value = 0;}
    public GenericNumber(double value) {
        this.value = value;
    }

    // ARITHMETIC OPERATIONS
    public GenericNumber plus(double other) {
        return new GenericNumber(value + other);
    }

    public GenericNumber minus(double other) {
        return new GenericNumber(value - other);
    }

    public GenericNumber times(double other) {
        return new GenericNumber(value * other);
    }

    public GenericNumber dividedBy(double other) {
        return new GenericNumber(value / other);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

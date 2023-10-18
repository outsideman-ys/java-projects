public class Parallelogram implements Figure {
    private final double a;
    private final double h;

    Parallelogram(double a, double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public double getArea() {
        return a * h;
    }

}
package Classes;

public class RightTriangle extends Triangle {

    public RightTriangle(int x1, int x2, int x3, int y1, int y2, int y3) {
        super(x1, x2, x3, y1, y2, y3);
    }

    public static boolean isTriangleRight(int x1, int x2, int x3, int y1, int y2, int y3) {

        double sideA = getSideLength(x1, y1, x2, y2);
        double sideB = getSideLength(x3, y3, x2, y2);
        double sideC = getSideLength(x1, y1, x3, y3);

        return (sideA + sideB > sideC) && (sideB + sideC > sideA) && (sideA + sideC > sideB) && (sideA > 0) && (sideB > 0) && (sideC > 0) && ((sideA * sideA + sideB * sideB == sideC * sideC) || (sideB * sideB + sideC * sideC == sideA * sideA) || (sideA * sideA + sideC * sideC == sideB * sideB));
    }

    @Override
    public String toString() {
        return "Right" + super.toString();
    }
}

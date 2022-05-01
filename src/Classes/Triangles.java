package Classes;

public class Triangles {

    final private Triangle[] triangles;
    private int currentTrianglesNumber;

    public Triangles(final int triangleNumber) {

        this.triangles = new Triangle[triangleNumber];
        currentTrianglesNumber = -1;
    }

    public void addTriangle(Triangle triangle) {
        if (++currentTrianglesNumber < triangles.length) {
            triangles[currentTrianglesNumber] = triangle;
        }

    }

    public Triangle findMaxAreaOfTriangle() {

        Triangle maxTriangleArea = triangles[0];
        for (int i = 1; i < triangles.length; i++) {
            if (triangles[i].getArea() >= maxTriangleArea.getArea()) {
                maxTriangleArea = triangles[i];
            }
        }
        return maxTriangleArea;
    }

    public Triangle findMinAreaOfTriangle() {
        Triangle minTriangleArea = triangles[0];
        for (int i = 1; i < triangles.length; i++) {
            if (triangles[i].getArea() <= minTriangleArea.getArea()) {
                minTriangleArea = triangles[i];
            }
        }
        return minTriangleArea;
    }

    public String findIdenticalTriangles() {

        String numberOfIdenticalTriangles = " ";
        Triangle IdenticalTriangle = triangles[0];
        int count = 0;
        for (int i = 1; i < triangles.length; i++) {

            if ((triangles[i].getLengthA()) == (IdenticalTriangle.getLengthA()) && (triangles[i].getLengthB()) == (IdenticalTriangle.getLengthB()) && ((triangles[i].getLengthC()) == (IdenticalTriangle.getLengthC()))) {
                count++;
                if (count == 1) {
                    numberOfIdenticalTriangles += i + " ";
                }
                numberOfIdenticalTriangles += i + 1 + " ";
            }
            IdenticalTriangle = triangles[i];
        }
        return numberOfIdenticalTriangles;
    }


    @Override
    public String toString() {
        String result = "Triangles: " + System.lineSeparator();
        for (int i = 0; i < triangles.length; i++) {

            result += triangles[i] + System.lineSeparator();
        }
        return result;
    }


}

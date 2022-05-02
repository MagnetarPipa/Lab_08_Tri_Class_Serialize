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

    public Triangle findTriangleMaxSquare() {

        Triangle maxTriangleArea = triangles[0];
        for (int i = 1; i < triangles.length; i++) {
            if (triangles[i].getArea() > maxTriangleArea.getArea()) {
                maxTriangleArea = triangles[i];
            }
        }
        return maxTriangleArea;
    }

    public Triangle findTriangleMinSquare() {
        Triangle minTriangleArea = triangles[0];
        for (int i = 1; i < triangles.length; i++) {
            if (triangles[i].getArea() < minTriangleArea.getArea()) {
                minTriangleArea = triangles[i];
            }
        }
        return minTriangleArea;
    }

    public String findIdenticalTriangles() {

        String numberOfIdenticalTriangles = " ";

        for (int i = 0; i < triangles.length; i++) {
            for (int j = 1; j < triangles.length; j++) {
                if ((triangles[i].getLengthA()) == (triangles[j].getLengthA()) && ((triangles[i].getLengthB()) == (triangles[j].getLengthB())) && ((triangles[i].getLengthC()) == (triangles[j].getLengthC()) && i != j)) {
                    numberOfIdenticalTriangles+=(i+1)+" ";
                    break;
                }
            }
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

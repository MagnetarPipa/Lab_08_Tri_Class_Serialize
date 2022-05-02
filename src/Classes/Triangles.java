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
            if (triangles[i].getSquare() > maxTriangleArea.getSquare()) {
                maxTriangleArea = triangles[i];
            }
        }
        return maxTriangleArea;
    }

    public Triangle findTriangleMinSquare() {
        Triangle minTriangleArea = triangles[0];
        for (int i = 1; i < triangles.length; i++) {
            if (triangles[i].getSquare() < minTriangleArea.getSquare()) {
                minTriangleArea = triangles[i];
            }
        }
        return minTriangleArea;
    }

    public String findIdenticalTriangles() {

        String numberOfIdenticalTriangles = " ";
        boolean isFirstIdentical;
        boolean[] IdenticalArray = new boolean[triangles.length];
        for (int i = 0; i < triangles.length; i++) {
            isFirstIdentical = true;
            for (int j = i + 1; j < triangles.length; j++) {
                if ((!IdenticalArray[j]) && (triangles[j].getLengthA()) == (triangles[i].getLengthA()) && ((triangles[j].getLengthB()) == (triangles[i].getLengthB())) && ((triangles[j].getLengthC()) == (triangles[i].getLengthC()))) {
                    IdenticalArray[j]=true;
                    if (isFirstIdentical) {
                        isFirstIdentical = false;
                        numberOfIdenticalTriangles += (i + 1) + " ";
                    }
                    numberOfIdenticalTriangles += (j + 1) + " ";
                }
            }
            numberOfIdenticalTriangles+="\n";
        }
        return numberOfIdenticalTriangles;
    }

    @Override
    public String toString() {
        String result = "Triangles: " + System.lineSeparator();
        for (int i = 0; i < triangles.length; i++) {

            result += "№"+(i+1)+" "+triangles[i] + System.lineSeparator();
        }
        return result;
    }


}

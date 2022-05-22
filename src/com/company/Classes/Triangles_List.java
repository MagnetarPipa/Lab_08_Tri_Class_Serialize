package com.company.Classes;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Triangles_List implements Serializable{

    private final List<Triangle> figure;

    public Triangles_List() {
        figure = new ArrayList<>();
    }


    public void add(Triangle triangle) {
        figure.add(triangle);
    }

    public void remove(Triangle triangle) {
        figure.remove(triangle);
    }

    public void remove(int number) {
        if (number < figure.size())
            figure.remove(number);
    }

    public int getSize() {
        return this.figure.size();
    }

    public int countOf(String type) {

        return getListOf(type).getSize();

    }

    public Triangles_List getListOf(String type) {
        Triangles_List result = new Triangles_List();

        for (Triangle item : figure) {
            if (item.getClass().getSimpleName().equalsIgnoreCase(type))
                result.add(item);
        }

        return result;
    }

    public Triangle findTriangle_List_MaxSquare() {

        Triangle maxTriangleArea = figure.get(0);
        for (Triangle triangle : figure) {
            if (triangle.getSquare() > maxTriangleArea.getSquare()) {
                maxTriangleArea = triangle;
            }

        }
        return maxTriangleArea;
    }

    public Triangle findTriangle_List_MinSquare() {
        Triangle minTriangleArea = figure.get(0);
        for (Triangle triangle : figure) {
            if (triangle.getSquare() < minTriangleArea.getSquare()) {
                minTriangleArea = triangle;
            }
        }
        return minTriangleArea;
    }

    public String findIdentical_List_Triangles() {

        String numberOfIdenticalTriangles = " ";
        boolean isFirstIdentical;
        boolean[] IdenticalArray = new boolean[figure.size()];
        for (int i = 0; i < figure.size(); i++) {
            isFirstIdentical = true;
            for (int j = i + 1; j < figure.size(); j++) {
                if ((!IdenticalArray[j]) && (figure.get(j).getLengthA()) == (figure.get(i).getLengthA()) && ((figure.get(j).getLengthB()) == (figure.get(i).getLengthB())) && ((figure.get(j).getLengthC()) == (figure.get(i).getLengthC()))) {
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
        return "Triangles_List{" + figure + '}';
    }
}

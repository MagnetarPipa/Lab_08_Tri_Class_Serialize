package com.company;


import Classes.RightTriangle;
import Classes.Triangle;
import Classes.Triangles;

/**
 * 18. Создать класс треугольник, члены класса – координаты 3-х точек. Предусмотреть в классе
 * методы проверки существования треугольника, вычисления и вывода сведений о фигуре – длины сторон,
 * углы, периметр, площадь. Создать производный класс – прямоугольный треугольник, предусмотреть
 * в классе проверку, является ли треугольник прямоугольным. Написать программу, демонстрирующую
 * работу с классом: дано N треугольников и M прямоугольных треугольников, найти треугольники с
 * максимальной и минимальной площадью и вывести номера одинаковых прямоугольных треугольников.
 */

public class Main {

    public static void main(String[] args) {

        final int MAX_SIDE_LENGTH = 25;
        final int N = 5;
        final int M = 5;

        Triangles triangles = new Triangles(N);
        Triangles rightTriangles = new Triangles(M);
        rightTriangles.addTriangle(new RightTriangle(0, 5, 0, 5, 0, 0));
        rightTriangles.addTriangle(new RightTriangle(0, 5, 0, 5, 0, 0));
        rightTriangles.addTriangle(new RightTriangle(0, 5, 0, 5, 0, 0));

        int X1, X2, X3;
        int Y1, Y2, Y3;

        for (int i = 0; i < N; i++) {
            while (!Triangle.isTriangleExists(X1 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, X2 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, X3 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y1 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y2 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y3 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5)) {
            }
            Triangle triangle = new Triangle(X1, X2, X3, Y1, Y2, Y3);
            triangles.addTriangle(triangle);
        }

        for (int i = 0; i < M; i++) {
            while (!RightTriangle.isTriangleRight(X1 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, X2 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, X3 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y1 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y2 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y3 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5)) {
            }
            RightTriangle rightTriangle = new RightTriangle(X1, X2, X3, Y1, Y2, Y3);
            rightTriangles.addTriangle(rightTriangle);

        }

        System.out.println(triangles + System.lineSeparator());

        System.out.println(rightTriangles + System.lineSeparator());


        System.out.println("Triangle with maximal area:" + triangles.findMaxAreaOfTriangle());
        System.out.println("Right triangle with maximal area:" + rightTriangles.findMaxAreaOfTriangle());
        System.out.println("Triangle with minimal area:" + triangles.findMinAreaOfTriangle());
        System.out.println("Right triangle with minimal area:" + rightTriangles.findMinAreaOfTriangle());
        System.out.println("Numbers of identical right Triangles:" + rightTriangles.findIdenticalTriangles());

    }

}

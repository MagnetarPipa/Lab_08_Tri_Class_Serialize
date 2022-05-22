package com.company;


import com.company.Classes.*;

import java.io.IOException;

/**
 * 18. Создать класс треугольник, члены класса – координаты 3-х точек. Предусмотреть в классе
 * методы проверки существования треугольника, вычисления и вывода сведений о фигуре – длины сторон,
 * углы, периметр, площадь. Создать производный класс – прямоугольный треугольник, предусмотреть
 * в классе проверку, является ли треугольник прямоугольным. Написать программу, демонстрирующую
 * работу с классом: дано N треугольников и M прямоугольных треугольников, найти треугольники с
 * максимальной и минимальной площадью и вывести номера одинаковых прямоугольных треугольников.
 */

public class Main {


    public Main() throws IOException, ClassNotFoundException {
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        final int MAX_SIDE_LENGTH = 25;
        final int N = 5;
        final int M = 5;

        int X1, X2, X3;
        int Y1, Y2, Y3;

        System.out.println("\n----------6_Лабараторная---------\n");

        Triangles_List triangles_list = new Triangles_List();
        Triangles_List rightTriangles_list = new Triangles_List();


        rightTriangles_list.add(new Triangle(0,0,0,6,4,1));
        rightTriangles_list.add(new Triangle(0,0,0,6,4,1));
        try {
            triangles_list = SerializationNativeJava.load_Triangle();
            rightTriangles_list=SerializationNativeJava.load_Right_Triangle();

            System.out.println(triangles_list);
            System.out.println(rightTriangles_list);

        }  catch (Exception e){

            for (int i = 0; i < N; i++) {
                while (!Triangle.isTriangleExists(X1 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, X2 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, X3 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y1 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y2 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y3 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5)) {
                }
                triangles_list.add(new Triangle(X1, X2, X3, Y1, Y2, Y3));//Чтобы объект не пересоздавать,называется анонимный объект
            }

            for (int i = 0; i < M; i++) {
                while (!Triangle.isTriangleExists(X1 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, X2 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, X3 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y1 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y2 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y3 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5)) {
                }
                rightTriangles_list.add(new Triangle(X1, X2, X3, Y1, Y2, Y3));//Чтобы объект не пересоздавать,называется анонимный объект
            }


            System.out.println(triangles_list);

            System.out.println("Triangle with maximal square:" + triangles_list.findTriangle_List_MaxSquare());
            System.out.println("Right triangle with maximal square:" + rightTriangles_list.findTriangle_List_MaxSquare());
            System.out.println("Triangle with minimal square:" + triangles_list.findTriangle_List_MinSquare());
            System.out.println("Right triangle with minimal square:" + rightTriangles_list.findTriangle_List_MinSquare());
            System.out.println("Numbers of identical right Triangles:" + rightTriangles_list.findIdentical_List_Triangles());
        }

        SerializationNativeJava.save_Triangle(triangles_list);
        SerializationNativeJava.save_Right_Triangle(rightTriangles_list);


    }


}

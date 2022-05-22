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
 *
 * Реализовать сериализацию/десериализацию данных в файл/из файла на диске для Задания №6 в виде отдельного класса с методами Save и Load (2 балла).
 * Использовать независимых 2 способа: нативную Java-сериализацию и любую внешнюю библиотеку (2 балла).
 * Предусмотреть автоматическое создание новой резервной копии файла данных при завершении работы программы, имя файла - метка времени (1 балл)
 * Реализовать восстановление данных из последней созданной копии при запуске (1 балл).
 * В начале каждого метода ОБЯЗАТЕЛЬНО добавить комментарии разработчика
 * Выгрузить проект в общедоступный репозиторий GitHub
 * Добавить в описание репозитория README формулировку всех своих заданий с ОБЯЗАТЕЛЬНЫМ указанием своего варианта
 * Прикрепить ссылку на репозиторий в виде ответа на задание
 *
 */

public class Main {


    public Main() {
    }

    public static void main(String[] args) throws IOException {

        final int MAX_SIDE_LENGTH = 25;
        final int N = 5;
        final int M = 5;

        int X1, X2, X3;
        int Y1, Y2, Y3;

        System.out.println("\n----------8_Лабараторная---------\n");

        Triangles_List triangles_list = new Triangles_List();
        Triangles_List rightTriangles_list = new Triangles_List();

        Triangles_List triangles_list_JSON = new Triangles_List();
        Triangles_List rightTriangles_list_JSON = new Triangles_List();


        rightTriangles_list.add(new Triangle(0,0,0,6,4,1));
        rightTriangles_list.add(new Triangle(0,0,0,6,4,1));
        try {
            triangles_list = SerializationNativeJava.load_Triangle();
            rightTriangles_list=SerializationNativeJava.load_Right_Triangle();

            triangles_list_JSON=SerializationJSONJava.load_Triangle_JSON();
            rightTriangles_list_JSON=SerializationJSONJava.load_Right_Triangle_JSON();

            System.out.println("Triangles for Native:");

            System.out.println(triangles_list);
            System.out.println(rightTriangles_list);


            System.out.println("Triangles for JSON:");

            System.out.println(triangles_list);
            System.out.println(rightTriangles_list);

        }  catch (Exception e){

//            System.out.println("catch");
            for (int i = 0; i < N; i++) {
                while (!Triangle.isTriangleExists(X1 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, X2 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, X3 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y1 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y2 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y3 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5)) {
                }
                triangles_list.add(new Triangle(X1, X2, X3, Y1, Y2, Y3));//Чтобы объект не пересоздавать,называется анонимный объект
                triangles_list_JSON.add(new Triangle(X1, X2, X3, Y1, Y2, Y3));
            }

            for (int i = 0; i < M; i++) {
                while (!Triangle.isTriangleExists(X1 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, X2 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, X3 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y1 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y2 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5, Y3 = (int) (Math.random() * MAX_SIDE_LENGTH) - 5)) {
                }
                rightTriangles_list.add(new Triangle(X1, X2, X3, Y1, Y2, Y3));//Чтобы объект не пересоздавать,называется анонимный объект
                rightTriangles_list_JSON.add(new Triangle(X1, X2, X3, Y1, Y2, Y3));
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

        SerializationJSONJava.save_Triangle_JSON(triangles_list);
        SerializationJSONJava.save_Right_Triangle_JSON(rightTriangles_list_JSON);


    }


}

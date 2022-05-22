package com.company.Classes;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


public class SerializationNativeJava {

    public static void save_Triangle(Triangles_List triangles_List) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/Native_Ser_Triangles/" + "Triangles " +LocalDate.now()  + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(triangles_List);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static Triangles_List load_Triangle() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(Objects.requireNonNull(new File("./src/Native_Ser_Triangles").listFiles())[Objects.requireNonNull(new File("./src/Native_Ser_Triangles").listFiles()).length-1]);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Triangles_List triangles_list = (Triangles_List) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return triangles_list;
    }


    public static void save_Right_Triangle(Triangles_List right_triangles_List) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/Native_Ser_Triangles/" + "Right Triangles " + LocalDate.now()  + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(right_triangles_List);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static Triangles_List load_Right_Triangle() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(Objects.requireNonNull(new File("./src/Native_Ser_Triangles").listFiles())[Objects.requireNonNull(new File("./src/Native_Ser_Triangles").listFiles()).length-2]);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Triangles_List right_triangles_List = (Triangles_List) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return right_triangles_List;
    }

}



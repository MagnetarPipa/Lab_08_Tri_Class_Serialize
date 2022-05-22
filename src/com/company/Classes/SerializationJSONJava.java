package com.company.Classes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


public class SerializationJSONJava {

    public static void save_Triangle_JSON(Triangles_List triangles_List) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/JSON_Ser_Triangles/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() +"1.json"), triangles_List);


    }

    public static Triangles_List load_Triangle_JSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Objects.requireNonNull(new File("./src/JSON_Ser_Triangles").listFiles())[Objects.requireNonNull(new File("./src/DatabaseJSON").listFiles()).length-1],Triangles_List.class);
    }

    public static void save_Right_Triangle_JSON (Triangles_List right_triangles_List) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/JSON_Ser_Triangles/" + LocalDate.now() + "," + LocalDateTime.now().getHour() + "," + LocalDateTime.now().getMinute() + "," + LocalDateTime.now().getSecond() +"0.json"), right_triangles_List);

    }

    public static Triangles_List load_Right_Triangle_JSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Objects.requireNonNull(new File("./src/JSON_Ser_Triangles").listFiles())[Objects.requireNonNull(new File("./src/DatabaseJSON").listFiles()).length-2], Triangles_List.class);
    }

}

package com.example.demo.common;

import com.example.demo.model.entity.AddStudentInput;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteToFile {
    public void write(AddStudentInput addStudentInput){
        String path = addStudentInput.getName()+".json";

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(addStudentInput);
            out.write(jsonString);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

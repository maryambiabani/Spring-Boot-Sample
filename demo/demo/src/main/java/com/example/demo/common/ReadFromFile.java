package com.example.demo.common;

import com.example.demo.model.entity.AddStudentInput;
import com.example.demo.model.entity.GetStudentOutput;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromFile {
    public AddStudentInput readJson(String name){
        String path=name;
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(path));

            // convert JSON file to student
            AddStudentInput student = gson.fromJson(reader, AddStudentInput.class);

            // close reader
            reader.close();
            return student;

        } catch (FileNotFoundException e){
            System.out.println();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return (new AddStudentInput());

    }

    public AddStudentInput read(String name){
//        System.out.println("--------------------------------");
//        System.out.println(name);
//        System.out.println("---------------------------------");
        String path=name+".json";
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(path));

            // convert JSON file to student
            AddStudentInput student = gson.fromJson(reader, AddStudentInput.class);

            // close reader
            reader.close();
            return student;

        } catch (FileNotFoundException e){
            System.out.println();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return (new AddStudentInput());

    }
}

package com.example.demo.model.repository;

import com.example.demo.common.GetAllFilesWithCertainExtMain;
import com.example.demo.common.ReadFromFile;
import com.example.demo.common.WriteToFile;
import com.example.demo.model.entity.AddStudentInput;
import com.example.demo.model.entity.AddStudentOutput;
import com.example.demo.model.entity.GetAverageInput;
import com.example.demo.model.entity.GetStudentOutput;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public AddStudentOutput doSave(AddStudentInput student){
        WriteToFile toFile = new WriteToFile();
        AddStudentOutput output=new AddStudentOutput();
        try {
            toFile.write(student);
            output.setErrorCode(0);
            output.setMessage("ثبت نام با موفقیت صورت گرفت");

        }catch (Exception e){
            output.setMessage(e.getMessage());
        }

        return output;
    }
    public AddStudentInput getAverage(GetAverageInput getAverageInput){
        ReadFromFile fromFile = new ReadFromFile();
        AddStudentInput studentInput=fromFile.read(getAverageInput.getName());
        return studentInput;
    }
    public GetStudentOutput getStudent(){
        GetAllFilesWithCertainExtMain main=new GetAllFilesWithCertainExtMain();
        File folder=new File("/Users/maryambiabani/Documents/java project/api sample/Spring-Boot-Sample/demo/demo");
        String[] test= main.getAllFilesWithCertainExtension(folder,"json");
        List<AddStudentInput> list=new ArrayList<>();
        for (int i = 0; i < test.length; i++) {
            AddStudentInput studentInput = new AddStudentInput();
            studentInput=new ReadFromFile().readJson(test[i]);
            list.add(studentInput);


        }
        GetStudentOutput output = new GetStudentOutput();
        output.setList(list);


        return output;
    }
}

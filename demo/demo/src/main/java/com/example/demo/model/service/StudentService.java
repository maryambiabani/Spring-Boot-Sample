package com.example.demo.model.service;

import com.example.demo.model.entity.AddStudentInput;
import com.example.demo.model.entity.AddStudentOutput;
import com.example.demo.model.entity.GetAverageInput;
import com.example.demo.model.entity.GetAverageOutput;
import com.example.demo.model.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Service
public class StudentService {
private StudentRepository studentRepository=new StudentRepository();

    public AddStudentOutput save(final AddStudentInput student) {
        System.out.println(student.getName());

        return  studentRepository.doSave(student);
    }
    public GetAverageOutput getAverage(GetAverageInput getAverageInput){
        AddStudentInput student=studentRepository.getAverage(getAverageInput);
        LinkedHashMap<String,Float> linkedHashMap= (LinkedHashMap<String, Float>) student.getCourseMap();
        ArrayList<Float> grades= new ArrayList<>();
        GetAverageOutput getAverageOutput = new GetAverageOutput();
        grades.addAll(linkedHashMap.values());
        System.out.println(linkedHashMap.values());
        float sum=0;
        int n=0;
        for (Float i:
             grades) {
            sum=sum+i;
            n++;
        }
       try {
           getAverageOutput.setAve(sum/n);
           getAverageOutput.setMessage("عملیات موفق");
           getAverageOutput.setErrorCode(0);
           return getAverageOutput;

       }catch (Exception e){
           getAverageOutput.setAve(0);
           getAverageOutput.setMessage("عملیات ناموفق");
           getAverageOutput.setErrorCode(101);
           return getAverageOutput;
       }


    }

//    public float average(final Student student){
//        LinkedHashMap<String,Float> linkedHashMap=new LinkedHashMap<>();
//        linkedHashMap= (LinkedHashMap<String, Float>) student.getCourses();
//        ArrayList<Float> grades= new ArrayList<>();
//        grades.addAll(linkedHashMap.values());
//        System.out.println(linkedHashMap.values());
//        float ave=0;
//        int n=0;
//        for (Float i:
//             grades) {
//            ave=ave+i;
//            n++;
//        }
//        return ave/n;
//    }
//public float getAve(String name){
//        return studentRepository.getAve(name);
//}
}

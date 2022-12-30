package com.example.demo.controller;

import com.example.demo.model.entity.*;
import com.example.demo.model.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class RestApi {

    StudentService studentService=new StudentService();

    public static void main(String[] args) {
        SpringApplication.run(RestApi.class, args);
    }

    /**
     * Create a student with the system.This end point accepts student information in
     * the json format.It will create and send back the data to the REST student.
     * @param
     * @return addStudentOutput
     */
//    http://localhost:8081/api/addStudent
//    {
//        "name":"maryam",
//            "id":1234,
//            "courseMap":{
//        "math":20,
//                "history":10
//    }
//    }


    @GetMapping("/getStudent")
    public ResponseEntity<GetStudentOutput> getSudent(){
        final GetStudentOutput output=studentService.getStudent();
        return new ResponseEntity< >(output, HttpStatus.CREATED);
    }

    @PostMapping(value = "/addStudent")
    public ResponseEntity<AddStudentOutput> addStudent(@RequestBody AddStudentInput addStudentInput) {

        final AddStudentOutput output = studentService.save(addStudentInput);
        return new ResponseEntity< >(output, HttpStatus.CREATED);
    }
//    http://localhost:8081/api/getAverage
    @PostMapping(value = "/getAverage")
    public ResponseEntity<GetAverageOutput> getAverage(@RequestBody GetAverageInput getAverageInput) {
        final GetAverageOutput output = studentService.getAverage(getAverageInput);
        return new ResponseEntity< >(output, HttpStatus.CREATED);
    }



}
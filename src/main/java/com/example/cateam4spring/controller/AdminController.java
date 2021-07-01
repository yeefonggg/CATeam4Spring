package com.example.cateam4spring.controller;

import java.util.List;

import com.example.cateam4spring.model.Student;
import com.example.cateam4spring.service.AdminStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cateam4spring.model.Lecturer;
import com.example.cateam4spring.service.AdminLecturerService;

@Controller
@RequestMapping(value="/admin_home")
public class AdminController {
	
	@Autowired
	private AdminLecturerService alservice;

    @Autowired
    private AdminStudentService asservice;

    @GetMapping("/home")
    public String returnHome(){
        return "Admin/admin_home";
    }

    @GetMapping("/student")
    public String AdminStudent(Model model){
        List<Student> listStudents = asservice.listAll();
        model.addAttribute("listStudents", listStudents);
        return "Admin/admin_student"; //return view from templates
    }

    @GetMapping("/lecturer")
    public String AdminLecturer(Model model) {
    	List<Lecturer> listLecturers = alservice.listAll();
    	model.addAttribute("listLecturers", listLecturers);
        return "Admin/admin_lecturer";
    }

    @GetMapping("/enrolment")
    public String AdminEnrolment(){
        return "Admin/admin_enrolment";
    }

    @GetMapping("/course")
    public String AdminCourse(){
        return "Admin/admin_enrolment";
    }

    @RequestMapping("/logout")
    public String logout() {

        return "index";
    }


}

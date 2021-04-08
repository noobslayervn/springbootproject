package com.demo.studentapp.controller;

import com.demo.studentapp.dao.StudentDAO;
import com.demo.studentapp.dao.SubjectDAO;
import com.demo.studentapp.model.Student;
import com.demo.studentapp.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/company")
public class StudentController {

    @Autowired
    StudentDAO studentDAO;
    @Autowired
    SubjectDAO subjectDAO;

    @GetMapping("/home")
    public ModelAndView home(ModelMap model) {
        Student student = new Student();
        model.addAttribute("student", student);
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRegistration(@Valid Student student,
                                   BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "home";//will redirect to viewemp request mapping
        }
        studentDAO.save(student);
        //redirectAttributes.addFlashAttribute("message", "Student " + student.getFirstName()+" "+student.getLastName() + " saved");
        return "redirect:/company/viewstudents";//will redirect to viewemp request mapping
    }

    /* It deletes record for the given id  and redirects to /viewstudents */
    @RequestMapping(value = "/deletestudent/{id}", method = RequestMethod.POST)
    public ModelAndView deleteStudent(@PathVariable(value = "id") Long stuid) {
        Student s = studentDAO.findOne(stuid);
        studentDAO.delete(s);
//    	System.out.println("Student with ${id} has been deleted");
        return new ModelAndView("redirect:/company/viewstudents");
    }

    // Edit the information of a student by ID
    @RequestMapping(value = "editstudent/{id}", method = RequestMethod.POST)
    public ModelAndView editStudent(@PathVariable(value = "id") Long stuid, ModelMap model) {
        ModelAndView mv = new ModelAndView("editstudent");
        Student s = studentDAO.findOne(stuid);
        model.addAttribute("student", s);
        return mv;
    }

    @RequestMapping(value = "editstudent/{id}", method = RequestMethod.PUT)
    public ModelAndView saveEdit(@PathVariable(value = "id") Long stuid, @Valid Student student) {
        student.setId(stuid);
        studentDAO.save(student);
        return new ModelAndView("redirect:/company/viewstudents");
    }

    @GetMapping("/students")
    public ModelAndView viewstudents() {
        List<Student> list = studentDAO.findAll();
        return new ModelAndView("viewstudents", "list", list);
    }


    @GetMapping("/students/{id}")
    public ModelAndView viewstudentByID(@PathVariable(value = "id") Long stuid) {
        List<Student> list = new ArrayList();
        list.add(studentDAO.findOne(stuid));
        return new ModelAndView("viewstudents", "list", list);
    }

    @GetMapping("/viewsubjects")
    public ModelAndView viewSubjects() {
        List<Subject> list = subjectDAO.findAll();
        return new ModelAndView("viewsubjects", "list", list);
    }

    @GetMapping("/registersubject")
    public ModelAndView registerSubject(ModelMap model) {
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        ModelAndView mv = new ModelAndView("registersubject");
        return mv;
    }

    @RequestMapping(value = "/savesubject", method = RequestMethod.POST)
    public String saveSubject(@Valid Subject subject,
                              BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {

//		if (result.hasErrors()) {
//			return "viewsubjects";//will redirect to viewemp request mapping  
//		}
        subjectDAO.save(subject);
        //redirectAttributes.addFlashAttribute("message", "Student " + student.getFirstName()+" "+student.getLastName() + " saved");
        return "redirect:/company/viewsubjects";//will redirect to viewemp request mapping
    }
}

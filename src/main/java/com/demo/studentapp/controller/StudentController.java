package com.demo.studentapp.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.studentapp.dao.StudentDAO;
import com.demo.studentapp.dao.SubjectDAO;
import com.demo.studentapp.model.Student;
import com.demo.studentapp.model.Subject;

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
	
//	@InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
//        sdf.setLenient(true);
//        binder.registerCustomEditor(Date.class, new 	(sdf, true));
//    }
//	
//	/* to save an employee*/
//	@PostMapping("/student")
//	public Student createEmployee(@Valid @RequestBody Student emp) {
//		return studentDAO.save(emp);
//	}
//	
//	/*get all students*/
//	@GetMapping("/student")
//	public List<Student> getAllEmployees(){
//		return studentDAO.findAll();
//	}
//	
//	/*get all employees*/
//	@GetMapping("/subject")
//	public List<Subject> getAllSubjects(){
//		return subjectDAO.findAll();
//	}
		
	@RequestMapping(value ="/save",method = RequestMethod.POST)
	public String saveRegistration(@Valid Student student,
			BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "home";//will redirect to viewemp request mapping  
		}
		studentDAO.save(student);		
		//redirectAttributes.addFlashAttribute("message", "Student " + student.getFirstName()+" "+student.getLastName() + " saved");
		return "redirect:/company/viewstudents";//will redirect to viewemp request mapping  
	}
	
	/* It deletes record for the given id  and redirects to /viewstudents */  
    @RequestMapping(value="/deletestudent/{id}",method = RequestMethod.POST)  
    public ModelAndView deleteStudent(@PathVariable(value="id") Long stuid){  
    	Student s = studentDAO.findOne(stuid);
    	studentDAO.delete(s);
//    	System.out.println("Student with ${id} has been deleted");
        return new ModelAndView("redirect:/company/viewstudents");  
    }
	
	 // Edit the information of a student by ID
    @RequestMapping(value="editstudent/{id}", method = RequestMethod.POST)
    public ModelAndView editStudent(@PathVariable(value="id") Long stuid,ModelMap model) {
    	ModelAndView mv = new ModelAndView("editstudent");
    	Student s = studentDAO.findOne(stuid);
    	model.addAttribute("student",s);
    	return mv; 
    }
    
    @RequestMapping(value="editstudent/{id}", method = RequestMethod.PUT)
   public ModelAndView saveEdit(@PathVariable(value="id") Long stuid, @Valid Student student) {
    	student.setId(stuid);
    	studentDAO.save(student);
    	return new ModelAndView("redirect:/company/viewstudents"); 
    }
	
	@GetMapping("/students")  
    public ModelAndView viewstudents(){  
        List<Student> list= studentDAO.findAll();
        return new ModelAndView("viewstudents","list",list);  
    } 
	

	@GetMapping("/students/{id}")  
    public ModelAndView viewstudentByID(@PathVariable(value="id") Long stuid){  
		List<Student> list = new ArrayList();
		list.add(studentDAO.findOne(stuid));
        return new ModelAndView("viewstudents","list",list);  
	} 
	
	@GetMapping("/viewsubjects")
	public ModelAndView viewSubjects() {
		List<Subject> list= subjectDAO.findAll();
		return new ModelAndView("viewsubjects","list",list);
	}
	
	@GetMapping("/registersubject") 
	public ModelAndView registerSubject(ModelMap model) {
		Subject subject = new Subject();
		model.addAttribute("subject", subject);	
		ModelAndView mv = new ModelAndView("registersubject");
		return mv;
	}
	
	@RequestMapping(value ="/savesubject",method = RequestMethod.POST)
	public String saveSubject(@Valid Subject subject,
			BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {

//		if (result.hasErrors()) {
//			return "viewsubjects";//will redirect to viewemp request mapping  
//		}
		subjectDAO.save(subject);		
		//redirectAttributes.addFlashAttribute("message", "Student " + student.getFirstName()+" "+student.getLastName() + " saved");
		return "redirect:/company/viewsubjects";//will redirect to viewemp request mapping  
	}
	
	
	
//	/*Get a list of subjects of a student*/
//	@GetMapping("/studentbysubject/{id}")
//	public Set<Subject> getSubjectListOfStudent(@PathVariable(value="id") Long stuid){
//		Student stu = studentDAO.findOne(stuid);
//		return stu.getSubjects();
//	}
//	
//	/*find a subject by ID*/
//	@GetMapping("/subjects/{id}")
//	public ResponseEntity<Subject> getSubjectById(@PathVariable(value="id") Long empid){
//		
//		Subject sub= subjectDAO.findOne(empid);
//		
//		if(sub==null) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok().body(sub);
//		
//	}

	/*get employee by empid*/
//	@GetMapping("/student/{id}")
//	public ResponseEntity<Student> getEmployeeById(@PathVariable(value="id") Long empid){
//		
//		Student emp= studentDAO.findOne(empid);
//		
//		if(emp==null) {
//			return ResponseEntity.notFound().build();
//		}
//		for (Subject s: emp.getSubjects()) {
//			System.out.println(s.getName());
//		}
//		
//		return ResponseEntity.ok().body(emp);
//		
//	}
//	
//	/*update an employee by empid*/
//	@PutMapping("/student/{id}")
//	public ResponseEntity<Student> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Student empDetails){
//		
//		Student emp= studentDAO.findOne(empid);
//		if(emp==null) {
//			return ResponseEntity.notFound().build();
//		}
//		
//		emp.setName(empDetails.getName());
//		emp.setDesignation(empDetails.getDesignation());
//		emp.setExpertise(empDetails.getExpertise());
//		
//		Student updateEmployee= studentDAO.save(emp);
//		return ResponseEntity.ok().body(updateEmployee);
//	}
//	
//	/*Delete an employee*/
//	@DeleteMapping("/student/{id}")
//	public ResponseEntity<Student> deleteEmployee(@PathVariable(value="id") Long empid){
//		
//		Student emp= studentDAO.findOne(empid);
//		if(emp==null) {
//			return ResponseEntity.notFound().build();
//		}
//		studentDAO.delete(emp);
//		
//		return ResponseEntity.ok().build();
//	}
}

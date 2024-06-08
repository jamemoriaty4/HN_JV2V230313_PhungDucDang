package exam.controller;

import exam.model.entity.Student;
import exam.model.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/student")
    public String student(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "student/index";
    }

    @GetMapping("/create-student")
    private String create(Model model,Student student) {
        model.addAttribute("createStudent",student);
        return "student/create";
    }

    @PostMapping("/create-student")
    public String save(@ModelAttribute("createStudent") Student student, @RequestParam("fileImage") MultipartFile file) {
        studentService.saveFile(file, student);
        studentService.create(student);
        return "redirect:student";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("/student/edit");
        mav.addObject("studentEdit", studentService.findById(id));
        return mav;
    }
    @PostMapping("/edit/{id}")
    public String doUpdate(@ModelAttribute Student student){
        studentService.update(student);
        return "redirect:/student";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable  Integer id){
        studentService.deleteById(id);
        return "redirect:/student";
    }
}

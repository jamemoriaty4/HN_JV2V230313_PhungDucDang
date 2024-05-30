package exam.model.service;

import exam.model.dao.StudentDAO;
import exam.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentDAO studentDAO;
    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll() ;
    }

    @Override
    public boolean create(Student student) {
        return studentDAO.create(student);
    }

    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }

    @Override
    public void saveFile(MultipartFile file, Student student) {
        String path = "D:\\Exam_JavaCore_WeWebapp\\exam\\src\\main\\webapp\\uploads";
        String fileName = file.getOriginalFilename();

        File destination = new File(path + "/" + fileName);
        try {
            Files.write(destination.toPath(), file.getBytes(), StandardOpenOption.CREATE);
            student.setImage(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        studentDAO.deleteById(id);
    }

    @Override
    public Student findById(Integer id) {
        return studentDAO.findById(id);
    }
}

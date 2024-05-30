package exam.model.service;

import exam.model.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    boolean create(Student student);
    void update(Student student);
    void deleteById(Integer id);
    Student findById(Integer id);
    void saveFile(MultipartFile file, Student student);
}

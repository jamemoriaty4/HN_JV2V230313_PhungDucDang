package exam.util;

import exam.model.entity.Student;

import java.text.SimpleDateFormat;

public class DateUtil {

    // Format date attribute (birthday) of Student class
    public static String formatStudentBirthday(Student student) {
        if (student.getBirthday() == null) {
            return ""; // Handle null case (optional)
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  // Customize format as needed
        return formatter.format(student.getBirthday());
    }
}

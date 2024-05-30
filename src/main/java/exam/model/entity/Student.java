package exam.model.entity;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private Integer id;

    @Column(name="student_name", length = 100)
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="birthday")
    private Date birthday;

    @Column(name="img_url")
    private String image;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name="sex")
    private boolean sex;

    public Student() {
    }

    public Student(Integer id, String name, String address, Date birthday, String image, String phoneNumber, boolean sex) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}

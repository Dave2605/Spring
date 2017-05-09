package entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Please enter teacher first name.")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Please enter teacher second name")
    @Column(name = "second_name")
    private String secondName;

    @NotNull(message = "Please enter teacher age")
    @Column(name = "age")
    private Integer age;

    @NotEmpty(message = "Please enter teacher email")
    @Email
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy="teacher", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private transient List<Subject> subjectList;

    public Teacher() {

    }

    public Teacher(String firstName, String secondName, Integer age, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public String getSecondName() {
        return secondName;

    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

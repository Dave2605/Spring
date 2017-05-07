package entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "second_name")
    @Getter
    @Setter
    private String secondName;

    @Column(name = "age")
    @Getter
    @Setter
    private Integer age;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @OneToMany(mappedBy="teacher", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @Getter
    @Setter
    private transient List<Subject> subjectList;

    public Teacher() {

    }

    public Teacher(String firstName, String secondName, Integer age, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
    }
}

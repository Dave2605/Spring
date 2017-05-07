package entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column(name="name")
    @Getter
    @Setter
    private String name;

    @Column(name="subject_group")
    @Getter
    @Setter
    private String subjectGroup;

    @Column(name="pass_score")
    @Getter
    @Setter
    private Integer passScore;

    @ManyToOne
    @JoinColumn(name = "teacher")
    @Getter
    @Setter
    private Teacher teacher;

//    @Getter
//    @Setter
//    @Column(name = "teacher")
//    private Integer teacherId;

    public Subject() {

    }

    public Subject(String name, String subjectGroup, Integer passScore, Teacher teacher) {
        this.name = name;
        this.subjectGroup = subjectGroup;
        this.passScore = passScore;
        this.teacher = teacher;
    }
}

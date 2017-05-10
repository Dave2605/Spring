package entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Please enter subject name.")
    @Column(name="name")
    private String name;

    @NotEmpty(message = "Please enter subject group.")
    @Column(name="subject_group")
    private String subjectGroup;

    @NotNull(message = "Please enter pass score")
    @Column(name="pass_score")
    private Integer passScore;

    @ManyToOne
    @JoinColumn(name = "teacher")
    private Teacher teacher;

    private transient Integer teacherId;

    public Subject() {

    }

    public Subject(String name, String subjectGroup, Integer passScore, Teacher teacher) {
        this.name = name;
        this.subjectGroup = subjectGroup;
        this.passScore = passScore;
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubjectGroup() {
        return subjectGroup;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjectGroup(String subjectGroup) {
        this.subjectGroup = subjectGroup;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}

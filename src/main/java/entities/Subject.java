package entities;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="subject_group")
    private String subjectGroup;

    @Column(name="pass_score")
    private Integer passScore;

    @ManyToOne
    @JoinColumn(name = "teacher")
    private Teacher teacher;

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
}

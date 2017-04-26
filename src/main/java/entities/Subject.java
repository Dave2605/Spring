package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="subject_group")
    private String subject_group;
    @Column(name="pass_score")
    private Integer pass_score;
    @Column(name="teacher")
    private Integer teacher;

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

    public String getSubject_group() {
        return subject_group;
    }

    public void setSubject_group(String subject_group) {
        this.subject_group = subject_group;
    }

    public Integer getPass_score() {
        return pass_score;
    }

    public void setPass_score(Integer pass_score) {
        this.pass_score = pass_score;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }
}

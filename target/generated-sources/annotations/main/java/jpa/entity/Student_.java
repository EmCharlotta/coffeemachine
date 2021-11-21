package main.java.jpa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import main.java.jpa.entity.Group;
import main.java.jpa.entity.StudentInfo;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-20T12:22:55")
@StaticMetamodel(Student.class)
public class Student_ extends BaseIdentify_ {

    public static volatile SingularAttribute<Student, StudentInfo> studentInfo;
    public static volatile ListAttribute<Student, Group> groups;
    public static volatile SingularAttribute<Student, String> email;

}
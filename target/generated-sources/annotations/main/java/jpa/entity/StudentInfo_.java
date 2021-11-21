package main.java.jpa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import main.java.jpa.entity.Student;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-20T12:22:55")
@StaticMetamodel(StudentInfo.class)
public class StudentInfo_ extends BaseIdentify_ {

    public static volatile SingularAttribute<StudentInfo, Student> student;
    public static volatile SingularAttribute<StudentInfo, String> name;
    public static volatile SingularAttribute<StudentInfo, Integer> age;

}
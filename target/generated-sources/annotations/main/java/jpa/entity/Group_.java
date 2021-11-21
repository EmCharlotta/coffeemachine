package main.java.jpa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import main.java.jpa.entity.Student;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-20T12:22:55")
@StaticMetamodel(Group.class)
public class Group_ extends BaseIdentify_ {

    public static volatile SingularAttribute<Group, Integer> duration;
    public static volatile SingularAttribute<Group, String> groupName;
    public static volatile SingularAttribute<Group, Integer> price;
    public static volatile ListAttribute<Group, Student> students;

}
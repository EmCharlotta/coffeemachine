package main.java.jpa.entity;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-20T12:22:55")
@StaticMetamodel(TextMessage.class)
public class TextMessage_ { 

    public static volatile SingularAttribute<TextMessage, String> author;
    public static volatile SingularAttribute<TextMessage, Integer> id;
    public static volatile SingularAttribute<TextMessage, String> text;
    public static volatile SingularAttribute<TextMessage, Calendar> sent;

}
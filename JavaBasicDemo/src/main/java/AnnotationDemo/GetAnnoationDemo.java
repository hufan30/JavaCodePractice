package AnnotationDemo;

import org.checkerframework.checker.lock.qual.ReleasesNoLocks;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/2/179:40 下午
 **/
public class GetAnnoationDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        //首先是通过反射拿到类，然后通过getAnnotation拿到注解
        Class c1 = Class.forName("AnnotationDemo.student");
        Annotation[] annotations = c1.getAnnotations();
        for(Annotation a:annotations){
            System.out.println(a);
        }
        //@AnnotationDemo.Annoation1(value=db_student)
        System.out.println("-----------next show student annotation1.value-------------");


        //但是我们希望获得的是其中的value
        Annotation1 c1Annotation = (Annotation1)c1.getAnnotation(Annotation1.class);
        System.out.println(c1Annotation);
        System.out.println(c1Annotation.value());//这样就能拿到其中的value；
        System.out.println("-------------next show student annotation2.field-----------");


        //拿到filed上面的注解
        Field id = c1.getDeclaredField("id");
        Annotation[] idAnnotations = id.getAnnotations();
        for(Annotation a:idAnnotations){
            System.out.println(a);
        }
        System.out.println("-------------next show student annotation id inside value-----------");
        //拿到注解里面的具体值；
        Annotation2 idAnnotation = id.getAnnotation(Annotation2.class);
        System.out.println(idAnnotation.colName());
        System.out.println(idAnnotation.type());
        System.out.println(idAnnotation.length());
    }
}

@Annotation1("db_student")
class student{
    @Annotation2(colName = "id",type = "int",length = 10)
    int id;
    @Annotation2(colName = "age",type = "int",length = 10)
    int age;
    @Annotation2(colName = "name",type = "varChar",length = 3)
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
       return this.age+this.id+this.name;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation1{
    String value() default "this is default value";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation2{
    String colName();
    String type();
    int length();
//这样的三个参数一般是对应表的结构，列名，类型，长度；
}
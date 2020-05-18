package JunitDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MyJunitDemo {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyBefore {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyTest {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAfter {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface OnceBefore{
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface OnceAfter {
}
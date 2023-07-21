package DateDemo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author hufan
 * @date 2023/7/21 20:30
 * @annotation
 */
public class MidNightBoolean {

    public static boolean getBooleanByDay() {
        LocalDateTime oldDay = LocalDateTime.of(2023, 7, 1, 0, 0, 0);
        LocalDate of = LocalDate.of(2023, 7, 1);
        long l1 = LocalDate.now().toEpochDay();
        long l = of.toEpochDay();
        Duration between = Duration.between(oldDay, LocalDateTime.now());

        //下面根据今天距离1970年，多少天，然后根据天数奇偶返回true,false;
        return (LocalDate.now().toEpochDay() & 1) == 1;
    }


    public static void main(String[] args) {
        boolean booleanByDay = getBooleanByDay();
        System.out.println(booleanByDay);

    }
}

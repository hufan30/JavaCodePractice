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
        Duration between = Duration.between(oldDay, LocalDateTime.now());
        return (between.toDays() & 1) == 1;
    }


    public static void main(String[] args) {
        boolean booleanByDay = getBooleanByDay();
        System.out.println(booleanByDay);

    }
}

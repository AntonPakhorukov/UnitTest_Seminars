import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;
public class Main {
    public static void main(String[] args) {
        /**
         * Пример 1
         */
//        int x = Integer.MAX_VALUE;
//        int y = 10;
//        System.out.println(addNums(x,y));

        /**
         * Пример 2
         */
        Calendar calendar = Calendar.getInstance(); // Есть календарь из которого берем дату
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy" /*"dd/MM/yyyy HH:mm:ss"*/); // есть формат, который мы хотим получить
        String currentDateTime = dateFormat.format(calendar.getTime()); // обращаемся к календарю и берем из него в нужном формате дату
//        System.out.println(currentDateTime); // 27/09/2023 23:29:39
        Calendar calendar1 = new GregorianCalendar();
        calendar1.set(Calendar.YEAR, 2023);
        calendar1.set(Calendar.MONTH, 8);
        calendar1.set(Calendar.DAY_OF_MONTH, 26);
        String dateX = dateFormat.format(calendar1.getTime());
        System.out.println(currentDateTime + " / " + dateX);
//        assert currentDateTime.compareTo("01/01/2023 00:00:00") >= 0 : "Еще 2023 год :("; // сравниваем дату
        assert calendar.compareTo(calendar1) <= 0 : "Еще 2023 год :(";
        System.out.println("С новым годом!!!");
    }
    public static int addNums(int x, int y) {
        assert Integer.MAX_VALUE - x >= y;
        return x + y;
    }
}

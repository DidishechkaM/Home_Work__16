package randomUtils;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import static randomUtils.TestData.*;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomInt(10, 100));
        System.out.println(getRandomItemFromArray(names));
        System.out.println(getRandomEmail());
        System.out.println(getdouble());
        System.out.println(getRandomItemFromArray(months));
        System.out.println(getRandomItemFromArray(subjects));

    }
    static String[] names = {"Diana", "Kirill", "Vladimir", "Kristina", "Kira"};

    //Рандомная строка
    public static String getRandomString(int length) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    //Радномное число
    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    //Рандомный email
    public static String getRandomEmail() {

        return getRandomString(10) + "@mail.ru";
    }

    //Работа с массивом
    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);
        return values[index];
    }

    // Рандомное double значение
    public static double getdouble () {
        Random r = new Random();
        r.nextDouble();
        return r.nextDouble();
    }

}

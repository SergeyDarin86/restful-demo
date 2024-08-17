import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        var uuid = UUID.randomUUID();
//        System.out.println(uuid + " <--- Universally Unique IDentifier");
//
//        List<String>list1 = new ArrayList<>();
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//
//        List<String>list2 = new ArrayList<>();
//        list2.add("1");
//        list2.add("2");
//        list2.add("3");
//
//        System.out.println("Two lists are equals - " + list1.equals(list2));

//        2023-09-22T14:04:19.616+00:00

//        String stringDate = "2023-09-22T14:04:19.616+00:00";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS", Locale.ROOT);
//
//
//        LocalDateTime time = LocalDateTime.parse(stringDate,formatter);
//        System.out.println(time);

        List<String>list = new ArrayList<>();
        list.add("tag1");
        list.add("tag2");
        System.out.println(list);

        List<String>list1 = new ArrayList<>();
        list1.add("tag2");
        list1.add("tag1");
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);


        System.out.println(list.equals(list1));

    }
}

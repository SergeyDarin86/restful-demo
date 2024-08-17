import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main2 {
    public static void main(String[] args) {
        String startDateString = "06/27/2007";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate;

//        try {
//            startDate = df.parse(startDateString);
//            System.out.println(startDate);
//        } catch (ParseException e) {
////            e.printStackTrace();
//            System.out.println("Неверный формат даты");
//        }



        try {
            startDate = df.parse(startDateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(startDate);

    }
}

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
/*
This example shows how to use the class LocalDate to manipulate dates in a handy way

*/
public class LocalDateTimeTest
{
    static final String OFFSET_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    public static void main(String[] args)
    {
        // format receives an object date and returns a string
        String time = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDateTime.now());

        // parse receives a string and returns an object date
        LocalDateTime time2 = LocalDateTime.parse("2011-12-03T10:15:30+01:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        // option 1: transform from local date time to offset date time, and keep only 3 digits in milliseconds
        LocalDateTime baseLocalTime = LocalDateTime.now();
        System.out.println(baseLocalTime+"base local time");

        OffsetDateTime offsetDateTime = OffsetDateTime.of(baseLocalTime, OffsetDateTime.now().getOffset());
        OffsetDateTime trimmedOffsetDateTime = trimExtraMilliseconds(offsetDateTime);

        // option 2: transform from local date time to offset date time, and keep only 3 digits in milliseconds
        LocalDateTime localDateTime = LocalDateTime.now();
        OffsetDateTime offsetDateTime2 = localDateTime.atOffset(OffsetDateTime.now().getOffset());
        OffsetDateTime trimmedOffsetDateTime2 = trimExtraMilliseconds(offsetDateTime2);

        //System.out.println(time+" string dd.MM.yyyy");
        //System.out.println(time2+" LocalDateTime");
        System.out.println(trimmedOffsetDateTime+" LocalDateTime to OffsetDateTime");
        System.out.println(trimmedOffsetDateTime2+" LocalDateTime to OffsetDateTime option 2");
    }

    private static OffsetDateTime trimExtraMilliseconds(OffsetDateTime offsetDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(OFFSET_DATE_TIME_PATTERN);
        String formatted = offsetDateTime.format(formatter);
        return OffsetDateTime.parse(formatted);
    }
}

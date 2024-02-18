import java.time.*;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        // the parameter passed here is something called IANA timezone
        ZoneId london = ZoneId.of("Europe/London");
        ZoneId losAngelesId = ZoneId.of("America/Los_Angeles");
        ZoneId mexicoId = ZoneId.of("America/Mexico_City");


        LocalDateTime someDate = LocalDateTime.of(
                2024,
                Month.FEBRUARY,
                1,
                7,
                30
        );
        ZonedDateTime zonedLondon = ZonedDateTime.of(someDate, london);
        ZonedDateTime zonedLondonToZonedLA = zonedLondon.withZoneSameInstant(losAngelesId);

        ZonedDateTime zonedMexicoCity = ZonedDateTime.of(someDate, mexicoId);
        ZonedDateTime zonedMxToZonedLondon = zonedMexicoCity.withZoneSameInstant(london);

        // in console print offset and zoned date time looks similar, my understanding is that ZonedDateTime
        // allows the user to make different operations with time, which is pretty common IMO
        System.out.println("transform zoned london to zoned los angeles");
        System.out.printf("from zoned london %s to zoned los angeles%s%n", zonedLondon, zonedLondonToZonedLA);
        System.out.printf("offset london %s and offset los angeles %s %n", zonedLondon.toOffsetDateTime(), zonedLondonToZonedLA.toOffsetDateTime());

        System.out.println("transform zoned date time mexico to london, also get offset value of each");
        System.out.printf("from zoned mexico %s to zoned london%s%n", zonedMexicoCity, zonedMxToZonedLondon);
        System.out.printf("offset mexico %s and offset london %s %n", zonedMexicoCity.toOffsetDateTime(), zonedMxToZonedLondon.toOffsetDateTime());
    }
}


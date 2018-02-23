package sample;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CustomClock extends Clock {
    private ZonedDateTime begin;


    /**
     * Crea un reloj. Por default el tiempo de inicio es now()
     */
    public CustomClock() {
        begin = ZonedDateTime.now();
    }

    @Override
    public ZoneId getZone() {
        return ZoneId.systemDefault();
    }

    @Override
    public Clock withZone(ZoneId zone) {
        return null;
    }

    @Override
    public Instant instant() {
        // UNUSED!
        // Gets 'now'.
        ZonedDateTime now = ZonedDateTime.now();
        long nowSeconds = now.toInstant().getEpochSecond();
        long beginSeconds = begin.toInstant().getEpochSecond();
        // Difference between the starting point of this clock and 'now'.
        long delta = nowSeconds - beginSeconds;
        // Creates a datetime that is in the future.
        return begin.plusSeconds(delta * 2).toInstant();
    }

    public String getTime(double speedMultiplier) {
        // Gets 'now'.
        ZonedDateTime now = ZonedDateTime.now();
        long nowSeconds = now.toInstant().getEpochSecond();
        long beginSeconds = begin.toInstant().getEpochSecond();
        // Difference between the starting point of this clock and 'now'.
        long delta = nowSeconds - beginSeconds;

        return DateTimeFormatter.ofPattern("hh:mm:ss").format(begin.plusSeconds(Math.round(delta * speedMultiplier)));
    }
}

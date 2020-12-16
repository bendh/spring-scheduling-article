package nl.benooms.scheduledannotationplayground.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Cron samples described in article.
 * @author Ben Ooms
 */
@Slf4j
@Service
public class CronSchedulingExamples {
    // Listing 3
    /**
     * This is activated in the default profile with * 0/1 * * * *
     * and deactivated in the set-scheduling profile with -
     */
    @Scheduled(cron = "${some.cronschedulingexample}")
    public void scheduledFromApplicationProperties() {
        log.info("Cron scheduled from application.properties fired");
    }
    @Scheduled(cron = "@daily")
    public void scheduledWithDaily() {
        log.info("Cron scheduled with @daily fired");
    }
}

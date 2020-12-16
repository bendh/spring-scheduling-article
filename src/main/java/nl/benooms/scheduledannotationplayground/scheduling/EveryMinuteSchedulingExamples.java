package nl.benooms.scheduledannotationplayground.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Sample used in article marked Listing 1
 *
 * @author Ben Ooms
 */
@Slf4j
@Service
public class EveryMinuteSchedulingExamples {
    // Listing 1
    @Scheduled(fixedRate = 60_000L)
    public void everyMinuteLong() {
        log.info("Job defined with long fired");
    }
    @Scheduled(fixedRateString = "PT1M")
    public void everyMinuteString() {
        log.info("Job defined with string fired");
    }
    // Listing 2
    @Scheduled(cron = "0 */1 9-17 * * MON-FRI")
    public void everyMinuteFrom9to5onWorkdays() {
        log.info("Job from 9 to 5 every workday fired");
    }

}

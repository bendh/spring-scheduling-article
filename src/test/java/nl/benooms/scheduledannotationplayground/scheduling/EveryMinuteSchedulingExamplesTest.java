package nl.benooms.scheduledannotationplayground.scheduling;

import nl.benooms.scheduledannotationplayground.SchedulingTestHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Ben Ooms
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class EveryMinuteSchedulingExamplesTest {

    @Autowired
    private SchedulingTestHelper schedulingTestHelper;

    @Test
    public void testEveryMinuteLongIsScheduled() {
        var expectedLongInterval = 60_000L;
        var expectedFullNameToMethod = "nl.benooms.scheduledannotationplayground.scheduling.EveryMinuteSchedulingExamples.everyMinuteLong";
        var taskFound = schedulingTestHelper.hasScheduledFixedRateTask(expectedLongInterval, expectedFullNameToMethod);

        assertThat(taskFound).isTrue();
    }

    @Test
    public void testEveryMinuteString() {
        var expectedLongInterval = Duration.parse("PT1M").getSeconds()*1000;
        var expectedFullNameToMethod = "nl.benooms.scheduledannotationplayground.scheduling.EveryMinuteSchedulingExamples.everyMinuteString";
        var taskFound = schedulingTestHelper.hasScheduledFixedRateTask(expectedLongInterval, expectedFullNameToMethod);

        assertThat(taskFound).isTrue();
    }

    @Test
    public void testEveryMinuteFrom9to5onWorkdays() {
        var expectedCronExpression = "0 */1 9-17 * * MON-FRI";
        var expectedFullNameToMethod = "nl.benooms.scheduledannotationplayground.scheduling.EveryMinuteSchedulingExamples.everyMinuteFrom9to5onWorkdays";
        var taskFound = schedulingTestHelper.hasScheduledCronTask(expectedCronExpression, expectedFullNameToMethod);

        assertThat(taskFound).isTrue();
    }


}

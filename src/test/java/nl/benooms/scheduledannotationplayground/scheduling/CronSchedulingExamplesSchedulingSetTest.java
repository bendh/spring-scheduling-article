package nl.benooms.scheduledannotationplayground.scheduling;

import nl.benooms.scheduledannotationplayground.SchedulingTestHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ben Ooms
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("scheduling-set")
class CronSchedulingExamplesSchedulingSetTest {

    @Autowired
    private SchedulingTestHelper schedulingTestHelper;

    @Test
    public void testCronSchedulingIsNotConfigured() {
        var expectedCronExpression = "* 0/1 * * * *";
        var expectedFullNameToMethod = "nl.benooms.scheduledannotationplayground.scheduling.CronSchedulingExamples.scheduledFromApplicationProperties";
        var taskFound = schedulingTestHelper.hasScheduledCronTask(expectedCronExpression, expectedFullNameToMethod);

        assertThat(taskFound).isFalse();
    }

    @Test
    public void testDailyMacroSchedulingIsConfigured() {
        var expectedCronExpression = "0 0 0 * * *";
        var expectedFullNameToMethod = "nl.benooms.scheduledannotationplayground.scheduling.CronSchedulingExamples.scheduledWithDaily";
        var taskFound = schedulingTestHelper.hasScheduledCronTask(expectedCronExpression, expectedFullNameToMethod);

        assertThat(taskFound).isTrue();
    }

}

package nl.benooms.scheduledannotationplayground.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests the configuration of @Scheduling support
 * of this application with application-scheduling-set.properties
 *
 * @author Ben Ooms
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("scheduling-set")
public class SchedulingConfigurationWithSchedulingSetProfileTest {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Test
    public void testPoolSize() {
        assertThat(threadPoolTaskScheduler).isNotNull();
        assertThat(threadPoolTaskScheduler.getPoolSize()).isEqualTo(2);
    }
}

package nl.benooms.scheduledannotationplayground.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the generic configuration of @Scheduling support
 * of this application.
 *
 * @author Ben Ooms
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DefaultSchedulingConfigurationTest {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Test
    public void testPoolSize() {
        assertThat(threadPoolTaskScheduler).isNotNull();
        assertThat(threadPoolTaskScheduler.getPoolSize()).isEqualTo(1);
    }
}

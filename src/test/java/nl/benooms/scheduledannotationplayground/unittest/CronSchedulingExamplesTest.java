package nl.benooms.scheduledannotationplayground.unittest;

import nl.benooms.scheduledannotationplayground.scheduling.CronSchedulingExamples;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the methods of {@link nl.benooms.scheduledannotationplayground.scheduling.CronSchedulingExamples}
 *
 * @author Ben Ooms
 */
public class CronSchedulingExamplesTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testScheduledFromApplicationProperties() {
        new CronSchedulingExamples().scheduledFromApplicationProperties();
        assertThat(outputStreamCaptor.toString()).contains("Cron scheduled from application.properties fired");
    }

    @Test
    public void testScheduledWithDaily() {
        new CronSchedulingExamples().scheduledWithDaily();
        assertThat(outputStreamCaptor.toString()).contains("Cron scheduled with @daily fired");
    }
}

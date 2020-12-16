package nl.benooms.scheduledannotationplayground.unittest;

import nl.benooms.scheduledannotationplayground.scheduling.EveryMinuteSchedulingExamples;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the methods of {@link nl.benooms.scheduledannotationplayground.scheduling.EveryMinuteSchedulingExamples}
 *
 * @author Ben Ooms
 */
public class EveryMinuteSchedulingExamplesTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testEveryMinuteLong() {
        new EveryMinuteSchedulingExamples().everyMinuteLong();
        assertThat(outputStreamCaptor.toString()).contains("Job defined with long fired");
    }

    @Test
    public void testEveryMinuteString() {
        new EveryMinuteSchedulingExamples().everyMinuteString();
        assertThat(outputStreamCaptor.toString()).contains("Job defined with string fired");
    }

    @Test
    public void testEveryMinuteFrom9to5onWorkdays() {
        new EveryMinuteSchedulingExamples().everyMinuteFrom9to5onWorkdays();
        assertThat(outputStreamCaptor.toString()).contains("Job from 9 to 5 every workday fired");
    }
}

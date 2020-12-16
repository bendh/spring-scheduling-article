package nl.benooms.scheduledannotationplayground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.*;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Ben Ooms
 */
@Service
public class SchedulingTestHelper {

    private Predicate<ScheduledTask> isCronTask = scheduledTask -> scheduledTask.getTask() instanceof CronTask;
    private Function<ScheduledTask, CronTask> convertToCronTask = scheduledTask -> (CronTask) scheduledTask.getTask();

    private Predicate<ScheduledTask> isFixedRateTask = scheduledTask -> scheduledTask.getTask() instanceof IntervalTask;
    private Function<ScheduledTask, IntervalTask> convertToIntervalTask = scheduledTask -> (IntervalTask) scheduledTask.getTask();

    @Autowired
    private ScheduledTaskHolder scheduledTaskHolder;

    public boolean hasScheduledCronTask(String cronExpression, String fullNameToMethod){
        Set<ScheduledTask> scheduledTasks = scheduledTaskHolder.getScheduledTasks();
        return scheduledTasks.stream()
                .filter(isCronTask)
                .map(convertToCronTask)
                .filter(cronTask -> cronTask.getExpression().equals(cronExpression))
                .filter(cronTask -> cronTask.toString().equals(fullNameToMethod))
                .count() == 1;
    }

    public boolean hasScheduledFixedRateTask(Long interval, String fullNameToMethod){
        Set<ScheduledTask> scheduledTasks = scheduledTaskHolder.getScheduledTasks();
        return scheduledTasks.stream()
                .filter(isFixedRateTask)
                .map(convertToIntervalTask)
                .filter(intervalTask -> intervalTask.getInterval() == interval)
                .filter(intervalTask -> intervalTask.toString().equals(fullNameToMethod))
                .count() == 1;
    }



}

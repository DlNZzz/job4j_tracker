package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().
                thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenJobDescByName() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenJobDescByNameSmallBig() {
        Comparator<Job> cmpNamePriority = new JobDescByNameSmallBig();
        int rsl = cmpNamePriority.compare(
                new Job("AImpl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenJobDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("AImpl task", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenJobDescByPrioritySmallBig() {
        Comparator<Job> cmpNamePriority = new JobDescByPrioritySmallBig();
        int rsl = cmpNamePriority.compare(
                new Job("AImpl task", 1),
                new Job("Fix bug", 20)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPrority2() {
        Comparator<Job> cmpNamePriority = new JobDescByNameSmallBig().
                thenComparing(new JobDescByPrioritySmallBig());
        int rsl = cmpNamePriority.compare(
                new Job("AImpl task", 30),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}
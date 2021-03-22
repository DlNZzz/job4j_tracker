package ru.job4j.oop;

import junit.framework.TestCase;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PointTest extends TestCase {

    @Test
    public void testDistance3d() {
        Point a = new Point(1, 2, 5);
        Point b = new Point(4, 0, -2);
        double rsl = a.distance3d(b);
        double expected = 6.164;
        assertThat(rsl, closeTo(expected, 0.001));
    }

    @Test
    public void testDistance() {
        Point a = new Point(1, 2);
        Point b = new Point(4, 0);
        double rsl = a.distance(b);
        double expected = 3.605;
        assertThat(rsl, closeTo(expected, 0.001));
    }
}
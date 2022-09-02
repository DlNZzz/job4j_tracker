package ru.job4j.tracker;

import org.junit.*;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in =
                     SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from item")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void replaceTest() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item2 = new Item("item2");
        tracker.add(item);
        tracker.replace(item.getId(), item2);
        assertThat(tracker.findById(item.getId()).getName(), is(item2.getName()));
    }

    @Test
    public void deleteTest() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void findAllTest() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> list = new ArrayList<>();
        Item item = new Item("item");
        Item item2 = new Item("item2");
        list.add(item);
        list.add(item2);
        tracker.add(item);
        tracker.add(item2);
        List<Item> listTest = tracker.findAll();
        assertThat(listTest, is(list));
    }

    @Test
    public void findByNameTest() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> list = new ArrayList<>();
        Item item = new Item("item");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        item.setName("a");
        item3.setName("a");
        list.add(item);
        list.add(item3);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> listTest = tracker.findByName("a");
        assertThat(listTest, is(list));
    }

    @Test
    public void findByIdTest() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }
}
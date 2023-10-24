import org.example.infa.DriverManager;
import org.example.logic.components.CalendarComponent;
import org.example.logic.components.WeeklyComponent;
import org.example.logic.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AppTests {

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DriverManager.initializeDriver();
    }
    @AfterEach
    public void tearDown(){
        DriverManager.closeDriver();
    }

    @ParameterizedTest
    @CsvSource(
        {"Study", "Biking", "Jogging"}
    )
    public void createTaskTest(String str) throws Exception {
        //arrange
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.moveToWeek();
        WeeklyComponent weeklyComponent = new WeeklyComponent(DriverManager.getDriver());
        weeklyComponent.addEvent();
        weeklyComponent.clickToday();
        //act
        TaskCreation taskCreation = new TaskCreation(DriverManager.getDriver());
        taskCreation.writeName(str);
        taskCreation.clickSave();
        //assert
        weeklyComponent.viewEvents();
        EventPage eventPage = new EventPage(DriverManager.getDriver());
        assertTrue(eventPage.confirmTask(str));
    }

    @ParameterizedTest
    @CsvSource(
            {"Study", "Biking", "Jogging"}
    )
    public void deleteTaskTest(String str) throws Exception {
        //arrange
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.moveToWeek();
        WeeklyComponent weeklyComponent = new WeeklyComponent(DriverManager.getDriver());
        weeklyComponent.addEvent();
        weeklyComponent.clickToday();
        TaskCreation taskCreation = new TaskCreation(DriverManager.getDriver());
        taskCreation.writeName(str);
        taskCreation.clickSave();
        //act
        weeklyComponent.viewEvents();
        EventPage eventPage = new EventPage(DriverManager.getDriver());
        assumeTrue(eventPage.confirmTask(str));
        eventPage.clickOnTask(str);
        //assert
        TaskPage taskPage = new TaskPage(DriverManager.getDriver());
        taskPage.deleteTask();
        assertFalse(eventPage.confirmTask(str));
    }

    @ParameterizedTest
    @CsvSource(
            {"Study", "Biking", "Jogging"}
    )
    public void searchForTaskTest(String str) throws Exception {
        //arrange
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.moveToWeek();
        WeeklyComponent weeklyComponent = new WeeklyComponent(DriverManager.getDriver());
        weeklyComponent.addEvent();
        weeklyComponent.clickToday();
        TaskCreation taskCreation = new TaskCreation(DriverManager.getDriver());
        taskCreation.writeName(str);
        taskCreation.clickSave();
        //act
        weeklyComponent.viewEvents();
        EventPage eventPage = new EventPage(DriverManager.getDriver());
        assumeTrue(eventPage.confirmTask(str));
        eventPage.clickSearch();
        eventPage.searchFor(str);
        //assert
        assertTrue(eventPage.confirmSearch(str));
    }
    @ParameterizedTest
    @CsvSource(
            {"25, Study", "27, Biking", "26, Jogging"}
    )
    public void calenderTaskTest(String day, String str) throws Exception {
        //arrange
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.moveToCalendar();
        CalendarComponent calendarComponent = new CalendarComponent(DriverManager.getDriver());
        calendarComponent.clickOnDay(day);
        EventPage eventPage = new EventPage(DriverManager.getDriver());
        eventPage.addEvent();
        TaskCreation taskCreation = new TaskCreation(DriverManager.getDriver());
        taskCreation.writeName(str);
        taskCreation.clickSave();

        //assert
        assertTrue(eventPage.confirmSearch(str));
    }
}

package umbcs680.wiser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WiserTest{
    private static final String ADDITIONAL_LECTURE_1 = "Additional Lecture 1";
    private static final String ADDITIONAL_LECTURE_2 = "Additional Lecture 2";
    private Course aiCourse;
    private Course tocCourse;
    private Course oopdCourse;

    @BeforeEach
    public void setUp() {
        aiCourse = TestFixtures.createAICourse();
        tocCourse = TestFixtures.createTOCCourse();
        oopdCourse = TestFixtures.createOOPDCourse();
    }

    @Test
    public void AICourseAddedTest() {
        assertNotNull(aiCourse);
        assertEquals("Artificial Intelligence (AI)", aiCourse.getName());
    }

    @Test
    public void TOCCourseAddedTest() {
        assertNotNull(tocCourse);
        assertEquals("Theory of Computation (TOC)", tocCourse.getName());
    }

    @Test
    public void OOPDCourseAdddedTest() {
        assertNotNull(oopdCourse);
        assertEquals("Object-Oriented Programming and Design (OOPD)", oopdCourse.getName());
    }

    @Test
    public void AISessionsAddingTest() {
        assertNotNull(aiCourse);
        WeeklySessions additionalSessions = new WeeklySessions();
        additionalSessions.add(new Session(ADDITIONAL_LECTURE_1));
        additionalSessions.add(new Session(ADDITIONAL_LECTURE_2));
        aiCourse.add(additionalSessions);
        assertEquals(2, ((WeeklySessions) additionalSessions).getChildCount());
    }

    @Test
    public void TOCSessionsAddingTest() {
        assertNotNull(tocCourse);
        WeeklySessions additionalSessions = new WeeklySessions();
        additionalSessions.add(new Session(ADDITIONAL_LECTURE_1));
        additionalSessions.add(new Session(ADDITIONAL_LECTURE_2));
        tocCourse.add(additionalSessions);
        assertEquals(2, ((WeeklySessions) additionalSessions).getChildCount());
    }

    @Test
    public void OOPDSessionsAddingTest() {
        assertNotNull(oopdCourse);
        WeeklySessions additionalSessions = new WeeklySessions();
        additionalSessions.add(new Session(ADDITIONAL_LECTURE_1));
        additionalSessions.add(new Session(ADDITIONAL_LECTURE_2));
        oopdCourse.add(additionalSessions);
        assertEquals(2, ((WeeklySessions) additionalSessions).getChildCount());
    }

    @Test
    public void DeletingDiscussionAI() {
        CourseComponent toRemove = new Discussions();
        aiCourse.add(toRemove);
        aiCourse.remove(toRemove);
        assertFalse(aiCourse.hasChild(toRemove));
    }

    @Test
    public void DeletingDiscussionTOC() {
        CourseComponent toRemove = new Discussions();
        tocCourse.add(toRemove);
        tocCourse.remove(toRemove);
        assertFalse(aiCourse.hasChild(toRemove));
    }

    @Test
    public void DeletingDiscussionOOPD() {
        CourseComponent toRemove = new Discussions();
        oopdCourse.add(toRemove);
        oopdCourse.remove(toRemove);
        assertFalse(aiCourse.hasChild(toRemove));
    }

    @Test
    public void AICourseDetailsDisplayTest() {
        aiCourse.display();
    }

    @Test
    public void TOCCourseDetailsDisplayTest() {
        tocCourse.display();
    }

    @Test
    public void OOPDCourseDetailsDisplayTest() {
        oopdCourse.display();
    }

    @Test
    public void AISessionCountTest() {
        assertEquals(12, ((WeeklySessions) aiCourse.getChild(0)).getChildCount());
    }

    @Test
    public void TOCSessionCountTest() {
        assertEquals(15, ((WeeklySessions) tocCourse.getChild(0)).getChildCount());
    }

    @Test
    public void OOPDSessionCountTest() {
        assertEquals(20, ((WeeklySessions) oopdCourse.getChild(0)).getChildCount());
    }

}

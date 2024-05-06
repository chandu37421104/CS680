package umbcs680.wiser;


public class TestFixtures {
    public static Course createAICourse() {
        Course aiCourse = new Course("Artificial Intelligence (AI)");
        WeeklySessions aiSessions = new WeeklySessions();
        Assignments aiAssignments = new Assignments();
        MyGrades aiGrades = new MyGrades();

        for (int i = 1; i <= 12; i++) {
            aiSessions.add(new Session("AI Lecture " + i));
        }

        aiCourse.add(aiSessions);
        aiCourse.add(aiAssignments);
        aiCourse.add(aiGrades);
        return aiCourse;
    }

    public static Course createTOCCourse() {
        Course tocCourse = new Course("Theory of Computation (TOC)");
        WeeklySessions tocSessions = new WeeklySessions();
        Assignments tocAssignments = new Assignments();
        MyGrades tocGrades = new MyGrades();

        for (int i = 1; i <= 15; i++) {
            tocSessions.add(new Session("TOC Lecture " + i));
        }

        tocCourse.add(tocSessions);
        tocCourse.add(tocAssignments);
        tocCourse.add(tocGrades);
        return tocCourse;
    }

    public static Course createOOPDCourse() {
        Course oopdCourse = new Course("Object-Oriented Programming and Design (OOPD)");
        WeeklySessions oopdSessions = new WeeklySessions();
        Assignments oopdAssignments = new Assignments();
        MyGrades oopdGrades = new MyGrades();

        for (int i = 1; i <= 20; i++) {
            oopdSessions.add(new Session("OOPD Lecture " + i));
        }

        oopdCourse.add(oopdSessions);
        oopdCourse.add(oopdAssignments);
        oopdCourse.add(oopdGrades);
        return oopdCourse;
    }
}

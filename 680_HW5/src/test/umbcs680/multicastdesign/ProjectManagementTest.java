package umbcs680.multicastdesign;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

import java.util.stream.Collectors;

public class ProjectManagementTest {

    private Project project1;
    private Project project2;
    private ProjectManager pm1;
    private ProjectManager pm2;
    private TeamManager teamManager;
    private List<TeamMember> teamMembers;

    @BeforeEach
    void setUp() {
        project1 = new Project("Ola Scooter");
        project2 = new Project("Ola Bike");

        pm1 = new ProjectManager("Shashi Kiran");
        pm2 = new ProjectManager("Kabir");

        teamManager = new TeamManager("Shankar");

        String[] memberNames = {"Sahithi", "Chandu", "Bhargav", "Siva Kumar", "Santoosh", "Pavan", "Bharthi", "Honnesh", "Aswini", "Raj"};
        teamMembers = new ArrayList<>();
        for (String name : memberNames) {
            teamMembers.add(new TeamMember(name));
        }

        String[] scooterTasks = {"Adding lock and unlock to app", "Proximity lock/unlock", "Adding multiple profiles", "Passcode API"};
        for (int i = 0; i < scooterTasks.length; i++) {
            Task task = new Task(scooterTasks[i]);
            project1.addTask(task);
            task.attach(pm1);
            TeamMember assignedMember = teamMembers.get(i);
            task.attach(assignedMember);
            attachHelpers(task, i);
        }

        String[] bikeTasks = {"Limiting speed based mode", "Party mode implementation", "Enabling all Capp features to Capp-Bike"};
        for (int i = 0; i < bikeTasks.length; i++) {
            Task task = new Task(bikeTasks[i]);
            project2.addTask(task);
            task.attach(pm2);
            TeamMember assignedMember = teamMembers.get(i + 4);
            task.attach(assignedMember);
            attachHelpers(task, i + 4);
        }
    }

    private void attachHelpers(Task task, int assignedMemberIndex) {
        int helpersNeeded = 3;
        int teamMembersCount = teamMembers.size();
    
        
        for (int i = teamMembersCount - 1; i >= 0 && helpersNeeded > 0; i--) {
            
            if (i == assignedMemberIndex) {
                continue;
            }
            task.attach(teamMembers.get(i));
            helpersNeeded--; 
        }
        task.attach(teamManager);
    }

    
@Test
public void countObserversForAddingLockAndUnlockToAppTask() {
    Task task = project1.getTasks().get(0);
    assertEquals(6, task.countObservers(), "Incorrect number of observers for 'Adding lock and unlock to app' task.");
 }

    
@Test
public void countObserversForProximityLockUnlockTask() {
    Task task = project1.getTasks().get(1);
    assertEquals(6, task.countObservers(), "Incorrect number of observers for 'Proximity lock/unlock' task.");
}



@Test
public void countObserversForAddingMultipleProfilesTask() {
    Task task = project1.getTasks().get(2);
    assertEquals(6, task.countObservers(), "Incorrect number of observers for 'Adding multiple profiles' task.");
}



@Test
public void countObserversForPasscodeApiTask() {
    Task task = project1.getTasks().get(3);
    assertEquals(6, task.countObservers(), "Incorrect number of observers for 'Passcode API' task.");
}



@Test
public void countObserversForLimitingSpeedBasedModeTask() {
    Task task = project2.getTasks().get(0);
    assertEquals(6, task.countObservers(), "Incorrect number of observers for 'Limiting speed based mode' task.");
}



@Test
public void countObserversForPartyModeImplementationTask() {
    Task task = project2.getTasks().get(1);
    assertEquals(6, task.countObservers(), "Incorrect number of observers for 'Party mode implementation' task.");
}


@Test
public void countObserversForEnablingAllCappFeaturesToCappBikeTask() {
    Task task = project2.getTasks().get(2);
    assertEquals(6, task.countObservers(), "Incorrect number of observers for 'Enabling all Capp features to Capp-Bike' task.");
}

@Test
    public void checkObserversForAddingLockAndUnlockToAppTask() {
        Task task = project1.getTasks().get(0);
        assertTrue(task.checkObserverNames(task, List.of("Shashi Kiran", "Shankar", "Sahithi",  "Honnesh", "Aswini", "Raj")),
            "Observer names do not match expected values for 'Adding lock and unlock to app' task.");
    }

    @Test
    public void checkObserversForProximityLockUnlockTask() {
        Task task = project1.getTasks().get(1);
        assertTrue(task.checkObserverNames(task, List.of("Shashi Kiran", "Shankar", "Chandu",  "Honnesh", "Aswini", "Raj")),
            "Observer names do not match expected values for 'Proximity lock/unlock' task.");
    }

    @Test
    public void checkObserversForAddingMultipleProfilesTask() {
        Task task = project1.getTasks().get(2);
        assertTrue(task.checkObserverNames(task, List.of("Shashi Kiran", "Shankar", "Bhargav",  "Honnesh", "Aswini", "Raj")),
            "Observer names do not match expected values for 'Adding multiple profiles' task.");
    }

    @Test
    public void checkObserversForPasscodeApiTask() {
        Task task = project1.getTasks().get(3);
        assertTrue(task.checkObserverNames(task, List.of("Shashi Kiran", "Shankar", "Siva Kumar", "Honnesh", "Aswini", "Raj")),
            "Observer names do not match expected values for 'Passcode API' task.");
    }

    @Test
    public void checkObserversForLimitingSpeedBasedModeTask() {
        Task task = project2.getTasks().get(0);
        assertTrue(task.checkObserverNames(task, List.of("Kabir", "Shankar", "Santoosh",  "Honnesh", "Aswini", "Raj")),
            "Observer names do not match expected values for 'Limiting speed based mode' task.");
    }

    @Test
    public void checkObserversForPartyModeImplementationTask() {
        Task task = project2.getTasks().get(1);
        assertTrue(task.checkObserverNames(task, List.of("Kabir", "Shankar", "Pavan",  "Honnesh", "Aswini", "Raj")),
            "Observer names do not match expected values for 'Party mode implementation' task.");
    }

    @Test
    public void checkObserversForEnablingAllCappFeaturesToCappBikeTask() {
        Task task = project2.getTasks().get(2);
        assertTrue(task.checkObserverNames(task, List.of("Kabir", "Shankar", "Bharthi",  "Honnesh", "Aswini", "Raj")),
            "Observer names do not match expected values for 'Enabling all Capp features to Capp-Bike' task.");
    }
   
}

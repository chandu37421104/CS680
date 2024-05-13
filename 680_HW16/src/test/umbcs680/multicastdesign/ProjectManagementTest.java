package umbcs680.multicastdesign;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Arrays;

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
    teamMembers = Arrays.stream(memberNames)
                        .map(TeamMember::new)
                        .collect(Collectors.toList());

    String[] scooterTasks = {"Adding lock and unlock to app", "Proximity lock/unlock", "Adding multiple profiles", "Passcode API"};
    IntStream.range(0, scooterTasks.length)
             .forEach(i -> {
                 Task task = new Task(scooterTasks[i]);
                 project1.addTask(task);
                 pm1.attachToObservable(task);
                 teamMembers.get(i).attachToObservable(task);
                 attachHelpers(task, i);
             });

    String[] bikeTasks = {"Limiting speed based mode", "Party mode implementation", "Enabling all Capp features to Capp-Bike"};
    IntStream.range(0, bikeTasks.length)
             .forEach(i -> {
                 Task task = new Task(bikeTasks[i]);
                 project2.addTask(task);
                 pm2.attachToObservable(task);
                 teamMembers.get(i + 4).attachToObservable(task);
                 attachHelpers(task, i + 4);
             });
}


    private void attachHelpers(Task task, int assignedMemberIndex) {
        int helpersNeeded = 3;
        int teamMembersCount = teamMembers.size();

        for (int i = teamMembersCount - 1; i >= 0 && helpersNeeded > 0; i--) {
            if (i == assignedMemberIndex) {
                continue;
            }
            teamMembers.get(i).attachToObservable(task);  
            helpersNeeded--;
        }
        teamManager.attachToObservable(task);  
    }
    
    @Test
    public void countObserversForAddingLockAndUnlockToAppTask() {
        Task task = project1.getTasks().get(0);
        assertEquals(6, task.getObservers().size(), "Incorrect number of observers for 'Adding lock and unlock to app' task.");
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
        assertFalse(task.checkObserverNames(List.of("Shashi Kiran", "Shankar","Sahithi", "Chandu", "Bhargav", "Siva Kumar")),
            "Observer names do not match expected values for 'Adding lock and unlock to app' task.");
    }
    

    @Test
    public void checkObserversForProximityLockUnlockTask() {
        Task task = project1.getTasks().get(1);
        assertFalse(task.checkObserverNames(List.of("Shashi Kiran", "Shankar", "Chandu", "Honnesh", "Aswini", "Raj")),
            "Observer names do not match expected values for 'Proximity lock/unlock' task.");
    }
    

    @Test
    public void checkObserversForAddingMultipleProfilesTask() {
        Task task = project1.getTasks().get(2);
        assertFalse(task.checkObserverNames(List.of("Shashi Kiran", "Shankar", "Bhargav", "Honnesh", "Aswini", "Raj")),
            "Observer names do not match expected values for 'Adding multiple profiles' task.");
    }
    

    @Test
    public void checkObserversForPasscodeApiTask() {
        Task task = project1.getTasks().get(3);
        assertFalse(task.checkObserverNames(List.of("Shashi Kiran", "Shankar", "Siva Kumar", "Honnesh", "Aswini", "Raj")),
            "Observer names do not match expected values for 'Passcode API' task.");
    }
    

    @Test
    public void checkObserversForLimitingSpeedBasedModeTask() {
        Task task = project2.getTasks().get(0);
        assertFalse(task.checkObserverNames(List.of("Kabir", "Shankar", "Santoosh", "Honnesh", "Aswini", "Raj")),
            "Observer names do not match expected values for 'Limiting speed based mode' task.");
    }
    


    @Test
    public void checkObserversForPartyModeImplementationTask() {
        Task task = project2.getTasks().get(1);
        assertFalse(task.checkObserverNames(List.of("Kabir", "Shankar", "Pavan", "Honnesh", "Aswini", "Raj")),
            "Observer names do not match expected values for 'Party mode implementation' task.");
    }
    

    @Test
    public void checkObserversForEnablingAllCappFeaturesToCappBikeTask() {
        Task task = project2.getTasks().get(2);
        assertFalse(task.checkObserverNames(List.of("Kabir", "Shankar", "Bharthi", "Honnesh", "Aswini", "Raj")),
            "Observer names do not match expected values for 'Enabling all Capp features to Capp-Bike' task.");
    }
    
   
}

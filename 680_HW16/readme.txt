

Application: project management system

Multicast Design Pattern Implementation:

Observers: 'TeamMember','TeamManager' and 'ProjectManager'
Observables: 'Task' and 'Project'


1. Observable Interface: Defines the methods for attaching, detaching,counting, clearing(removes all observers), printing and notifying observers. 
Implemented by the 'Task' and 'Project' classes, allowing them to be observed for updates.


2. Observer Interface: Defines the update method that observers must implement.
 Implemented by 'TeamMember', 'TeamManager', and 'ProjectManager' classes, enabling them to receive and act upon notifications.


3. Task Class: Represents a task in the project management system. 
Implements the Observable interface, allowing observers to subscribe to updates such as comments added by team members or managers.


4. Project Class: Represents a project and also implements the Observable interface. 
It notifies observers about project creation, updates, and assignments to team members.


5. TeamMember, TeamManager, ProjectManager Classes: They implement the Observer interface to receive updates on tasks and projects they are observing.
 these classes implement the 'Commenter' interface, allowing them to comment on tasks.


6. Commenter Interface: Allows TeamMember, TeamManager, and ProjectManager to comment on tasks

Testing 

2 projects: Ola Scooter, Ola Bike

Ola Scooter Tasks: "Adding lock and unlock to app," "Proximity lock/unlock," "Adding multiple profiles," "Passcode API"
Ola Bike Tasks: "Limiting speed-based mode," "Party mode implementation," "Enabling all Capp features to Capp-Bike"

Adding 1 PM for each project, 1 Team Manager, a total of 10 team members.
Each task is assigned to 1 team member and the remaining 3 members are added to all tasks as helping members.

so for each task total no of obsevers is 6 :: 1PM, 1TM, 1 assigned team member, 3 helping team members. These can comment on their respective tasks. 










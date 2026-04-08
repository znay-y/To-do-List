# Java To-do List

This project is a simple feature rich to-do list that uses the programming language java. It's purpose is to showcase skills such as arrays, methods, exception handling, and modular code structure.  


***



## v0.1.0 — Initial Release

### Features
- Add new tasks from the command line
- View all current tasks
- Remove tasks by index
- Interactive CLI menu for easy navigation
***
### Implementation Details
- Built using core Java (no external libraries)
- Tasks stored in a dynamically resized array
- Modular structure with separate methods:
  - `addTask()` — add new tasks
  - `viewTasks()` — view all tasks
  - `removeTask()` — remove tasks by number
***
### Limitations
- Tasks are **not persisted** (data is lost when program exits)
- Basic input validation only
- Uses arrays instead of more flexible data structures
***
### Purpose
This version establishes the **core functionality** of the task manager and provides a foundation for future improvements, such as:
- Task persistence
- Enhanced CLI experience
- Better data structures (like `ArrayList`)
***

## v0.1.1 — Minor Update

### Changes 
- Fixed string comparison for main menu
- Fixed incorrect error being caught 

### Upcoming 
- Actual removal of tasks as apposed to making them null
- Renaming poorly named variables

## v0.1.2 — 

### Changes
- Tasks actaully get removed from the list now
- Visual updates like waiting before printing new line 
- Removed irrelevant lines/methods

### Upcoming 
- Replacing string array with arraylist
- Allowing users to undo removals
- Showing users the updated to-do list 
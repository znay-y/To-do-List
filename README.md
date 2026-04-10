# Java To-do List

This project is a simple feature rich to-do list that uses the programming language java. It's purpose is to showcase skills such as arrays, methods, exception handling, and modular code structure.  






## v0.1.0 — Initial Release

### Features
- Add new tasks from the command line
- View all current tasks
- Remove tasks by index
- Interactive CLI menu for easy navigation

### Limitations
- Basic input validation only
- Uses arrays instead of more flexible data structures

### Upcoming 
- Replacing string array with arraylist
- Allowing users to undo removals
- Showing users the updated to-do list 


## v0.1.1 — Minor Update

### Changes 
- Fixed string comparison for main menu
- Fixed incorrect error being caught 

## v0.1.2 — Bug Fixes

### Changes
- Tasks actaully get removed from the list now
- Visual updates like waiting before printing new line 
- Removed irrelevant lines/methods

## v0.2.0 - Visual Refresh 

### Changes 
- Use arrayLists instead of an actual array resulting in many useless methods 
- Visual updates like clearing the console when moving between menus by using `clearWithLinuxCommand()`
- Users can preview item removal before finalising choice
- Input validation for main menu

### Limitations
-  `clearWithLinuxCommand()` has not been tested on other platforms e.g. Windows

### Upcoming 
- Allowing users to view and restore removed entries
- Not letting users add dulicate entries 
- Priotity for tasks
- Due dates for tasks 

## v0.2.1 Minor Update

### Updates
- Viewing empty arrayList bug
- Removing on empty lists fixed

## v0.3.0 - Restoration 

### Changes 
- New Mode in main menu for restoring tasks with the use of a new `arrayList <String>`
- Stopped users from adding duplicate tasks
- Validate user inputs so letters are accepted no matter what using `equalsIgnoreCase`
- New method for copying items from one array to another
- Minor changes to make output messages 


### Limitations
-  `arrayCopy()` should remove the entry from the previous array to reduce the amount of calling `removeTask()`
- Lack of comments 

### Upcoming 
- Priotity for tasks
- Due dates for tasks 
- Tags for tasks to sort by group made by the user e.g. Work, hobbies etc.
- Reading and writing files for persistence 
- Search and filter using the tag system
- GUI integration using Swing


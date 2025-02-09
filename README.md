To-Do List Application

This is a simple command-line To-Do List application built with Java and Spring Boot. The application allows users to add, edit, mark as completed, and display tasks, with task data being stored in a JSON file.

Features

Add tasks with a title, description, and deadline.

View the list of tasks.

Mark tasks as completed.

Edit existing tasks.

Save and load tasks from a JSON file.

Technologies Used

Java

Spring Boot

Gson (for JSON serialization/deserialization)

Installation & Setup

Clone this repository:

git clone https://github.com/your-username/your-repo.git

Navigate to the project directory:

cd your-repo

Compile the project:

mvn clean install

Run the application:

java -jar target/my_todolist-1.0.jar

Usage

Upon running the application, the following menu will be displayed:

1. Add a task
2. Display tasks
3. Mark a task as completed
4. Edit a task
5. Exit

Follow the on-screen instructions to manage your tasks.

Task Data Storage

Tasks are stored in task_file.json in the project directory. The file is automatically updated when tasks are added, edited, or marked as completed.

Example Task Format

[
  {
    "title": "Complete project report",
    "description": "Prepare and submit the final project report",
    "deadline": "2024-12-12",
    "isCompleted": false
  }
]

Contributing

Feel free to fork this repository and submit pull requests with improvements.

License

This project is open-source and available under the MIT License.

package com.day1.level1;
class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;


    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;

    }
}

class TaskList {
    private Task head;
    private Task tail;

    public TaskList() {
        this.head = null;
        this.tail = null;
    }

    // Add a task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            newTask.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add a task at the end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            newTask.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    // Add a task at a specific position
    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        for (int i=1;i < position - 1&&temp.next != head ;i++) {
            temp = temp.next;

        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }
    }

    // Remove a task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("The task list is empty.");
            return;
        }

        if (head.taskId == taskId) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            System.out.println("Task with ID " + taskId + " removed.");
            return;
        }

        Task temp = head;
        Task prev = null;
        while (temp.next != head) {
            if (temp.taskId == taskId) {
                prev.next = temp.next;
                if (temp == tail) {
                    tail = prev;
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        }

        if (temp.taskId == taskId) {
            prev.next = temp.next;
            tail = prev;
            System.out.println("Task with ID " + taskId + " removed.");
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    // View the current task and move to the next task
    public void viewAndMoveToNext() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: ID: " + head.taskId + ", Name: " + head.taskName + ", Priority: " + head.priority + ", Due Date: " + head.dueDate);
        head = head.next;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task temp = head;
        System.out.println("Task List:");
        while (true) {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
            if (temp == head) {
                break;
            }
        }
    }

    // Search for a task by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        boolean found = false;
        while (true) {
            if (temp.priority == priority) {
                System.out.println("Task Found: ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
            if (temp == head) {
                break;
            }
        }

        if (!found) {
            System.out.println("No tasks found with Priority " + priority);
        }
    }


}

public class TaskScheduler {
    public static void main(String[] args) {
        TaskList scheduler = new TaskList();

        scheduler.addAtBeginning(1, "Task A", 1, "2025-01-30");
        scheduler.addAtEnd(2, "Task B", 2, "2025-02-15");
        scheduler.addAtPosition(3, "Task C", 1, "2025-02-20", 1);

        scheduler.displayAllTasks();

        scheduler.viewAndMoveToNext();
        scheduler.viewAndMoveToNext();

        scheduler.removeByTaskId(2);
        scheduler.displayAllTasks();

        scheduler.searchByPriority(1);
        scheduler.searchByPriority(3);
    }
}


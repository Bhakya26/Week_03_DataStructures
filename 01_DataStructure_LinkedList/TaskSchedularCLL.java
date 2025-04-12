class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;

    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private TaskNode head = null;
    private TaskNode tail = null;
    private TaskNode current = null;

    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = current = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (tail == null) {
            head = tail = current = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 1 || head == null) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode;
        }
    }

    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        TaskNode temp = head;
        TaskNode prev = tail;
        boolean found = false;

        do {
            if (temp.taskId == taskId) {
                found = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("Task ID not found.");
            return;
        }

        if (head == tail && temp == head) { // Only one node
            head = tail = current = null;
        } else if (temp == head) {
            head = head.next;
            tail.next = head;
            if (current == temp) current = head;
        } else {
            prev.next = temp.next;
            if (temp == tail) tail = prev;
            if (current == temp) current = temp.next;
        }

        System.out.println("Task with ID " + taskId + " removed.");
    }

    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }
        printTask(current);
    }

    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
        }
        viewCurrentTask();
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        System.out.println("Tasks:");
        TaskNode temp = head;
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        boolean found = false;
        TaskNode temp = head;
        do {
            if (temp.priority == priority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }

    private void printTask(TaskNode task) {
        System.out.println("ID: " + task.taskId + ", Name: " + task.taskName + ", Priority: "
                + task.priority + ", Due Date: " + task.dueDate);
    }
}

public class TaskSchedularCLL {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(1, "Write report", 2, "2025-04-12");
        scheduler.addAtBeginning(2, "Submit assignment", 1, "2025-04-10");
        scheduler.addAtPosition(2, 3, "Review code", 3, "2025-04-15");
        scheduler.addAtEnd(4, "Prepare presentation", 2, "2025-04-20");

        scheduler.displayAllTasks();

        System.out.println("\nViewing Current Task:");
        scheduler.viewCurrentTask();

        System.out.println("\nMoving to Next Task:");
        scheduler.moveToNextTask();

        System.out.println("\nSearching for Tasks with Priority 2:");
        scheduler.searchByPriority(2);

        System.out.println("\nRemoving Task ID 3:");
        scheduler.removeByTaskId(3);
        scheduler.displayAllTasks();
    }
}

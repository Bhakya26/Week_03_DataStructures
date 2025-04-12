class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

class CircularLinkedList {
    private Process head = null;
    private Process tail = null;

    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
            tail = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    public void removeProcess(int pid) {
        if (head == null) return;

        Process current = head;
        Process prev = tail;

        do {
            if (current.pid == pid) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else {
                    prev.next = current.next;
                    if (current == head) head = current.next;
                    if (current == tail) tail = prev;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) return;

        Process current = head;
        int time = 0;
        int totalWaitingTime = 0, totalTurnaroundTime = 0;
        int processCount = getProcessCount();

        while (!isEmpty()) {
            if (current.remainingTime > 0) {
                int executionTime = Math.min(current.remainingTime, timeQuantum);
                time += executionTime;
                current.remainingTime -= executionTime;

                if (current.remainingTime == 0) {
                    current.turnaroundTime = time;
                    current.waitingTime = current.turnaroundTime - current.burstTime;
                    totalWaitingTime += current.waitingTime;
                    totalTurnaroundTime += current.turnaroundTime;
                    System.out.println("Process " + current.pid + " completed.");
                    int pidToRemove = current.pid;
                    current = current.next;
                    removeProcess(pidToRemove);
                } else {
                    current = current.next;
                }

                displayProcesses();
            } else {
                current = current.next;
            }
        }

        System.out.println("\nAverage Waiting Time: " + (float) totalWaitingTime / processCount);
        System.out.println("Average Turnaround Time: " + (float) totalTurnaroundTime / processCount);
    }

    public int getProcessCount() {
        if (head == null) return 0;
        int count = 0;
        Process current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process current = head;
        System.out.println("Current Processes in Circular Queue:");
        do {
            System.out.println("PID: " + current.pid + ", Burst Time: " + current.burstTime +
                    ", Remaining: " + current.remainingTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        CircularLinkedList scheduler = new CircularLinkedList();
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        int timeQuantum = 3;
        scheduler.simulateRoundRobin(timeQuantum);
    }
}

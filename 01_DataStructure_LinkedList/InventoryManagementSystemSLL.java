class InventoryNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    InventoryNode next;

    public InventoryNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagementSystem {
    private InventoryNode head;

    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        InventoryNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position <= 1 || head == null) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        InventoryNode temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != null) {
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeById(int itemId) {
        if (head == null) return;

        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }

        InventoryNode temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Item with ID " + itemId + " removed.");
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
        }
    }

    public void updateQuantity(int itemId, int newQuantity) {
        InventoryNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for item ID " + itemId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item ID not found.");
    }

    public void searchById(int itemId) {
        InventoryNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item ID not found.");
    }

    public void searchByName(String name) {
        InventoryNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                printItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No items found with name: " + name);
    }

    public void calculateTotalValue() {
        InventoryNode temp = head;
        double total = 0;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.printf("Total Inventory Value: $%.2f\n", total);
    }

    public void sortByName(boolean ascending) {
        head = mergeSort(head, "name", ascending);
        System.out.println("Inventory sorted by name (" + (ascending ? "ascending" : "descending") + ").");
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, "price", ascending);
        System.out.println("Inventory sorted by price (" + (ascending ? "ascending" : "descending") + ").");
    }

    private InventoryNode mergeSort(InventoryNode head, String criteria, boolean ascending) {
        if (head == null || head.next == null) return head;

        InventoryNode middle = getMiddle(head);
        InventoryNode nextOfMiddle = middle.next;
        middle.next = null;

        InventoryNode left = mergeSort(head, criteria, ascending);
        InventoryNode right = mergeSort(nextOfMiddle, criteria, ascending);

        return sortedMerge(left, right, criteria, ascending);
    }

    private InventoryNode sortedMerge(InventoryNode a, InventoryNode b, String criteria, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        InventoryNode result;

        boolean condition;
        if (criteria.equals("name")) {
            condition = ascending
                ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = ascending
                ? a.price <= b.price
                : a.price > b.price;
        }

        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, criteria, ascending);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, criteria, ascending);
        }

        return result;
    }

    private InventoryNode getMiddle(InventoryNode head) {
        if (head == null) return head;

        InventoryNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayItems() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        InventoryNode temp = head;
        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    private void printItem(InventoryNode node) {
        System.out.println("ID: " + node.itemId + ", Name: " + node.itemName + ", Qty: "
                + node.quantity + ", Price: $" + node.price);
    }
}

public class InventoryManagementSystemSLL{
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        inventory.addAtEnd("Laptop", 101, 10, 999.99);
        inventory.addAtBeginning("Mouse", 102, 50, 19.99);
        inventory.addAtPosition(2, "Keyboard", 103, 30, 49.99);
        inventory.addAtEnd("Monitor", 104, 20, 149.99);

        System.out.println("\nAll Inventory Items:");
        inventory.displayItems();

        System.out.println("\nSearching by ID:");
        inventory.searchById(103);

        System.out.println("\nUpdating Quantity:");
        inventory.updateQuantity(101, 15);

        System.out.println("\nTotal Inventory Value:");
        inventory.calculateTotalValue();

        System.out.println("\nSorting by Name Ascending:");
        inventory.sortByName(true);
        inventory.displayItems();

        System.out.println("\nSorting by Price Descending:");
        inventory.sortByPrice(false);
        inventory.displayItems();

        System.out.println("\nRemoving Item with ID 102:");
        inventory.removeById(102);
        inventory.displayItems();
    }
}

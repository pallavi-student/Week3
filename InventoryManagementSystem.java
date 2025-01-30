package com.day1.level1;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagementSystem {
    private Item head;

    public InventoryManagementSystem() {
        this.head = null;
    }

    // 1. Add an item at the beginning
    public void addItemAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // 2. Add an item at the end
    public void addItemAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newItem;
    }

    // 3. Add an item at a specific position
    public void addItemAtPosition(String name, int id, int quantity, double price, int position) {
        if (position < 0) {
            System.out.println("Invalid position: cannot be less than 0.");
            return;
        }

        if (position == 0) {
            addItemAtBeginning(name, id, quantity, price);
            return;
        }

        Item newItem = new Item(name, id, quantity, price);
        Item current = head;
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position exceeds the size of the inventory. Adding at the end.");
            addItemAtEnd(name, id, quantity, price);
        } else {
            newItem.next = current.next;
            current.next = newItem;
        }
    }

    // 4. Remove an item based on Item ID
    public void removeItemById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.id == id) {
            head = head.next;
            System.out.println("Item with ID " + id + " removed.");
            return;
        }

        Item current = head;
        while (current.next != null && current.next.id != id) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Item with ID " + id + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Item with ID " + id + " removed.");
        }
    }

    // 5. Update the quantity of an item by Item ID
    public void updateItemQuantity(int id, int newQuantity) {
        Item current = head;
        while (current != null) {
            if (current.id == id) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + id + ".");
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    // 6. Search for an item based on Item ID or Name
    public void searchItemById(int id) {
        Item current = head;
        while (current != null) {
            if (current.id == id) {
                displayItem(current);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    public void searchItemByName(String name) {
        Item current = head;
        boolean found = false;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                displayItem(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Item with name" + name +  "not found.");
        }
    }

    // 7. Calculate and display total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        Item current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        System.out.println("Total inventory value: " + totalValue);
    }

    // 8. Sort inventory by Name or Price
    public void sortInventoryByName() {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSort(head, true);
        System.out.println("Inventory sorted by name.");
    }

    public void sortInventoryByPrice() {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSort(head, false);
        System.out.println("Inventory sorted by price.");
    }

    private Item mergeSort(Item head, boolean sortByName) {
        if (head == null || head.next == null) {
            return head;
        }

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;

        middle.next = null;

        Item left = mergeSort(head, sortByName);
        Item right = mergeSort(nextOfMiddle, sortByName);

        return merge(left, right, sortByName);
    }

    private Item merge(Item left, Item right, boolean sortByName) {
        if (left == null) return right;
        if (right == null) return left;

        Item result;
        if ((sortByName && left.name.compareToIgnoreCase(right.name) <= 0) ||
                (!sortByName && left.price <= right.price)) {
            result = left;
            result.next = merge(left.next, right, sortByName);
        } else {
            result = right;
            result.next = merge(left, right.next, sortByName);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;

        Item slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Display an item
    private void displayItem(Item item) {
        System.out.println("ID: " + item.id + ", Name: " + item.name +
                ", Quantity: " + item.quantity + ", Price: " + item.price);
    }

    // Display the entire inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        Item current = head;
        while (current != null) {
            displayItem(current);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addItemAtBeginning("ItemA", 101, 10, 50.0);
        ims.addItemAtEnd("ItemB", 102, 5, 30.0);
        ims.addItemAtPosition("ItemC", 103, 20, 25.0, 1);

        System.out.println("Inventory:");
        ims.displayInventory();

        ims.removeItemById(102);
        System.out.println("After removing Item ID 102:");
        ims.displayInventory();

        ims.updateItemQuantity(103, 15);
        System.out.println("After updating quantity of Item ID 103:");
        ims.displayInventory();

        ims.searchItemById(101);
        ims.searchItemByName("ItemC");

        ims.calculateTotalValue();

        ims.sortInventoryByName();
        System.out.println("After sorting by name:");
        ims.displayInventory();

        ims.sortInventoryByPrice();
        System.out.println("After sorting by price:");
        ims.displayInventory();
    }
}

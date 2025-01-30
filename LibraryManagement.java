package com.day1.level1;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryManagement {
    private Book head;
    private Book tail;
    private int bookCount;

    public LibraryManagement() {
        this.head = null;
        this.tail = null;
        this.bookCount = 0;
    }

    // 1. Add a new book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);

        if (head == null) { // Empty list
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }

    // 2. Add a new book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);

        if (head == null) { // Empty list
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    // 3. Add a book at a specific position
    public void addBookAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 0) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        int index = 0;

        while (temp != null && index < position - 1) {
            temp = temp.next;
            index++;
        }

        if (temp == null) {
            System.out.println("Position out of bounds. Adding at the end.");
            addBookAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;

            if (temp.next != null) {
                temp.next.prev = newBook;
            }
            temp.next = newBook;

            if (temp == tail) {
                tail = newBook;
            }
            bookCount++;
        }
    }

    // 4. Remove a book by Book ID
    public void removeBookById(int bookId) {
        if (head == null) {
            System.out.println("The library is empty.");
            return;
        }

        Book temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head) { // Removing the head
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (temp == tail) { // Removing the tail
                    tail = tail.prev;
                    tail.next = null;
                } else { // Removing from middle
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                bookCount--;
                System.out.println("Book with ID " + bookId + " removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // 5. Search for a book by Book Title or Author
    public void searchBook(String keyword) {
        if (head == null) {
            System.out.println("The library is empty.");
            return;
        }

        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(keyword) || temp.author.equalsIgnoreCase(keyword)) {
                System.out.println("Book Found -> ID: " + temp.bookId + ", Title: " + temp.title +
                        ", Author: " + temp.author + ", Genre: " + temp.genre +
                        ", Available: " + (temp.isAvailable ? "Yes" : "No"));
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No book found with Title/Author: " + keyword);
        }
    }

    // 6. Update a book’s Availability Status
    public void updateAvailability(int bookId, boolean status) {
        if (head == null) {
            System.out.println("The library is empty.");
            return;
        }

        Book temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                System.out.println("Updated Book ID " + bookId + " availability to " + (status ? "Available" : "Not Available"));
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    // 7. Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("The library is empty.");
            return;
        }

        Book temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title +
                    ", Author: " + temp.author + ", Genre: " + temp.genre +
                    ", Available: " + (temp.isAvailable ? "Yes" : "No"));
            temp = temp.next;
        }
    }

    // 8. Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("The library is empty.");
            return;
        }

        Book temp = tail;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title +
                    ", Author: " + temp.author + ", Genre: " + temp.genre +
                    ", Available: " + (temp.isAvailable ? "Yes" : "No"));
            temp = temp.prev;
        }
    }

    // 9. Count the total number of books
    public int countBooks() {
        return bookCount;
    }

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        library.addBookAtEnd("Book A", "Author X", "Fiction", 101, true);
        library.addBookAtBeginning("Book B", "Author Y", "Science", 102, false);
        library.addBookAtPosition("Book C", "Author Z", "Fantasy", 103, true, 1);

        System.out.println("All Books in Forward Order:");
        library.displayBooksForward();

        System.out.println("All Books in Reverse Order:");
        library.displayBooksReverse();

        System.out.println("Search for a Book by Title:");
        library.searchBook("Book B");

        System.out.println("Update Book Availability:");
        library.updateAvailability(102, true);

        System.out.println("Remove a Book:");
        library.removeBookById(103);

        System.out.println("Total Books in Library: " + library.countBooks());

        System.out.println("All Books After Removal:");
        library.displayBooksForward();
    }
}

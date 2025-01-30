package com.day1.level1;
class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextList {
    private TextState currentState;
    private int historySize;
    private int currentSize;

    // Constructor with a fixed history size
    public TextList(int historySize) {
        this.historySize = historySize;
        this.currentSize = 0;
        this.currentState = null;
    }

    // Add a new text state at the end of the list
    public void addTextState(String content) {
        TextState newState = new TextState(content);
        if (currentState == null) {
            currentState = newState;
        } else {
            // Trim history if it exceeds the fixed size
            if (currentSize == historySize) {
                removeOldestState();
            }
            // Set the next pointer of the current state to the new state
            currentState.next = newState;
            newState.prev = currentState;
            currentState = newState;
        }
        currentSize++;
        System.out.println("Current Text: " + content);
    }

    // Remove the oldest state (used when history exceeds size)
    private void removeOldestState() {
        if (currentState != null && currentState.prev != null) {
            currentState.prev.next = null;
            currentState = currentState.prev;
            currentSize--;
        }
    }

    // Undo the last action
    public void undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("Nothing to undo.");
            return;
        }
        currentState = currentState.prev;
        System.out.println("Undo: " + currentState.content);
    }

    // Redo the last undone action
    public void redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("Nothing to redo.");
            return;
        }
        currentState = currentState.next;
        System.out.println("Redo: " + currentState.content);
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (currentState == null) {
            System.out.println("No content yet.");
        } else {
            System.out.println("Current State: " + currentState.content);
        }
    }
}

public class TextEditor{
    public static void main(String[] args) {

        TextList editor = new TextList(5);

        // Simulating user actions
        editor.addTextState("Hello");
        editor.addTextState("Hello, world!");
        editor.addTextState("Hello, world! How are you?");
        editor.addTextState("Hello, world! How are you? I'm good.");
        editor.addTextState("Hello, world! How are you? I'm good. How about you?");
        editor.addTextState("Hello, world! How are you? I'm good. How about you? Let's meet.");

        // Display the current state
        editor.displayCurrentState();

        // Perform some undo operations
        editor.undo();
        editor.undo();

        // Perform a redo operation
        editor.redo();

        // Add a new state after redo
        editor.addTextState("Hello, world! How are you? Let's meet soon.");

        // Display the current state again
        editor.displayCurrentState();

        // Perform undo and redo after adding a new state
        editor.undo();
        editor.redo();
    }
}



package com.day1.level1;
import java.util.ArrayList;
class FriendNode {
    int friendId;
    FriendNode next;

    public FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friends;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }

    // Add a friend to the user's friend list
    public void addFriend(int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        if (friends == null) {
            friends = newFriend;
        } else {
            FriendNode temp = friends;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newFriend;
        }
    }

    // Remove a friend from the user's friend list
    public void removeFriend(int friendId) {
        if (friends == null) return;

        // If the first friend is the one to be removed
        if (friends.friendId == friendId) {
            friends = friends.next;
            return;
        }

        FriendNode temp = friends;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Display all friends of the user
    public void displayFriends() {
        if (friends == null) {
            System.out.println("No friends.");
            return;
        }
        FriendNode temp = friends;
        System.out.print("Friends of " + name + ": ");
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find mutual friends between this user and another user
    public ArrayList<Integer> findMutualFriends(UserNode otherUser) {
        ArrayList<Integer> mutualFriends = new ArrayList<>();
        FriendNode thisUserFriends = this.friends;
        while (thisUserFriends != null) {
            FriendNode otherUserFriends = otherUser.friends;
            while (otherUserFriends != null) {
                if (thisUserFriends.friendId == otherUserFriends.friendId) {
                    mutualFriends.add(thisUserFriends.friendId);
                    break;
                }
                otherUserFriends = otherUserFriends.next;
            }
            thisUserFriends = thisUserFriends.next;
        }
        return mutualFriends;
    }

    // Count the number of friends
    public int countFriends() {
        int count = 0;
        FriendNode temp = friends;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

class SocialMedia {
    private UserNode head;

    public SocialMedia() {
        this.head = null;
    }

    // Add a user to the system
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    // Find a user by ID
    public UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Find a user by name
    public UserNode findUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        }
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        }
    }

    // Display all users
    public void displayAllUsers() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }

    // Display mutual friends between two users
    public void displayMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            ArrayList<Integer> mutualFriends = user1.findMutualFriends(user2);
            if (mutualFriends.isEmpty()) {
                System.out.println("No mutual friends between " + user1.name + " and " + user2.name);
            } else {
                System.out.print("Mutual Friends between " + user1.name + " and " + user2.name + ": ");
                for (int friendId : mutualFriends) {
                    System.out.print(friendId + " ");
                }
                System.out.println();
            }
        }
    }

    // Display all friends of a user by User ID
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user != null) {
            user.displayFriends();
        } else {
            System.out.println("User not found.");
        }
    }
}

public class SocialMediaConnection {
    public static void main(String[] args) {
        SocialMedia social = new SocialMedia();

        // Add users
        social.addUser(1, "Alice", 25);
        social.addUser(2, "Bob", 30);
        social.addUser(3, "John", 28);
        social.addUser(4, "Johny", 22);

        // Add friend connections
        social.addFriendConnection(1, 2);
        social.addFriendConnection(1, 3);
        social.addFriendConnection(2, 3);
        social.addFriendConnection(3, 4);

        // Display all users
        social.displayAllUsers();

        // Display all friends of a specific user
        social.displayFriends(1);

        // Remove a friend connection
        social.removeFriendConnection(1, 2);

        // Display mutual friends between two users
        social.displayMutualFriends(1, 3);

        // Count the number of friends for a user
        System.out.println("Number of friends of Alice: " + social.findUserById(1).countFriends());
    }
}

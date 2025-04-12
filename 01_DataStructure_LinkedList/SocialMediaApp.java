import java.util.ArrayList;
import java.util.List;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialNetwork {
    private UserNode head;

    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    private UserNode findUserById(int userId) {
        UserNode current = head;
        while (current != null) {
            if (current.userId == userId) return current;
            current = current.next;
        }
        return null;
    }

    public void addFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if (user1 == null || user2 == null) return;
        if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
        if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
    }

    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if (user1 != null) user1.friendIds.remove((Integer) userId2);
        if (user2 != null) user2.friendIds.remove((Integer) userId1);
    }

    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if (user1 == null || user2 == null) return;
        for (int friendId : user1.friendIds) {
            if (user2.friendIds.contains(friendId)) {
                UserNode mutual = findUserById(friendId);
                System.out.println("ID: " + mutual.userId + ", Name: " + mutual.name);
            }
        }
    }

    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) return;
        System.out.println(user.name + "'s Friends:");
        for (int friendId : user.friendIds) {
            UserNode friend = findUserById(friendId);
            if (friend != null) {
                System.out.println("ID: " + friend.userId + ", Name: " + friend.name);
            }
        }
    }

    public void searchUser(String nameOrId) {
        UserNode current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(nameOrId) || String.valueOf(current.userId).equals(nameOrId)) {
                System.out.println("ID: " + current.userId + ", Name: " + current.name + ", Age: " + current.age);
            }
            current = current.next;
        }
    }

    public void countFriends() {
        UserNode current = head;
        while (current != null) {
            System.out.println("User ID: " + current.userId + " has " + current.friendIds.size() + " friends.");
            current = current.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork();

        sn.addUser(1, "Alice", 20);
        sn.addUser(2, "Bob", 22);
        sn.addUser(3, "Charlie", 25);
        sn.addUser(4, "Diana", 23);

        sn.addFriend(1, 2);
        sn.addFriend(1, 3);
        sn.addFriend(2, 3);
        sn.addFriend(3, 4);

        sn.displayFriends(1);
        sn.findMutualFriends(1, 2);
        sn.searchUser("Charlie");
        sn.countFriends();
        sn.removeFriend(1, 2);
        sn.displayFriends(1);
    }
}

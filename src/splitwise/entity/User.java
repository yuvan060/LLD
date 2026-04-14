package splitwise.entity;

import splitwise.enums.Role;
import java.time.LocalDateTime;
import java.util.*;

public class User {
    private final String userId;
    private String name;
    private String email;
    private final LocalDateTime createdAt;
    private final Map<String, Friendship> friendships; // userId -> Friendship
    private final Map<String, Group> groups; // groupId -> Group
    private final Map<String, Split> unpaidSplits; // splitId -> Split

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.createdAt = LocalDateTime.now();
        this.friendships = new HashMap<>();
        this.groups = new HashMap<>();
        this.unpaidSplits = new HashMap<>();
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Map<String, Friendship> getFriendships() {
        return friendships;
    }

    public Map<String, Group> getGroups() {
        return groups;
    }

    public Map<String, Split> getUnpaidSplits() {
        return unpaidSplits;
    }

    // Core Methods
    public Group createGroup(String groupName, String description) {
        Group group = new Group(UUID.randomUUID().toString(), groupName, description, this);
        groups.put(group.getGroupId(), group);
        return group;
    }

    public void addFriendship(User otherUser) {
        String friendshipId = generateFriendshipId(this.userId, otherUser.getUserId());
        if (!friendships.containsKey(friendshipId)) {
            Friendship friendship = new Friendship(friendshipId, this, otherUser);
            friendships.put(friendshipId, friendship);
        }
    }

    public void addUnpaidSplit(Split split) {
        unpaidSplits.put(split.getSplitId(), split);
    }

    public void removeUnpaidSplit(String splitId) {
        unpaidSplits.remove(splitId);
    }

    public double getTotalAmountOwed() {
        return unpaidSplits.values().stream()
                .filter(split -> !split.isSettled())
                .mapToDouble(Split::getAmount)
                .sum();
    }

    public double getTotalAmountToReceive() {
        return unpaidSplits.values().stream()
                .filter(split -> !split.isSettled())
                .mapToDouble(Split::getAmount)
                .sum();
    }

    public void notify(Notification notification) {
        // TODO: Implement notification logic - send email/push notification
        System.out.println("Notifying user " + this.name + ": " + notification.getMessage());
    }

    private String generateFriendshipId(String userId1, String userId2) {
        return userId1.compareTo(userId2) < 0 ? userId1 + "_" + userId2 : userId2 + "_" + userId1;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}



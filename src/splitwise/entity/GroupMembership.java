package splitwise.entity;

import splitwise.enums.Role;
import java.time.LocalDateTime;

public class GroupMembership {
    private final User user;
    private final Group group;
    private Role role;
    private final LocalDateTime joinDate;

    public GroupMembership(User user, Group group, Role role) {
        this.user = user;
        this.group = group;
        this.role = role;
        this.joinDate = LocalDateTime.now();
    }

    // Getters
    public User getUser() {
        return user;
    }

    public Group getGroup() {
        return group;
    }

    public Role getRole() {
        return role;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    // Core Methods
    public void setRole(Role role) {
        this.role = role;
    }

    public boolean canModifyGroup() {
        return role == Role.OWNER || role == Role.ADMIN;
    }

    public boolean canDeleteGroup() {
        return role == Role.OWNER;
    }

    public boolean canDeleteExpense() {
        return role == Role.OWNER || role == Role.ADMIN;
    }

    @Override
    public String toString() {
        return "GroupMembership{" +
                "user=" + user.getName() +
                ", role=" + role +
                ", joinDate=" + joinDate +
                '}';
    }
}


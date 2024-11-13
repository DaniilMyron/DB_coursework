package com.miron.kursach.models;

public class SelectRole {
    private static Role role;

    public SelectRole(Role role) {
        SelectRole.role = role;
    }

    public static Role getRole() {
        return role;
    }
}

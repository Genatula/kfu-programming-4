package ru.kpfu.itis.genatulin.hw4_2.models;

@ArrayFields(fields = {"members"})
public class Group {
    private String[] members;

    public Group(String[] members) {
        this.members = members;
    }

    public String[] getMembers() {
        return members;
    }
}

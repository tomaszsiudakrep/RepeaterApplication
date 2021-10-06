package com.quiz.quizapplication.importantInformation.objects;

public class GroupInformation {

    private String groupName;
    private boolean archived;

    public GroupInformation(String groupName) {
        this.groupName = groupName;
        archived = false;
    }

    public String getGroupName() {
        return groupName;
    }

    public boolean isArchived() {
        return archived;
    }

    @Override
    public String toString() {
        return "GroupInformation{" +
                "groupName='" + groupName + '\'' +
                ", archived=" + archived +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupInformation that = (GroupInformation) o;

        if (archived != that.archived) return false;
        return groupName != null ? groupName.equals(that.groupName) : that.groupName == null;
    }

    @Override
    public int hashCode() {
        int result = groupName != null ? groupName.hashCode() : 0;
        result = 31 * result + (archived ? 1 : 0);
        return result;
    }
}

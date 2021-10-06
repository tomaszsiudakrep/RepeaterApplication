package com.quiz.quizapplication.importantInformation.objects;

public class ImportantInformation {

    private boolean archivedInformation;
    private String title;
    private String description;

    public ImportantInformation( String title, String description) {
        archivedInformation = false;
        this.title = title;
        this.description = description;
    }

    public boolean isArchivedInformation() {
        return archivedInformation;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImportantInformation that = (ImportantInformation) o;

        if (archivedInformation != that.archivedInformation) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = (archivedInformation ? 1 : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ImportantInformation{" +
                "archivedInformation=" + archivedInformation +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

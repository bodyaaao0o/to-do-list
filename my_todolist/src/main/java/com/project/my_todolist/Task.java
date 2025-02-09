package com.project.my_todolist;

import java.time.LocalDate;

public class Task {

    private String title;
    private String description;
    private LocalDate deadline;
    private boolean isCompleted;

    public Task(String title, String description, LocalDate deadline, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.isCompleted = isCompleted; // виправлено
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = completed; // виправлено
    }

    public void AsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return title + " (Дедлайн: " + deadline + ") - " + (isCompleted ? "Виконано" : "Невиконано");
    }

}

package com.developer.bugs.response;

public class BugResponse {
    private long id;
    private String title;
    private String description;
    private int priority;
    private boolean resolved;

    public BugResponse(long id, String title, String description, int priority, boolean resolved) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.resolved = resolved;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
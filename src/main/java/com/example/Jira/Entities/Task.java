package com.example.Jira.Entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name ="tasks")
public class Task {

    @Id
    @Column(name = "task_id")
    private String id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name ="task_priority")
    private String priority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }

}

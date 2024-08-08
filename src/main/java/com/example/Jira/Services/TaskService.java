package com.example.Jira.Services;

import com.example.Jira.Entities.Task;
import com.example.Jira.Repositories.TaskDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskDAO taskDAO;

    public List<Task> retrieveAllTask() {
        return taskDAO.findAll();
    }

    @Transactional
    public ResponseEntity<List<Task>> addTasks(List<Task> tasks) {
        return new ResponseEntity<>(taskDAO.saveAll(tasks), HttpStatus.OK);
    }

    @Transactional
    public void deleteTasks(List<String> tasksId) {
        taskDAO.deleteByIds(tasksId);

    }

    public ResponseEntity<List<Task>> filterByPriority(String priority) {
        return new ResponseEntity<>(taskDAO.findByPriority(priority),HttpStatus.OK);

    }
}

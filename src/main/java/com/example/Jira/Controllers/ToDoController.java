package com.example.Jira.Controllers;

import com.example.Jira.Entities.Task;
import com.example.Jira.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    TaskService taskService;

    @GetMapping("/allTasks")
    public ResponseEntity<?> allTasks(){
        return ResponseEntity.ok(taskService.retrieveAllTask());
    }

    @PostMapping("/addTask")
    public ResponseEntity<List<Task>> addTask(@RequestBody List<Task> tasks){
        return taskService.addTasks(tasks);
    }

    @DeleteMapping("/deleteTasks")
    public void deleteTasks(@RequestBody List<String> tasksId){
         taskService.deleteTasks(tasksId);
    }

    @GetMapping("/getTasksByPriority/{priority}")
    public ResponseEntity<List<Task>> getTasksByPriority(@PathVariable String priority){
        return taskService.filterByPriority(priority);
    }

}
package org.example.taskmanagerapi.controller;

import org.example.taskmanagerapi.model.Task;
import org.example.taskmanagerapi.service.TaskService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Task Controller", description = "CRUD API for managing tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(
            summary = "Get all tasks",
            description = "Retrieve a list of all tasks stored in the system."
    )
    @ApiResponse(responseCode = "200", description = "Successfully retrieved task list")
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @Operation(
            summary = "Get task by ID",
            description = "Retrieve a single task by its unique identifier."
    )
    @ApiResponse(responseCode = "200", description = "Task found")
    @ApiResponse(responseCode = "404", description = "Task not found")
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @Operation(
            summary = "Create a new task",
            description = "Add a new task with title, description and status."
    )
    @ApiResponse(responseCode = "201", description = "Task created successfully")
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @Operation(
            summary = "Update an existing task",
            description = "Update the details of an existing task by its ID."
    )
    @ApiResponse(responseCode = "200", description = "Task updated successfully")
    @ApiResponse(responseCode = "404", description = "Task not found")
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @Operation(
            summary = "Delete a task",
            description = "Delete a task from the system by its ID."
    )
    @ApiResponse(responseCode = "200", description = "Task deleted successfully")
    @ApiResponse(responseCode = "404", description = "Task not found")
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id) ? "Deleted" : "Not found";
    }
}
package org.example.taskmanagerapi.service;

import org.example.taskmanagerapi.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private Long counter = 1L;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(Long id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Task addTask(Task task) {
        task.setId(counter++);
        tasks.add(task);
        return task;
    }

    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> existing = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();

        if (existing.isPresent()) {
            Task task = existing.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            return task;
        }
        return null;
    }

    public boolean deleteTask(Long id) {
        return tasks.removeIf(t -> t.getId().equals(id));
    }
}
package org.example.taskmanagerapi.repository;

import org.example.taskmanagerapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
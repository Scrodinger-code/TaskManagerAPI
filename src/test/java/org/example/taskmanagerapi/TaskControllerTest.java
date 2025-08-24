package org.example.taskmanagerapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.taskmanagerapi.model.Task;
import org.example.taskmanagerapi.service.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnAllTasks() throws Exception {
        Mockito.when(taskService.getAllTasks())
                .thenReturn(List.of(new Task(1L, "Test Task", "Description", "NEW")));

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Test Task"));
    }

    @Test
    void shouldReturnTaskById() throws Exception {
        Mockito.when(taskService.getTaskById(1L))
                .thenReturn(new Task(1L, "Test Task", "Description", "NEW"));

        mockMvc.perform(get("/tasks/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Task"));
    }

    @Test
    void shouldCreateTask() throws Exception {
        Task task = new Task(1L, "New Task", "Description", "NEW");
        Mockito.when(taskService.addTask(any(Task.class))).thenReturn(task);

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("New Task"));
    }

    @Test
    void shouldUpdateTask() throws Exception {
        Task updatedTask = new Task(1L, "Updated Task", "Updated Description", "DONE");
        Mockito.when(taskService.updateTask(eq(1L), any(Task.class))).thenReturn(updatedTask);

        mockMvc.perform(put("/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedTask)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Task"));
    }

    @Test
    void shouldDeleteTask() throws Exception {
        Mockito.when(taskService.deleteTask(1L)).thenReturn(true);

        mockMvc.perform(delete("/tasks/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted"));
    }
}
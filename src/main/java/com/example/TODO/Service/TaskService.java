package com.example.TODO.Service;


import com.example.TODO.Entity.Task;
import com.example.TODO.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task updateTaskStatus(String id, Task.Status status) {
        Task task = getTaskById(id); // Fetch the task
        task.setStatus(status);     // Update the status
        return repository.save(task); // Save the updated task
    }

    public void deleteTask(String id) {
        repository.deleteById(id);
    }
}

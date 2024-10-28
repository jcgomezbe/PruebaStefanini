package com.Tasks.tasks.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import com.Tasks.tasks.Model.*;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public Task createTask(String title, String description) {
        Task task = new Task(counter.incrementAndGet(), title, description);
        tasks.add(task);
        return task;
    }

    public boolean deleteTask(Long id) {
        return tasks.removeIf(task -> task.getId().equals(id));
    }

    public Optional<Task> getTaskById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }
}

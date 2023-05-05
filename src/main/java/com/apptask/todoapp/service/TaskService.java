package com.apptask.todoapp.service;

import org.springframework.stereotype.Service;

import com.apptask.todoapp.persistence.entity.Task;
import com.apptask.todoapp.persistence.repository.TaskRepository;
import com.apptask.todoapp.service.dto.TaskInDTO;

@Service
public class TaskService {
	
	private final TaskRepository repository;

	public TaskService(TaskRepository repository) {
		this.repository = repository;
	}
	
	public Task createTask(TaskInDTO taskInDTO) {
		this.repository.save(entity);
	}
}

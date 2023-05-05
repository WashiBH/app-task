package com.apptask.todoapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.apptask.todoapp.exceptions.TaskExceptions;
import com.apptask.todoapp.mapper.TaskInDTOToTask;
import com.apptask.todoapp.persistence.entity.Task;
import com.apptask.todoapp.persistence.entity.TaskStatus;
import com.apptask.todoapp.persistence.repository.TaskRepository;
import com.apptask.todoapp.service.dto.TaskInDTO;

@Service
public class TaskService {

	private final TaskRepository repository;
	private final TaskInDTOToTask mapper;

	public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public Task createTask(TaskInDTO taskInDTO) {

		Task task = mapper.map(taskInDTO);
		return this.repository.save(task);

	}

	public List<Task> findAll() {
		return this.repository.findAll();
	}

	public List<Task> findAllByTaskStatus(TaskStatus taskStatus) {
		return this.repository.findAllByTaskStatus(taskStatus);
	}

	@Transactional
	public void updateTaskAsFinished(Long id) {
		Optional<Task> optionalTask = this.repository.findById(id);
		if (optionalTask.isEmpty()) {
			throw new TaskExceptions("Task not found", HttpStatus.NOT_FOUND);
		}
		this.repository.markTaskAsFinished(id);
	}

	@Transactional
	public void deleteById(Long id) {
		Optional<Task> optionalTask = this.repository.findById(id);
		if (optionalTask.isEmpty()) {
			throw new TaskExceptions("Task not found", HttpStatus.NOT_FOUND);
		}
		this.repository.deleteById(id);
	}
}

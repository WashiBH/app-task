package com.apptask.todoapp.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.apptask.todoapp.persistence.entity.Task;
import com.apptask.todoapp.persistence.entity.TaskStatus;
import com.apptask.todoapp.service.dto.TaskInDTO;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task> {

	@Override
	public Task map(TaskInDTO in) {
		Task task = new Task();
		task.setTitle(in.getTitle());
		task.setDescription(in.getDescription());
		task.setEta(in.getEta());
		task.setCreatedDate(LocalDateTime.now());
		task.setFinished(false);
		task.setTaskStatus(TaskStatus.ON_TIME);
		return task;
	}

}

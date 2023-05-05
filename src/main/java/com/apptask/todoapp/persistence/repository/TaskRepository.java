package com.apptask.todoapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apptask.todoapp.persistence.entity.Task;
import com.apptask.todoapp.persistence.entity.TaskStatus;

public interface TaskRepository extends JpaRepository<Task, Long> {
	public List<Task> findAllByTaskStatus(TaskStatus taskStatus);

	@Modifying
	@Query(value = "update task set finished = true where id = :id", nativeQuery = true)
	public void markTaskAsFinished(@Param("id") Long id);
}

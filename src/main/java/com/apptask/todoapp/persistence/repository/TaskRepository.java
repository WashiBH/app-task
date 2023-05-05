package com.apptask.todoapp.persistence.repository;

import com.apptask.todoapp.persistence.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>{

}

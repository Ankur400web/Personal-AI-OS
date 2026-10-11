package com.personalai.os.task.repository;

import com.personalai.os.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    List<Task> findAllByUserId(UUID id);

    Optional<Task> findByIdAndUserId(UUID taskId, UUID userId);
}

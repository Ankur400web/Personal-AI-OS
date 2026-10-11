package com.personalai.os.task.dto;


import com.personalai.os.enums.TaskPriority;
import com.personalai.os.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class TaskResponse {

    private UUID id;
    private  String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private OffsetDateTime dueAt;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}

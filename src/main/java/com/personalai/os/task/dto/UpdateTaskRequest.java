package com.personalai.os.task.dto;


import com.personalai.os.enums.TaskPriority;
import com.personalai.os.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class UpdateTaskRequest {


    @NotBlank
    @Size(max = 200)
    private String title;

    private String description;

    @NotNull
    private TaskStatus status;

    private TaskPriority priority = TaskPriority.MEDIUM;

    private OffsetDateTime dueAt;
}

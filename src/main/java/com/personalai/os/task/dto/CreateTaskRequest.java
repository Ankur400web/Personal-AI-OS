package com.personalai.os.task.dto;


import com.personalai.os.enums.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


import java.time.OffsetDateTime;

@Getter
@Setter
public class CreateTaskRequest {

    @NotBlank
    @Size(max = 200)
    private String title;

    private String description;

    private TaskPriority priority = TaskPriority.MEDIUM;

    private OffsetDateTime dueAt;
}

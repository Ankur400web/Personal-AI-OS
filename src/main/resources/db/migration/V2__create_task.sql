CREATE TABLE tasks(
    id UUID PRIMARY KEY ,
    user_id UUID NOT NULL ,
    title VARCHAR(200) NOT NULL ,
    description VARCHAR(500) ,
    status VARCHAR(20) NOT NULL DEFAULT 'TODO',
    priority VARCHAR(20) NOT NULL DEFAULT 'MEDIUM',
    due_at TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,

    CONSTRAINT fk_tasks_user
        FOREIGN KEY (user_id)
            REFERENCES users(id)
            ON DELETE CASCADE
    
);

CREATE INDEX idx_tasks_user_id ON tasks(user_id);
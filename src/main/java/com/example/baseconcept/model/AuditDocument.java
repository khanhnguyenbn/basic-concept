package com.example.baseconcept.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
public abstract class AuditDocument {
    @Field("created_at")
    private Date createdAt;

    @Field("updated_at")
    private Date updatedAt;
}

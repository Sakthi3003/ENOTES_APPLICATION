package com.enotes.Enotes.entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Column(name ="is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
    private Integer createdBy;
    private LocalDate createdDate;
    private Integer updatedBy;
    private LocalDate updatedDate;
}

package com.fitandfocused.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "tb_personal_trainer")
public class PersonalTrainer extends User {
    private String cref;
    private String specialization;
}
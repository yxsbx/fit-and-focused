package com.fitandfocused.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "tb_cancellation_policy")
public class CancellationPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long trainerId;
    private int minimumNoticeHours;
    private String penalty;
}

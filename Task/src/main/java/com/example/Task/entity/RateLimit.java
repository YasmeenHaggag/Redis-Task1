package com.example.Task.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "rate_limit")
public class RateLimit {
    @Id
    private int id;

    private int userId;
    private int maxRequests;
    private int duration;

}

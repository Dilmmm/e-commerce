package com.ecommerce.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    public Cart() {
    }

    public Cart(User user, LocalDateTime creationDate) {
        this.user = user;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

}

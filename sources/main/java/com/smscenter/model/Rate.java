package com.smscenter.model;

import javax.persistence.*;

/**
 * Rate Data
 * Тарифы
 *
 * @author Evgenii Evgenevich
 */
@Entity
@Table(name = "rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "is_active", nullable = false, columnDefinition = "boolean DEFAULT true")
    private boolean isActive = true;

    @Column(name = "title", nullable = false)
    private String title;

    public Long getId() {
        return this.id;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public String getTitle() {
        return this.title;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

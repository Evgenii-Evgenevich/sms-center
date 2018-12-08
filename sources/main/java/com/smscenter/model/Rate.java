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
    boolean isActive = true;

    @Column(name = "title", nullable = false)
    private String title;
}

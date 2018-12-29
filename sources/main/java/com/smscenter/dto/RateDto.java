package com.smscenter.dto;

import com.smscenter.model.Rate;

/**
 * Rate Data Transfer Object
 * Тарифы
 *
 * @author Evgenii Evgenevich
 */
public class RateDto {
    private long id;

    private String title;

    private RateDto() {
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public static RateDto of(Rate rate) {
        if (rate == null) return null;
        RateDto dto = new RateDto();
        dto.id = rate.getId();
        dto.title = rate.getTitle();
        return dto;
    }
}

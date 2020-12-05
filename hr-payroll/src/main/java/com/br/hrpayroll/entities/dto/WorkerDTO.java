package com.br.hrpayroll.entities.dto;

import java.io.Serializable;

public class WorkerDTO implements Serializable {

    private long id;
    private String name;
    private Double dailyIncome;

    public WorkerDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }
}

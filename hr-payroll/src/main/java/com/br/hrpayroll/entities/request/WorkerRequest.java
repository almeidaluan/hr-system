package com.br.hrpayroll.entities.request;

import java.util.List;

public class WorkerRequest {

    public List<Opcao> option;
    public String name;
    public Long id;

    public WorkerRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

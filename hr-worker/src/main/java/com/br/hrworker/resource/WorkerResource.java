package com.br.hrworker.resource;

import com.br.hrworker.entities.Worker;
import com.br.hrworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> AllWorkers(){

        List<Worker> workers = repository.findAll();

        return ResponseEntity.ok(workers);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Optional<Worker>> FindWorker(@PathVariable long id){
        return ResponseEntity.ok(repository.findById(id));
    }
}

package com.br.hrworker.resource;

import com.br.hrworker.entities.Worker;
import com.br.hrworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/Param")
    public ResponseEntity<Optional<Worker>> FindWorkerQueryParam(@RequestParam Long id){
        return ResponseEntity.ok(repository.findById(id));
    }
}

package controllers;

import models.Andriana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import services.AndrianaService;

@RestController 
@RequestMapping("/andrianas")
public class AndrianaController {
    private final AndrianaService andrianaService;

    @Autowired
    public AndrianaController(AndrianaService andrianaService) {
        this.andrianaService = andrianaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Andriana> getAndrianaById(@PathVariable Long id) {
        Andriana andriana = andrianaService.getAndrianaById(id);
        return new ResponseEntity<>(andriana, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Andriana> createAndriana(@RequestBody Andriana andriana) {
        Andriana createdAndriana = andrianaService.createAndriana(andriana);
        return new ResponseEntity<>(createdAndriana, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Andriana> updateAndriana(@PathVariable Long id, @RequestBody Andriana Andriana) {
        Andriana updatedAndriana = andrianaService.updateAndriana(id, andriana);
        return new ResponseEntity<>(updatedAndriana, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAndriana(@PathVariable Long id) {
        andrianaService.deleteAndriana(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

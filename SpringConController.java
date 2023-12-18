package controllers;

import models.SpringCon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import services.SpringConService;

@RestController 
@RequestMapping("/springcons")
public class SpringConController {
    private final SpringConService springconService;

    @Autowired
    public SpringConController(SpringConService springconService) {
        this.springconService = springconService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpringCon> getSpringConById(@PathVariable Long id) {
        SpringCon springcon = springconService.getSpringConById(id);
        return new ResponseEntity<>(springcon, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SpringCon> createSpringCon(@RequestBody SpringCon springcon) {
        SpringCon createdSpringCon = springconService.createSpringCon(springcon);
        return new ResponseEntity<>(createdSpringCon, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpringCon> updateSpringCon(@PathVariable Long id, @RequestBody SpringCon SpringCon) {
        SpringCon updatedSpringCon = springconService.updateSpringCon(id, springcon);
        return new ResponseEntity<>(updatedSpringCon, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpringCon(@PathVariable Long id) {
        springconService.deleteSpringCon(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

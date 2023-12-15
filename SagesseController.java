package Controllers;

import models.Sagesse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import services.SagesseService;

@RestController
@RequestMapping("/Sagesses")
public class SagesseController {
    private final SagesseService SagesseService;

    @Autowired
    public SagesseController(SagesseService SagesseService) {
        this.SagesseService = SagesseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sagesse> getSagesseById(@PathVariable Long id) {
        Sagesse Sagesse = SagesseService.getSagesseById(id);
        return new ResponseEntity<>(Sagesse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sagesse> createSagesse(@RequestBody Sagesse Sagesse) {
        Sagesse createdSagesse = SagesseService.createSagesse(Sagesse);
        return new ResponseEntity<>(createdSagesse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sagesse> updateSagesse(@PathVariable Long id, @RequestBody Sagesse Sagesse) {
        Sagesse updatedSagesse = SagesseService.updateSagesse(id, Sagesse);
        return new ResponseEntity<>(updatedSagesse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSagesse(@PathVariable Long id) {
        SagesseService.deleteSagesse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

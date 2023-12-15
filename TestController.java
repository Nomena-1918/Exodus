package Controllers;

import models.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import services.TestService;

@RestController 
@RequestMapping("/Tests")
public class TestController {
    private final TestService TestService;

    @Autowired
    public TestController(TestService TestService) {
        this.TestService = TestService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Test> getTestById(@PathVariable Long id) {
        Test Test = TestService.getTestById(id);
        return new ResponseEntity<>(Test, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Test> createTest(@RequestBody Test Test) {
        Test createdTest = TestService.createTest(Test);
        return new ResponseEntity<>(createdTest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Test> updateTest(@PathVariable Long id, @RequestBody Test Test) {
        Test updatedTest = TestService.updateTest(id, Test);
        return new ResponseEntity<>(updatedTest, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        TestService.deleteTest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.hritvik.SBAssignmentPrecize.controller;


import com.hritvik.SBAssignmentPrecize.model.dto.SatResultInput;
import com.hritvik.SBAssignmentPrecize.service.SatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/sat-results")
public class SatController {

    @Autowired
    private SatService satService;

    /**
     * Inserts the given `SatResultInput` object into the database.
     *
     * @param satResult the `SatResultInput` object to be inserted
     * @return the response entity containing the result of the insert operation
     */

    @PostMapping("/insert")
    public ResponseEntity<String> insertData(@RequestBody SatResultInput satResult) {
        // Call the insertData method of the satService to insert the satResult into the database
        return satService.insertData(satResult);
    }

    /**
     * GetMapping function to view all data.
     *
     * @return  ResponseEntity containing a list of data
     */

    @GetMapping("/view-all")
    public ResponseEntity<List<?>> viewAllData() {
        // call the viewAllData method of the satService to view all data
        return satService.viewAllData();
    }

    /**
     * Retrieves the rank for the given name.
     *
     * @param  name  the name of the person
     * @return       the rank associated with the name
     */

    @GetMapping("/get-rank/{name}")
    public ResponseEntity<String> getRank(@PathVariable String name) {
//     call the getRank method of the satService to get the rank
        return satService.getRank(name);

    }

    /**
     * Retrieves the passed status of a given name.
     *
     * @param  name  the name to check
     * @return       the passed status as a ResponseEntity<String>
     */

    @GetMapping("/is-passed/{name}")
    public ResponseEntity<String> isPassed(@PathVariable String name) {
//     call the isPassed method of the satService to get the passed status
        return satService.isPassed(name);
    }

    /**
     * Updates the score for a given name.
     *
     * @param  name      the name of the person
     * @param  newScore  the new score to be updated
     * @return           the response entity containing the result of the score update
     */

    @PutMapping("/update-score/{name}")
    public ResponseEntity<String> updateScore(@PathVariable String name, @RequestParam int newScore) {
//     call the updateScore method of the satService to update the score
        return satService.updateScore(name, newScore);

    }

    /**
     * Deletes a record with the specified name.
     *
     * @param  name  the name of the record to be deleted
     * @return       the response entity indicating the result of the delete operation
     */

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteRecord(@PathVariable String name) {
        // call the deleteRecord method of the satService to delete the record
        return satService.deleteRecord(name);

    }

}


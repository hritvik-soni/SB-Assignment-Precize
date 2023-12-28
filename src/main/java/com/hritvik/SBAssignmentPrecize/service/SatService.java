package com.hritvik.SBAssignmentPrecize.service;

import com.hritvik.SBAssignmentPrecize.model.SatResult;
import com.hritvik.SBAssignmentPrecize.model.dto.SatResultInput;
import com.hritvik.SBAssignmentPrecize.repository.SatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SatService {

    @Autowired
    private SatRepository satRepository;

    /**
     * Inserts data into the database if the record does not already exist.
     *
     * @param  satResult    the SatResultInput object containing the data to be inserted
     * @return              a ResponseEntity<String> indicating the success or failure of the operation
     */
    public ResponseEntity<String> insertData(SatResultInput satResult) {

       // check if the record already exists
        if(satRepository.existsByName(satResult.getName())) {

            // return an error response if the record already exists
            return new ResponseEntity<>("Record already exists", HttpStatus.BAD_REQUEST);
        }

        // check if the score is valid
        if (satResult.getSatScore() < 0 || satResult.getSatScore() > 100) {

            // return an error response if the score is not valid
            return new ResponseEntity<>("Invalid score (range: 0-100)", HttpStatus.BAD_REQUEST);
        }

       // insert the record
        SatResult satResult1 = SatResult.builder()
                .name(satResult.getName())
                .address(satResult.getAddress())
                .city(satResult.getCity())
                .country(satResult.getCountry())
                .pinCode(satResult.getPinCode())
                .satScore(satResult.getSatScore())
                .isPassed(satResult.getSatScore() > 30)
                .build();

        // save the record
        satRepository.save(satResult1);

        // return the response
        return new ResponseEntity<>("Record added successfully", HttpStatus.OK);

    }

    /**
     * Retrieves all data from the repository.
     *
     * @return   A ResponseEntity containing a list of records if found, or a list containing "No records found" if no records are found.
     */
    public ResponseEntity<List<?>> viewAllData() {

        // check if there are any records
        if(satRepository.findAll().isEmpty()) {

            // return an error response if there are no records
            return new ResponseEntity<>(List.of("No records found"), HttpStatus.NOT_FOUND);
        }

        // return the response
        return new ResponseEntity<>(satRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Retrieves the rank for a given name.
     *
     * @param  name  the name for which to retrieve the rank
     * @return       the rank of the name as a string, or "Record not found" if the name is not found
     */
    public ResponseEntity<String> getRank(String name) {

        // search and sort the records

        List<SatResult> sortedResults = satRepository.findAll().stream()
                .sorted((r1, r2) -> Integer.compare(r2.getSatScore(), r1.getSatScore()))
                .toList();

       // find the rank
        for (int i = 0; i < sortedResults.size(); i++) {

            // check if the name matches
            if (sortedResults.get(i).getName().equals(name)) {

                // return the response
                return new ResponseEntity<>("Rank: " + (i + 1), HttpStatus.OK);
            }
        }

        // return the response
       return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
    }

    /**
     * Checks if the record with the given name exists and determines if it has passed or failed based on the SAT score.
     *
     * @param  name    the name of the record to check
     * @return         a ResponseEntity<String> with the result of the check
     */
    public ResponseEntity<String> isPassed(String name) {

      // check if the record exists
        if(satRepository.existsByName(name)) {

            // get the record
            SatResult result = satRepository.findByName(name);

            // check if the score is greater than 30
            if (result.getSatScore() >30) {

                // return the response
                return new ResponseEntity<>("Passed", HttpStatus.OK);
             }
            else {

                // return the response
                return new ResponseEntity<>("Failed", HttpStatus.OK);
            }
        }

        // return the response
        return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
    }

    /**
     * Updates the score for a given name.
     *
     * @param  name      the name to update the score for
     * @param  newScore  the new score to set
     * @return           a ResponseEntity containing the updated score if the record exists,
     *                   or a ResponseEntity with a "Record not found" message if the record does not exist
     */
    public ResponseEntity<String> updateScore(String name, int newScore) {

        // check if the record exists
        if(satRepository.existsByName(name)) {

            // get the record
            SatResult result = satRepository.findByName(name);

            // check if the score is valid
            if (newScore < 0 || newScore > 100) {
                return new ResponseEntity<>("Invalid score (range: 0-100)", HttpStatus.BAD_REQUEST);
            }

            // check if the new score is the same as the old score
            if (result.getSatScore()==newScore) {
                // return the response
                return new ResponseEntity<>("New score same as old", HttpStatus.BAD_REQUEST);
            }

            // update the score
            result.setSatScore(newScore);
            // update the passed status
            result.setPassed(newScore > 30);

            // save the record
            satRepository.save(result);

            // return the response
            return new ResponseEntity<>("Score updated successfully Old Score: " + result.getSatScore() + " New Score: " + newScore, HttpStatus.OK);
        }

        // return the response
        return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
    }

    /**
     * Deletes a record with the given name.
     *
     * @param  name  the name of the record to be deleted
     * @return       a ResponseEntity<String> indicating the result of the deletion
     */
    public ResponseEntity<String> deleteRecord(String name) {

        // check if the record exists
        if(satRepository.existsByName(name)) {

            // delete the record
            satRepository.delete(satRepository.findByName(name));

            // return the response
            return new ResponseEntity<>("Record deleted successfully", HttpStatus.OK);
        }
        
        // return the response
        return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
    }


}



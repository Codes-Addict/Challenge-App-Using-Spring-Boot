package com.SpringProject.ChallangeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallangeController {

    private ChallangeService challangeService ;

    public ChallangeController(ChallangeService challangeService){
        this.challangeService = challangeService ;
    }

    @GetMapping
    public List<Challange> getAllChallanges(){
        return challangeService.getAllChallanges() ;
    }

    @PostMapping
    public String addChallenge(@RequestBody Challange challenge2){
        boolean isChallangeAdded =  challangeService.addChallenge(challenge2) ;
        if (isChallangeAdded){
            return "Challenge Added successfully" ;
        }
        else {
            return "Challange not added successfully" ;
        }
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challange> getAllChallanges(@PathVariable String month){
        Challange challange = challangeService.getChallange(month) ;

        if(challange != null){
        return new ResponseEntity(challange, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallange(@PathVariable Long id, @RequestBody Challange updatedChallange){
        boolean ischallengeupdated = challangeService.updateChallange(id, updatedChallange) ;
        if(ischallengeupdated){
            return new ResponseEntity("Challenge updated successfully", HttpStatus.OK) ;
        }
        else{
            return new ResponseEntity<>("Challenge not updated", HttpStatus.NOT_FOUND) ;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallange(@PathVariable Long id){
        boolean ischallengeDeleted = challangeService.deleteChallange(id) ;
        if(ischallengeDeleted){
            return new ResponseEntity("Challege deleted successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Challange not deleted", HttpStatus.NOT_FOUND) ;
        }
    }

}

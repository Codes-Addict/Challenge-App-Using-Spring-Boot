package com.SpringProject.ChallangeApp;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallangeService {

    private List<Challange> challenges = new ArrayList<>() ;
    private Long nextId = 1L  ;

    public ChallangeService(){

    }

    public List<Challange> getAllChallanges() {
        return challenges;
    }

    //Get method
    public Challange getChallange(String month) {
        for(Challange challange : challenges){
            if(challange.getMonth().equalsIgnoreCase(month)){
                return challange ;
            }
        }
        return null ;
    }

    //Post method
    public boolean addChallenge(Challange challenge2){
        challenge2.setId(nextId++);
        if(challenge2 != null){
        challenges.add(challenge2) ;
        return true ;
        }
        else{
        return false ;
        }
    }

    //Put method
    public boolean updateChallange(Long id, Challange updatedChallange) {
        for(Challange challange : challenges){
            if(challange.getId().equals(id)){
                challange.setMonth(updatedChallange.getMonth());
                challange.setDescription(updatedChallange.getDescription()) ;
                return true ;
            }
        }
        return false ;
    }

    public boolean deleteChallange(Long id) {
        return challenges.removeIf(challange -> challange.getId().equals(id)) ;
    }
}

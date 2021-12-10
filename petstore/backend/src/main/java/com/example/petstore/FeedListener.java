package com.example.petstore;


public class FeedListener implements Listener {

    int feedCriteria = 0; 

    public FeedListener(int criteria) {
        this.feedCriteria = criteria;
    }

    @Override
    public void energyChanged(int energy) {
        if(energy < feedCriteria){ // energy의 변화폭이 기준보다 작은 경우
            System.out.println("please feed some food."); 
        }
    }
    
    
}

package com.example.demo;

public class FeedListener implements Listener {
	
	int feedCriteria = 0;

	public FeedListener(int criteria) {
		this.feedCriteria = criteria;
	}
	
	@Override
	public void energyChanged(int energy) {
		if (energy < feedCriteria) {
			System.out.println("Feed");
		}
	}

}

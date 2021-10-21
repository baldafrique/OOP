package observer;

public class FeedListener implements Listener {

	@Override
	public void energyChanged(int energy) {
		if (energy < 5) {
			System.out.println("Please feed some food.");
		}
	}

}

package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
	
	abstract public void speak();
	
	List<Listener> listeners = new ArrayList<Listener>();
	
	public void addListener(Listener listener) {
		this.listeners.add(listener);
	}
	
	int energy = 0;
	
	public void eat() {
		energy++;
		
		for (int i=0; i<listeners.size(); i++) {
			listeners.get(i).energyChanged(energy);
		}
	}
	
}

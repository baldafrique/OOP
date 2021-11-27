package com.example.petstore;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorColumn(
		discriminatorType = DiscriminatorType.STRING,
		name = "pet_type",
		columnDefinition = "CHAR(5)"
		)

public abstract class Pet {     // Entity. Domain

	 @Id @GeneratedValue
	 Long id;
	 String name;
	 String type;
	 
	 public Long getId() {
		return this.id;
	 }
	
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	 public String getName() {
		 return this.name;
	 }
	 
	 public void setType(String type) {
		 this.type = type;
	 }
	 
	 public String getType() {
		 return type;
	 }
	 
    abstract public void speak();


//    List<Listener> listeners = new ArrayList<Listener>();
//    public void addListener(Listener listener) {
//        this.listeners.add(listener);
//    }

    private int energy = 0;
    private int appearance = 0;
    
    public int getEnergy() {
        return energy;
    }
    protected void setEnergy(int energy) {
        if(Math.abs(this.energy - energy) < 3 )
            this.energy = energy;
        else    
            throw new IllegalArgumentException("Energy change is too big");
    }
    
    public int getAppearance() {
    	return appearance;
    }
    
    protected void setAppearance(int appearance) {
    	this.appearance = appearance;
    }
        

    public void eat(){
        energy++;

//        if(listeners!=null){
//            for(int i = 0; i<listeners.size(); i++){
//                listeners.get(i).energyChanged(energy);
//            }
//        }
    }

    @Override
    public String toString() {
        
        return "<a href='./"+this.getClass().getSimpleName().toLowerCase()+"'" + ">" + this.getClass().getSimpleName() + "</a>";
    }
    
}

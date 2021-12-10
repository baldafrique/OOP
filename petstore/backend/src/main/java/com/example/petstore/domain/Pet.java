package com.example.petstore.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorColumn( // super class의 구분 컬럼 지정
		discriminatorType = DiscriminatorType.STRING,
		name = "pet_type",
		columnDefinition = "CHAR(5)"
		)

public abstract class Pet { // Entity, Domain

	 @Id @GeneratedValue // id를 Pet entity의 primary key로 설정하고 primary key 값을 자동 생성
	 Long id; 
	 String name;
	 String type;
	 private int energy = 0; 
	 private int appearance = 0; 
	 
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

    public int getEnergy() {
        return energy;
    }
    
    protected void setEnergy(int energy) {
        if(Math.abs(this.energy - energy) < 3 ) { // energy 변화폭이 3 미만인 경우 허용
            this.energy = energy;
        } else { // energy 변화폭이 3 이상인 경우 throw exception 
            throw new IllegalArgumentException("Energy change is too big");
        }
    }
    
    public int getAppearance() {
    	return appearance;
    }
    
    protected void setAppearance(int appearance) {
    	this.appearance = appearance;
    }

    public void eat(){
        energy++; // increase energy by 1

//        if(listeners!=null){
//            for(int i = 0; i<listeners.size(); i++){
//                listeners.get(i).energyChanged(energy);
//            }
//        }
        
    }
    
    public void sleep() {
    	energy += 2; // increase energy by 2
    }

    @Override
    public String toString() { // class명을 불러와 hypertext reference link를 return
        return "<a href='./"+this.getClass().getSimpleName().toLowerCase()+"'" + ">" + this.getClass().getSimpleName() + "</a>";
    }
    
}

package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DoorManager {

	private List<DoorListener> listeners;

	public DoorManager() {
		// TODO Auto-generated constructor stub
		listeners = new ArrayList<>();
	}

	public void addDoorListener(DoorListener listener) {
		listeners.add(listener);
	}

	public void removeDoorListener(DoorListener listener) {
		listeners.remove(listener);
		System.out.println(listeners.size());
	}

	public void addDoorListeners(DoorListener... listeners) {
		for (DoorListener listener : listeners) {
			this.listeners.add(listener);
		}
	}
	
	
	public void removeDoorListeners(DoorListener... listeners){
		for (DoorListener listener : listeners) {
			this.listeners.remove(listener);
		}
	}
	
	
	public void fireDoorOpen(){
		System.out.println(listeners.size());
		DoorEvent event=new DoorEvent(this, "open");
		notifyListeners(event);
	}
	
	
	public void fireDoorClose(){
		DoorEvent event=new DoorEvent(this, "close");
		notifyListeners(event);
	}
	
	
	public void notifyListeners(DoorEvent event){
		Iterator<DoorListener> iterator=listeners.iterator();
		while(iterator.hasNext()){
			DoorListener listener = iterator.next();
			listener.doorEvent(event);
		}
	}
}

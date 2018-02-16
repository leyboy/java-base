package utils;

public class TestListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoorManager manager= new DoorManager();
		Door1Listener listener=new Door1Listener();
		manager.addDoorListener(listener);
		manager.fireDoorClose();
		manager.fireDoorOpen();
		manager.removeDoorListener(listener);
		manager.fireDoorClose();
	}

}

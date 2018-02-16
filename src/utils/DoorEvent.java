package utils;

import java.util.EventObject;

/**
 * 事件对象
 * @see {@link EventObject}
 * **/
public class DoorEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String doorState = "";

	public DoorEvent(Object source, String doorState) {
		super(source);
		// TODO Auto-generated constructor stub
		this.doorState = doorState;
	}

	public void setDoorState(String doorState) {
		this.doorState = doorState;
	}

	public String getDoorState() {
		return doorState;
	}
	
	
	@Override
	public String toString() {
		return "DoorEvent [doorState=" + doorState + "]";
	}
}

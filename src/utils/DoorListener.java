package utils;

import java.util.EventListener;

/**
 * 定义事件监听接口
 * 
 * **/
public interface DoorListener extends EventListener {
	
	/**
	 * Listens door event
	 * @param event
	 * 			door event
	 * **/
	void doorEvent(DoorEvent event);
}

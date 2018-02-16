package utils;

public class Door1Listener implements DoorListener {

	@Override
	public void doorEvent(DoorEvent event) {
		// TODO Auto-generated method stub
		if(event.getDoorState()!=null&&"open".equals(event.getDoorState())){
			System.out.println("门打开了");
		}else{
			System.out.println("门关闭了");
		}
	}

}

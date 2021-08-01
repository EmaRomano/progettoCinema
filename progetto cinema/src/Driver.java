import controllers.ControllerCentrale;

public class Driver {
	
	ControllerCentrale controllerCentrale;
	
	public Driver(){
		controllerCentrale=new ControllerCentrale();
	}

	public static void main(String[] args) {
		new Driver();
	}

}

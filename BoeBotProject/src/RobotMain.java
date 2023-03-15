import Week2.*;
import TI.BoeBot;

public class RobotMain {

	/**
	 * Main loop for the robot
	 */
	public static void main(String[] args) {
		while (true) {
			
			// Add robot code here
			PWMLED.Opdracht2a();

			// Wait 20ms
			BoeBot.wait(20);
		}
	}
}

import Week2.*;
import TI.*;

public class RobotMain {

	/**
	 * Main loop for the robot
	 */
	public static void main(String[] args) {
		Buzzer buzzer = new Buzzer(0);
		int[] freqs = {1000, 1500, 2000, 1500};

		while (true) {

			for (int i = 0; i < 4; i++) {
				buzzer.buzz(freqs[i], 250);
				BoeBot.wait(2);
			}
		}
	}
}

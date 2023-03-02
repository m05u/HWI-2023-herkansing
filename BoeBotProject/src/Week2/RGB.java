package Week2;

import TI.BoeBot;
import TI.PinMode;

public class RGB {
	public static void Opdracht3a() {
		BoeBot.setMode(0, PinMode.Output); // red
		BoeBot.setMode(1, PinMode.Output); // green
		BoeBot.setMode(2, PinMode.Output); // blue

		boolean on = false;
		boolean off = true;

		BoeBot.digitalWrite(0, on);
		BoeBot.digitalWrite(1, off);
		BoeBot.digitalWrite(2, off);
	}
}

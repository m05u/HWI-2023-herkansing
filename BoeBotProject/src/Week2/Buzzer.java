package Week2;

import TI.BoeBot;
import TI.PWM;
import TI.PinMode;

public class Buzzer {
	private int pin;

	public Buzzer(int pin) {

		BoeBot.setMode(pin, PinMode.Output);
	}

	public void buzz(int freq, int duration) {
		BoeBot.freqOut(pin, freq, duration);
	}
}

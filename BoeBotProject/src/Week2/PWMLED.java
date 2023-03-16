package Week2;

import TI.BoeBot;
import TI.PinMode;
import TI.PWM;
import TI.Timer;

public class PWMLED {

	/**
	 * Let the LED go from 0% to 100% (0-255) over a period of 2 seconds.
	 * Let the other LED go from 100% to 0% (255-0) and back.
	 */
	public static void Opdracht2a() {
		BoeBot.setMode(0, PinMode.Output); // PWM pin
		BoeBot.setMode(1, PinMode.Output); // PWM pin

		PWM led1 = new PWM(0, 0);
		PWM led2 = new PWM(1, 255);

		for (int i = 0; i < 255; i++) {
			led1.update(i);
			led2.update(255 - i);
			BoeBot.wait(8);
		}

		for (int i = 255; i > 0; i--) {
			led1.update(i);
			led2.update(255 - i);
			BoeBot.wait(8);
		}
	}


	public static void Opdracht2b() {

		// Duty Cycles
		double firstDC = 0;
		double secondDC = 0;
		int previousDC = 1;

		int outputPin = 0;
		BoeBot.setMode(outputPin, PinMode.Output);
		PWM pwm = new PWM(outputPin, (int) firstDC);

		int outputPin1 = 1;
		BoeBot.setMode(outputPin1, PinMode.Output);
		PWM pwm1 = new PWM(outputPin1, (int) secondDC);

		// amount of steps between the output being on and off
		int pwmIntervals = 100;
		double R;
		R = (pwmIntervals * Math.log(2)) / (Math.log(256));

		while (true) {
			firstDC = 0;
			previousDC = 1;

			for (int interval = 0; interval <= pwmIntervals; interval++) {
				firstDC = firstDC  >= 255 ? 0 : firstDC;
				firstDC += 2.55;
				secondDC = (previousDC * (Math.pow(2, (interval / R)) - 1));
				pwm.update( (int) firstDC);
				pwm1.update((int) secondDC);
				System.out.println(secondDC);
//				System.out.println(firstDC);
				BoeBot.wait(20);
			}
		}
	}
}

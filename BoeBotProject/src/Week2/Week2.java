package Week2;

import TI.*;

import java.awt.*;

public class Week2 {
	public static void ledStandard() {
		BoeBot.setMode(0, PinMode.Output);

		boolean state = true;

		while (true) {
			state = !state;
			BoeBot.digitalWrite(0, state);
			BoeBot.wait(1000);
		}
	}


	public static void opdrachtTweeA() {
		BoeBot.setMode(0, PinMode.Output);
		PWM pwm1 = new PWM(0, 0);
		while (true) {
			pwm1.update(255);
			BoeBot.wait(1000);

			pwm1.update(128);
			BoeBot.wait(1000);

			pwm1.update(0);
			BoeBot.wait(1000);
		}

	}

	public static void opdrachtTweeB() {
		BoeBot.setMode(0, PinMode.Output);
		PWM pwm = new PWM(0, 199); // de laatste waarde die we nog zichtbaar genoeg vonden, hoger was amper te zien

	}

	public static void opdrachtTweeE() {
		BoeBot.setMode(0, PinMode.Output);
		PWM pwm1 = new PWM(0, 199);
		while (true) {
			int counter = 0;
			for (int i = 256; i > 0; i /= 1.1) {
				pwm1.update(i - 1);

				BoeBot.wait(50);
				counter++;
			}
			System.out.println(counter);
		}
	}

	public static void opdrachtTweeD() {
		BoeBot.setMode(0, PinMode.Output);
		PWM pwm = new PWM(0, 199);
		Timer timer = new Timer(10);

		timer.mark();
		while (true) {
			if (timer.timeout()) {
				pwm.update(pwm.getDutyCycle() - 1);
				timer.mark();
				if (pwm.getDutyCycle() == 0) pwm.update(199);
			}
			BoeBot.wait(1);
		}
	}

	public static void opdrachtDrieA() {
		PWM pwm = new PWM(0, 0);
		PWM pwm1 = new PWM(1, 255);

		Timer timer1 = new Timer(10);
		int counterValue = 0;
		boolean rising = true;
		while (true) {
			if (pwm.getDutyCycle() == 255) {
				rising = !rising;
			}
			int i = 0;
			while (i < 100) {


				if (timer1.timeout()) {
					i++;
					if (rising) {
						counterValue += 2.5;
					} else counterValue -= 2.5;
				}
				pwm.update(counterValue);
				pwm1.update(255 - counterValue);
			}
			BoeBot.wait(50);

		}
	}

	public static void opdrachtVierB() {

		while (true) {
			for (int i = 0; i < 360; i++) {
				Color color =ColorFader.fade(i/360f);
				System.out.println("RGB values: " + color.getRed() + " " + color.getGreen()+ " " + color.getBlue());
			}
		}
	}

	public static void opdrachtVijfA() {
		Servo LeftServo = new Servo(12);
		BoeBot.setMode(0, PinMode.Output);
		Servo RightServoMirrored = new Servo(13);

		while (true) {
			RightServoMirrored.update(1500);
			LeftServo.update(1500);
			BoeBot.wait(10);

		}
	}

	public static void opdrachtVijfB() {
		Servo LeftServo = new Servo(12);
		BoeBot.setMode(0, PinMode.Output);
		Servo RightServoMirrored = new Servo(13);

		int signal = 1500;
		System.out.println("Servos set to " + signal/1000 + " ms.");
		while (true) {
			RightServoMirrored.update(signal);
			LeftServo.update(signal);
			BoeBot.wait(10);
		}
	}

	public static void opdrachtZesA() {
		Driver driver = new Driver();
		while (true) {
			driver.getToSpeed(-50);
			driver.getToSpeed(-25);
			driver.getToSpeed(0);
			BoeBot.wait(100);
			driver.getToSpeed(50);
			driver.getToSpeed(25);
			driver.getToSpeed(0);
			BoeBot.wait(100);

		}
	}

	public static void opdrachtZeven() {
		BoeBot.setMode(0, PinMode.Output);

		BoeBot.freqOut(0, 1000, 500000);
	}


	public static void opdrachtAchtB() {
		Driver driver = new Driver();
		if (BoeBot.digitalRead(5) && BoeBot.digitalRead(6)) {
			System.out.println("werkt");
			BoeBot.digitalWrite(1, false);
			BoeBot.digitalWrite(0, false);
			driver.getToSpeed(100);

		} else if (!BoeBot.digitalRead(5) && !BoeBot.digitalRead(6)) {
			BoeBot.digitalWrite(1, true);
			BoeBot.digitalWrite(0, true);
			driver.emergencyBrake();
			driver.getToSpeed(-100);
			BoeBot.wait(1000);
			driver.getToSpeed(0);
			driver.turn(50);
			BoeBot.wait(2000);


		} else if (!BoeBot.digitalRead(6)) {
			BoeBot.digitalWrite(1, true);
			BoeBot.digitalWrite(0, false);
			driver.emergencyBrake();
			driver.getToSpeed(-100);
			BoeBot.wait(1000);
			driver.emergencyBrake();
			driver.turn(-50);

		} else if (!BoeBot.digitalRead(5)) {
			BoeBot.digitalWrite(1, false);
			BoeBot.digitalWrite(0, true);
			driver.getToSpeed(-100);
			BoeBot.wait(1000);
			driver.turn(50);
			BoeBot.wait(3000);
			driver.emergencyBrake();

		}
	}
}

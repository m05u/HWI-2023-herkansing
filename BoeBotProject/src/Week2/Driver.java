package Week2;

import TI.*;

public class Driver {
	private Servo leftServo = new Servo(12);
	private Servo rightServoMirrored = new Servo(13);
	private int speed = 0;

	public void getToSpeed(int newSpeed) {


		 if (newSpeed < speed) {
			while (speed != newSpeed) {
				speed -= 1;
				leftServo.update(1500 - speed);
				rightServoMirrored.update(1500 + speed);
				BoeBot.wait(50);
			}
		} else if (newSpeed > speed) {
			while (speed != newSpeed) {
				speed += 1;
				leftServo.update(1500 + speed);
				rightServoMirrored.update(1500 - speed);
				BoeBot.wait(50);
			}
		}

	}

	public void emergencyBrake() {
		leftServo.update(1500);
		rightServoMirrored.update(1500);
	}

	public void turn(int turningSpeed) {
		leftServo.update(turningSpeed + 1500);
		rightServoMirrored.update(turningSpeed + 1500);
	}

	public void turnAngle(int angle, int turningSpeed) {

	}
}
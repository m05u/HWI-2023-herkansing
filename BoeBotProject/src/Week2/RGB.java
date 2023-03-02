package Week2;

import TI.BoeBot;
import TI.PWM;
import TI.PinMode;

import java.awt.*;

public class RGB {
	public static void Opdracht3a() {
		BoeBot.setMode(0, PinMode.Output); // red
		BoeBot.setMode(1, PinMode.Output); // green
		BoeBot.setMode(2, PinMode.Output); // blue

		boolean on = false;  // for clarification
		boolean off = true;

		BoeBot.digitalWrite(0, on);
		BoeBot.digitalWrite(1, off);
		BoeBot.digitalWrite(2, off);
	}
	public static void Opdracht3b() {
		// init
		BoeBot.setMode(0, PinMode.Output);
		BoeBot.setMode(1, PinMode.Output);
		BoeBot.setMode(2, PinMode.Output);

		PWM red = new PWM(0, 0);
		PWM green = new PWM(1, 0);
		PWM blue = new PWM(2, 0);

		// main loop - fading color using HSB
		while (true) {

			// HSB values
			float hue;
			float sat = 1;
			float bri = 1;

			// iterate through hues (0 - 360)
			for (int i = 0; i < 360; i++) {

				hue = i / 360f;

				// get the color class from HSB
				Color rgb = Color.getHSBColor(hue, sat, bri);

				// get the individual R, G, B values
				int R = rgb.getRed();
				int B = rgb.getBlue();
				int G = rgb.getGreen();

				red.update(R);
				green.update(G);
				blue.update(B);

				BoeBot.wait(25);
			}
			BoeBot.wait(10);
		}

	}
}

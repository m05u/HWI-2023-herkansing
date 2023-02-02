package Week2;

import java.awt.*;

public class ColorFader {

	public static Color fade(float fraction) {
		Color start = Color.RED;
		Color end = Color.BLUE;

		float[] startHSB = Color.RGBtoHSB(start.getRed(), start.getGreen(), start.getBlue(), null);
		float[] endHSB = Color.RGBtoHSB(end.getRed(), end.getGreen(), end.getBlue(), null);

		float hue = startHSB[0] + (endHSB[0] - startHSB[0]) * fraction;
		float saturation = startHSB[1] + (endHSB[1] - startHSB[1]) * fraction;
		float brightness = startHSB[2] + (endHSB[2] - startHSB[2]) * fraction;

		return Color.getHSBColor(hue, saturation, brightness);
	}

}

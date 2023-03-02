import TI.BoeBot;
import TI.PWM;
import TI.PinMode;
import Week2.Week2;

public class RobotMain {

    public static void main(String[] args) {
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

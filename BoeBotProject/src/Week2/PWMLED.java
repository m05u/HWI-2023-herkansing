package Week2;
import TI.BoeBot;
import TI.PinMode;
import TI.PWM;

public class PWMLED {
    
    /**
     * Let the LED go from 0% to 100% (0-255) over a period of 2 seconds.
     * Let the other LED go from 100% to 0% (255-0) and back.
     */
    public static void Opdracht2a() {
        BoeBot.setMode(15, PinMode.Output); // PWM pin
        BoeBot.setMode(16, PinMode.Output); // PWM pin

        PWM led1 = new PWM(15, 0);
        PWM led2 = new PWM(16, 255);
        
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

    }
}

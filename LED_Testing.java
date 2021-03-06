import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinDirection;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
import com.pi4j.io.gpio.trigger.GpioPulseStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSetStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSyncStateTrigger;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.event.PinEventType;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LED_Testing{
public static void main(String[] args)throws InterruptedException{
        final GpioController gpio = GpioFactory.getInstance();
        Scanner keeb = new Scanner(System.in);
        GpioPinDigitalOutput DMS = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04,"DMS",PinState.LOW);
        System.out.println("0 = off");
        System.out.println("1 = on");
	System.out.println("2 = flash");
        int input = keeb.nextInt();
        switch(input){
                case 0 : DMS.low();
                        break;
                case 1: DMS.high();
                        break;
		case 2: for(int i = 1; i > 0; i++){
				DMS.high();
				Thread.sleep(250);
				DMS.low();
				Thread.sleep(250);
			}
			break;
                default: System.out.println("logic machine broke");
			break;
        }
}
}

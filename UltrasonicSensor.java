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
//import java.util.concurrent.locks.LockSupport;

public class UltrasonicSensor{
public static void main(String[] args)throws InterruptedException{
final GpioController gpio = GpioFactory.getInstance();
        GpioPinDigitalOutput trigger = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04);
         GpioPinDigitalInput echo = gpio.provisionDigitalInputPin(RaspiPin.GPIO_05);
        boolean echoState = echo.isHigh();
        long startTime = 0;
        long endTime = 0;
        double distanceMeters = 0;
        while(true){
                trigger.high();
		Thread.sleep((long) 0.01);
                trigger.low();
                while(echo.isLow()){ //Wait until the ECHO pin gets HIGH
     		 }
        	startTime = System.nanoTime();
		while(echo.isHigh()){ //Wait until the ECHO pin gets HIGH
     		 }
        	endTime = System.nanoTime();
		distanceMeters =((endTime-startTime)/1000)/58;
		System.out.println("Distance: " + distanceMeters);
                Thread.sleep(100);
        }
}
}

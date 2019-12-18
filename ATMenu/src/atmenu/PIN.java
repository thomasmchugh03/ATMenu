package atmenu;

import java.util.*;
/**
 * class designed to validate a pin number
 * @author Thomas
 */
public class PIN 
{
    private int pin;
    Random r = new Random();
    /**
     * constructor for when pin is specified 
     * @param i 
     */
    public PIN(int i) 
    {
        pin = i;
    }
    /**
     * constructor that randomly selects a pin number
     */
    public PIN() 
    {
        pin = r.nextInt(10000);
    }
    
    /**
     * designate pin to a specific number
     * @param pin_input 
     */
    public void setPIN(int pin_input)
    {
        pin = pin_input;
    }
    /**
     * turn pin into a random number
     */
    public void setPIN()
    {
        pin = r.nextInt(10000);
    }
    /**
     * retrieve pin
     * @return 
     */
    public int getPIN()
    {
        return pin;
    }
    /**
     * determine if pin is valid
     * @param comp_pin
     * @return 
     */
    public boolean validate(int comp_pin)
    {
        
	if(pin == comp_pin)
	{
            return true;
	}
	else
	{
            return false;
	}
    }
    /**
     * print out pin information
     * @return 
     */
    public String toString()
    {
        String s = "" + pin;
	return s;
    }
    /**
     * determine if the pin of two objects are the same
     * @param p
     * @return 
     */
    public boolean equals(PIN p)
    {
        int b = p.getPIN();
        if (pin == b)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

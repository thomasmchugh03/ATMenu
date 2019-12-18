package atmenu;


/**
 *
 * @author Thomas
 */
import java.util.*;

/**
 * Class is designed to resemble an ATM system
 * @author Tommy
 *
 */
public class BankAccount 
{
	private String name;
	private int id;
	private int number;
	private double balance = 0;
	Random r = new Random();
	/**
	* constructor for when the balance, id, and name are specified
	* @param amount The initial balance, must be positive 
	* @param num The account id number
	* @param n The account holders name
	*/
	public BankAccount(double amount, int num, String n)
	{
		balance = amount;
		id = num;
		name = n;
	}
	
        /**
         * constructor when balance and name are specified
         * @param amount
         * @param n 
         */
	public BankAccount(double amount, String n)
	{
		balance = amount;
		id = r.nextInt(1000)+10;
		name = n;
	}
	
        /**
         * 
         * @param n 
         */
	public BankAccount(String n)
	{
		balance = 0;
		id = r.nextInt(1000)+10;
		name = n;
	}
	
        /**
         * get the balance of an account
         * @return 
         */
	public double getBalance()
	{
            return balance;
	}
	
        /**
         * get the account id
         * @return 
         */
	public double getID()
	{
            System.out.print("The ID is: ");
		return id;
	}
	
        /**
         * designate a balance to a specific amount
         * @param v 
         */
	public void setBalance(double v)
	{
		if (v >= 0)
		{
			balance = v;
		}
	}
	/**
	 * Withdraw money from the account, cannot go below 0
	 * @param amount The amount to withdraw. Must be greater than balance
	 */
	public void withdraw(double amount)
	{
		if(balance - amount >= 0)
		{
			balance = balance - amount;
		}
	}
	
        /**
         * take all the money out of the account
         */
	public void withdraw()
	{
		balance = 0;
	}
	
        /**
         * put money into the account
         * @param amount 
         */
	public void deposit(double amount)
	{
		balance = balance + amount;
	}
	
        /**
         * print out the important information
         * @return 
         */
	public String toString()
	{
		String s = "Name; " + name + " | id: " + id + " | balance: " + balance;
		return s;
	}
        /**
         * make interest on the account
         * @param rate 
         */
        public void addInterest(double rate)
        {
            balance = balance + balance*(rate * .01);
        }
}

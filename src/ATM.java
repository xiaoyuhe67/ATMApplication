import java.util.Scanner;

public class ATM {
	
	static AccountDatabase accountDatabase=new AccountDatabase();
	
	static String WrongMessage;
	
    static Scanner sc=new Scanner(System.in);
	
	static String accountnumber;
	static String pin;
	
	static int Wronglogintimes=0;
	
	
	
	static String option;
	static double deposit;
	static double withdraw;
	
	static String transaction[]=new String[100];
	
	static int transactiontime=0;
	
	public void process()
	{
		lockaccount();
		if(Wronglogintimes==3)
		{
			System.out.println("You have entered 3 times wrong input. You are locked");
		}
		else
		{
            System.out.println("You have log on successfully!");
            
            while(1>0)
            {
			System.out.println("Please enter your option: 1 for deposit, 2 for withdraw, 3 for check balance, -1 for quit");		
			option=sc.next();
			if(option.equals("-1"))
			{
				printreport();
				break;			
			}
			else if(option.equals("1"))
			{
				System.out.println("Please enter the amount of your deposit:");
				deposit=sc.nextDouble();
				deposit(accountnumber,deposit);
				transaction[transactiontime]="You have deposit "+deposit;
				transactiontime++;
			}
			else if(option.equals("2"))
			{
				System.out.println("Please enter the amount of your withdraw:");
				withdraw=sc.nextDouble();
				withdraw(accountnumber,withdraw);
				transaction[transactiontime]="You have withdraw "+deposit;
				transactiontime++;
			}
			else if(option.equals("3"))
			{
				System.out.println("Your balance is"+checkbalance(accountnumber));
				transaction[transactiontime]="You have checked your blance: "+checkbalance(accountnumber);
				transactiontime++;
			}
            }
				
		}
		
	}
	public static void printreport()
	{
		for(int i=0;i<=transactiontime-1;i++)
		{
			System.out.println(transaction[i]);
		}
	}
	
	public void login()
	{
		
		System.out.println("Please enter your Account Number");
		accountnumber=sc.next();
		System.out.println("Please enter your Pin Number");
		pin=sc.next();	
		
	}
	
	public void lockaccount()
	{	
		    login();
		    if(validate(accountnumber,pin)==false)
		    {
			    Wronglogintimes++;
			    System.out.println(WrongMessage);
			    login();
			    if(validate(accountnumber,pin)==false)
			    {
			    	Wronglogintimes++;
			    	System.out.println(WrongMessage);
				    login();
			    }
			    if(validate(accountnumber,pin)==false)
			    {
			    	Wronglogintimes++;
			    	System.out.println(WrongMessage);
				    login();
			    }
			    
		    }
		   
		
		
		
	}
	
		
	public boolean validate(String AccountNumber, String Pin)
	{
		    accountDatabase.createBookDatabase();
		    
		    boolean validation=false;
		    if(accountDatabase.searchAccount(AccountNumber)!=null)
		    {
		    	if(accountDatabase.searchAccount(AccountNumber).getPin().equals(Pin))
		    	{
		    		validation=true;
		    	}
		    	else
		    	{
		    		validation=false;
		    		WrongMessage="The pin is wrong!";
		    	}
		    }
		    else
		    {
		    	validation=false;
		    	WrongMessage="This account number doesn't exist!";
		    }
		return validation;
	}
	
	
	
	
	public void deposit(String AccountNumber, double deposit)
	{
		double balance=accountDatabase.searchAccount(AccountNumber).getBalance();
		balance=balance+deposit;
		accountDatabase.searchAccount(AccountNumber).setBalance(balance);
		
	}
	public void withdraw(String AccountNumber, double withdraw)
	{
		double balance=accountDatabase.searchAccount(AccountNumber).getBalance();
		balance=balance-withdraw;
		accountDatabase.searchAccount(AccountNumber).setBalance(balance);
		
	}
	
	public double checkbalance(String AccountNumber)
	{
		double balance=accountDatabase.searchAccount(AccountNumber).getBalance();
		
		return balance;
	}

}

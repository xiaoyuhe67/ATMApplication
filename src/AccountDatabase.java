public class AccountDatabase {
	
	static Account[] myAccount=new Account[100];
	int count=6;
	
	public void createBookDatabase()
	{
		Account account1=new Account("0001","James0001",5000,"120597");
		Account account2=new Account("0002","Mary0002",3000.87,"782649");
		Account account3=new Account("0003","Dave0003",7000.98,"158700");
		Account account4=new Account("0004","Lucy0004",400.90,"893659");
		Account account5=new Account("0005","Kathy0005",100.78,"457923");
		Account account6=new Account("0006","Selina0006",-200.53,"789532");
		
		myAccount[0]=account1;
		myAccount[1]=account2;
		myAccount[2]=account3;
		myAccount[3]=account4;
		myAccount[4]=account5;
		myAccount[5]=account6;
			
	}
	
	public int getCount()
	{
		 return this.count;
	}
	
	public Account searchAccount(String AccountNumber)
	{
		Account newAccount=null;
		
		for(int i=0; i<getCount();i++)
		{
			if(myAccount[i].getAccountNumber().equals(AccountNumber))
			{
				newAccount=myAccount[i];
			}
		}	
		return newAccount;
		
	}
	

}

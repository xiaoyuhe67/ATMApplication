
public class Account {	
	
	private String AccountNumber;
	private String UserName;
	private double Balance;
	private String Pin;
	

	
	Account(String strAccountNumber,String strUserName, double douBalance, String strPin){
		
		AccountNumber=strAccountNumber;
		UserName=strUserName;
		Balance=douBalance;
		Pin=strPin;
		
	}
	
	//Getter and setter methods
	public String getAccountNumber() {
	       return AccountNumber;
	   }	  
	   public String getUserName() {
	       return UserName;
	   }
	   public double getBalance() {
	       return Balance;
	   }
	   public void setBalance(double balance) {
		   this.Balance = balance;
	   }
	   public String getPin() {
	       return Pin;
	   }
	  
	   
	  
	
	

}

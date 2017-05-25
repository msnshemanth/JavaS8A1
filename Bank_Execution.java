public class Bank_Execution{
public static void main(String args[]){

	Account acct = new Account();
	Account acct1 = new Account();
		
		System.out.println("************SBI BANK**************");
		acct.setAtmId(100);
		acct.setBankName("SBI");
		acct.setLocation("Bangalore");
		acct.setBalance(13000);
		System.out.println(acct.getAtmId());
		System.out.println(acct.getBankName());
		System.out.println(acct.getLocation());
		System.out.println("Current balance : " + acct.getBalance()); 
        System.out.println("Withdrawing : 1000");
        acct.withdraw(1000);
        System.out.println("Current balance : " + Account.balance);
        acct.withdraw(10000);	
		System.out.println("");
		System.out.println("************ICICI BANK**************");
		acct1.setAtmId(101);
		acct1.setBankName("ICICI");
		acct1.setLocation("Bangalore");
		acct1.setBalance(10000);
		System.out.println(acct1.getAtmId());
		System.out.println(acct1.getBankName());
		System.out.println(acct1.getLocation());
		System.out.println("Current balance : " + acct1.getBalance()); 
        System.out.println("Withdrawing : 13000");
        acct1.withdraw(13000);
        System.out.println("Current balance : " + Account.balance);
        acct1.withdraw(10000);
		
	}
}


 class BankATMException extends RuntimeException{
	private String message;
	
	public BankATMException(String message){
		this.message=message;
	}
	
	public BankATMException(Throwable cause, String message){
		super(cause);
		this.message =  message;
	}
	
	public String getMessage(){
		return message;
	}
	
}


 class Account {
 
    
	private int atmId;
	private String bankName;
	private String location;
	public static int balance;


	public int getAtmId(){
		return atmId;
	}
	public void setAtmId(int atmId){
		this.atmId=atmId;
	}

	public String getBankName(){
		return bankName;
	}
	public void setBankName(String bankName){
		this.bankName=bankName;
	}

	public String getLocation(){
		return location;
	}
	public void setLocation(String location){
		this.location=location;
	}
	public int getBalance(){
		return balance;
	}
	public void setBalance(int balance){
		this.balance=balance;
	}

   // public int balance() {
    //    return balance;
    //}
 
    public void withdraw(int amt) throws BankATMException {
		
		if(balance < 10000){
			throw new BankATMException(String.format("Less balance %d",balance));
		}
        else if (amt > balance) {
            throw new BankATMException(String.format(
                    "Current balance %d is less than requested amount %d",
                    balance, amt));
		//
        }
		
		else{
			balance = balance - amt;
		}
    }
 
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(String.format(
                    "Invalid deposit amount %s", amount));
        }
    }
 
}


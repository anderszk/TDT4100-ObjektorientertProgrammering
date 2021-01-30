package encapsulation;

public class Account{
    private double balance;
    private double interestRate;

    private boolean validatePositive(double in){
        if (in <= 0){
            throw new IllegalArgumentException("Invalid parameter, only positive integers");
        }
        else return true;
    }

    public double getBalance(){
        return this.balance;
    }

    public double getInterestRate(){
        return this.interestRate;
    }

    public void deposit(double d){
        if(validatePositive(d)){
            this.balance += d;
        }
        else throw new IllegalArgumentException("Can not add a negative integer to you balance");
    }

    public void setInterestRate(double interestRate){
        if(validatePositive(interestRate)){
            this.interestRate = interestRate;
        }
        else throw new IllegalArgumentException("Can not set negative interest rate");
    }

    public void withdraw(double w){
        if (validatePositive(w) && w < this.balance){
            this.balance -= w;
        }
        else if (w > this.balance){
            throw new IllegalArgumentException("Account balance too low");
        }
        else throw new IllegalArgumentException("Can not withdraw a negative integer");
    }

    public void addInterest(){
        this.balance += this.balance * interestRate;
    }

    Account(double balance, double interestRate){
        if (validatePositive(balance) && validatePositive(interestRate)){
            this.balance = balance;
            this.interestRate = interestRate;
        }
        else throw new IllegalArgumentException("Both numbers need to be positive integers");
    }
}


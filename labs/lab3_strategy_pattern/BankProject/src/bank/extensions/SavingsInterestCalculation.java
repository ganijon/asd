package bank.extensions;

public class SavingsInterestCalculation implements InterestCalculation {

    public double calculate(double balance) {
        //If balance < 1000 then you get 1% interest
        //If balance > 1000 and balance < 5000 then you get 2% interest
        //If balance > 5000 then you get 4% interest

        if (balance <= 1000)
            return 0.01 * balance;
        else if (balance > 1000 && balance <= 5000)
            return 0.02 * balance;
        else if (balance > 5000)
            return 0.04 * balance;
        else
            return 0.0;
    }
}

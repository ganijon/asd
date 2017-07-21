package bank.extensions;

public class CheckingsInterestCalculation implements InterestCalculation {

    public double calculate(double balance) {
        //If balance < 1000 then you get 1,5% interest
        //If balance > 1000 then you get 2,5% interest

        if (balance <= 1000)
            return 0.015 * balance;
        else if (balance > 1000)
            return 0.025 * balance;
        else
            return 0.0;
    }
}

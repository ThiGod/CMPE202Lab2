

import java.util.Random;

public class HasCoinState implements State {
    GumballMachine gumballMachine;
 
    public HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
  
    public void insertCoin(int c) {
        if(c == 25)
            System.out.println("You inserted a quarter (25 cents)");
        else if(c == 10)
            System.out.println("You inserted a dime (10 cents)");
        else if(c == 5)
            System.out.println("You inserted a nickel (5 cents)");
        else
            System.out.println("Sorry, only accepte quarter, dime and nickel");
            
        gumballMachine.setCoin(gumballMachine.getCoin() + c);
    }
 
    public void ejectCoin() {
        System.out.println("Coin returned (" + gumballMachine.getCoin() + ")");
        gumballMachine.setCoin(0);
        gumballMachine.setState(gumballMachine.getNoCoinState());
    }
 
    public void turnCrank() {
        System.out.println("There are " + gumballMachine.getCoin() + " cents inside machine");
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
    public String toString() {
        return "waiting for turn of crank";
    }
}



public class NoCoinState implements State {
    GumballMachine gumballMachine;
 
    public NoCoinState(GumballMachine gumballMachine) {
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
        
        if(gumballMachine.getCoin() > 50)
            gumballMachine.setState(gumballMachine.getHasCoinState());
    }
 
    public void ejectCoin() {
        if(gumballMachine.getCoin() > 0) {
            System.out.println("Coin returned (" + gumballMachine.getCoin() + ")");
            gumballMachine.setCoin(0);
        }
        else
            System.out.println("You haven't inserted a coin");
    }
 
    public void turnCrank() {
        if(gumballMachine.getCoin() > 0) {
            System.out.println("There are " + gumballMachine.getCoin() + " cents inside machine");
            System.out.println("You turned..");
            System.out.println("Not enough money");
        }
        else
            System.out.println("You turned, but there's no coin");
     }
 
    public void dispense() {
        if(gumballMachine.getCoin() > 0) {
        }
        else
            System.out.println("You need to pay first");
    } 
 
    public String toString() {
        return "waiting for coin";
    }
}

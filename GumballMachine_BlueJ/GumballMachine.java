

public class GumballMachine implements IGumballMachine {
 
    State soldOutState;
    State noCoinState;
    State hasCoinState;
    State soldState;
 
    State state = soldOutState;
    int count = 0;
    int gumballInSlot = 0;
    int coin = 0;
 
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noCoinState;
        } 
    }
 
    public void insertQuarter() {
        state.insertCoin(25);
    }
    
    public void insertDime() {
        state.insertCoin(10);
    }
    
    public void insertNickel() {
        state.insertCoin(5);
    }
 
    public void ejectCoin() {
        state.ejectCoin();
    }
 
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }
 
    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
            gumballInSlot++;
            coin = coin - 50;
        }
        System.out.println("You had " + getCoin() + " cents left in machine");
        System.out.println(gumballInSlot + " gumball in the slot");
    }
 
    int getCount() {
        return count;
    }
 
    void refill(int count) {
        this.count = count;
        state = noCoinState;
    }
    
    public void setCoin(int c) {
        coin = c;
    }
    
    public int getCoin() {
        return coin;
    }
    
    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getSoldState() {
        return soldState;
    }
 
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result  .append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
    
    public boolean isGumballInSlot() {
        if (gumballInSlot > 0) {
            System.out.println("isGumballInSlot: true");
            return true;
        } else {
            System.out.println("isGumballInSlot: flase");
            return false;
        }
    }
        
    public void takeGumballFromSlot() {
        if (gumballInSlot > 0) {
            System.out.println("Take all gumball (" + gumballInSlot + ") from the slot");
            gumballInSlot = 0;
        } 
        if (gumballInSlot == 0) {
        }
        else {
            System.out.println("No gumball in the slot");
        }
    }
}

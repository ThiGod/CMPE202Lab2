

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GumballMachineTest
{
    private GumballMachine gm;
    
    /**
     * Default constructor for test class GumballMachineTest
     */
    public GumballMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        gm = new GumballMachine(5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testMoreThan50Cents() {
        System.out.println("\n----- Test more than 50 cents -----");
        gm.insertQuarter();
        gm.insertDime();
        gm.insertQuarter();
        gm.turnCrank();
        gm.takeGumballFromSlot();
    }
    
    @Test
    public void testNoCoin() {
        System.out.println("\n----- Test no coin -----");
        gm.turnCrank();
        gm.takeGumballFromSlot();
    }
    
    @Test
    public void testNotEnoughCoin() {
        System.out.println("\n----- Test not enough coin -----");
        gm.insertQuarter();
        gm.insertDime();
        gm.insertNickel();
        gm.turnCrank();
        gm.takeGumballFromSlot();
    }
    
    @Test
    public void testMoreThan50CentsThanAddMoreCoinTurnAgain() {
        System.out.println("\n----- Test more than 50 cents then add more money turn again -----");
        gm.insertQuarter();
        gm.insertQuarter();
        gm.insertNickel();
        gm.turnCrank();
        gm.insertQuarter();
        gm.insertDime();
        gm.insertNickel();
        gm.insertQuarter();
        gm.turnCrank();
        gm.isGumballInSlot();
        gm.takeGumballFromSlot();
        gm.isGumballInSlot();
    }
    
    @Test
    public void testMoreThan50CentsButCrackTwice() {
        System.out.println("\n----- Test more than 50 cents but crank twice -----");
        gm.insertQuarter();
        gm.insertQuarter();
        gm.insertDime();
        gm.turnCrank();
        gm.turnCrank();
        gm.takeGumballFromSlot();
    }
    
    @Test
    public void testBuy1GumballEjectRestMoney() {
        System.out.println("\n----- Test buy 1 gumball, then eject rest money -----");
        gm.insertQuarter();
        gm.insertDime();
        gm.insertQuarter();
        gm.turnCrank();
        gm.takeGumballFromSlot();
        gm.ejectCoin();
    }
    
    @Test
    public void testEjectAllMoney() {
        System.out.println("\n-----Eject all money -----");
        gm.insertDime();
        gm.insertQuarter();
        gm.ejectCoin();
        gm.insertNickel();
        gm.ejectCoin();
        gm.turnCrank();
        gm.takeGumballFromSlot();
    }
}

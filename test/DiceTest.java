import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiceTest {

    @Test
    public void testRandomDice() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        String result = Dice.RandomDice();
        System.out.println("the result of throwing a dice is " + result);
        Assertions.assertNotNull(result);
    }

    @Test
    public void testNumDist() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num("dist");
        System.out.println(result);
        Assertions.assertEquals(10, result);
    }

    @Test
    public void testNumBnj() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num("bnj");
        System.out.println(result);
        Assertions.assertEquals(25, result);
    }

    @Test
    public void testNumSheqah() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num("sheqah");
        System.out.println(result);
        Assertions.assertEquals(6, result);

    }

    @Test
    public void testNumBara() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num("bara");
        System.out.println(result);
        Assertions.assertEquals(12, result);

    }

    @Test
    public void testNumDowaq() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num("dowaq");
        System.out.println(result);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void testNumThree() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num("three");
        System.out.println(result);
        Assertions.assertEquals(3, result);

    }

    @Test
    public void testNumFour() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num("four");
        System.out.println(result);
        Assertions.assertEquals(4, result);

    }

    @Test
    public void testNumKhal() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num("khal");
        System.out.println(result);
        Assertions.assertEquals(1, result);

    }

}

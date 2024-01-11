import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiceTest {

    @Test
    public void testRandomDice() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        String result = Dice.RandomDice();
        System.out.println("the result of throwing a dice is " + result);
        String result2 = Dice.RandomDice();
        System.out.println("the result of throwing a dice is " + result2);
        String result3 = Dice.RandomDice();
        System.out.println("the result of throwing a dice is " + result3);
        String result4 = Dice.RandomDice();
        System.out.println("the result of throwing a dice is " + result4);
        Assertions.assertNotNull(result);
    }

    @Test
    public void testNumDist() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num(Dice.DIST);
        System.out.println(result);
        Assertions.assertEquals(10, result);
    }

    @Test
    public void testNumBnj() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num(Dice.BNJ);
        System.out.println(result);
        Assertions.assertEquals(25, result);
    }

    @Test
    public void testNumSheqah() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num(Dice.SHEQAH);
        System.out.println(result);
        Assertions.assertEquals(6, result);

    }

    @Test
    public void testNumBara() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num(Dice.BARA);
        System.out.println(result);
        Assertions.assertEquals(12, result);

    }

    @Test
    public void testNumDowaq() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num(Dice.DOWAQ);
        System.out.println(result);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void testNumThree() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num(Dice.THREE);
        System.out.println(result);
        Assertions.assertEquals(3, result);

    }

    @Test
    public void testNumFour() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num(Dice.FOUR);
        System.out.println(result);
        Assertions.assertEquals(4, result);

    }

    @Test
    public void testNumKhal() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int result = Dice.num(Dice.KHAL);
        System.out.println(result);
        Assertions.assertEquals(1, result);

    }

}

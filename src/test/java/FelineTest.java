import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class FelineTest {
    @Test
    public void checkFelineEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> result = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }

    @Test
    public void checkFelineGetFamily() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void checkFelineGetKittens() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void checkFelineGetKittensParam() {
        Feline feline = new Feline();
        Assert.assertEquals(11, feline.getKittens(11));
    }
}
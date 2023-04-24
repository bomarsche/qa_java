import com.example.Feline;
import com.example.Lion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


@RunWith(Parameterized.class)
public class LionTest {

    private final String lionSex;
    private final boolean maneAvailability;

    public LionTest (String lionSex, boolean maneAvailability) {
        this.lionSex = lionSex;
        this.maneAvailability = maneAvailability;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;


    @Test
    public void checkLionGetKittens() throws Exception{
        Lion lion = new Lion(lionSex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittenCount = 1;
        Assert.assertEquals(expectedKittenCount, lion.getKittens());
    }

    @Test
    public void checkLionManeAvailability() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        Assert.assertEquals(maneAvailability, lion.doesHaveMane());
    }


    @Test
    public void checkLionGetFoodAsPredator() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}

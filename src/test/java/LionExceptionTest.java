import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class LionExceptionTest {
    @Mock
    Feline feline;

    @Test
    public void checkLionException() {
        String expectedException = "Используйте допустимые значения пола животного - самец или самка";
        Exception actualException = Assert.assertThrows("Сработало исключение: ", Exception.class, () -> new Lion("Выдра", feline));
        Assert.assertEquals(expectedException, actualException.getMessage());
    }

}



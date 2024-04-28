import Part1Flyweight.CharacterProperties;
import Part1Flyweight.CharPropertiesFactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CharPropertiesFactoryTest
{
    CharPropertiesFactory testFactory = new CharPropertiesFactory();
    @Test
    public void getPropertiesTest()
    {
        CharacterProperties expected = testFactory.getProperties("Arial","Blue","12");
        CharacterProperties actual = testFactory.getProperties("Arial", "Blue", "12");
        assertEquals(expected, actual);
    }
}

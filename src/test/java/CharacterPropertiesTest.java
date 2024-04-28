import Part1Flyweight.CharacterProperties;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CharacterPropertiesTest
{
    CharacterProperties testProperties = new CharacterProperties("Arial","Black","14");

    @Test
    public void getFontTest()
    {
        String expected = "Arial";
        String actual = testProperties.getFont();
        assertEquals(expected, actual);
    }
    @Test
    public void getColorTest()
    {
        String expected = "Black";
        String actual = testProperties.getColor();
        assertEquals(expected, actual);
    }
    @Test
    public void getSizeTest()
    {
        String expected = "14";
        String actual = testProperties.getSize();
        assertEquals(expected, actual);
    }
}

import Part1Flyweight.Character;
import Part1Flyweight.CharacterProperties;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CharacterTest
{
    CharacterProperties properties = new CharacterProperties("Arial","Red","12");
    Character testCharacter = new Character('T', properties);

    @Test
    public void getCharacterTest()
    {
        char expected = 'T';
        char actual = testCharacter.getCharacter();
        assertEquals(expected, actual);
    }
    @Test
    public void getCharacterPropertiesTest()
    {
        CharacterProperties expected = properties;
        CharacterProperties actual = testCharacter.getPropertiesOfCharacter();
        assertEquals(expected, actual);
    }
    @Test
    public void setCharacterPropertiesTest()
    {
        CharacterProperties expected = new CharacterProperties("Arial", "Black", "12");
        testCharacter.setPropertiesOfCharacter(expected);
        CharacterProperties actual = testCharacter.getPropertiesOfCharacter();
        assertEquals(expected, actual);
    }
}

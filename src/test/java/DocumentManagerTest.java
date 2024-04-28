import Part1Flyweight.CharPropertiesFactory;
import Part1Flyweight.Character;
import Part1Flyweight.CharacterProperties;
import Part1Flyweight.DocumentManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DocumentManagerTest
{
    CharPropertiesFactory factory = new CharPropertiesFactory();
    CharacterProperties properties = factory.getProperties("Arial","Cyan","12");
    DocumentManager testManager = new DocumentManager();
    @Test
    public void addAndGetCharacterTest()
    {
        testManager.addCharacter('T', properties);
        Character savedCharacter = testManager.getCharacters().getLast();
        char expected = 'T';
        char actual = savedCharacter.getCharacter();
        assertEquals(expected, actual);
    }
    @Test
    public void saveAndLoadDocumentTest()
    {
        testManager.addCharacter('W', properties);
        testManager.saveDocument("Test.txt");
        testManager.loadDocument("Test.txt", factory);
        Character loadedCharacter = testManager.getCharacters().getLast();
        char expected = 'W';
        char actual = loadedCharacter.getCharacter();
        assertEquals(expected, actual);
    }
}

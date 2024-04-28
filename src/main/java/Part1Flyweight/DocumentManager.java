package Part1Flyweight;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class DocumentManager
{
    private List<Character> charactersInDoc;
    public DocumentManager()
    {
        this.charactersInDoc = new ArrayList<>();
    }

    public void addCharacter(char character, CharacterProperties propertiesOfCharacter)
    {
        charactersInDoc.add(new Character(character, propertiesOfCharacter));
    }

    public void saveDocument(String fileName)
    {
        // Write to a file of name given, if no file type given, assume it's a txt file
        if (fileName.indexOf('.') < 0)
        {
            fileName += ".txt";
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
        {
            for (Character thisCharacter : charactersInDoc)
            {
                // Create a comma seperated file of character followed by its metadata
                writer.write(thisCharacter.getCharacter() + ","
                    + thisCharacter.getPropertiesOfCharacter().getFont() + ","
                    + thisCharacter.getPropertiesOfCharacter().getColor() + ","
                    + thisCharacter.getPropertiesOfCharacter().getSize());
                writer.newLine();
            }
        }
        catch (IOException exception)
        {
            System.err.println("Error, could not write to file: " + exception.getMessage());
        }
    }

    public void loadDocument(String fileName, CharPropertiesFactory factory)
    {
        // Loading new file, delete all characters previously held
        charactersInDoc.clear();
        // Could create a new factory, but better to use an existing one instead to keep memory usage low
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String thisLine;
            while ((thisLine = reader.readLine()) != null)
            {
                // Comma Seperated File
                String[] characterAndProperties = thisLine.split(",");
                if (characterAndProperties.length == 4) // Error is this character
                {
                    char thisCharacter = characterAndProperties[0].charAt(0); // String Character to Char Character
                    String font = characterAndProperties[1];
                    String color = characterAndProperties[2];
                    String size = characterAndProperties[3];
                    CharacterProperties propertiesOfCharacter = factory.getProperties(font, color, size);
                    charactersInDoc.add(new Character(thisCharacter, propertiesOfCharacter));

                }
            }
        }
        catch (IOException exception)
        {
            System.err.println("Error, could no read file: " + exception.getMessage());
        }
        catch (NumberFormatException exception)
        {
            System.err.println("Error, formatting fault: " + exception.getMessage());
        }
    }

    public List<Character> getCharacters()
    {
        return charactersInDoc;
    }
}

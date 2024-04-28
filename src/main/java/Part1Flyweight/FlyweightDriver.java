package Part1Flyweight;
import java.util.Random;

public class FlyweightDriver
{
    public static void main(String[] args)
    {
        Random randomNumber = new Random();
        CharPropertiesFactory factory = new CharPropertiesFactory();
        DocumentManager manager = new DocumentManager();
        String[] fontOptions = {"Arial", "Calibri", "Verdana"};
        String[] colorOptions = {"Red", "Blue", "Black"};
        String[] sizeOptions = {"12", "14", "16"};

        String inputString = "HelloWorldCS4800"; // Create at least 4 variations

        int rand1 = 0;
        int rand2 = 0;
        int rand3 = 0;
        for (int character = 0; character < inputString.length(); character++)
        {
            if (character % 2 == 0) // 16 total characters in input string, % 2 = 8 different variations
            {
              rand1 = randomNumber.nextInt(3);
              rand2 = randomNumber.nextInt(3);
              rand3 = randomNumber.nextInt(3);
            }
            CharacterProperties newProperties = factory.getProperties(fontOptions[rand1], colorOptions[rand2], sizeOptions[rand3]);
            manager.addCharacter(inputString.charAt(character), newProperties);
        }

        // Randomly Created Properties For Characters, Let's Take a Look!
        System.out.println("Properties randomly created, displaying character properties: \n");
        printDocument(manager);

        // Test Save and Load Feature
        manager.saveDocument("output"); // automatically put .txt at end
        System.out.println("Saved, Reloading from File");
        manager.loadDocument("output.txt", factory);

        System.out.println("Loading complete, displaying character properties:\n");
        printDocument(manager);

        // Test editing a character
        Character editCharacter = manager.getCharacters().get(3);
        CharacterProperties newProperties = factory.getProperties(fontOptions[0], colorOptions[0], sizeOptions[0]);
        editCharacter.setPropertiesOfCharacter(newProperties);

        System.out.println("Edit completed, Displaying:\n");
        printDocument(manager);
    }

    private static void printDocument(DocumentManager manager)
    {
        for (Character thisCharacter : manager.getCharacters())
        {
            System.out.println("Char: " + thisCharacter.getCharacter()
            + ", Font: " + thisCharacter.getPropertiesOfCharacter().getFont()
            + ", Color: " + thisCharacter.getPropertiesOfCharacter().getColor()
            + ", Size: " + thisCharacter.getPropertiesOfCharacter().getSize());
        }
        System.out.println();
    }
}

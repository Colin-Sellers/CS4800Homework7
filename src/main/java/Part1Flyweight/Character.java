package Part1Flyweight;

public class Character
{
    private char character;
    private CharacterProperties propertiesOfCharacter;

    public Character(char character, CharacterProperties propertiesOfCharacter)
    {
        this.character = character;
        this.propertiesOfCharacter = propertiesOfCharacter;
    }

    // Allow to edit the properties of the character
    public void setPropertiesOfCharacter(CharacterProperties propertiesOfCharacter)
    {
        this.propertiesOfCharacter = propertiesOfCharacter;
    }

    public char getCharacter()
    {
        return character;
    }

    public CharacterProperties getPropertiesOfCharacter()
    {
        return propertiesOfCharacter;
    }
}

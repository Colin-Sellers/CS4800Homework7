package Part1Flyweight;

public class CharacterProperties
{
    final private String font;
    final private String color;
    final private String size;

    public CharacterProperties(String font, String color, String size)
    {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public String getFont()
    {
        return font;
    }

    public String getColor()
    {
        return color;
    }

    public String getSize()
    {
        return size;
    }
}

package Part1Flyweight;
import java.util.HashMap;
import java.util.Map;

public class CharPropertiesFactory
{
    private Map<String, CharacterProperties> constructedProperties;

    public CharPropertiesFactory()
    {
        this.constructedProperties = new HashMap<>();
    }

    public CharacterProperties getProperties(String font, String color, String size)
    {
        String objectKey = font + color + size;
        if (!constructedProperties.containsKey(objectKey))
        {
            constructedProperties.put(objectKey, new CharacterProperties(font, color, size));
        }
        return constructedProperties.get(objectKey);
    }
}

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CharacterPropertiesTest.class, CharacterTest.class,
        CharPropertiesFactoryTest.class, DocumentManagerTest.class})
public class CompleteFlyWeightUnitTest
{

}

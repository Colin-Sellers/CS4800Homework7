import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({SongTest.class, RealServerTest.class, ProxyServerTest.class})
public class CompleteProxyUnitTest {
}

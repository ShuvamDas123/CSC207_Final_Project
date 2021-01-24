import Entities.Organizer;
import org.junit.Test;

public class TestOrganizer {

    @Test(timeout = 50)
    public void TestisOrganizer(){
        Organizer admin = new Organizer("admin","I am Entities.Organizer");
        assert (admin.isOrganizer());
    }
}

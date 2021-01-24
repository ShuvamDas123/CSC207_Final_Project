import Entities.Attendee;
import Entities.Speaker;
import UseCases.UserManager;
import org.junit.*;
import static org.junit.Assert.*;
public class TestUserManager {
    @Before

    // precondition: the userid are unique because it will be the email id
    @Test(timeout=50)
    public void testConstructor() {
        new UserManager();
    }

    @Test(timeout=50)
    public void testAddUsers() {
        // positive test
        UserManager usM = new UserManager();
        Attendee attendee1 = new Attendee("user1", "qwerty");
        usM.addUser(attendee1);
        assertEquals("The user exists \n", attendee1, usM.getUser("user1"));
        usM.removeUser(attendee1);
        //negative test
        assertNull("This user is removed and so does not exist", usM.getUser("user1"));
    }

    @Test(timeout = 50)
    public void testCreateAttendee(){
        UserManager usM = new UserManager();
        Attendee attendee3 = usM.createAttendee("user2", "monkey");
        assertEquals("Checks the created attendee", attendee3, usM.getAttendee("user2"));
    }

    @Test(timeout = 50)
    public void testGetUser(){
        UserManager usM = new UserManager();
        Attendee attendee3 = usM.createAttendee("user2", "monkey");
        assertEquals("Checks the created attendee", attendee3, usM.getUser("user2"));
    }

    @Test(timeout = 50)
    public void testCreateSpeaker(){
        UserManager usM = new UserManager();
        Speaker speaker1 = usM.createSpeaker("speak", "I speak a lot ppp");
        assertEquals("Checks if the speaker is added", speaker1, usM.getSpeaker("speak"));
    }

}
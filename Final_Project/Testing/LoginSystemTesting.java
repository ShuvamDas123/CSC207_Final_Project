import ConferenceControllers.LoginReceiver;
import UI.InterfaceController;
import org.junit.Test;
import UseCases.ConversationManager;
import UseCases.UserManager;


public class LoginSystemTesting {
    /*
    @Test(timeout = 5000)
    public void AllTestsLogin() throws ClassNotFoundException {
        UserManager userManager = new UserManager();
        ConversationManager conversationManager = new ConversationManager();
        InterfaceController interfaceController = new InterfaceController();
        userManager.createAttendee("Dave", "pineapples");
        userManager.createAttendee("John", "oranges");
        userManager.createAttendee("Anthony", "peaches");

        LoginReceiver loginReceiver = new LoginReceiver(userManager,interfaceController);
        assert loginReceiver.login("Dave", "pineapples") == 3;
        assert loginReceiver.login("John", "oranges") == 3;
        assert loginReceiver.login("Anthony", "peaches") == 3;

        assert loginReceiver.login("Pat", "beinghuman") == 0;
        assert loginReceiver.login("Pat", "beinghuman") == 0;

        // check the user differentiation
        userManager.createOrganizer("Jack", "pineapples");
        userManager.createOrganizer("Harry", "pineaåpples");

        assert  loginReceiver.login("Harry", "pineaåpples") == 1;
        assert loginReceiver.login("Jack", "pineapples") == 1;

        // check speaker
        userManager.createSpeaker("Ted","oranges");
        userManager.createSpeaker("Tess", "oranges");

        assert  loginReceiver.login("Ted","oranges") == 2;
        assert loginReceiver.login("Tess","oranges") == 2;

    }*/
}

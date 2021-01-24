import ConferenceControllers.EventScheduler;
import ConferenceControllers.EventSignup;
import ConferenceControllers.UserMessenger;
import Entities.Room;
import Entities.Speaker;
import Entities.User;
import UI.InterfaceController;
import UseCases.ConversationManager;
import UseCases.EventManager;
import UseCases.UserManager;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDateTime;

/*public class MessagingSystemsTests {
    @Test(timeout = 5000)
    public void testSendMessage() throws ParseException, ClassNotFoundException {
        UserManager userManager = new UserManager();
        ConversationManager conversationManager = new ConversationManager();
        userManager.createAttendee("Dave", "pineapples");
        userManager.createAttendee("John", "oranges");
        userManager.createAttendee("Anthony", "peaches");

        User dave = userManager.getAttendee("Dave");
        User john = userManager.getAttendee("John");
        User anthony = userManager.getAttendee("Anthony");
        userManager.setCurrentUser(dave);
        InterfaceController interfaceController = new InterfaceController();
        UserMessenger userMessenger = new UserMessenger(conversationManager, userManager,interfaceController);

        assert userManager.isValidId("Dave");
        assert !userMessenger.addContact("William");
        assert userMessenger.addContact("John");
        assert dave.getContacts().size() == 1;

        assert userMessenger.getContacts().size() == 1;
        userMessenger.getConversationByUser(0);
        userMessenger.updateConversation("Hello John");

        assert userMessenger.getConversations().size() == 1;
        userMessenger.getConversationByIndex(0);
        userMessenger.updateConversation("Please respond");

        System.out.println(userMessenger.getConversationByIndex(0).printConversation());
    }
    @Test(timeout = 5000)
    public void testEventAnnouncer() throws ParseException {
        UserManager userManager = new UserManager();
        ConversationManager conversationManager = new ConversationManager();
        userManager.createSpeaker("Mark", "longisland");
        userManager.createAttendee("Dave", "pineapples");
        userManager.createAttendee("John", "oranges");

        Speaker mark = userManager.getSpeaker("Mark");
        User dave = userManager.getAttendee("Dave");
        User john = userManager.getAttendee("John");
        userManager.setCurrentUser(mark);

        EventManager eventManager = new EventManager();
        EventScheduler eventScheduler = new EventScheduler(eventManager,userManager);
        LocalDateTime startTime = LocalDateTime.of(2001, 7,5,9,0);
        LocalDateTime endTime = LocalDateTime.of(2001, 7,5,10,0);
        LocalDateTime startTime2 = LocalDateTime.of(2001, 7,5,10,0);
        LocalDateTime endTime2 = LocalDateTime.of(2001, 7,5,11,0);
        Room room = eventScheduler.createRoom("BA100");

        assert room.getSchedule().isEmpty();
        Event shoeTying = eventScheduler.createEvent("How to tie your shoes",startTime,endTime,
                mark.getUserId(),room.getId());

        EventSignup eventSignup = new EventSignup(userManager,eventManager);
        assert eventSignup.addUser(shoeTying.getEventId(), dave.getUserId());
        assert eventSignup.addUser(shoeTying.getEventId(), john.getUserId());

        /*
        Controllers.UserMessenger userMessengerMark = new Controllers.UserMessenger(conversationManager, userManager);
        Controllers.SpeakerMessenger speakerMessenger = new Controllers.SpeakerMessenger(conversationManager,userManager, eventManager);

        assert speakerMessenger.getEvents().size() == 1;
        speakerMessenger.getEventByIndex(0);
        System.out.println(speakerMessenger.getUserIdsInEvent());
        speakerMessenger.sendToAll("Yo shoes are awesome!");
        speakerMessenger.chooseOneUser(1);
        speakerMessenger.sendToOne("Please come to my event!");

        assert userMessengerMark.getConversations().size() == 2;

        userManager.setCurrentUser(john);
        Controllers.UserMessenger userMessengerJohn = new Controllers.UserMessenger(conversationManager, userManager);
        assert userMessengerJohn.getConversations().size() == 1;
        System.out.println(userMessengerJohn.getConversationByIndex(0).printConversation());

         */
  //  }
//}

import ConferenceControllers.EventScheduler;
import ConferenceControllers.EventSignup;
import ConferenceControllers.UserGenerator;
import Entities.Attendee;
import Entities.Event;
import Entities.Room;
import Entities.Speaker;
import UI.InterfaceController;
import UseCases.EventManager;
import UseCases.UserManager;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventSystemsTests {
    /*
    @Test(timeout = 5000)
    public  void testRoomSetUp() throws ParseException, ClassNotFoundException {
        UserManager userManager = new UserManager();
        EventManager eventManager = new EventManager();
        InterfaceController interfaceController = new InterfaceController();
        UserGenerator userGenerator = new UserGenerator(userManager, interfaceController);
        EventScheduler eventScheduler = new EventScheduler(eventManager,userManager, interfaceController, userGenerator);
        Room room = eventScheduler.createRoom("BA100",2);
        LocalDateTime startTime = LocalDateTime.of(2001, 7,5,9,0);
        LocalDateTime endTime = LocalDateTime.of(2001, 7,5,10,0);
        LocalDateTime startTime2 = LocalDateTime.of(2001, 7,5,10,0);
        LocalDateTime endTime2 = LocalDateTime.of(2001, 7,5,11,0);
        assert room.getSchedule().isEmpty();
        userManager.createSpeaker("Username","Password"); //Usermanager needs to return types
        Speaker speaker = userManager.getSpeaker("Username");
        ArrayList<String> speakerids = new ArrayList<>();
        speakerids.add(speaker.getUserId());
        Event event1 = eventScheduler.createEvent("ted talking",startTime,endTime,
                speakerids,room.getId(),2);
        assert event1.getAttendeeIds().isEmpty();
        assert !room.isAvailable(startTime,endTime);
        assert room.isAvailable(startTime2,endTime2);
        eventScheduler.removeEvent(event1.getEventId());
        assert room.getSchedule().isEmpty();
        assert eventManager.getSchedule().get(room).isEmpty();
    }

    @Test(timeout = 5000)
    public void testEventSignup() throws ClassNotFoundException {
        UserManager userManager = new UserManager();
        EventManager eventManager = new EventManager();
        InterfaceController interfaceController = new InterfaceController();
        UserGenerator userGenerator = new UserGenerator(userManager, interfaceController);
        EventSignup eventSignup = new EventSignup(userManager,eventManager,interfaceController);
        EventScheduler eventScheduler = new EventScheduler(eventManager,userManager, interfaceController, userGenerator);
        Room room = eventScheduler.createRoom("BA100",2);
        Room room2 = eventScheduler.createRoom("BA101",2);
        LocalDateTime startTime = LocalDateTime.of(2001, 7,5,9,0);
        LocalDateTime endTime = LocalDateTime.of(2001, 7,5,10,0);
        LocalDateTime startTime2 = LocalDateTime.of(2001, 7,5,10,0);
        LocalDateTime endTime2 = LocalDateTime.of(2001, 7,5,11,0);
        LocalDateTime startTime3 = LocalDateTime.of(2001, 7,5,9,0);
        LocalDateTime endTime3 = LocalDateTime.of(2001, 7,5,10,0);
        userManager.createAttendee("yo","yoyo");
        userManager.createSpeaker("speak","Speaking");
        userManager.createSpeaker("can't speak","wont speak");
        userManager.createAttendee("lol","lol");
        userManager.createAttendee("why","me");
        Speaker s = userManager.getSpeaker("speak");
        Speaker s2 = userManager.getSpeaker("can't speak");
        Attendee a = userManager.getAttendee("yo");
        Attendee a2 = userManager.getAttendee("lol");
        Attendee a3 = userManager.getAttendee("why");
        ArrayList<String> speakerIds = new ArrayList<>();
        speakerIds.add(s.getUserId());
        ArrayList<String> speakerIds2 = new ArrayList<>();
        speakerIds2.add(s2.getUserId());
        Event e = eventScheduler.createEvent("epic ted talk", startTime,endTime,speakerIds,room.getId(),2);
        Event e2 = eventScheduler.createEvent("epic ted talk part 2",startTime2,endTime2, speakerIds,room.getId(),2);
        Event e3 = eventScheduler.createEvent("not epic talk",startTime3,endTime3, speakerIds2,room.getId(),2);
        Event e4 = eventScheduler.createEvent("not epic talk",startTime3,endTime3, speakerIds,room2.getId(),2);
        Event e5 = eventScheduler.createEvent("not epic talk",startTime3,endTime3, speakerIds2,room2.getId(),2);
        assert e3 == null;
        assert e4 == null;
        assert eventSignup.addUser(e.getEventId(),a.getUserId());
        assert eventSignup.addUser(e2.getEventId(), a.getUserId());
        assert !eventSignup.addUser(e5.getEventId(),a.getUserId());
        assert !a.isAvailable(startTime,endTime);
        assert a.getEventIds().contains(e.getEventId());
        //nice
        assert e.getAttendeeIds().contains(a.getUserId());
        assert eventSignup.addUser(e.getEventId(), a2.getUserId());
        assert !eventSignup.addUser(e.getEventId(),a3.getUserId());
        assert a3.isAvailable(startTime,endTime);
        eventScheduler.removeEvent(e.getEventId());
        assert s.isAvailable(startTime,endTime);
        assert a.isAvailable(startTime,endTime);
        assert a2.isAvailable(startTime,endTime);
        assert !a.getEventIds().contains(e.getEventId());
        assert !a2.getEventIds().contains(e.getEventId());
        assert !s.getGivenTalks().contains(e.getEventId());
    }

    @Test(timeout = 5000)
    public void testRemovingRoom() throws ClassNotFoundException {
        UserManager userManager = new UserManager();
        EventManager eventManager = new EventManager();
        InterfaceController interfaceController = new InterfaceController();
        UserGenerator userGenerator = new UserGenerator(userManager, interfaceController);
        EventScheduler eventScheduler = new EventScheduler(eventManager,userManager,interfaceController,userGenerator);
        EventSignup eventSignup = new EventSignup(userManager,eventManager,interfaceController);
        Room room = eventScheduler.createRoom("BA100",2);
        LocalDateTime startTime = LocalDateTime.of(2001, 7,5,9,0);
        LocalDateTime endTime = LocalDateTime.of(2001, 7,5,10,0);
        LocalDateTime startTime2 = LocalDateTime.of(2001, 7,5,10,0);
        LocalDateTime endTime2 = LocalDateTime.of(2001, 7,5,11,0);
        LocalDateTime startTime3 = LocalDateTime.of(2001, 7,5,11,0);
        LocalDateTime endTime3 = LocalDateTime.of(2001, 7,5,12,0);
        userManager.createAttendee("yo","yoyo");
        userManager.createSpeaker("speak","Speaking");
        userManager.createAttendee("lol","lol");
        Speaker s = userManager.getSpeaker("speak");
        Attendee a = userManager.getAttendee("yo");
        Attendee a2 = userManager.getAttendee("lol");
        ArrayList<String> speakerIds = new ArrayList<>();
        speakerIds.add(s.getUserId());
        Event e = eventScheduler.createEvent("epic ted talk", startTime,endTime,speakerIds,room.getId(),2);
        Event e2 = eventScheduler.createEvent("epic ted talk part 2",startTime2,endTime2, speakerIds,room.getId(),2);
        Event e3 = eventScheduler.createEvent("epic ted talk part 3",startTime3,endTime3, speakerIds,room.getId(),2);
        assert eventSignup.addUser(e.getEventId(),a.getUserId());
        assert eventSignup.addUser(e.getEventId(), a2.getUserId());
        assert eventSignup.addUser(e2.getEventId(),a.getUserId());
        assert eventSignup.addUser(e2.getEventId(), a2.getUserId());
        assert eventSignup.addUser(e3.getEventId(),a.getUserId());
        assert eventSignup.addUser(e3.getEventId(), a2.getUserId());
        eventScheduler.removeRoom(room.getId());
        assert a.isAvailable(startTime,endTime);
        assert a.isAvailable(startTime2,endTime2);
        assert a.isAvailable(startTime3,endTime3);
        assert a2.isAvailable(startTime,endTime);
        assert a2.isAvailable(startTime2,endTime2);
        assert a2.isAvailable(startTime3,endTime3);
        assert s.isAvailable(startTime,endTime);
        assert s.isAvailable(startTime2,endTime2);
        assert s.isAvailable(startTime3,endTime3);
        assert !a.getEventIds().contains(e.getEventId());
        assert !a.getEventIds().contains(e2.getEventId());
        assert !a.getEventIds().contains(e3.getEventId());
        assert !a2.getEventIds().contains(e.getEventId());
        assert !a2.getEventIds().contains(e2.getEventId());
        assert !a2.getEventIds().contains(e3.getEventId());
        assert !s.getEventIds().contains(e.getEventId());
        assert !s.getEventIds().contains(e2.getEventId());
        assert !s.getEventIds().contains(e3.getEventId());
        assert !e.getAttendeeIds().contains(a.getUserId());
        assert !e.getAttendeeIds().contains(a2.getUserId());
        assert !e2.getAttendeeIds().contains(a.getUserId());
        assert !e2.getAttendeeIds().contains(a2.getUserId());
    }

    @Test(timeout=5000)
    public void testEventSignup2() throws ClassNotFoundException {

        UserManager userManager = new UserManager();
        EventManager eventManager = new EventManager();
        InterfaceController interfaceController = new InterfaceController();
        UserGenerator userGenerator = new UserGenerator(userManager, interfaceController);
        EventScheduler eventScheduler = new EventScheduler(eventManager,userManager,interfaceController,userGenerator);
        EventSignup eventSignup = new EventSignup(userManager,eventManager,interfaceController);

        Speaker Johnathan = userManager.createSpeaker("Jonathan Walker", "123");
        Attendee JohnathanDisciple1 = userManager.createAttendee("Disciple1", "12345");
        Attendee JohnathanDisciple2 = userManager.createAttendee("Disciple2", "123456");
        Attendee JohnathanDisciple3 = userManager.createAttendee("Disciple3", "1234567");
        Room room = eventScheduler.createRoom("BA3200",2);
        ArrayList<String> speakerIds = new ArrayList<>();
        speakerIds.add(Johnathan.getUserId());
        Event event1 = eventScheduler.createEvent("How to Jonathan Walk--According to an expert",
                LocalDateTime.of(2020, 10, 8, 13, 0),
                LocalDateTime.of(2020, 10, 8, 14, 0), speakerIds,
                room.getId(),2);

        Event event2 = eventScheduler.createEvent("How to Jonathan Walk--According to an expert pt2",
                LocalDateTime.of(2020, 10, 8, 14, 0),
                LocalDateTime.of(2020, 10, 8, 15, 0), speakerIds,
                room.getId(),2);

        eventSignup.addUser(event1.getEventId(), JohnathanDisciple1.getUserId());
        assert !eventSignup.addUser(event1.getEventId(), JohnathanDisciple1.getUserId());
        assert event1.getAttendeeIds().size() == 1;
        assert event1.getAttendeeIds().contains(JohnathanDisciple1.getUserId());
        assert eventSignup.canAddAttendee(event1.getEventId());

        eventSignup.addUser(event1.getEventId(), JohnathanDisciple2.getUserId());
        assert !eventSignup.addUser(event1.getEventId(), JohnathanDisciple3.getUserId());
        assert event1.getAttendeeIds().size() == 2;
        assert event1.getAttendeeIds().contains(JohnathanDisciple2.getUserId());

        eventSignup.addUser(event2.getEventId(), JohnathanDisciple2.getUserId());
        assert event1.getAttendeeIds().contains(JohnathanDisciple2.getUserId()) &&
                event2.getAttendeeIds().contains(JohnathanDisciple2.getUserId());

        eventSignup.addUser(event2.getEventId(), JohnathanDisciple3.getUserId());
        assert !eventSignup.canAddAttendee(event2.getEventId());

    }
    @Test(timeout=5000)
    public void testMultiRoom1() throws ClassNotFoundException {
        UserManager userManager = new UserManager();
        EventManager eventManager = new EventManager();
        InterfaceController interfaceController = new InterfaceController();
        UserGenerator userGenerator = new UserGenerator(userManager, interfaceController);
        EventScheduler eventScheduler = new EventScheduler(eventManager,userManager,interfaceController,userGenerator);
        EventSignup eventSignup = new EventSignup(userManager,eventManager,interfaceController);

        Speaker Johnathan = userManager.createSpeaker("Jonathan Walker", "123");
        Speaker JohnathanImposter = userManager.createSpeaker("Jönathan Walker", "12345");
        Attendee JohnathanDisciple1 = userManager.createAttendee("Disciple1", "12345");
        Attendee JohnathanDisciple2 = userManager.createAttendee("Disciple2", "123456");
        Attendee JohnathanDisciple3 = userManager.createAttendee("Disciple3", "1234567");
        Room room1 = eventScheduler.createRoom("BA3200",2);
        Room room2 = eventScheduler.createRoom("BA3201",2);
        ArrayList<String> speakerIds = new ArrayList<>();
        speakerIds.add(Johnathan.getUserId());
        ArrayList<String> speakerIds2 = new ArrayList<>();
        speakerIds2.add(JohnathanImposter.getUserId());
        Event event1 = eventScheduler.createEvent("How to Jonathan Walk--According to an expert",
                LocalDateTime.of(2020, 10, 8, 13, 0),
                LocalDateTime.of(2020, 10, 8, 14, 0), speakerIds,
                room1.getId(),2);

        Event event2 = eventScheduler.createEvent("How to Jonathan Walk--According to an expert pt2",
                LocalDateTime.of(2020, 10, 8, 14, 0),
                LocalDateTime.of(2020, 10, 8, 15, 0), speakerIds,
                room1.getId(),2);

        Event event3 = eventScheduler.createEvent("How to Jonathan Walk--According to an expert pt3",
                LocalDateTime.of(2020, 10, 8, 13, 0),
                LocalDateTime.of(2020, 10, 8, 14, 0), speakerIds,
                room2.getId(),2);
        //Johnathan can't give 2 talks at the same time
        assert event3 == null;

        Event event4 = eventScheduler.createEvent("How to Jonathan Walk--According to an imposter",
                LocalDateTime.of(2020, 10, 8, 13, 0),
                LocalDateTime.of(2020, 10, 8, 14, 0), speakerIds2,
                room2.getId(),2);

        assert event4.getAttendeeIds().isEmpty();

        eventSignup.addUser(event1.getEventId(), JohnathanDisciple1.getUserId());
        eventSignup.addUser(event1.getEventId(), JohnathanDisciple2.getUserId());
        eventSignup.addUser(event2.getEventId(), JohnathanDisciple2.getUserId());
        eventSignup.addUser(event2.getEventId(), JohnathanDisciple3.getUserId());
        assert !eventSignup.addUser(event4.getEventId(), JohnathanDisciple1.getUserId());
        eventSignup.addUser(event4.getEventId(), JohnathanDisciple3.getUserId());

        event2 = eventScheduler.rescheduleEvent(event2.getEventId(), room2.getId(), event2.getStartTime(), event2.getEndTime());
        assert event2.getAttendeeIds().isEmpty();
        assert event2.getRoomId() == room2.getId();
        assert event2.getStartTime().getHour() == 14 && event2.getEndTime().getHour() == 15;


        assert eventScheduler.rescheduleEvent(event1.getEventId(), room2.getId(), event1.getStartTime(), event1.getEndTime()) == null;
        assert event1.getStartTime().getHour() == 13;
        assert event1.getEndTime().getHour() == 14;
        assert event1.getAttendeeIds().size()==2;
        assert event1.getAttendeeIds().contains(JohnathanDisciple1.getUserId());
        assert event1.getAttendeeIds().contains(JohnathanDisciple2.getUserId());
        assert !(eventScheduler.rescheduleEvent(event2.getEventId(), room1.getId(), event2.getStartTime(), event2.getEndTime())==null);
        assert event2.getAttendeeIds().isEmpty();
        assert room2.isAvailable(event2.getStartTime(), event2.getEndTime());
        assert !room2.isAvailable(event1.getStartTime(), event1.getEndTime());
    }

    @Test(timeout = 5000)
    public void testStuff() throws ClassNotFoundException {
        UserManager userManager = new UserManager();
        EventManager eventManager = new EventManager();
        InterfaceController interfaceController = new InterfaceController();
        UserGenerator userGenerator = new UserGenerator(userManager, interfaceController);
        EventScheduler eventScheduler = new EventScheduler(eventManager,userManager,interfaceController,userGenerator);
        EventSignup eventSignup = new EventSignup(userManager,eventManager,interfaceController);

        Speaker Johnathan = userManager.createSpeaker("Jonathan Walker", "123");
        Speaker JohnathanImposter = userManager.createSpeaker("Jönathan Walker", "12345");
        Attendee JohnathanDisciple1 = userManager.createAttendee("Disciple1", "12345");
        Attendee JohnathanDisciple2 = userManager.createAttendee("Disciple2", "123456");
        Attendee JohnathanDisciple3 = userManager.createAttendee("Disciple3", "1234567");
        Room room1 = eventScheduler.createRoom("BA3200",2);
        Room room2 = eventScheduler.createRoom("BA3201",2);
        ArrayList<String> speakerIds = new ArrayList<>();
        speakerIds.add(Johnathan.getUserId());
        ArrayList<String> speakerIds2 = new ArrayList<>();
        speakerIds2.add(JohnathanImposter.getUserId());
        Event event1 = eventScheduler.createEvent("How to Jonathan Walk--According to an expert",
                LocalDateTime.of(2020, 10, 8, 13, 0),
                LocalDateTime.of(2020, 10, 8, 14, 0), speakerIds,
                room1.getId(),2);

        Event event2 = eventScheduler.createEvent("How to Jonathan Walk--According to an expert pt2",
                LocalDateTime.of(2020, 10, 8, 14, 0),
                LocalDateTime.of(2020, 10, 8, 15, 0), speakerIds,
                room2.getId(),2);

        eventSignup.addUser(event1.getEventId(), JohnathanDisciple1.getUserId());
        eventSignup.addUser(event1.getEventId(), JohnathanDisciple2.getUserId());
        eventSignup.addUser(event1.getEventId(), JohnathanDisciple3.getUserId());
        eventSignup.addUser(event2.getEventId(), JohnathanDisciple1.getUserId());
        eventSignup.addUser(event2.getEventId(), JohnathanDisciple2.getUserId());
        eventSignup.addUser(event2.getEventId(), JohnathanDisciple3.getUserId());


        //assert eventScheduler.rescheduleEvent(event1.getEventId(), room2.getId(), event2.getStartTime(), event2.getEndTime()) == null;
        event1.getAttendeeIds().size();
        assert event1.getAttendeeIds().size()==2;
        assert JohnathanDisciple1.getEventIds().contains(event1.getEventId());
        assert JohnathanDisciple2.getEventIds().contains(event1.getEventId());
        assert !JohnathanDisciple3.getEventIds().contains(event1.getEventId());
        eventScheduler.removeRoom(room1.getId());
        assert event1.getAttendeeIds().size()==0;
        assert !JohnathanDisciple1.getEventIds().contains(event1.getEventId());
        assert !JohnathanDisciple2.getEventIds().contains(event1.getEventId());
        assert !JohnathanDisciple3.getEventIds().contains(event1.getEventId());
        Event event11 = eventScheduler.createEvent("How to Jonathan Walk--According to an expert",
                LocalDateTime.of(2020, 10, 8, 13, 0),
                LocalDateTime.of(2020, 10, 8, 14, 0), speakerIds,
                room1.getId(),2);
        //assert event11 == null;
        eventScheduler.rescheduleEvent(event2.getEventId(), room1.getId(), event2.getStartTime(), event2.getEndTime());
        //assert event2.getAttendeeIds().size()==2;
        //assert JohnathanDisciple1.getEventIds().contains(event2.getEventId());
        //assert JohnathanDisciple2.getEventIds().contains(event2.getEventId());
        //assert JohnathanDisciple3.getEventIds().contains(event2.getEventId());
        //eventScheduler.removeRoom(room1.getId());
        //assert event2.getAttendeeIds().size()==0;
        //assert !JohnathanDisciple1.getEventIds().contains(event2.getEventId());
        //assert !JohnathanDisciple2.getEventIds().contains(event2.getEventId());
        //assert !JohnathanDisciple3.getEventIds().contains(event2.getEventId());
        //assert event2.getRoomId() == null;
    }*/
}

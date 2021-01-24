import Entities.Attendee;
import org.junit.Test;

import java.time.LocalDateTime;

public class TestAttendee {

    @Test(timeout = 50)
    public void TestAddTime(){
        //positive test
        Attendee attendee1 = new Attendee("attendee1", "hi123");
        LocalDateTime startTime = LocalDateTime.of(2001, 7,5,9,0);
        LocalDateTime endTime = LocalDateTime.of(2001, 7,5,10,0);
        assert attendee1.addTime(startTime, endTime);

        //negative test
        assert !attendee1.addTime(startTime, endTime);
    }

    @Test(timeout = 50)
    public void TestRemoveTime(){
        //poistive test
        Attendee attendee2 = new Attendee("attendee2", "hi123");
        LocalDateTime startTime = LocalDateTime.of(2001, 7,5,9,0);
        LocalDateTime endTime = LocalDateTime.of(2001, 7,5,10,0);
        assert attendee2.addTime(startTime, endTime);
        assert attendee2.removeTime(startTime, endTime);


    }

    @Test(timeout = 50)
    public void TestisAvailable(){
        //positive test
        Attendee attendee3 = new Attendee("attendee3", "hi123");
        LocalDateTime startTime = LocalDateTime.of(2001, 7,5,9,0);
        LocalDateTime endTime = LocalDateTime.of(2001,7,5,9,1 );
        assert attendee3.isAvailable(startTime, endTime);

    }


}

package tech.rahulpandey.backend.scheduler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserSchedulerTests {

    @Autowired
    private EventScheduler eventScheduler;

    @Test
    void testUpdateAllEventsData(){
        Assertions.assertTrue(eventScheduler.updateAllEventsData());
    }

}

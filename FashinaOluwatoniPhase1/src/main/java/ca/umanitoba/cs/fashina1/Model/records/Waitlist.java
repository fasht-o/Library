package ca.umanitoba.cs.fashina1.Model.records;
import ca.umanitoba.cs.fashina1.Model.classes.Media;
import ca.umanitoba.cs.fashina1.Model.classes.User;
import com.google.common.base.Preconditions;

import java.util.Date;
public record Waitlist(User user, Media media, Date startTime) {
    private void checkWaitlist() {
        Preconditions.checkNotNull(media, "Media should not be null");
        Preconditions.checkNotNull(user, "User should not be null");
        Preconditions.checkNotNull(startTime, "startTime should not be null");
    }
}

package event;

import java.util.ArrayList;
import java.util.List;

public class AdoptionEvent {
    private List<IAdoptable> participants = new ArrayList<>();

    public void registerParticipant(IAdoptable participant) {
        participants.add(participant);
    }

    public void hostEvent() {
        for (IAdoptable participant : participants) {
            participant.adopt();
        }
    }
}


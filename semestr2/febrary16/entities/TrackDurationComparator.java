package febrary16.entities;

import java.util.Comparator;

/**
 * Created by Максим on 28.02.2017.
 */
public class TrackDurationComparator implements Comparator<Track> {
    @Override
    public int compare(Track o1, Track o2) {
        Integer o1Duration = o1.getDuration();
        Integer o2Duration = o2.getDuration();
        return o1Duration.compareTo(o2Duration);
    }
}

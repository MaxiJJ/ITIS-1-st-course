package febrary28.track;

import java.util.Comparator;

/**
 * Created by Максим on 28.02.2017.
 */
public class TrackTitleComparator implements Comparator<Track> {
    @Override
    public int compare(Track o1, Track o2) {
        return o1.getTitle().compareToIgnoreCase(o2.getTitle());
    }
}

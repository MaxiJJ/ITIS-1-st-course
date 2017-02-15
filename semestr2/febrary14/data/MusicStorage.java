package febrary14.data;

import febrary14.entities.Track;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class MusicStorage {
    private List<Track> trackList;
    private DataStorage dataStorage;
    private URI uri;

    public MusicStorage() {
            trackList = new ArrayList<>();
            dataStorage = new InternalDataStorage();
    }

    public boolean add(Track track) {
        return trackList.add(track);
    }

    public List<Track> scan() {
        Set<File> trackFiles = dataStorage.scan(uri);
        trackList = new ArrayList<>();

        for (File file : trackFiles) {
            Track track = new Track();

            String[] fileData = file.getName().split("[.]");
            track.setTitle(fileData[0]);
            track.setFormat(fileData[1]);

            add(track);
        }

        return trackList;
    }

    public void sort() {
        trackList.sort(new Comparator<Track>() {
            @Override
            public int compare(Track track1, Track track2) {
                return track1.getTitle().compareToIgnoreCase(track2.getTitle());
            }
        });
    }

    public Track search(String name) {
        for (Track track : trackList) {
            if (track.getTitle().contains(name)) return track;
        }
        throw new NoSuchElementException("Can't find track with title:" + name);
    }

    public void createPlaylist() {
        scan();
        int trackNum = 1;

        for (Track track : trackList) {
            System.out.println(trackNum + ". " + track.getTitle());
            trackNum++;
        }
    }

    public void changeStoragePath(URI path) {
        dataStorage.remove(uri);
        uri = path;
    }

}
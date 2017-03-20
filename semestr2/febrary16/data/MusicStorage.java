package febrary16.data;

import febrary16.entities.Track;
import febrary16.entities.TrackComposerComparator;
import febrary16.entities.TrackDurationComparator;
import febrary16.entities.TrackTitleComparator;

import java.io.File;
import java.net.URI;
import java.util.*;

public class MusicStorage {
    private List<Track> trackList;
    private DataStorage dataStorage;

    public MusicStorage() {
        trackList = new ArrayList<>();
        dataStorage = new InternalDataStorage();
    }

    public boolean add(URI uri) {
        return dataStorage.add(uri);
    }

    public Track get(int index) {
        return trackList.get(index - 1);
    }

    public boolean delete(Track track) {
        return dataStorage.remove(track.getUri());
    }

    public void clear() {
        trackList.clear();
        dataStorage.clear();
    }

    private List<Track> handleFiles() {
        Set<File> trackFiles = dataStorage.getFileSet();

        List<Track> trackList = new ArrayList<>();
        for (File file : trackFiles) {
            Track track = new Track();

            String[] fileData = file.getName().split("[.]");
            track.setTitle(fileData[0]);
            track.setFormat(fileData[1]);
            track.setUri(file.toURI());

            trackList.add(track);
        }

        if (!trackList.equals(this.trackList)) this.trackList = trackList;

        return this.trackList;
    }

    public void sortByTitle() {
        trackList.sort(new TrackTitleComparator());
    }

    public void sortByDuration() {
        trackList.sort(new TrackDurationComparator());
    }

    public void sortByComposer() {
        trackList.sort(new TrackComposerComparator());
    }

    public Track searchByName(String title) {
        for (Track track : trackList) {
            if (track.getTitle().contains(title)) return track;
        }
        throw new NoSuchElementException("Can't find track with title: " + title);
    }

    public Track searchByComposer(String name) {
        for (Track track : trackList) {
            if (track.getComposer().getName().contains(name)) return track;
        }
        throw new NoSuchElementException("Can't find track with composer name: " + name);
    }

    public void createPlaylist() {
        handleFiles();
        int trackNum = 1;

        for (Track track : trackList) {
            System.out.println(trackNum + ". " + track.getTitle());
            trackNum++;
        }
    }

    public List<Track> getTrackList() {
        return handleFiles();
    }
}
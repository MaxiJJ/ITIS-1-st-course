package febrary16.data;

import java.io.File;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Максим on 15.02.2017.
 */
public class InternalDataStorage implements DataStorage {
    private Set<File> fileSet;

    public InternalDataStorage() {
        fileSet = new HashSet<>();
    }

    @Override
    public boolean add(URI uri) {
        if (!checkUri(uri)) return false;

        File folder = new File(uri);
        File[] listOfFiles = folder.listFiles();

        if (folder.isFile()) {
            fileSet.add(folder);
        } else if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    fileSet.add(file);
                } else {
                    add(file.toURI());
                }
            }
        }
        return true;
    }

    @Override
    public void read(URI uri) {

    }

    @Override
    public boolean remove(URI uri) {
        if (!checkUri(uri)) return false;

        File folder = new File(uri);
        File[] listOfFiles = folder.listFiles();

        if (folder.isFile()) {
            fileSet.remove(folder);
        } else if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    fileSet.remove(file);
                } else {
                    remove(file.toURI());
                }
            }
        }
        return true;
    }

    public Set<File> getFileSet() {
        return fileSet;
    }

    @Override
    public void clear() {
        fileSet.clear();
    }

    private boolean checkUri(URI uri) {
        if (uri == null) return false;
        return true;
    }
}
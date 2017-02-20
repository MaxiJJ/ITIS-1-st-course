package febrary16.data;

import java.io.File;
import java.net.URI;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Максим on 15.02.2017.
 */
public class InternalDataStorage implements DataStorage {
    private Set<File> fileSet;

    public InternalDataStorage() {
        fileSet = new HashSet<>();
    }

    @Override
    public Set<File> scan(URI uri) {
        File folder = new File(uri);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    fileSet.add(file);
                } else {
                    scan(file.toURI());
                }
            }
        }
        return fileSet;
    }

    @Override
    public void read(URI uri) {

    }

    @Override
    public Set<File> remove(URI uri) {
        if (uri == null) return fileSet;

        File folder = new File(uri);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    fileSet.remove(file);
                } else {
                    remove(file.toURI());
                }
            }
        }
        return fileSet;
    }
}

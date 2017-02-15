package febrary14.data;

import java.io.File;
import java.net.URI;
import java.util.Set;

/**
 * Created by Максим on 15.02.2017.
 */
public interface DataStorage {
    Set<File> scan(URI uri);

    void read(URI uri);

    Set<File> remove(URI uri);
}

package febrary9.data;

import java.util.ArrayList;

/**
 * Created by Максим on 09.02.2017.
 */
public class MemoryStorage implements Db {
    ArrayList memoryStorage;

    public MemoryStorage() {
        memoryStorage = new ArrayList();
    }

    @Override
    public void save(Object obj) throws DbException {
        memoryStorage.add(obj);
    }

    @Override
    public Object[] findAll() throws DbException {
        return memoryStorage.toArray();
    }
}

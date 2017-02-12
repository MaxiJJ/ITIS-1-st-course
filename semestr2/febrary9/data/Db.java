package febrary9.data;

/**
 * Created by Максим on 09.02.2017.
 */
public interface Db {
    public void save(Object obj) throws DbException;
    public Object[] findAll() throws DbException;
}

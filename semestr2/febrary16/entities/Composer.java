package febrary16.entities;

import java.util.Calendar;

/**
 * Created by Максим on 14.02.2017.
 */
public class Composer implements Comparable<Composer> {
    private String name;
    private Calendar birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getBirth() {
        return birth;
    }

    public void setBirth(Calendar birth) {
        this.birth = birth;
    }

    @Override
    public int compareTo(Composer o) {
        return name.compareToIgnoreCase(o.name);
    }
}

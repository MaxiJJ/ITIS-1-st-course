package febrary14.entities;

/**
 * Created by Максим on 14.02.2017.
 */
public class Track {
    private String title;
    private String format;
    private Composer composer;
    private Cover cover;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (title != null ? !title.equals(track.title) : track.title != null) return false;
        if (format != null ? !format.equals(track.format) : track.format != null) return false;
        if (composer != null ? !composer.equals(track.composer) : track.composer != null) return false;
        return cover != null ? cover.equals(track.cover) : track.cover == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (composer != null ? composer.hashCode() : 0);
        result = 31 * result + (cover != null ? cover.hashCode() : 0);
        return result;
    }
}

public class MusicalComposition {
    private String name;
    private String group;
    private MusicalGenre genre;
    private double duration;

    public MusicalComposition(String name, String group, MusicalGenre genre, double duration) {
        this.name = name;
        this.group = group;
        this.genre = genre;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public MusicalGenre getGenre() {
        return genre;
    }

    public double getDuration() {
        return duration;
    }

    public void setGenre(MusicalGenre genre) {
        this.genre = genre;
    }
}

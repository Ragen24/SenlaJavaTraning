import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MusicalDisk {
    private double totalDuration = 0;
    private MusicalGenre totalGenre;
    private ArrayList<MusicalComposition> music;

    public MusicalDisk(ArrayList<MusicalComposition> music) {
        this.music = music;
        setTotalDuration();
        setTotalGenre();
    }

    private void setTotalDuration() {
        for (MusicalComposition comp : music) {
            totalDuration += comp.getDuration();
        }
    }

    public double getTotalDuration() {
        return totalDuration;
    }

    private void setTotalGenre() {
        HashMap<MusicalGenre, Integer> genresAmount = new HashMap<>();
        Map.Entry<MusicalGenre, Integer> maxEntry = null;
        for (MusicalComposition comp : music) {
            if (genresAmount.containsKey(comp.getGenre()))
                genresAmount.put(comp.getGenre(), genresAmount.get(comp.getGenre()) + 1);
            else
                genresAmount.put(comp.getGenre(), 1);
        }
        for (Map.Entry<MusicalGenre, Integer> entry : genresAmount.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                maxEntry = entry;
        }
        totalGenre = maxEntry.getKey();
    }

    public MusicalGenre getTotalGenre() {
        return totalGenre;
    }
}

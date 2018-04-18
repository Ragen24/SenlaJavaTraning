import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<MusicalComposition> musicalCompositions = new ArrayList<>();
        musicalCompositions.add(new MusicalComposition("Name1", "group1", MusicalGenre.CLASSIC, 4.15));
        musicalCompositions.add(new MusicalComposition("Name2", "group2", MusicalGenre.METAL, 5.12));
        musicalCompositions.add(new MusicalComposition("Name3", "group3", MusicalGenre.METAL, 3.25));
        musicalCompositions.add(new MusicalComposition("Name4", "group4", MusicalGenre.METAL, 6.2));
        musicalCompositions.add(new MusicalComposition("Name5", "group5", MusicalGenre.POP, 8.43));
        musicalCompositions.add(new MusicalComposition("Name6", "group6", MusicalGenre.ROCK, 12.51));
        musicalCompositions.add(new MusicalComposition("Name7", "group7", MusicalGenre.ROCK, 5.66));

        MusicalDisk disk = new MusicalDisk(musicalCompositions);

        System.out.println("Общая продолжительность: " + disk.getTotalDuration());
        System.out.println("Общий жанр: " + disk.getTotalGenre());
    }
}

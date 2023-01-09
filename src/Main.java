import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        List<Double> sorszam = new ArrayList<>();
        List<Double> allomasok = new ArrayList<>();
        List<Double> ora = new ArrayList<>();
        List<Double> perc = new ArrayList<>();
        List<String> indulas = new ArrayList<>();

        File file = new File("vonat.txt");

        try (Scanner scanner = new Scanner(file)){
            scanner.nextLine();
            while (scanner.hasNextLine()){
                String sor = scanner.nextLine();
                String[] split = sor.split("\t");
                sorszam.add(Double.parseDouble(split[0]));
                allomasok.add(Double.parseDouble(split[1]));
                ora.add(Double.parseDouble(split[2]));
                perc.add(Double.parseDouble(split[3]));
                indulas.add(split[4]);
            }
            List<Double> alltemp = new ArrayList<>();
            List<Double> vonattemp = new ArrayList<>();

            for (Double allomas:allomasok){
                if (alltemp.contains(allomas)==false){
                    alltemp.add(allomas);
                }
            }

            for (Double vonat:sorszam){
                if (vonattemp.contains(vonat)==false){
                    vonattemp.add(vonat);
                }
            }

            System.out.println("2. feladat");
            System.out.println("Az állomások száma: "+ alltemp.size());
            System.out.println("A vonatok száma: "+ vonattemp.size());
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
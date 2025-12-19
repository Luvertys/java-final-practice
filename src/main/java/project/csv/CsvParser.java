package project.csv;

import project.model.CountryRecord;
import java.io.*;
import java.util.*;

public class CsvParser {

    public List<CountryRecord> load(String filename) throws Exception {
        List<CountryRecord> list = new ArrayList<>();

        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
        if (is == null) {
            throw new FileNotFoundException("Файл " + filename + " не найден в resources");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            br.readLine(); // пропускаем заголовок
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                CountryRecord c = new CountryRecord(
                        p[0],                        // Country
                        p[1],                        // Region
                        Integer.parseInt(p[2]),      // Happiness Rank
                        Double.parseDouble(p[3]),    // Happiness Score
                        Double.parseDouble(p[5]),    // Economy
                        Double.parseDouble(p[6]),    // Family
                        Double.parseDouble(p[7]),    // Health
                        Double.parseDouble(p[8]),    // Freedom
                        Double.parseDouble(p[9]),    // Trust
                        Double.parseDouble(p[10]),   // Generosity
                        Double.parseDouble(p[11])    // Dystopia Residual
                );
                list.add(c);
            }
        }
        return list;
    }
}


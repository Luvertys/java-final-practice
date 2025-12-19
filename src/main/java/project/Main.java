package project;

import project.csv.CsvParser;
import project.model.CountryRecord;
import project.db.*;

import java.util.List;
import project.chart.EconomyChart;


public class Main {
    public static void main(String[] args) throws Exception {

        // Парсим CSV
        CsvParser parser = new CsvParser();
        List<CountryRecord> records = parser.load("countries.csv");

        // Создаём таблицы
        SchemaInitializer.init();

        // Сохраняем данные в бд
        CountryDao dao = new CountryDao();
        dao.insertAll(records);

        System.out.println("Данные загружены в бд\n");

        // SQL-запросы
        QueryExecutor.highestEconomy();
        QueryExecutor.averageEconomy();

        // график
        EconomyChart.show();
    }
}

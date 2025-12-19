package project.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import project.db.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EconomyChart {

    public static void show() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String sql =
                "SELECT country, economy " +
                        "FROM country " +
                        "ORDER BY economy DESC " +
                        "LIMIT 15";

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String country = rs.getString("country");
                double economy = rs.getDouble("economy");

                dataset.addValue(economy, "Economy", country);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Economy by Country",
                "Country",
                "Economy",
                dataset
        );

        ChartFrame frame = new ChartFrame("Economy Chart", chart);
        frame.pack();
        frame.setVisible(true);
    }
}

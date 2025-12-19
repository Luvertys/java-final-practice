package project.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryExecutor {

    // 1. Страна с самым высоким показателем экономики
    public static void highestEconomy() throws Exception {
        String sql = "SELECT country, region, economy " +
                "FROM country " +
                "WHERE region IN ('Latin America and Caribbean', 'Eastern Asia') " +
                "ORDER BY economy DESC " +
                "LIMIT 1";

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                System.out.println("Страна с самым высоким показателем экономики:");
                System.out.println(rs.getString("country") + " | " +
                        rs.getString("region") + " | " +
                        rs.getDouble("economy"));
            }
        }
    }

    // 2. Страна со средним показателем
    public static void averageEconomy() throws Exception {
        String sql = "SELECT country, region, economy " +
                "FROM country " +
                "WHERE region IN ('Western Europe', 'North America') " +
                "ORDER BY ABS(economy - (" +
                "SELECT AVG(economy) FROM country " +
                "WHERE region IN ('Western Europe', 'North America'))) " +
                "LIMIT 1";

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                System.out.println("Страна с самым средним показателем экономики:");
                System.out.println(rs.getString("country") + " | " +
                        rs.getString("region") + " | " +
                        rs.getDouble("economy"));
            }
        }
    }
}

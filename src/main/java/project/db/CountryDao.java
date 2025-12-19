package project.db;

import project.model.CountryRecord;
import java.sql.*;
import java.util.List;

public class CountryDao {

    public void insertAll(List<CountryRecord> list) throws Exception {
        String sql = "INSERT INTO country(country, region, happiness_rank, happiness_score, economy, " +
                "family, health, freedom, trust, generosity, dystopia_residual)VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = Database.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (CountryRecord c : list) {
                ps.setString(1, c.getCountry());
                ps.setString(2, c.getRegion());
                ps.setInt(3, c.getHappinessRank());
                ps.setDouble(4, c.getHappinessScore());
                ps.setDouble(5, c.getEconomy());
                ps.setDouble(6, c.getFamily());
                ps.setDouble(7, c.getHealth());
                ps.setDouble(8, c.getFreedom());
                ps.setDouble(9, c.getTrust());
                ps.setDouble(10, c.getGenerosity());
                ps.setDouble(11, c.getDystopiaResidual());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }
}


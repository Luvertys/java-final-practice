package project.db;

import java.io.*;
import java.sql.*;
import java.util.stream.Collectors;

public class SchemaInitializer {

    public static void init() throws Exception {

        // Загружаем schema.sql из resources
        InputStream is = SchemaInitializer.class.getClassLoader().getResourceAsStream("schema.sql");
        if (is == null) {
            throw new RuntimeException("schema.sql не найден в resources");
        }

        String sql;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            sql = br.lines().collect(Collectors.joining("\n"));
        }

        try (Connection conn = Database.connect();
             Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
        }
    }
}
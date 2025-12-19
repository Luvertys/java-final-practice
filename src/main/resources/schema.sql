DROP TABLE IF EXISTS country;

CREATE TABLE country (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    country TEXT,
    region TEXT,
    happiness_rank INTEGER,
    happiness_score REAL,
    economy REAL,
    family REAL,
    health REAL,
    freedom REAL,
    trust REAL,
    generosity REAL,
    dystopia_residual REAL
);

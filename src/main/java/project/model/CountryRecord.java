package project.model;

public class CountryRecord {
    private String country;
    private String region;
    private int happinessRank;
    private double happinessScore;
    private double economy;
    private double family;
    private double health;
    private double freedom;
    private double trust;
    private double generosity;
    private double dystopiaResidual;

    // конструктор
    public CountryRecord(String country, String region, int happinessRank,
                         double happinessScore, double economy, double family,
                         double health, double freedom, double trust,
                         double generosity, double dystopiaResidual) {
        this.country = country;
        this.region = region;
        this.happinessRank = happinessRank;
        this.happinessScore = happinessScore;
        this.economy = economy;
        this.family = family;
        this.health = health;
        this.freedom = freedom;
        this.trust = trust;
        this.generosity = generosity;
        this.dystopiaResidual = dystopiaResidual;
    }

    // геттеры
    public String getCountry() { return country; }
    public String getRegion() { return region; }
    public int getHappinessRank() { return happinessRank; }
    public double getHappinessScore() { return happinessScore; }
    public double getEconomy() { return economy; }
    public double getFamily() { return family; }
    public double getHealth() { return health; }
    public double getFreedom() { return freedom; }
    public double getTrust() { return trust; }
    public double getGenerosity() { return generosity; }
    public double getDystopiaResidual() { return dystopiaResidual; }
}


class University {
    private String name;
    private String city;
    private int prestige;

    public University() {}

    University(String name, String city) {
        this.name = name;
        this.city = city;
    }

    University(String name, String city, int prestige) {
        this.name = name;
        this.city = city;
        if (!(prestige >= 0 && prestige <=10)) prestige = 0;
        this.prestige = prestige;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPrestige() {
        return prestige;
    }

    public void setPrestige(int prestige) {
        this.prestige = prestige;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package br.com.meli.sports;

public enum Level {


    BEGINNER("begginer"),
    AMATEUR("amateur"),
    PROFESSIONAL("professional");
    public String level;

    Level(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}

package Sample.CardEnums;

public enum CommonCard {
    Berserker("Berserker", "increaseScoreByMerdermore", 4, "ranged", false , 1),
    YoungBerserker("YoungBerserker", "increaseScoreByMerdermore", 2, "ranged", false , 2),

    Decoy("Decoy", "dec0oy", 0, "all", false , 3);;
    private final String cardName;
    private final String ability;
    private int score;

    private int count;

    private final String playField;
    private final boolean isHero;

    CommonCard(String cardName, String ability, int score, String playField, boolean isHero , int count) {
        this.cardName = cardName;
        this.ability = ability;
        this.score = score;
        this.count = count;
        this.playField = playField;
        this.isHero = isHero;

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void decreaseOneCount() {
        this.count--;
    }
}


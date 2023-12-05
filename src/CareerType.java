//https://www.baeldung.com/a-guide-to-java-enums
public enum CareerType {
    BANKER(1, "Banker", 400.00, 9, 2),
    CARPENTER(2, "Carpenter", 250.00, 6, 7),
    FARMER(3, "Farmer", 150.00, 4, 9);

    private final int id;
    private final String nick;
    private final double money;
    private final int intelligence;
    private final int strength;

    CareerType(int id, String nick, double money, int intelligence, int strength) {
        this.id = id;
        this.nick = nick;
        this.money = money;
        this.intelligence = intelligence;
        this.strength = strength;
    }

    public int getId() { return id; }
    public String getNick() { return nick; }
    public double getMoney() { return money; }
    public int getIntelligence() { return intelligence; }
    public int getStrength() { return strength; }
}


public class OregonLogic {

    private int water;
    private int food;

    private int career;

    public OregonLogic() {
        water = 0;
        food = 0;
    }

    public int getCareer() {
        return career;
    }

    public void setCareer(int career) {
        this.career = career;
    }

    //returns a random integer between a and b, b is not inclusive
    public int randInt(int a, int b) {
        return (int) (Math.random() * (b - a)) + a;
    }

    public boolean isDead() {
        return (water <= 0 || food <= 0);
    }

}

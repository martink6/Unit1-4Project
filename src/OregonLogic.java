public class OregonLogic {

    public OregonLogic() { }

    //returns a random integer between a and b, b is not inclusive
    public int randInt(int a, int b) {
        return (int) (Math.random() * (b - a)) + a;
    }


}

public class OregonVisual {
    public OregonVisual() { }
    Menus menu = new Menus();

    public String LearnTheTrail() {
        return menu.logo() + """
                            Try taking a journey by 
                            covered wagon across 2000 
                            miles of plains, rivers, and 
                            mountains. Try! On the 
                            plains, will you slosh your 
                            oxen through mud and 
                            water-filled ruts or will you 
                            plod through the dust six inches 
                            deep?"
      """;
    }

}

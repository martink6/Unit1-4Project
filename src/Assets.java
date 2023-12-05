import java.util.Map;

public class Assets {
    public static final String LOGO = """
          _______ _             ____                               _______        _ _ \s
         |__   __| |           / __ \\                             |__   __|      (_) |\s
            | |  | |__   ___  | |  | |_ __ ___  __ _  ___  _ __      | |_ __ __ _ _| |\s
            | |  | '_ \\ / _ \\ | |  | | '__/ _ \\/ _` |/ _ \\| '_ \\     | | '__/ _` | | |\s
            | |  | | | |  __/ | |__| | | |  __/ (_| | (_) | | | |    | | | | (_| | | |\s
            |_|  |_| |_|\\___|  \\____/|_|  \\___|\\__, |\\___/|_| |_|    |_|_|  \\__,_|_|_|\s
                                                __/ |                                 \s
                                               |___/                                  \s
        """;

    public static final String MAIN_MENU = """
         You may:
         1. Travel the trail
         2. Learn about the trail
         3. Exit
         """;
    public static final String LORE = """
        Try taking a journey by
        covered wagon across 2000
        miles of plains, rivers, and
        mountains. Try! On the
        plains, will you slosh your
        oxen through mud and
        water-filled ruts or will you
        plod through the dust six inches
        deep?
        """;

    public static final String CAREER_DETAILS = """
        Traveling to Oregon isn't easy!
        But if you're a banker, you'll
        have more money for supplies
        and services than a carpenter
        or a farmer.
        
        However, the harder you have
        to try, the more points you
        deserve! Therefore, the
        farmer earns the greatest
        number of points and the
        banker earns the least.
        """;

    public static final String CAREER_PROMPT = """
        Many kinds of people made the trip to Oregon.
        You may:
        1. Be a banker from Boston
        2. Be a carpenter from Ohio
        3. Be a farmer from Illinois
        4. Find out the difference between these choices
        """;

    public static final Map<String, Events> EVENTS = Map.ofEntries(
            Map.entry("You come across a river", Events.INCREASE_WATER),
            Map.entry("You come across a lake", Events.INCREASE_WATER),
            Map.entry("You find wild berries", Events.INCREASE_FOOD),
            Map.entry("A thief steals some of your supplies", Events.DECREASE_FOOD),
            Map.entry("You encounter a storm", Events.DECREASE_TRAVELED),
            Map.entry("You find a shortcut", Events.INCREASE_TRAVELED),
            Map.entry("The destination was closer than you thought", Events.WIN),
            Map.entry("You are caught in a blizzard", Events.DIE),
            Map.entry("You meet friendly natives", Events.INCREASE_FOOD),
            Map.entry("A wagon wheel breaks", Events.DECREASE_TRAVELED),
            Map.entry("You find an abandoned wagon", Events.INCREASE_FOOD),
            Map.entry("Your water supply gets contaminated", Events.DECREASE_WATER),
            Map.entry("You spot a herd of buffalo", Events.INCREASE_FOOD),
            Map.entry("Heavy rains flood the trail", Events.DECREASE_TRAVELED),
            Map.entry("You find a clear spring", Events.INCREASE_WATER),
            Map.entry("You lose your way", Events.DECREASE_TRAVELED),
            Map.entry("A member of your party falls ill", Events.DECREASE_FOOD),
            Map.entry("A local guide offers help", Events.INCREASE_TRAVELED),
            Map.entry("You find a hidden path through the woods", Events.INCREASE_TRAVELED),
            Map.entry("A wagon axle breaks and needs repair", Events.DECREASE_TRAVELED),
            Map.entry("You encounter a group of bandits", Events.DECREASE_FOOD),
            Map.entry("You are lost in a dense fog", Events.DECREASE_TRAVELED),
            Map.entry("A nearby volcano erupts, slowing your journey", Events.DECREASE_TRAVELED),
            Map.entry("You discover a beehive full of honey", Events.INCREASE_FOOD),
            Map.entry("An eagle drops a fish near your camp", Events.INCREASE_FOOD),
            Map.entry("You rescue a stranded traveler who shares supplies", Events.INCREASE_FOOD),
            Map.entry("You find a rare medicinal herb", Events.INCREASE_FOOD),
            Map.entry("A flash flood washes away some of your supplies", Events.DECREASE_FOOD),
            Map.entry("You come across an ancient burial site", Events.INCREASE_TRAVELED),
            Map.entry("A friendly bear guides you through the forest", Events.INCREASE_TRAVELED),
            Map.entry("You find a forgotten orchard full of fruit", Events.INCREASE_FOOD),
            Map.entry("A sudden snowstorm forces you to halt", Events.DECREASE_TRAVELED),
            Map.entry("You find an old, abandoned mine with supplies", Events.INCREASE_FOOD),
            Map.entry("A pack of wolves follows your wagon, keeping you alert", Events.DECREASE_TRAVELED),
            Map.entry("You come across a bustling frontier town", Events.INCREASE_FOOD),
            Map.entry("An old hermit gives you a map with a shortcut", Events.INCREASE_TRAVELED),
            Map.entry("You discover a river rich with fish", Events.INCREASE_FOOD)
    );
}

import java.util.*;

public enum Events {
    DECREASE_FOOD(),
    INCREASE_FOOD(),
    INCREASE_WATER(),
    DECREASE_WATER(),
    INCREASE_TRAVELED(),
    DECREASE_TRAVELED(),
     WIN(),
    DIE();

    Events() {}


    public static Map<String, Events> randomEvent() {
        List<String> keys = new ArrayList<>(Assets.EVENTS.keySet());
        String randomKey = keys.get(Utils.randInt(0, keys.size()));
        Events randomValue = Assets.EVENTS.get(randomKey);

        return Collections.singletonMap(randomKey, randomValue);
    }
}

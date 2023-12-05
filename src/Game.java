import java.util.Map;

public class Game {
    private final int TARGET_DISTANCE = 2000;
    private CareerType career;
    private double water = 100;
    private double food = 100;
    private double traveled = 0;
    private boolean won = false;
    private boolean dead = false;

    public Game() {
    }

    public void start() {
        mainMenu();
    }

    private void updateWater(double amount) {
        water += amount;
    }

    private void updateFood(double amount) {
        food += amount;
    }

    private void updateTraveled(double amount) {
        traveled += amount;
    }

    private void updateWon(boolean won) {
        this.won = won;
    }

    private void updateDead(boolean dead) {
        this.dead = dead;
    }

    private double getWater() {
        return water;
    }

    private double getFood() {
        return food;
    }

    private double getTraveled() {
        return traveled;
    }

    private boolean hasWon() {
        return won;
    }

    private boolean isDead() {
        return dead;
    }

    private void mainMenu() {
        Utils.clearScreen();
        System.out.print(Assets.LOGO);
        System.out.println();
        System.out.print(Assets.MAIN_MENU);
        int choice = Utils.askQuestionInt("What is your choice? ");
        switch (choice) {
            case 1 -> startGame();
            case 2 -> learnAboutTheTrail();
            case 3 -> System.exit(0);
            default -> {
                System.out.println("Invalid choice");
                mainMenu();
            }
        }
    }

    private void startGame() {
        chooseCareer();
        while (!hasWon() && !isDead() && getTraveled() < TARGET_DISTANCE) {
            travelTheTrail();
        }
        System.out.printf("You traveled %.2f miles%n", getTraveled());
        System.out.printf("The game is over. You %s%n", hasWon() ? "won!" : "lost!");
        System.out.printf("""
                Your final stats:
                Career: %s
                Food: %.2f units
                Water: %.2f units
                Distance traveled: %.2f miles
                """, career.getNick(), getFood(), getWater(), getTraveled());

        String ans = Utils.askQuestion("Would you like to play again? (y/n) ");
        if (ans.equalsIgnoreCase("y")) {
            resetGame();
            start();
        } else {
            System.exit(0);
        }
    }

    private void resetGame() {
        water = 100;
        food = 100;
        traveled = 0;
        updateWon(false);
        updateDead(false);
    }

    private void learnAboutTheTrail() {
        Utils.clearScreen();
        System.out.print(Assets.LORE);
        System.out.println();
        Utils.askQuestion("Press enter to continue");
        mainMenu();
    }

    private void chooseCareer() {
        Utils.clearScreen();
        System.out.print(Assets.CAREER_PROMPT);
        int choice = Utils.askQuestionInt("What is your choice? ");
        switch (choice) {
            case 1 -> career = CareerType.BANKER;
            case 2 -> career = CareerType.CARPENTER;
            case 3 -> career = CareerType.FARMER;
            case 4 -> {
                learnAboutTheCareers();
                chooseCareer();
            }
            default -> {
                System.out.println("Invalid choice");
                chooseCareer();
            }
        }
    }

    private void learnAboutTheCareers() {
        Utils.clearScreen();
        System.out.print(Assets.CAREER_DETAILS);
        System.out.println();
        Utils.askQuestion("Press enter to continue");
    }

    private void travelTheTrail() {
        Utils.clearScreen();
        playEvent();
        if (hasWon() || isDead() || getTraveled() >= TARGET_DISTANCE) {
            return;
        }
        System.out.println("You traveled " + getTraveled() + " miles");
        System.out.println("You have " + getFood() + " food");
        System.out.println("You have " + getWater() + " water");
        System.out.println("You have " + (TARGET_DISTANCE - getTraveled()) + " miles left");
        System.out.println();
        Utils.askQuestion("Press enter to continue");
    }

    private void playEvent() {
        Map<String, Events> Event = Events.randomEvent();
        System.out.println(Event.keySet().toArray()[0]);
        Events eventType = (Events) Event.values().toArray()[0];

        switch (eventType) {
            case INCREASE_FOOD:
                int baseGainFood = Utils.randInt(0, 10);
                double foodMultiplier = 1 + (career.getStrength() / 5.0);
                double totalGainFood = baseGainFood * foodMultiplier;
                updateFood(totalGainFood);
                System.out.printf("You've found food! Base gain: %d units. Your strength increases the total gain by %.2f%%, resulting in %.2f units.%n",
                        baseGainFood, (foodMultiplier - 1) * 100, totalGainFood);
                System.out.printf("Your current food supply is %.2f units.%n", getFood());
                break;

            case DECREASE_FOOD:
                int baseLossFood = Utils.randInt(0, 10);
                double strengthLossMultiplier = 1 - (career.getStrength() / 5.0);
                double totalLossFood = baseLossFood * strengthLossMultiplier;
                updateFood(-totalLossFood);

                double strengthReductionPercent = (1 - strengthLossMultiplier) * 100;

                System.out.printf("Misfortune strikes! You've lost some food. Base loss: %d units, Strength reduction: %.2f%%, Total loss: %.2f units.%n",
                        baseLossFood, strengthReductionPercent, Math.abs(totalLossFood));
                System.out.printf("You now have %.2f units of food remaining.%n", getFood());
                break;

            case INCREASE_WATER:
                int baseGainWater = Utils.randInt(0, 10);
                double intelligenceGainMultiplier = 1 + (career.getIntelligence() / 5.0);
                double totalGainWater = baseGainWater * intelligenceGainMultiplier;
                updateWater(totalGainWater);
                System.out.printf("You've discovered a water source! Base gain: %d units. Your intelligence increases the total gain by %.2f%%, resulting in %.2f units.%n",
                        baseGainWater, (intelligenceGainMultiplier - 1) * 100, totalGainWater);
                System.out.printf("Your current water supply is %.2f units.%n", getWater());
                break;

            case DECREASE_WATER:
                int baseLossWater = Utils.randInt(0, 10);
                double intelligenceLossMultiplier = 1 - (career.getIntelligence() / 5.0);
                double totalLossWater = baseLossWater * intelligenceLossMultiplier;
                updateWater(-totalLossWater);
                System.out.printf("You've lost some water. Base loss: %d units. Your intelligence reduces the loss by %.2f%%, resulting in %.2f units lost.%n",
                        baseLossWater, (1 - intelligenceLossMultiplier) * 100, Math.abs(totalLossWater));
                System.out.printf("Your remaining water supply is %.2f units.%n", getWater());
                break;

            case INCREASE_TRAVELED:
                double distanceGain = Utils.randInt(0, 100);
                double strengthTravelMultiplier = 1 + (career.getStrength() / 5.0);
                double totalTravelGain = distanceGain * strengthTravelMultiplier;
                updateTraveled(totalTravelGain);
                System.out.printf("You've made good progress! Base distance gained: %.2f miles. Your strength increases the distance by %.2f%%, resulting in a total gain of %.2f miles.%n",
                        distanceGain, (strengthTravelMultiplier - 1) * 100, totalTravelGain);
                System.out.printf("Your total distance traveled is now %.2f miles.%n", getTraveled());
                break;

            case DECREASE_TRAVELED:
                double distanceLoss = Utils.randInt(0, 100);
                double strengthTravelLossMultiplier = 1 - (career.getStrength() / 5.0);
                double totalTravelLoss = distanceLoss * strengthTravelLossMultiplier;
                updateTraveled(-totalTravelLoss);
                System.out.printf("You've encountered a delay. Base distance lost: %.2f miles. Your strength reduces the distance lost by %.2f%%, resulting in a total loss of %.2f miles.%n",
                        distanceLoss, (1 - strengthTravelLossMultiplier) * 100, Math.abs(totalTravelLoss));
                System.out.printf("Your total distance traveled is now %.2f miles.%n", getTraveled());
                break;

            case WIN:
                updateWon(true);
                System.out.println("Congratulations! You have successfully completed your journey!");
                break;

            case DIE:
                updateDead(true);
                System.out.println("Sadly, your journey has come to an end. Better luck next time!");
                break;
        }
    }
}

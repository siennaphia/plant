public class Cactus extends Plant {
    Cactus() {
        super("Does your cactus have soft, discolored patches?");
        addChild("yes", new Diagnosis("Diagnosis: Overwatering. Reduce the frequency of watering and make sure your cactus has good drainage."));
        addChild("no", new Diagnosis("Your cactus seems to be healthy. Continue current care regimen."));
    }

    @Override
    void diagnose() {
        System.out.println(question);
    }
}

public class Tulip extends Plant {
    Tulip() {
        super("Are the leaves and stems rotting and turning to mush?");
        addChild("yes", new Diagnosis("Diagnosis: Tulip fire. Remove and destroy affected plants. Do not plant tulips in the same soil for several years."));
        addChild("no", new Diagnosis("Your tulip seems to be healthy. Continue current care regimen."));
    }

    @Override
    void diagnose() {
        System.out.println(question);
    }
}

public class Rose extends Plant {
    Rose() {
        super("Are there black spots on the leaves?");
        addChild("yes", new Diagnosis("Diagnosis: Black spot disease. Remove affected leaves and apply a suitable fungicide."));
        addChild("no", new Diagnosis("Your rose seems to be healthy. Continue current care regimen."));
    }

    @Override
    void diagnose() {
        System.out.println(question);
    }
}

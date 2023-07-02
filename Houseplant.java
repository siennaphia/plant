public class Houseplant extends Plant {
    Houseplant() {
        super("Are the leaves pale or yellowing?");
        addChild("yes", new Diagnosis("Diagnosis: Nutrient deficiency. Try adding a balanced fertilizer to your plant care regimen."));
        addChild("no", new Diagnosis("Your houseplant seems to be healthy. Continue current care regimen."));
    }

    @Override
    void diagnose() {
        System.out.println(question);
    }
}

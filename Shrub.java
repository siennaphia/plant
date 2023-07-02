class Shrub extends Plant {
    Shrub() {
        super("Is the shrub losing leaves or showing signs of wilting?");
        addChild("yes", new Diagnosis("Diagnosis: Water stress or disease. Check for proper watering and inspect for any signs of pests or diseases."));
        addChild("no", new Diagnosis("Your shrub seems to be healthy. Continue current care regimen."));
    }

    @Override
    void diagnose() {
        System.out.println(question);
    }
}
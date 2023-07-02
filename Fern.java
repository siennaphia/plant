public class Fern extends Plant {
    Fern() {
        super("Are the fronds turning brown and crispy?");
        addChild("yes", new Diagnosis("Diagnosis: Dry air or insufficient humidity. Mist the fern regularly and place a humidifier nearby."));
        addChild("no", new Diagnosis("Your fern seems to be healthy. Continue current care regimen."));
    }

    @Override
    void diagnose() {
        System.out.println(question);
    }
}

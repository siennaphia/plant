import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlantDoctor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Construct the decision tree
        Plant root = createDecisionTree();

        diagnosePlant(root, scanner);
    }

    private static void diagnosePlant(Plant node, Scanner scanner) {
        node.diagnose();
        String answer = scanner.nextLine().toLowerCase();
        Plant nextNode = node.getNext(answer);
        if (nextNode != null) {
            diagnosePlant(nextNode, scanner);
        } else {
            System.out.println("Unable to diagnose the problem. Please consult a plant expert.");
        }
    }

    private static Plant createDecisionTree() {
        // Construct and connect the decision tree here
        Plant root = new Node("Do you know the type of your plant?");

        Node typeYes = new Node("What type of plant is it? (cactus/rose/tulip/fern/shrub/houseplant)");

        Node cactus = new Node("Does your cactus have soft, discolored patches?");
        Diagnosis cactusYes = new Diagnosis("Diagnosis: Overwatering. Reduce the frequency of watering and make sure your cactus has good drainage.");
        Diagnosis cactusNo = new Diagnosis("Your cactus seems to be healthy. Continue current care regimen.");
        cactus.addChild("yes", cactusYes);
        cactus.addChild("no", cactusNo);

        Node rose = new Node("Are there black spots on the leaves?");
        Diagnosis roseYes = new Diagnosis("Diagnosis: Black spot disease. Remove affected leaves and apply a suitable fungicide.");
        Diagnosis roseNo = new Diagnosis("Your rose seems to be healthy. Continue current care regimen.");
        rose.addChild("yes", roseYes);
        rose.addChild("no", roseNo);

        Node tulip = new Node("Are the leaves and stems rotting and turning to mush?");
        Diagnosis tulipYes = new Diagnosis("Diagnosis: Tulip fire. Remove and destroy affected plants. Do not plant tulips in the same soil for several years.");
        Diagnosis tulipNo = new Diagnosis("Your tulip seems to be healthy. Continue current care regimen.");
        tulip.addChild("yes", tulipYes);
        tulip.addChild("no", tulipNo);

        Node fern = new Node("Are the fronds turning brown and crispy?");
        Diagnosis fernYes = new Diagnosis("Diagnosis: Dry air or insufficient humidity. Mist the fern regularly and place a humidifier nearby.");
        Diagnosis fernNo = new Diagnosis("Your fern seems to be healthy. Continue current care regimen.");
        fern.addChild("yes", fernYes);
        fern.addChild("no", fernNo);

        Node shrub = new Node("Is the shrub losing leaves or showing signs of wilting?");
        Diagnosis shrubYes = new Diagnosis("Diagnosis: Water stress or disease. Check for proper watering and inspect for any signs of pests or diseases.");
        Diagnosis shrubNo = new Diagnosis("Your shrub seems to be healthy. Continue current care regimen.");
        shrub.addChild("yes", shrubYes);
        shrub.addChild("no", shrubNo);

        Node houseplant = new Node("Are the leaves pale or yellowing?");
        Diagnosis houseplantYes = new Diagnosis("Diagnosis: Nutrient deficiency. Try adding a balanced fertilizer to your plant care regimen.");
        Diagnosis houseplantNo = new Diagnosis("Your houseplant seems to be healthy. Continue current care regimen.");
        houseplant.addChild("yes", houseplantYes);
        houseplant.addChild("no", houseplantNo);

        typeYes.addChild("cactus", cactus);
        typeYes.addChild("rose", rose);
        typeYes.addChild("tulip", tulip);
        typeYes.addChild("fern", fern);
        typeYes.addChild("shrub", shrub);
        typeYes.addChild("houseplant", houseplant);

        Node typeNo = new Node("Are the plant's leaves turning yellow?");

        Node yellowYes = new Node("Is the plant receiving too much water?");
        Diagnosis yellowYesYes = new Diagnosis("Diagnosis: Overwatering. Cut down on watering and ensure the plant has good drainage.");
        Diagnosis yellowYesNo = new Diagnosis("Diagnosis: Nutrient deficiency. Try adding a balanced fertilizer to your plant care regimen.");
        yellowYes.addChild("yes", yellowYesYes);
        yellowYes.addChild("no", yellowYesNo);

        Node yellowNo = new Node("Are the plant's leaves wilting or curling?");
        Diagnosis yellowNoYes = new Diagnosis("Diagnosis: Underwatering or too much heat. Increase watering and consider moving the plant to a cooler location.");
        Diagnosis yellowNoNo = new Diagnosis("Your plant seems to be healthy. Continue current care regimen.");
        yellowNo.addChild("yes", yellowNoYes);
        yellowNo.addChild("no", yellowNoNo);

        typeNo.addChild("yes", yellowYes);
        typeNo.addChild("no", yellowNo);

        root.addChild("yes", typeYes);
        root.addChild("no", typeNo);

        return root;
    }
}

class Node extends Plant {
    Node(String question) {
        super(question);
    }

    @Override
    void diagnose() {
        System.out.println(question);
    }
}

class Diagnosis extends Plant {
    String message;

    Diagnosis(String message) {
        super(null);
        this.message = message;
    }

    @Override
    void diagnose() {
        System.out.println(message);
    }
}

class Plant {
    String question;
    Map<String, Plant> children;

    Plant(String question) {
        this.question = question;
        this.children = new HashMap<>();
    }

    void addChild(String answer, Plant child) {
        children.put(answer, child);
    }

    Plant getNext(String answer) {
        return children.get(answer);
    }

    void diagnose() {
        System.out.println(question);
    }
}

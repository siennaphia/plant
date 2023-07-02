import java.util.HashMap;
import java.util.Map;

public abstract class Plant {
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

    abstract void diagnose();
}

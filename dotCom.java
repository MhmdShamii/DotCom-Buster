import java.util.*;

public class dotCom {
    private String name;
    private ArrayList<String> location;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLocation(ArrayList<String> location) {
        this.location = location;
    }

    public String checkYourSelf(String Guess) {
        String result = "miss";
        if (location.contains(Guess)) {
            location.remove(Guess);
            if (location.isEmpty()) {
                result = "Kill";
            } else {
                result = "hit";
            }
        }
        return result;
    }
}

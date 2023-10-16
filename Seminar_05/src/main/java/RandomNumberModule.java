import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberModule {
    public List<Integer> generateRandomNumbers(){
        Random rnd = new Random();
        List<Integer> rndNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rndNumbers.add(rnd.nextInt());
        }
        return rndNumbers;
    }
}

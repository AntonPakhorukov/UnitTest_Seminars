import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RandomNumberModuleTest {
    Random rnd = new Random();
    @Test
    void testGenerateIntegerList() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4 ,5);
        RandomNumberModule randomNumber = mock(RandomNumberModule.class);
        when(randomNumber.generateRandomNumbers()).thenReturn(nums);
        assertEquals(nums, randomNumber.generateRandomNumbers());
    }
    @Test
    void testFindMaxNumber() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        MaxNumberModule findMaxNumber = mock(MaxNumberModule.class);
        when(findMaxNumber.maxNumber(nums)).thenReturn(5);
        assertEquals(5, findMaxNumber.maxNumber(nums));
    }
    @Test
    void testIntegrationFindMaxNumber() {
        RandomNumberModule generateRandom = new RandomNumberModule();
        List<Integer> numbers = generateRandom.generateRandomNumbers();
        MaxNumberModule findMax = new MaxNumberModule();
        int maxNum = findMax.maxNumber(numbers);
        Collections.sort(numbers);
        assertEquals(numbers.get(numbers.size() - 1), maxNum);
    }
}

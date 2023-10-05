public class SomeService {
    public String FizzBuzz(int i){
        String result = "";
        if (i % 15 ==0){
            result += "FizzBuzz";
        } else if (i % 3 == 0) {
            result += "Fizz";
        } else if (i % 5 == 0){
            result += "Buzz";
        } else {
            result += i;
        }
        return result;
    }
    public boolean firstLast6(int[] nums){
        return nums[0] == 6 || nums[nums.length-1] == 6;
    }
    public int luckySum(int a, int b, int c){
        int result = 0;
        if (a != 13) {
            result += a;
        }
        if (b!= 13) {
            result += b;
        }
        if (c != 13) {
            result += c;
        }
        return result;
    }

}

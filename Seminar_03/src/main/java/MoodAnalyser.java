public class MoodAnalyser {
    public String analyseMood(String phrase){
        if(phrase.contains("good")) {
            return "Good day";
        } else if (phrase.contains("sad")){
            return "Bad day";
        } else {
            return "Neutral day";
        }
    }
}

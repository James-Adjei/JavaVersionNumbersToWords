
import com.jimi.numberToText.Trillion;

public class App {
    public static void main(String[] args) throws Exception {
       
       
       long tval=998L;
       String results = Trillion.TranslateToWords(tval,"ghc");
       
        System.out.println(results);
    }
}
 
import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class PatternMatching
{
    static boolean containsAToZ(String s)
    {
       int alpha_Arr[] = new int[26];
       int len = s.length();
       int iterator=0;
       for(; iterator<len; iterator++)
       {
           char c = s.charAt(iterator);
           int asci_c = (int)c;
           if(asci_c >= 65 && asci_c <= 90)
           {
               alpha_Arr[asci_c%65] = 1;
           }
           else if(asci_c >= 97 && asci_c <= 122)
           {
               alpha_Arr[asci_c%97] = 1;
           }
       }
       for(Integer val : alpha_Arr)
       
           if(val == 0) return false;
           
       return true;
    }
   
}

public class PatternMatchingDriver {
	 public static void main(String args[]) throws IOException{
		Logger logger = Logger.getLogger(PatternMatching.class.getName());
		PatternMatching patternObj = new PatternMatching();
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        String input = bufferedReader.readLine();
	        if(!(patternObj.containsAToZ(input)))
	        {
	            logger.log(Level.INFO, "doesn't contain a-z characters");
	        }
	        else
	        {
	            logger.log(Level.INFO, "does contain a-z characters");
	        }
	    }
}

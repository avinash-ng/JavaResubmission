import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class FormFilling
{
	 public static String findDates(String firstSignUp, String current) throws ParseException
	    {


	        SimpleDateFormat obj = new SimpleDateFormat("dd-MM-yyyy");
	        Calendar c_obj = Calendar.getInstance();
	        
	        //if firstSignUp is in future 
	        Date first = obj.parse(firstSignUp);
	        Date currentDate = obj.parse(current);
	        if(first.compareTo(currentDate) > 0)
	            return "No range";

	        
	        
	        String currentYearAnniversary = firstSignUp.substring(0, 6)+current.substring(6, 10);
	        
	        c_obj.setTime(obj.parse(currentYearAnniversary));

	        int val = Calendar.DAY_OF_MONTH;
	        
	        
	        //find the start and end dates for form filling and store them as strings
	        c_obj.add(val, 30);
	        String maxDateAsString = obj.format(c_obj.getTime());
	        c_obj.add(val, -60);
	        String minDateAsString = obj.format(c_obj.getTime());



	        //converting strings to dates
	        Date maxDate = obj.parse(maxDateAsString);
	        Date minDate = obj.parse(minDateAsString);



	        //if current years anniversary date completed 
	        Date currentYearAnniversaryDate = obj.parse(currentYearAnniversary);
	        if(currentYearAnniversaryDate.compareTo(currentDate) < 0)
	            return minDateAsString+" "+maxDateAsString;

	        
	        if(maxDate.compareTo(currentDate) > 0)
	            return minDateAsString+" "+current;
	        
	        else
	            return current+" "+maxDateAsString;

	        
	    }


    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<String>();
        while(number > 0){
            String []arr = br.readLine().split("\\s");
            String firstFilledDate = arr[0];
            String currentDate = arr[1];
            try{
                String ans = findDates(firstFilledDate, currentDate);
                list.add(ans);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }

            number -= 1;
        }
        for(String s: list) System.out.println(s);
    }
}
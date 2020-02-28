
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class FileFinder
{
	
	FileFinder(){
		
	}
	ArrayList<String> findFiles(String regex) {
		ArrayList<String> list1 = new ArrayList<>();
		if(regex.length() == 0)
		{
			list1.add("improper regex");
			return list1;
		}
		
		//command to be executed is fed into a list
        List<String> list = new ArrayList<String>();
        list.add("find");
        list.add(".");
        list.add("-name");
        list.add(regex);

        
        
        ProcessBuilder pb = new ProcessBuilder(list);

//setting directory to be looked for
        pb.directory(new File("/home"));
        
        try{
        	//executing the command inside list
        	            Process p = pb.start();

        	            BufferedReader reader = new BufferedReader(
        	                    new InputStreamReader(p.getInputStream()));
        	            String line = null;
        	            while (true) {
        	//iterating the output of the executed command

        	                try {
        	                    if (!((line = reader.readLine()) != null)) break;
        	                } catch (IOException e) {
        	                    e.printStackTrace();
        	                }
        	                list1.add(line);
        	            }

        	            
        	            try {
        	                reader.close();
        	            } catch (IOException ex) {
        	                ex.printStackTrace();
        	            }

         }
        catch(IOException ex){
            System.out.println("Exception raised");
        }
        
        return list1;

	}
}


public class FileFinderDriver {
    public static void main(String args[]) throws IOException {


    	
    	FileFinder fd = new FileFinder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.parseInt(br.readLine());
        while(choice == 1)
        {
        	String regex = br.readLine();
        	
        	ArrayList<String> list1 = fd.findFiles(regex);
        
        
        	for(String string : list1) {
        		System.out.println(string);
        	}
        	choice = Integer.parseInt(br.readLine());
        }
        if(choice == 2)	{
        	System.out.println("Process breaked");	
        }
        
        
      }

	
}
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveToFIle {
	public void fileSave(ArrayList<ArrayList<String> > words)
	{
	    BufferedWriter writer;
	    StringBuilder builder = new StringBuilder();
	    //String built = builder.toString();
		for(int i=0;i<words.size();i++)
	    {
	    	builder.append(words.get(i)).append(System.lineSeparator());	
	    		//^Turns the 2d array back to one String; Line Separator remembers the new lines
	    }
		 String built = builder.toString();
	    built = built.replaceAll("\\[","").replaceAll("\\]","").replaceAll("\\,","");
	    //System.out.println(built);
		try {
			writer = new BufferedWriter(new FileWriter("D:\\SAP2.txt"));
			writer.write(built.toString());
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printList(ArrayList<ArrayList<String> > words)
	{
		for (ArrayList<String> list : words) {
            for (String i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
	}
}

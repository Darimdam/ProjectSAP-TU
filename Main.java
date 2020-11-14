import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

//D:\SAP.txt

public class Main {
	public static void main(String[] args) throws FileNotFoundException{
		ArrayList<ArrayList<String> > words = new ArrayList<ArrayList<String> >();
		//Printing the 2d ArrayList without the [] by iterating the whole list and printing each element
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter file path:");
		String path=scanner.nextLine(); //Giving the file path
	       try {
	           File file=new File(path); //creating the file var
	           Scanner scan=new Scanner(file);
	           while(scan.hasNextLine()){	//Traversing the file
	        	   words.add(new ArrayList<String>(Arrays.asList(scan.nextLine().split("\\s+"))));
	        	   	//^saves the lines from the file in the 2d ArrayList and splits them into words
	           }

	       }catch (IOException e) {
	           System.out.println("An error occurred.");
	           e.printStackTrace();
	       }
	       System.out.println("1: Swap lines\n2: Swap words\n3: Print List");
	    //StringBuilder asd2 = new StringBuilder();
	    //String asd = asd2.toString();
	    
	    SaveToFIle save = new SaveToFIle();
		int choice=scanner.nextInt();
		switch(choice)
		{
		case 1: //swap lines
			try
			{
			int line1, line2;
			System.out.println("Enter index of 1st and 2nd line: ");
			line1= scanner.nextInt();
			line2 = scanner.nextInt();
			//Switching lines with the help of collections.swap and the indexes of each line
			Collections.swap(words,line1,line2);
			}
			catch (IndexOutOfBoundsException e)
			{
                System.out.println("Index out of bounds.");
                e.printStackTrace();
			}
			save.printList(words);
			save.fileSave(words);
			break;
		case 2: //swap words
			try
			{
			//Switching words with the get and set methods
			int line1, line2;
			int row1,row2;
			System.out.println("Print the indexes of the lines and words(line1-word1/line2-word2): ");
			line1= scanner.nextInt();
			row1 = scanner.nextInt();
			line2 = scanner.nextInt();
			row2 = scanner.nextInt();
			String temp=(words.get(line1).get(row1));	//temp var declaration
			words.get(line1).set(row1, words.get(line2).get(row2));	//w.get(0) goes to the 1st line and the .set(1..) works
														//with the second element in that line by setting another
														//value to it; switching happens here
			words.get(line2).set(row2, temp);	//finalizing the swap
			}
			catch (IndexOutOfBoundsException e)
			{
                System.out.println("Index out of bounds.");
                e.printStackTrace();
			}
			save.printList(words);
			save.fileSave(words);
			break;
		case 3: //printing
			save.printList(words);
			break;
		default:
			System.out.println("Invalid input.");
		}
	}

}

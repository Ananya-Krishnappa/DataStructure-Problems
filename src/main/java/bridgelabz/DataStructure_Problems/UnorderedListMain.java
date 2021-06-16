/**
 * Purpose:a. Desc -> Read the Text from a file, split it into words and arrange it as Linked List. Take a user input to search a Word in the List. If the Word is not found then add it to the list, and if it found then remove the word from the List. In the end save the list into a file 
b. I/P -> Read from file the list of Words and take user input to search a Text c. Logic -> Create a Unordered Linked List. The Basic Building Block is the Node Object. Each node object must hold at least two pieces of information. One ref to the data field and second the ref to the next node object. 
d. O/P -> The List of Words to a File.

 * @author Ananya K
 * @version 1.0
 * @since 15/06/2021
 * 
 */
package bridgelabz.DataStructure_Problems;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UnorderedListMain<T> {
	private static LinkedList<String> list = new LinkedList<String>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		readFile();
		System.out.println("Enter a word from list to search");
		String searchWord = sc.nextLine();
		int searchResult = list.searchByValue(searchWord);
		if (searchResult == -1) {
			list.add(searchWord);
		} else {
			list.removeAtIndex(searchResult);
		}
		writeFile();
	}

	/**
	 * This method writes an output file
	 * 
	 * @throws IOException
	 */
	private static void writeFile() throws IOException {
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			str = str.concat(list.get(i)).concat(" ");
		}
		FileWriter fw = new FileWriter("E:\\workspace\\DataStructure_Problems\\output.txt");
		for (int i = 0; i < str.length(); i++)
			fw.write(str.charAt(i));
		System.out.println("Writing successful");
		fw.close();
	}

	/**
	 * This method reads an input file
	 * 
	 * @throws IOException
	 */
	private static void readFile() throws IOException {
		int ch;
		FileReader fr = null;
		String lines = "";
		try {
			fr = new FileReader("E:\\workspace\\DataStructure_Problems\\input.txt");
		} catch (FileNotFoundException fe) {
			System.out.println("File not found");
		}
		// read from FileReader till the end of file
		while ((ch = fr.read()) != -1) {
			System.out.print((char) ch);
			lines = lines.concat(String.valueOf((char) ch));
		}
		System.out.println();
		fr.close();
		String[] wordArray = lines.split(" ");
		for (String word : wordArray) {
			list.add(word);
		}
	}
}

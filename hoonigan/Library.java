package hoonigan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;

public class Library {
	
	private HashMap<String, Library_Items> libraryMap;
	private BufferedReader reader;
	private Parser parser;
	
	public Library() {
		try{
			//Read Json file, change Directory of File as needed
			reader = new BufferedReader(new FileReader("hello.json"));
			
			//Create Parser instance which takes in our Json file
			parser = new Parser(reader);
			
			//Parser object parses and stores our Library
			libraryMap = parser.parse();

		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

	}
	
	//Prints out: name, type, id, [artist/author], checkedOutStatus
	public void printLibrary() {
		System.out.println("Items in Library:");
		Iterator<String> itr = libraryMap.keySet().iterator();
		while(itr.hasNext()){
			Library_Items li = libraryMap.get(itr.next());
			System.out.println(li.toString());
		}
		
	}
	
	// check item out from library
	public void checkOutItem(String itemId) {
		try {
			Library_Items item = libraryMap.get(itemId);
			item.checkOut();
		}
		catch (Exception ex) {
			
		}
	}

	// check item in to library
	public void checkInItem(String itemId) {
		try {
			Library_Items item = libraryMap.get(itemId);
			item.checkIn();
		}
		catch (Exception ex) {
			
		}
	}
	
	// returns true if item is checked out
	public boolean itemCheckedOut(String itemId) {
		try {
			Library_Items item = libraryMap.get(itemId);
			return item.isCheckedOut();
		}
		catch (Exception ex) {
			return false;
		}
	}
	
	// returns true if this item id is found in library
	public boolean validId(String itemId) {
		if (libraryMap.get(itemId) instanceof Library_Items) {
			return true;
		}
		else {
			return false;
		}
	}

}

package hoonigan;
import java.time.LocalDate;

/** Book
 *  
 * 	A simple Book class--extended from Abstract Library_Items class
 * 
 */
public class Book extends Library_Items{
	//Various fields
	private String item_name;
	private String item_type;
	private String item_id;
	private String item_author;
	private String returnDate;
	private boolean checkedOut;
	
	//Default constructor
	Book(){
	}
	
	//Constructor
	Book(String name, String type, String id, String author){
		item_name = name;
		item_type = type;
		item_id = id;
		item_author = author;
		checkedOut = false;
		returnDate = LocalDate.now().toString();
	}

	//Typical Getters and Setters
	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_type() {
		return item_type;
	}

	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	
	public String getItem_author() {
		return item_author;
	}

	public void setItem_author(String item_author) {
		this.item_author = item_author;
	}
	
	//Returns corresponding boolean value based on if Object is checked out
	public boolean isCheckedOut(){
		return checkedOut;
	}
	
	//Sets checkout value to true if checked out
	public void checkOut(){
		if(checkedOut == false)
			returnDate = LocalDate.now().plusDays(21).toString();
			checkedOut = true;
	}
		
	//Sets checkout value to false if checked out
	public void checkIn(){
		if(checkedOut == true)
			returnDate = LocalDate.now().toString();
			checkedOut = false;
	}
	 
	//Sets returnDate to currentDate + 21 days
	public String returnDate(){
		return LocalDate.parse(returnDate).plusDays(21).toString();
	}
	
	public String status() {
		if(this.isCheckedOut()) {
			return "Checked out, due: " + this.returnDate;
		}
		else {
			return "Available";
		}
	}
	
	@Override
	public String toString(){
		String line = String.format("ID: %s | TITLE: %s | TYPE: %s | AUTHOR: %s | STATUS: %s", 
				item_id, item_name, item_type, item_author, status());
		return line;
	}
}

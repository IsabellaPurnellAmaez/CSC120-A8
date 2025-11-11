/* This is a stub for the Library class */

import java.util.Hashtable;

/**
 * Class that contains all information required to make a Libraru
 */
public class Library extends Building implements LibraryRequirements{

  private Hashtable<String, Boolean> collection;
    
  /**
   * Constructor for a library
   * @param name name of library
   * @param address address of library
   * @param nFloors number of floors of librart
   */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();

      System.out.println("You have built a library: 📖");
    }

    /**
     * Method checks if the title is already in the library, if not adds it to the library. 
     * Otherwise throws an exception
     * @param title Title and author of book trying to add to library.
     */
    public void addTitle(String title){
      if (!this.collection.containsKey(title)){
        this.collection.put(title, true);
        System.out.println(title + " added to library");
      }
      else{
        throw new RuntimeException(title + " already in library, cannot be added.");
      }
    }

    /**
     * Removes a title from the library only if it was already there. Otherwise, throws an exception.
     * @param title Title and author of book being removed from the library
     * @return the title of the book if successfully removed.  
     */
    public String removeTitle(String title){  // return the title that we removed
      if(this.collection.containsKey(title)){
        this.collection.remove(title);
        return title;
      }
      else{
        throw new RuntimeException(title  + " not in library, cannot be removed.");
      }
    } 

    /**
     * Checks out a book from the library changing the value in the hashmap of books in the library to false 
     * to indicate that the library has it but it's checked out. 
     * @param title name of the book getting checked out
     */
    public void checkOut(String title){
      if (this.collection.containsKey(title)){
        if (this.collection.get(title) == true){
          this.collection.put(title, false);
        }
        else{
          throw new RuntimeException(title  + " already checked out.");
        }
      }
      else{
        throw new RuntimeException(title  + " not in library, cannot be checked out.");
      }
    }

    /** 
     * Returns a book that's been checked out back to the library. Throws errors if the book is not in the library or is already checked out
     *  @param title Title and author of book being returned
     */
    public void returnBook(String title){ 
      if (this.collection.containsKey(title)){
        if (this.collection.get(title) == false){
          this.collection.put(title, true);
        }
        else{
          throw new RuntimeException(title  + " not checked out, cannot be returned.");
        }
      }
      else{
        throw new RuntimeException(title  + " not in library, cannot be returned.");
      }
    }

    /**
     * Says whether or not title is in library
     * @param title Title and author of book being checked
     * @return T/F: does the library have this book
     */
    public boolean containsTitle(String title){
      if(this.collection.containsKey(title)){
        return true;
      }
      else{
        return false;
      }
    }
    
    /**
     * Says whether or not book is available
     * @param title Title and author of book being checked
     * @return T/F: Is this book available
     */
    public boolean isAvailable(String title){
      if (this.collection.containsKey(title)){
        return this.collection.get(title);
      }
        throw new RuntimeException(title  + " not in library.");
    }

    /**
     * Prints all books in the library and their availability status
     */
    public void printCollection(){
      System.out.println("Library Collection:");
      for (String key : this.collection.keySet()) {
        System.out.print(key);
        if(this.collection.get(key)){
          System.out.println(": AVAILABLE");
        }
        else{
          System.out.println(": CHECKED OUT");

        }

      }
    }
     
    public void showOptions(){
      super.showOptions();
      System.out.println(" + addTitle(String title) \n + removeTitle(String title) \n + checkOut(String title) \n + returnBook(String title) \n + containsTitle(String title) \n + isAvailable(String title) \n + printCollection()");
    }

  
    public static void main(String[] args) {

      Library Neilson = new Library("Neilson", "Smith Campus", 5);
      String book1 = "The Lorax by Dr. Seuss";
      Neilson.addTitle(book1);
      System.out.println(Neilson.isAvailable(book1));

      Neilson.printCollection();

      Neilson.showOptions();

      String book3 = "Oh The Places You'll Go by Dr. Seuss";
      Neilson.addTitle(book3);
      Neilson.checkOut(book3);

      Neilson.returnBook(book1); //catches this and throws exception which then stops the program...

      String book4 = "The Lorax by Dr. Seuss";
      Neilson.addTitle(book4); 

      String book2 = "The Giver by Lois Lowry"; 
      Neilson.checkOut(book2);

    

    }
  
  }
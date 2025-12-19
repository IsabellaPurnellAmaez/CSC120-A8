/* This is a stub for the Cafe class */
/**
 * Contains all information for setting up a Cafe
 */
public class Cafe extends Building implements CafeRequirements{

    private int nCoffeeOunces = 200;  
    private int nSugarPackets = 50;  
    private int nCreams = 50;  
    private int nCups = 25;  

    /**
     * Cafe constructor
     * @param name name of Cafe
     * @param address address of Cafe
     * @param nFloors number of floors of cafe
     */
    public Cafe(String name, String address, int nFloors){
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
    }
    
    /**
     * Sells coffe based off of customer order. Calls restock if store is out of any items
     * @param size Size of coffee ordered in ounces
     * @param nSugarPackets number of sugars in the coffee order
     * @param nCreams number of creamers in coffee order
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(this.nCoffeeOunces > size){
            this.nCoffeeOunces = this.nCoffeeOunces - size;
        }
        else{
            System.out.println("Restocking Coffee!");
            restock(100, 0, 0, 0);
            this.nCoffeeOunces = this.nCoffeeOunces - size;
        }
        if(this.nSugarPackets > nSugarPackets){
            this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        }
        else{
            System.out.println("Restocking Sugar Packets!");
            restock(0, 50, 0, 0);
            this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        }
         if(this.nCreams > nCreams){
            this.nCreams = this.nCreams - nCreams;
        }
        else{
            System.out.println("Restocking Cream!");
            restock(0, 0, 50, 0);
        } 
        if(this.nCups >1){
            this.nCups = this.nCups - 1;
        }
        else{
            System.out.println("Restocking Cups!");
            restock(0, 0, 0, 10);
            this.nCups = this.nCups - 1;
        }
        System.out.println("Enjoy your " + size + " ounce coffee with " + nSugarPackets + " sugar packets and " + nCreams + " creams!");
    }

    /**
     * Restocks coffee shop inventory when something runs out. 
     * @param nCoffeeOunces number of coffee in ounces being added to inventory
     * @param nSugarPackets number of sugar packets being added to inventory
     * @param nCreams number of creamers being added to inventory
     * @param nCups number of cups being added to inventory. 
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces;
        this.nSugarPackets = this.nSugarPackets + nSugarPackets;
        this.nCreams = this.nCreams + nCreams;
        this.nCups = this.nCups + nCups;

    }

    /* navigation options */
    public void showOptions(){
        super.showOptions();
        System.out.println( " + sellCoffee(size, nSugarPackets, nCreams)");
    }

    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
        if (floorNum > 1 ) {
        throw new RuntimeException("Customers cannog to above the first floor, please stay on the ground floor of the cafe.");
      }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    
    public static void main(String[] args) {
        Cafe Iconica = new Cafe("Iconica", "Main St", 2);
        Iconica.sellCoffee(12, 2, 3);

        Iconica.showOptions();
    }
}

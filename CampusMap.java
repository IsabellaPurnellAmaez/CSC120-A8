import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));

        myMap.addBuilding(new Building("Lamont House", "17 Prospect Street, MA 01063", 4));
        myMap.addBuilding(new Building("Burton Hall", "46 College Lane, MA 01063", 4));
        myMap.addBuilding(new Building("Nielson Library", "7 Neilson Drive, MA 01063", 4));
        myMap.addBuilding(new Building("Gardiner House", "1 Paradise Road, MA 01063", 4));
        myMap.addBuilding(new Building("Northrop House", "49 Elm Street, MA 01063", 5));
        myMap.addBuilding(new Building("Sage Hall", "144 Green Street, MA 01063", 3));
        myMap.addBuilding(new Building("John M. Greene Hall", "60 Elm Street, MA 01063", 3));
        myMap.addBuilding(new Building("Campus Center", "1 Chapin Way, MA 01063", 3));
        myMap.addBuilding(new Building("Comstock House", "1 Mandelle Road, MA 01063", 4));
        myMap.addBuilding(new Building("McConnell Hall", "2 Tyler Drive, MA 01063", 4));

        System.out.println(myMap);
    }
    
}

import java.util.LinkedList;

public class Town implements Comparable<Town> {

    private String townName;
    private LinkedList<Town> adjTown;
    private int distance;
    private Town previous;

    public Town(String townName) {
        this.townName = townName;
        adjTown = new LinkedList<>();
    }

    public Town(Town t) {
        this.townName = t.townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public LinkedList<Town> getAdjTown() {
        return adjTown;
    }

    public void setAdjTown(LinkedList<Town> adjTown) {
        this.adjTown = adjTown;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Town getPrevious() {
        return previous;
    }

    public void setPrevious(Town previous) {
        this.previous = previous;
    }

    @Override
    public int hashCode() {
        return townName.hashCode();
    }

    @Override
    public boolean equals(Object t) {
        if (this == t) return true;
        if (!(t instanceof Town)) return false;
        Town sameTown = (Town) t;
        return sameTown.getName().equals(this.townName) &&
               sameTown.getDistance() == this.distance &&
               (sameTown.getPrevious() == this.previous || 
                (sameTown.getPrevious() != null && this.previous != null && sameTown.getPrevious().getName().equals(this.previous.getName()))) &&
               sameTown.getAdjTown().equals(this.adjTown);
    }


    @Override
    public String toString() {
        return townName;
    }

    @Override
    public int compareTo(Town o) {
        return o.getName().compareTo(townName);
    }

	public String  getName() {
		// TODO Auto-generated method stub
		return townName;
	}
}

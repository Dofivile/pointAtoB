import java.util.Objects;

public class Road implements Comparable <Road> {
	
	private Town source;
	private Town destination;
	private int distance;
	private String name;
	
	public Road(Town source, Town destination, int distance, String name) {
		this.source=source;
		this.destination=destination;
		this.distance=distance;
		this.name=name;
	}
	
	public boolean contains(Town town) {
		
		return (source.equals(town) || destination.equals(town));
	}
	

	public Town getSource() {
		return source;
	}


	public void setSource(Town source) {
		this.source = source;
	}


	public Town getDestination() {
		return destination;
	}


	public void setDestination(Town destination) {
		this.destination = destination;
	}


	public int getWeight() {
		return distance;
	}


	public void setDegrees(int degrees) {
		this.distance = degrees;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Road road = (Road) o;
	    return distance == road.distance &&
	            ((Objects.equals(source, road.source) && Objects.equals(destination, road.destination)) ||
	            (Objects.equals(source, road.destination) && Objects.equals(destination, road.source))) &&
	            Objects.equals(name, road.name);
	}

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, distance, name);
    }
	@Override
	public int compareTo(Road r) {
		
		return this.name.compareTo(r.getName()) ;
	}
	
	@Override
	public String toString() {
	    return "Road Name: " + name + ", Source Town: " + source.getName() + ", Destination Town: " + destination.getName() + ", Distance: " + distance;
	}



	

}

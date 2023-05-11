import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TownGraphManager implements TownGraphManagerInterface {
	private Graph graph;

	public TownGraphManager() {
		this.graph = new Graph();
	}

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town source = getTown(town1);
		Town destination = getTown(town2);

		if (source != null && destination != null) {
			graph.addEdge(source, destination, weight, roadName);
			return true;
		}
		return false;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town source = getTown(town1);
		Town destination = getTown(town2);

		if (source != null && destination != null) {
			Road road = graph.getEdge(source, destination);
			if (road != null) {
				return road.getName();
			}
		}
		return null;
	}

	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}

	@Override
	public Town getTown(String name) {
		for (Town town : graph.vertexSet()) {
			if (town.getName().equals(name)) {
				return town;
			}
		}
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town source = getTown(town1);
		Town destination = getTown(town2);

		if (source != null && destination != null) {
			return graph.containsEdge(source, destination);
		}
		return false;
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> roads = new ArrayList<>();
		for (Road road : graph.edgeSet()) {
			roads.add(road.getName());
		}
		roads.sort(String::compareTo);
		return roads;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town source = getTown(town1);
		Town destination = getTown(town2);

		if (source != null && destination != null) {
			return graph.removeEdge(source, destination, -1, road) != null;
		}
		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(new Town(v));
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> towns = new ArrayList<>();
		for (Town town : graph.vertexSet()) {
			towns.add(town.getName());
		}
		towns.sort(String::compareTo);
		return towns;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town source = getTown(town1);
		Town destination = getTown(town2);

		if (source != null && destination != null) {
			return graph.shortestPath(source, destination);
		}
		return null;
	}

	public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException, NumberFormatException, java.io.IOException {
	    BufferedReader reader = null;
	    try {
	        reader = new BufferedReader(new FileReader(selectedFile));

	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(",");
	            if (parts.length >= 4) {
	                String town1 = parts[0].trim();
	                String town2 = parts[1].trim();
	                int weight = Integer.parseInt(parts[2].trim());
	                String roadName = parts[3].trim();

	                addTown(town1);
	                addTown(town2);
	                addRoad(town1, town2, weight, roadName);
	            }
	        }
	    } finally {
	        if (reader != null) {
	            reader.close();
	        }
	    }
	}
}

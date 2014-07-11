package ben.kn.algorithms.dijkstra;

/**
 * This class represents a path between two nodes, and contains the distance between them.
 * 
 * @author Ben (bknear@gmail.com)
 */
public class TreeNodePath {
	private TreeNode endOne, endTwo;
	private double distance;

	public TreeNodePath(TreeNode endOne, TreeNode endTwo, double distance) {
		this.endOne = endOne;
		this.endTwo = endTwo;
		this.distance = distance;
		if ( endOne.equals(endTwo) ) {
			throw new DijkstraException("Error creating the TreeNodePath: two unique TreeNodes names are required");
		}
	}


	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}


	public TreeNode getEndOne() {
		return endOne;
	}


	public TreeNode getEndTwo() {
		return endTwo;
	}
}

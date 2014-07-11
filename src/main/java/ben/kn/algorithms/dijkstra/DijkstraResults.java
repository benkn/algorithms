package ben.kn.algorithms.dijkstra;

import java.util.HashMap;
import java.util.Map;

public class DijkstraResults {
	private Map<String, String> pathsToNode = new HashMap<String, String>();
	private Map<TreeNode, Double> nodeDistances = new HashMap<TreeNode, Double>();

	public Map<TreeNode, Boolean> populateAndCreateVisitedMap(DijkstraTree tree) {
		Map<TreeNode, Boolean> visitedNodes = new HashMap<TreeNode, Boolean>();
		for ( TreeNode node : tree.getNodes() ) {
			// initialize all distances as infinity, and let the algorithm
			// set based on the starting node.
			nodeDistances.put(node, Double.MAX_VALUE);
			pathsToNode.put(node.getName(), "");
			visitedNodes.put(node, false);
		}
		return visitedNodes;
	}

	public Map<String, String> getPathsToNode() {
		return pathsToNode;
	}

	public Map<TreeNode, Double> getNodeDistances() {
		return nodeDistances;
	}
}
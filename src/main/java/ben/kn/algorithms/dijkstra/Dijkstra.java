package ben.kn.algorithms.dijkstra;

import java.util.Map;

public class Dijkstra {
	public static void main(String[] args) {
		System.out.println("Starting algorithm");
		String path = new Dijkstra().findShortestPath(DijkstraTreeGenerator.generateDijkstraTree(),
				"0", "6");
		System.out.println(path);
	}

	// Let the node at which we are starting be called the initial node. Let the
	// distance of node Y be the distance from the initial node to Y. Dijkstra's
	// algorithm will assign some initial distance values and will try to
	// improve them step by step.

	// 1. Assign to every node a distance value: set it to zero for our initial
	// node and to infinity for all other nodes.
	// 2. Mark all nodes as unvisited. Set initial node as current.

	// 3. For current node, consider all its unvisited neighbors and calculate
	// their tentative distance. For example, if current node (A) has distance
	// of 6, and an edge connecting it with another node (B) is 2, the distance
	// to B through A will be 6+2=8. If this distance is less than the
	// previously recorded distance, overwrite the distance. All unvisited
	// neighbors are added to an unvisited set.

	// 4. When we are done considering all neighbors of the current node, mark
	// it as visited. A visited node will not be checked ever again; its
	// distance recorded now is final and minimal.

	// 5. The next current node will be the node with the lowest distance in the
	// unvisited set.

	// 6. If all nodes have been visited, finish. Otherwise, set the unvisited
	// node with the smallest distance (from the initial node, considering all
	// nodes in graph) as the next "current node" and continue from step 3.

	public String findShortestPath(DijkstraTree tree, String startingNode, String endingNode) {
		// Steps 1 and 2
		DijkstraResults results = new DijkstraResults();
		// also create a Map to tell which nodes have been visited
		@SuppressWarnings("unused")
		// unused until I decide not to store the boolean on the node's
		// themselves
		Map<TreeNode, Boolean> vistedNodesMap = results.populateAndCreateVisitedMap(tree);

		/**************************************************************/

		// set the starting node as the current node
		TreeNode currentNode = tree.findNodeByName(startingNode);
		results.getNodeDistances().put(currentNode, 0d);
		results.getPathsToNode().put(currentNode.getName(), currentNode.getName());

		/**************************************************************/

		// while we have a node to review
		outer: while (currentNode != null) {
			// get the known shortest distance to this current node
			Double distanceToCurrentNode = results.getNodeDistances().get(currentNode);

			if ( currentNode.getPaths() != null ) {
				// go through all of the currentNode's paths
				for ( TreeNodePath path : currentNode.getPaths() ) {
					TreeNode end = path.getEndOne();

					// check that the end isn't the currentNode and hasn't been
					// visited
					if ( !end.equals(currentNode) && !end.isVisited() ) {
						// get the current believed distance to this end
						double believedDistance = results.getNodeDistances().get(end);

						/*
						 * if the distance to our current node and the current
						 * path distance is less than the believed distance,
						 * than this path is shorter.
						 */
						if ( (distanceToCurrentNode + path.getDistance()) < believedDistance ) {
							// AWESOME, WE FOUND A SHORTER PATH!
							// store the new distance
							results.getNodeDistances().put(end,
									distanceToCurrentNode + path.getDistance());

							// store the path to get to this end
							String pathToCurrentNode = results.getPathsToNode().get(currentNode.getName());
							String pathToEnd = appendStringWithComma(pathToCurrentNode,
									end.getName());
							results.getPathsToNode().put(end.getName(), pathToEnd);
						}
					}

					else {
						end = path.getEndTwo();
						if ( !end.isVisited() ) {
							// get the current believed distance to this end
							double believedDistance = results.getNodeDistances().get(end);

							/*
							 * if the distance to our current node and the
							 * current path distance is less than the believed
							 * distance, than this path is shorter.
							 */
							if ( (distanceToCurrentNode + path.getDistance()) < believedDistance ) {
								// AWESOME, WE FOUND A SHORTER PATH!
								// store the new distance
								results.getNodeDistances().put(end,
										distanceToCurrentNode + path.getDistance());

								// store the path to get to this end
								String pathToCurrentNode = results.getPathsToNode()
										.get(currentNode.getName());
								String pathToEnd = appendStringWithComma(pathToCurrentNode,
										end.getName());
								results.getPathsToNode().put(end.getName(), pathToEnd);
							}
						}
					}
				}
			}

			/**************************************************************/

			System.out.println("Finished with " + currentNode.getName()
					+ " node, placing distance of " + results.getNodeDistances().get(currentNode)
					+ " away from the start. To get there, follow this path - "
					+ results.getPathsToNode().get(currentNode.getName()));

			// seek next current node
			for ( TreeNodePath path : currentNode.getPaths() ) {
				TreeNode end = path.getEndOne();
				// check that this end isn't the current node
				if ( !end.equals(currentNode) && !end.isVisited() ) {
					currentNode = end;
					currentNode.setVisited(true);
					continue outer;
				} else {
					end = path.getEndTwo();
					// this end is definitely not the current, so just check if
					// it has been visited yet.
					if ( !end.isVisited() ) {
						currentNode = end;
						currentNode.setVisited(true);
						continue outer;
					}
				}
			}

			// if we've gone through all of the nodes, then there is no longer a
			// connection from this node to any other.
			currentNode = null;
		}

		TreeNode ending = tree.findNodeByName(endingNode);
		System.out.println("Shortest Distance = " + results.getNodeDistances().get(ending));

		return results.getPathsToNode().get(endingNode);
	}

	private String appendStringWithComma(String a, String b) {
		String c;
		if ( a != null && a.trim().length() > 0 ) {
			c = a + ", " + b;
		} else {
			c = b;
		}
		return c;
	}
}

package ben.kn.algorithms.dijkstra;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a node in a tree. It also contains a collection of the
 * paths it connects to.
 * 
 * @author Ben (bknear@gmail.com)
 */
public class TreeNode {
	private String name;
	private Set<TreeNodePath> paths;

	private boolean visited;

	public TreeNode(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<TreeNodePath> getPaths() {
		return paths;
	}

	public void setPaths(Set<TreeNodePath> paths) {
		this.paths = paths;
	}

	public void addPath(TreeNodePath path) {
		if ( paths == null ) {
			paths = new HashSet<TreeNodePath>();
		}
		paths.add(path);
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public boolean equals(Object node) {
		if ( node instanceof TreeNode ) {
			return ((TreeNode) node).getName().equals(name);
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "node " + name;
	}
}
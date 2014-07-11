package ben.kn.algorithms.dijkstra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DijkstraTree {

	private Set<TreeNode> set = new HashSet<TreeNode>();

	public boolean addPath(TreeNodePath path) {
		// integrate the path into the existing node tree
		TreeNode endOne = path.getEndOne();
		TreeNode endTwo = path.getEndTwo();
		if ( endOne == null || endTwo == null ) {
			return false;
		}
		endOne.addPath(path);
		endTwo.addPath(path);
		return true;
	}

	public boolean add(TreeNode node) {
		return set.add(node);
	}

	public boolean add(TreeNode node, List<TreeNodePath> pathways) {
		boolean success = set.add(node);
		if ( success ) {
			for ( TreeNodePath path : pathways ) {
				success = addPath(path);
				if ( !success ) {
					break;
				}
			}
		}
		return success;
	}

	public boolean addAll(Collection<? extends TreeNode> nodes) {
		return set.addAll(nodes);
	}

	public boolean addAll(Collection<? extends TreeNode> nodes, List<TreeNodePath> pathways) {
		boolean success = set.addAll(nodes);
		if ( success ) {
			for ( TreeNodePath path : pathways ) {
				success = addPath(path);
				if ( !success ) {
					break;
				}
			}
		}
		return success;
	}

	public void clear() {
		set.clear();
	}

	public Iterator<TreeNode> iterator() {
		return set.iterator();
	}

	public TreeNode findNodeByName(String name) {
		TreeNode foundNode = null;
		Iterator<TreeNode> iter = set.iterator();
		while (iter.hasNext()) {
			TreeNode node = iter.next();
			if ( node.getName().equalsIgnoreCase(name) ) {
				foundNode = node;
				break;
			}
		}

		return foundNode;
	}

	public DijkstraTree createCleanDuplicateTree() {
		Set<TreeNode> nodes = new HashSet<TreeNode>();
		List<TreeNodePath> paths = new ArrayList<TreeNodePath>();
		for ( TreeNode node : set ) {
			TreeNode newNode = new TreeNode(node.getName());
			nodes.add(newNode);

			for ( TreeNodePath path : node.getPaths() ) {
				paths.add(new TreeNodePath(path.getEndOne(), path.getEndTwo(), 0));
			}
		}

		DijkstraTree newTree = new DijkstraTree();
		newTree.addAll(nodes, paths);
		return newTree;
	}

	public Set<TreeNode> getNodes() {
		return set;
	}
}
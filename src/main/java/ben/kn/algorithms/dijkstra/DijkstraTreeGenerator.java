package ben.kn.algorithms.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class DijkstraTreeGenerator {

	public static DijkstraTree generateDijkstraTree() {
		DijkstraTree tree = new DijkstraTree();

		List<TreeNode> nodes = new ArrayList<TreeNode>();
		TreeNode zero = new TreeNode("0");
		TreeNode one = new TreeNode("1");
		TreeNode two = new TreeNode("2");
		TreeNode three = new TreeNode("3");
		TreeNode four = new TreeNode("4");
		TreeNode five = new TreeNode("5");
		TreeNode six = new TreeNode("6");
		nodes.add(zero);
		nodes.add(one);
		nodes.add(two);
		nodes.add(three);
		nodes.add(four);
		nodes.add(five);
		nodes.add(six);

		List<TreeNodePath> paths = new ArrayList<TreeNodePath>();
		paths.add(new TreeNodePath(zero, one, 3));
		paths.add(new TreeNodePath(zero, two, 6));
		paths.add(new TreeNodePath(zero, three, 2));
		paths.add(new TreeNodePath(one, two, 4));
		paths.add(new TreeNodePath(one, four, 7));
		paths.add(new TreeNodePath(two, four, 2));
		paths.add(new TreeNodePath(three, five, 4));
		paths.add(new TreeNodePath(four, six, 3));
		paths.add(new TreeNodePath(five, six, 1));

		tree.addAll(nodes, paths);

		return tree;
	}
}

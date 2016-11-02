package wirelessrouters;

import java.util.*;

public class WirelessRouter2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			Node[] nodes = new Node[n];
			int[] s = new int[n]; // satisfaction point array
			int i;
			for (i = 0; i < n; i++) {
				int value = sc.nextInt();
				nodes[i] = new Node(value);
				s[i] = value;
			}
			for (i = 0; i < n - 1; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;

				// add links
				nodes[a].addLink(b);
				nodes[b].addLink(a);

				// update satisfaction point array
				s[a] += nodes[b].value;
				s[b] += nodes[a].value;
			}
			sc.close();

			int sum = 0;
			sum = findMax(nodes, s, m);
			System.out.println(sum);
		}
	}

	public static int findMax(Node[] nodes, int[] s, int m) {
		if (m <= 0) {
			return m;
		}

		int n = nodes.length;

		// find max value point
		int max = 0, i;
		for (i = 0; i < n; i++) {
			max = max > s[i] ? max : s[i];
		}

		if (m == 1 || max == 0) {
			return max;
		}

		// handle the multi-maxValue case when m > 1
		int res = 0;
		for (i = 0; i < n; i++) {
			if (s[i] == max) {

				// deep clone nodes & s => nodes2 & s2
				int[] s2 = s.clone();
				Node[] nodes2 = new Node[n];
				for (int j = 0; j < n; j++) {
					if (null == nodes[j]) {
						continue;
					}
					nodes2[j] = new Node(nodes[j]);
				}

				// update the new s array when take off the current node
				Node tmp = nodes2[i];
				for (int j = 0; j < tmp.linkCnt; j++) {
					int link = tmp.linkList[j];
					Node nd = nodes2[link];
					if (null == nd) {
						continue;
					}
					s2[link] -= (nd.value + tmp.value);

					for (int k = 0; k < nd.linkCnt; k++) {
						int sublink = nd.linkList[k];
						Node subnd = nodes2[sublink];
						if (null == subnd) {
							continue;
						}
						s2[sublink] -= nd.value;
					}

					nd.value = 0;
					nd.removeLink(i);
				}

				nodes2[i] = null;
				s2[i] = 0;

				int k = findMax(nodes2, s2, m - 1);
				res = res > k ? res : k;
			}
		}

		return max + res;
	}

	// room class
	private static class Node {
		int value;
		int[] linkList;
		int linkCnt;

		Node(int v) {
			this.value = v;
			linkList = new int[3];
			linkCnt = 0;
		}

		Node(Node nd) {
			this.value = nd.value;
			linkList = nd.linkList.clone();
			linkCnt = nd.linkCnt;
		}

		boolean addLink(int a) {
			if (linkCnt >= 3) {
				return false;
			}
			linkList[linkCnt++] = a;
			return true;
		}

		boolean removeLink(int a) {
			for (int i = 0; i < linkCnt; i++) {
				if (a == linkList[i]) {
					linkCnt--;
					linkList[i] = linkList[linkCnt];
					return true;
				}
			}
			return false;
		}
	}

}

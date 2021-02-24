public class DisjointSetForest implements DisjointSetDataStructure {

		private class Element {
			public Element(int item) {
				parent = item;
				rank = 1;
			}

			int rank;
			int parent;
		}

		Element[] arr;

		public DisjointSetForest(int size) {
			arr = new Element[size];
		}

		@Override
		public void makeSet(int item) {
			arr[item] = new Element(item);
		}

		@Override
		public int findSet(int item) {
			if (arr[item] == null)
				return -1;
			if (item != arr[item].parent) {
				arr[item].parent = findSet(arr[item].parent);
			}
			return arr[item].parent;
		}

		@Override
		public boolean union(int itemA, int itemB) {
			return link(findSet(itemA), findSet(itemB));
		}

		private boolean link(int itemA, int itemB) {
			if (itemA == -1 || itemB == -1 || itemA == itemB)
				return false;
			if (arr[itemA].rank > arr[itemB].rank)
				arr[itemB].parent = itemA;
			else {
				arr[itemA].parent = itemB;
				if (arr[itemA].rank == arr[itemB].rank) {
					arr[itemB].rank = arr[itemB].rank + 1;
				}
			}
			return true;
		}

		@Override
		public String toString() {
			String str = "Disjoint sets as forest:\n";
			for (int x = 0; x < arr.length; x++) {
				str += x + " -> " + arr[x].parent + "\n";
			}
			return removeLine(str);
		}

		private String removeLine(String string) {

			if (string.length() < 2)
				return string;
			return string.substring(0, string.length() - 1);

		}

		@Override
		public int countSets() {
			// TODO Auto-generated method stub
			return 0;
		}
	}

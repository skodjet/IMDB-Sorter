
/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Tommy Skodje*/

public class BSTIndex {

		private class Node {
			private String key;
			private MovieInfo data;
			private Node left, right;

			public Node(MovieInfo info) {
				data = info;
				key = data.shortTitle;
			}
		}

		private Node root;

		public BSTIndex() {
			root = null;
		}

		// --------- [DO NOT MODIFY!] public BST methods  --------- //
		/* Important: Notice that each public method here calls another private method while passing it a reference to the tree root. This is a common way of structuring BST functions such that external client code will not have direct access to the tree root. You will be implementing the code in the private methods, not the public ones. */

		/* Calculate and return the height of the current tree. */
		public int calcHeight(){
				return calcNodeHeight(this.root);
		}

		/* Insert the given data element into the proper place in the BST structure. */
		public void insertMovie(MovieInfo data) {
			root = insertMovie(data, this.root);
		}

		/* Find and return the data element (i.e. the MovieInfo object)
		of the node where the movie's shortTitle matches the given key.
		Return null if the movie is not found. */
		public MovieInfo findMovie(String key) {
			return findMovie(this.root, key);
		}

		/* Print out all movies in the database whose shortTitle begins with
		the passed prefix string. If no movies match the given prefix, nothing
		will be printed. The order of printing does not matter, but make sure
		to print each match in a separate line. */
		public void printMoviesPrefix(String prefix) {
			printMoviesPrefix(this.root, prefix);
		}
		// ----------------- end of public methods ------------------ //


		// ------------- [TODO] private BST methods --------------- //
		private int calcNodeHeight(Node t) {
				// ... TODO ... //
			/*Approach is to find the height of the left subtree
			 * and the height of the right subtree, then choose the larger
			 * of the two subtrees and return that value recursively.
			 */
			
			if (t == null) {
				return 0;
			}
			
			int leftHeight = calcNodeHeight(t.left);
			int rightHeight = calcNodeHeight(t.right);
			
			if (leftHeight >= rightHeight) {
				return leftHeight + 1;
			} else {
				return rightHeight + 1;
			}
			
		}

		private Node insertMovie(MovieInfo data, Node t) {
				// ... TODO ... //
			
				
				if (t == null) {
					Node newMovie = new Node(data);
					return newMovie;
				}
				
				
			int compare = data.shortTitle.compareTo(t.data.shortTitle); //Compare the short titles of the node to insert to the current node.
			
			if (compare < 0) { //If the key of the node to insert < the key of the current node.
				t.left = insertMovie(data, t.left); //Call method recursively on the left node.
			} else if (compare > 0) { //If the key of the node to insert > the key of the current node.
				t.right = insertMovie(data, t.right); //Call the method recursively on the right node.
			}	
			 //If the key of the node to insert equals the key of the current node do nothing
			return t;
			
		}

		private MovieInfo findMovie(Node t, String key) {
				// ... TODO ... //
			
			if (t == null) {
				return null;
			}
			
			int compare = key.compareTo(t.data.shortTitle);
			
			if (compare < 0) { //If the key < the key in t recurse on the left subtree
				return findMovie(t.left, key);
			} else if (compare > 0) { //If the key > the key in t recurse on the right subtree
				return findMovie(t.right, key);
			} else { //Found a match!
				return t.data;
			}
		}

		private void printMoviesPrefix(Node t, String prefix) {
				// ... TODO ... //
			if (t != null) {
				if (t.data.shortTitle.startsWith(prefix.substring(0, prefix.length() - 1))) { //If this node's short title matches the string inputed (minus the *)
					System.out.println(t.data.shortTitle); //Print the short title of the movie.
				}
			
			
			if (t.left != null) {
				printMoviesPrefix(t.left, prefix);
			} if (t.right != null) {
				printMoviesPrefix(t.right, prefix);
			}
			
		}
		}
}

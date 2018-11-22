// Julia Boettcher, 2012; updated 2013, 2014, 2015, 2016
// Updated 2018 Konrad Swanepoel
// A class for representing a Huffman tree, implemented as binary tree
// whose nodes are of type HuffmanNode (see the file HuffmanNode.java).

public class HuffmanTree {

    public HuffmanNode root;  // the root of the Huffman tree
    
    // Builds the Huffman tree for character frequencies as in the given word:
    public HuffmanTree (String word) {
        // count the number of occurences of each character in word:
        CharacterCounts counts = new CharacterCounts();
        for (int i=0; i<word.length(); i++) {
            counts.increment( word.charAt(i) );
        }
        // According to these character counts, generate Huffman nodes
        // (without children) for each of these characters with
        // corresponding frequencies and insert each of them into a Huffman
        // list; this is all done by the method toHuffmanList of the class
        // CharacterCounts.
        HuffmanList list = counts.toHuffmanList();
        // The nodes now in the list are the leaves of the Huffman tree;
        // next construct the internal nodes
        while( ! list.containsAtMostOneItem() ) {
            // To construct an internal node, choose two nodes of
            // smallest frequency in list as children of this new node,
            // sum their frequencies to get the frequency of the new node,
            // delete these two nodes from the list, and insert the new node.
            HuffmanNode node = new HuffmanNode();
            node.left = list.extractMin();  // this automatically deletes
                                            // this node from the list
            node.right = list.extractMin();
            node.frequency = node.left.frequency + node.right.frequency;
            // label the new node with a string containing all the characters
            // in the subtree with this node as root
            node.label = node.left.label + node.right.label;
            list.insert(node);
        } 
        // Now only the root of the whole tree is in the list.
        root = list.extractMin();
    }
        
    // Prints the Huffman tree:
    public void print() {
        printRecursively(root, 0);	
    }
    
    // recursive printing of the Huffman tree;
    // depth is the depth in the tree.
    private void printRecursively(HuffmanNode node, int depth) {
        if (node == null) {
            return;
        }
        // print 4*depth spaces
        for ( int k=0; k < depth; k++) {
            System.out.print("    ");
        }
        // print the node frequency and its label
        System.out.print (node.frequency);
        System.out.println ( " (" + node.label + ")");
        // recursively print the children of the node
        printRecursively(node.left, depth+1);
        printRecursively(node.right, depth+1);
    }

}

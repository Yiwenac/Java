// Julia Boettcher, 2015; updated 2016
// Updated 2018 Konrad Swanepoel
//
// This is an implementation of a min-heap (with an underlying array)
// storing int values, supporting the operations insert and extractMin,
// which run in time log(n).  A min-heap is a linked data structure in the
// form of a complete binary tree. What is special is that the tree will
// always be as balanced as possible, and obeys the rule: for each item the
// value stored in this item is smaller than the values stored in its
// children.
//
// (If you want to base your implementation of HuffmanList on this class
// you can omit the toString() methods in Item and MinHeap and the
// main method.)
//
// java MinHeap x1 x2 x3 ....
// interprets the integer command line arguments as follows:
// 0: print  >0:  insert  <0:  extractMin 

public class MinHeap {

    private Item root; // the root of the min-heap binary tree
    private Item[] itemArray; // the items in this data structure are
                              // stored in a binary tree as well as in an
                              // (underlying) array (this makes it easy to
                              // find the last leaf or the last but one
                              // leaf in the tree, which is needed below)
    private int lastItemIndex; // the index of the last active item in the array

    private class Item {
        int value;
        boolean active=false; // items in this data structure can
                              // be inactive (we chose here to
                              // never delete items again)
        Item left, right, parent; // a min-heap is a (full) binary tree

        // check if the item has no active left child
        boolean noLeft() {
            return (left==null) || (!left.active);
        }
        
        // check if the item has no active right child
        boolean noRight() {
            return (right==null) || (!right.active);
        }

        // a string representation of an item (for test purposes only)
        public String toString() {
            if (!active) {
                return "off";
            }
            String s = value + ", left: ";
            if ( noLeft() ) {
                s += "off";
            } else {
                s += left.value;
            }
            s += ", right: ";
            if ( noRight() ) {
                s += "off";
            } else {
                s += right.value;
            }
            return s;
        }

    }

    // overwrites the default constructor
    // constructs an (empty) min-heap with one inactive node
    public MinHeap() {
        itemArray = new Item[1];
        itemArray[0] = new Item();
        root = itemArray[0];
        lastItemIndex = -1;
    }

    // returns true if the min-heap is empty or contains only one item, and
    // false otherwise
    public boolean containsAtMostOneItem() {
        return (lastItemIndex<1);
    }

    // inserts a value x into the heap
    public void insert(int x) {
        // when the last level of the binary tree is full; add an (entire)
        // new level and correspondingly increase the size of the underlying array
        if (lastItemIndex==itemArray.length-1) {
            // adding a new level (roughly) doubles the number of items in
            // the tree, so we need to (roughly) double the size of the
            // underlying array (hence, in total, copying the array entries
            // only takes time O(n))
            Item[] newArray= new Item[2*itemArray.length+1];
            for (int i=0; i<newArray.length; i++) {
                if (i<itemArray.length) {
                    // copy the old entries to the new array
                    newArray[i] = itemArray[i];
                } else {
                    // create new items and add pointer structure for the
                    // new level
                    newArray[i]=new Item();
                    Item parent = newArray[(i-1)/2];
                    newArray[i].parent=parent;
                    if (i%2==0) {
                        parent.right = newArray[i];
                    } else {
                        parent.left = newArray[i];
                    }
                }
            }
            itemArray = newArray;
        }
        lastItemIndex++;
        // now the item in the tree to be newly occupied is already created
        // (but inactive) and can be found at itemArray[lastItemIndex]
        itemArray[lastItemIndex].active=true;
        Item p = itemArray[lastItemIndex];
        // compare x to the value stored in p's parent (and
        // so on) and float up the tree
        while (p!=null) {
            if (p.parent==null || p.parent.value<=x) { // reached right position
                p.value=x;
                break;
            }
            p.value=p.parent.value;
            p=p.parent;
        }
    }

    // returns the node stored in the heap with minimum value (which is
    // at the root) and deletes the corresponding item from the heap;
    // returns -1 if the heap is empty
    public int extractMin() {
        if (!root.active) {
            return -1;
        }
        int x=root.value;
        Item last = itemArray[lastItemIndex];
        // we do not decrease the size of the array, only update
        // lastItemIndex
        lastItemIndex--;
        // inactivate last leaf (we don't delete items) 
        last.active=false;
        // if heap gets empty
        if(lastItemIndex==-1) { 
            return x;
        }
        // compare value of this last leaf to root and float down
        Item p=root;
        while (p!=null) {
            // correct position found
            if ( (p.noLeft() && p.noRight()) ||
                 (p.noLeft() && p.right.value>=p.value) ||
                 (p.noRight() && p.left.value>=p.value) ||
                 (p.left.value>=last.value && p.right.value>=last.value)
            ) { 
                p.value=last.value;
                break;
            }
            // otherwise
            if (p.noLeft()) { // in this case we know the right child has smaller value
                p.value=p.right.value;
                p=p.right;
            } else if (p.noRight()) { // in this case we know the left child has smaller value
                p.value=p.left.value;
                p=p.left;
            } else { // left child or right child has smaller value
                if (p.left.value<p.right.value) {
                    p.value=p.left.value;
                    p=p.left;
                } else {
                    p.value=p.right.value;
                    p=p.right;
                }
            }
        }
        return x;
    }

    // recursively form a string representing the
    // subtree with root p (at given depth) 
    // (for test purposes only)
    public String toString(Item p, int depth) { 
        if (p == null || !p.active) {
            return "";
        }
        String s = "";
        for ( int k=0; k < depth; k++) {
            s += "   ";
        }
        s += p + "\n";  // \n prints a new line
        s += toString(p.left,depth+1);
        s += toString(p.right,depth+1);
        return s;
    }

    // a string representation of the binary tree
    // (for test purposes only)
    public String toString() {
        return toString(root,0);
    }

    // test the data structure
    public static void main (String[] args) {
        if (args.length<=0) return;
        MinHeap heap = new MinHeap();
        int x;
        for (int i=0; i < args.length; i++) {
            x = Integer.parseInt(args[i]);
            if (x == 0) {     // print
                System.out.println(heap);
            } else if (x>0) { // insert
                heap.insert(x);
            } else {            // extractMin
                x = heap.extractMin();
                System.out.println( "extracted " + x);
            }
        }
    }

}

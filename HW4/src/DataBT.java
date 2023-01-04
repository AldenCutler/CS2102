import java.util.LinkedList;

class DataBT implements IBinTree {
    int data;
    IBinTree left;
    IBinTree right;
    DataBT(int data, IBinTree left, IBinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // an alternate constructor for when both subtrees are empty
    DataBT(int data) {
        this.data = data;
        this.left = new MtBT();
        this.right = new MtBT();
    }
    // determines whether this node or node in subtree has given element
    public boolean hasElt(int e) {
        return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
    }
    // adds 1 to the number of nodes in the left and right subtrees
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }
    // adds 1 to the height of the taller subtree
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }

    /**
     *
     * @return true if the object satisfies the definition of a heap
     */
    public boolean isHeap() {
        return this.isSmallest(this.data) && this.left.isHeap() && this.right.isHeap();
    }

    /**
     *
     * @param elt represents an element in a tree
     * @return the number of times that element appears in the tree
     */
    public int countNumElt (int elt) {
        if(elt == this.data) {
            return 1 + this.right.countNumElt(elt) + this.left.countNumElt(elt);
        } else return this.right.countNumElt(elt) + this.left.countNumElt(elt);
    }

    @Override
    public boolean remMinEltValidator(IHeap hOrig, IBinTree hRemoved) {
        return false;
    }

    public boolean isSmallest(int data) {
        return data <= this.data && this.left.isSmallest(data) && this.right.isSmallest(data);
    }

    /**
     *
     * @return a list containing all of the elements in the tree
     */
    public LinkedList<Integer> listOfElt () {
        LinkedList<Integer> eltList = new LinkedList<>();
        eltList.add(this.data);
        if (this.right != null) {
            for (int i = 0; i < this.right.size(); i++) {
                eltList.add(this.right.listOfElt().get(i));
            }
        }
        if (this.left != null) {
            for (int i = 0; i < this.left.size(); i++) {
                eltList.add(this.left.listOfElt().get(i));
            }
        } return eltList;
    }

}
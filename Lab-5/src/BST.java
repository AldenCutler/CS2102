public class BST implements ISet {
    String name;
    ISet right;
    ISet left;

    BST(String name, ISet right, ISet left) { // Constructor
        this.name = name;
        this.right = right;
        this.left = left;
    }


    /**
     *
     * @param elt represents the element to be added to the BST
     * @return the same BST except the element has been added to its correct place in the tree
     */
    public BST addElt (String elt) {
        if (elt.equals(this.name)) { // No duplicate elements
            return this;
        } else if (elt.compareTo(this.name) < 0) {
            return new BST(this.name, this.right, this.left.addElt(elt));
        } else return new BST (this.name, this.right.addElt(elt), this.left); // else if (elt.compareTo(this.name) > 0)
    }

    /**
     *
     * @param elt represents the element that is being checked if it's in the tree
     * @return true if the given element is present in the tree, false otherwise
     */
    public boolean hasElt (String elt) {
        return elt.equals(this.name) || this.right.hasElt(elt) || this.left.hasElt(elt);
    }

    /**
     *
     * @return the total number of nodes in the tree
     */
    public int size() {
        return 1 + this.right.size() + this.left.size();
    }


}

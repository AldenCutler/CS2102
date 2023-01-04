public class EmptyBST implements ISet {
    EmptyBST() {}

    /**
     *
     * @param elt represents the element to be added to the tree
     * @return a new BST with the given element as the only node
     */
    public BST addElt (String elt) {
        return new BST(elt, new EmptyBST(), new EmptyBST());
    }

    /**
     *
     * @param elt represents the element being checked if it's present
     * @return false since an empty BST has no elements
     */
    public boolean hasElt (String elt) {
        return false;
    }

    /**
     *
     * @return 0 since there are no elements in an empty BST
     */
    public int size () {
        return 0;
    }




}


import java.util.LinkedList;

class MtBT implements IBinTree {
    MtBT(){}
    // returns false since empty tree has no elements
    public boolean hasElt(int e) {
        return false;
    }
    // returns 0 since empty tree has no elements
    public int size() {
        return 0;
    }
    // returns 0 since empty tree has no branches
    public int height() {
        return 0;
    }
    public boolean isSmallest(int data) {
        return true;
    }

    @Override
    public boolean remMinEltValidator(IHeap hOrig, IBinTree hRemoved) {
        return false;
    }

    public boolean isHeap() {
        return true;
    }

    @Override
    public LinkedList<Integer> listOfElt() {
        return null;
    }

    @Override
    public int countNumElt(int elt) {
        return 0;
    }
}
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.*;

public class Examples {
    HeapChecker HT = new HeapChecker();

    IHeap four = new DataHeap(4, new DataHeap(5), new DataHeap(6));
    IHeap ten = new DataHeap(10);
    IHeap eleven = new DataHeap(11);
    IHeap eight = new DataHeap(8, ten, eleven);
    IHeap heap = new DataHeap(3, eight, four);

    IHeap badHeap = new DataHeap(10, new DataHeap(8), new DataHeap(4)); // invalid because largest element is on top
    IHeap badHeap2 = new DataHeap(2,new DataHeap(2), new DataHeap(4)); // invalid because two of same element

    IHeap fourRemoved = new DataHeap(5, new MtHeap(), new DataHeap(6));
    IHeap heapRemoved = new DataHeap(4, eight, fourRemoved);

    public Examples() {
    }

    @Test
    public void testHeap() { // Test the isHeap() method with a valid heap
        assertTrue(heap.isHeap());
    }

    @Test
    public void testHeap2() { // Test the isHeap() method with an invalid heap
        assertFalse(badHeap.isHeap());
    }

    @Test
    public void testListOfElt(){
        LinkedList<Integer> eltList = new LinkedList<>();
        eltList.add(3);
        eltList.add(4);
        eltList.add(6);
        eltList.add(5);
        eltList.add(8);
        eltList.add(11);
        eltList.add(10);
        assertEquals(eltList, heap.listOfElt());
    }

    @Test
    public void testAddEltValidator1(){ // Test the addEltValidator() method base case
        assertTrue(HT.addEltValidator(heap, 2 , heap.addElt(2)));
    }

    @Test
    public void testAddEltValidator2(){ // Test the addEltValidator() method with an invalid input
        assertFalse(HT.addEltValidator(heap, 4, badHeap.addElt(2)));
    }

    @Test
    public void testAddEltValidator3() { // Test the addEltValidator() method returning a bad heap
        assertFalse(HT.addEltValidator(heap, 10, badHeap.addElt(10)));
    }

    @Test
    public void testAddEltValidator4() { // Test the addEltValidator() method on a bad heap
        assertFalse(HT.addEltValidator(badHeap2, 4, badHeap2.addElt(3)));
    }

    @Test
    public void testRemMinEltValidator1() { // Test the remMinEltValidator() method base case
        assertTrue(HT.remMinEltValidator(heap, heapRemoved));
    }

    @Test
    public void testRemMinEltValidator2() {  // Test the remMinEltValidator() method on a bad heap
        assertFalse(HT.remMinEltValidator(badHeap, heapRemoved));
    }

    @Test
    public void testRemMinEltValidator3() { // Test the remMinEltValidator() method returning a bad heap
        assertFalse(HT.remMinEltValidator(heap, badHeap));
    }
}
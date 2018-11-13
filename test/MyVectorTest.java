import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyVectorTest {
    //constant vectors for testing purpose
    private final double[] ORIGDOUBLEARRAY = new double[]{-1.1, 0.0, 1.0, 2.3, 3.0};
    private final MyVector DOUBLEV = new MyVector(ORIGDOUBLEARRAY);
    private final int[] ORIGINTARRAY = new int[]{3, 2, 1, 0, -1};
    private final MyVector INTV = new MyVector(ORIGINTARRAY);
    private final MyVector EMPTYVECTOR = new MyVector();
//inorder to let the test runnable need to implement the get value  and get size function inorder to test field by field
//then implement the equal function and then assert equals function will be able to run to compare two myVector objects

    @Test //test get value
    public void getValue() {
        assertEquals(2.0, DOUBLEV.getValue(3).doubleValue, "test getValue from double vector");
        assertEquals(3.0, DOUBLEV.getValue(4).doubleValue);
        assertEquals(null, DOUBLEV.getValue(5).doubleValue, "test getValue from an index out of bound");
        assertEquals(null, DOUBLEV.getValue(3).doubleValue, "test getValue from empty vector");
        assertEquals(5, INTV.getValue(3).intValue, "test getValue from int vector");
        assertEquals(7, INTV.getValue(4).intValue);
    }

    @Test //test getlength
    public void testGetLength() {
        assertEquals("5", DOUBLEV.getLength(),"length should be 5");
        assertEquals("5", DOUBLEV.getLength(),"length should be 5");
        assertEquals(0,EMPTYVECTOR.getLength(),"empty vector return 0 length");
    }

    @Test //test equal
    public void testEqual() {
        //todo this is not complete need to compare each elements and the length
        MyVector vD1 = new MyVector(ORIGDOUBLEARRAY);
        MyVector vD2 = new MyVector(ORIGDOUBLEARRAY);
        double[] doubleArray = new double[]{3.0, 2.3, 1.0, 0.0, -1.1};
        MyVector diffVD3 = new MyVector(doubleArray);
        assertEquals(true, vD1.equal(vD2));
        assertEquals(false, vD1.equal(diffVD3));

        MyVector vI1 = new MyVector(ORIGINTARRAY);
        MyVector vI2 = new MyVector(ORIGINTARRAY);
        assertEquals(true, vI1.equal(vI2));
    }

    @Test //test append double[]
    public void testAppendDdouble() {
        MyVector vectorD = new MyVector(ORIGDOUBLEARRAY);
        //create a new double array which is a concatenation of two original double array
        double[] concatD = DoubleStream.concat(Arrays.stream(ORIGDOUBLEARRAY), Arrays.stream(ORIGDOUBLEARRAY)).toArray();
        MyVector expectVectorD = new MyVector(concatD);
        assertEquals(true , vectorD.append(ORIGDOUBLEARRAY).equal(expectVectorD));
    }

    @Test //test append int[]
    public void testAppendInt() {
        MyVector vector = new MyVector(ORIGINTARRAY);
        int[] concatD = IntStream.concat(Arrays.stream(ORIGINTARRAY), Arrays.stream(ORIGINTARRAY)).toArray();
        MyVector expectVectorD = new MyVector(concatD);
        //assertEquals("", vector.append());
    }

    @Test //test Clone
    public void testClone() {
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("", vector);
    }



    @Test //test add vector
    public void testAdd() {
        MyVector vector = new MyVector(ORIGDOUBLEARRAY);
        System.out.println("");
        assertEquals("", vector);
    }

    @Test //test add double
    public void testAddDouble() {
        double two = 2.0;
        double[] expect = new double[]{0.9, 2, 3, 4.3, 5};
        MyVector vectorD = new MyVector(ORIGDOUBLEARRAY);
        MyVector result = vectorD.add(two);
        MyVector expectV = new MyVector(expect);
        assertEquals(expectV, result);
    }

    @Test //test sub vector
    public void testSub() {
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("", vector);
    }

    @Test //test add double
    public void testSubDouble() {
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("", vector);
    }

    @Test //test mult vector
    public void testMult() {
        MyVector vectorD1 = new MyVector(ORIGDOUBLEARRAY);
        MyVector vectorD2 = new MyVector(ORIGDOUBLEARRAY);
        Double[] tempDouble = new Double[]{3.0, 2.3, 1.0, 0.0, -1.1};
        assertEquals("", vectorD1);
    }

    @Test //test mult double
    public void testMultDouble() {
        MyVector vector = new MyVector(ORIGDOUBLEARRAY);
        System.out.println("");
        assertEquals("", vector.mult(2));
    }

    @Test //test normalize
    public void testNormalize() {
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("", vector);
    }

    @Test //test euclidean  distance
    public void testEuclideanDistance() {
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("", vector);
    }
}
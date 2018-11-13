import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyVectorTest {
    private final double[] ORIGDARRAY = new double[]{-1.1, 0.0, 1.0, 2.3, 3.0};
    private final int[] ORIGIARRAY = new int[]{3, 2, 1, 0, -1};

    @Test //test initialize vector
    public void initVector() {
        MyVector doubleVector = new MyVector(ORIGDARRAY);
        assertEquals(0, doubleVector);
        MyVector intVector = new MyVector(ORIGIARRAY);
        MyVector emptyVector = new MyVector();
    }

    @Test //test get value
    public void getValue() {
        MyVector doubleVector = new MyVector(ORIGDARRAY);
        MyVector emptyVector = new MyVector();
        assertEquals(2.0, (double) doubleVector.getValue(3), "test getValue from double vector");
        assertEquals(3.0, (double) doubleVector.getValue(4));
        assertEquals(null, (double) doubleVector.getValue(5), "test getValue from an index out of bound");
        assertEquals(null, (double) doubleVector.getValue(3), "test getValue from empty vector");
        MyVector intVector = new MyVector(ORIGIARRAY);
        assertEquals(5, (int) intVector.getValue(3), "test getValue from int vector");
        assertEquals(7, (int) intVector.getValue(4));
    }

    @Test //test equal
    public void testEqual() {
        //todo this is not complete how to assert equal of two new objects
        MyVector vD1 = new MyVector(ORIGDARRAY);
        MyVector vD2 = new MyVector(ORIGDARRAY);
        double[] doubleArray = new double[]{3.0, 2.3, 1.0, 0.0, -1.1};
        MyVector diffVD3 = new MyVector(doubleArray);
        assertEquals(true, vD1.equal(vD2));
        assertEquals(false, vD1.equal(diffVD3));

        MyVector vI1 = new MyVector(ORIGIARRAY);
        MyVector vI2 = new MyVector(ORIGIARRAY);
        assertEquals(true, vI1.equal(vI2));
    }

    @Test //test append double[]
    public void testAppendDdouble() {
        MyVector vectorD = new MyVector(ORIGDARRAY);
        //create a new double array which is a concatenation of two original double array
        double[] concatD = DoubleStream.concat(Arrays.stream(ORIGDARRAY), Arrays.stream(ORIGDARRAY)).toArray();
        MyVector expectVectorD = new MyVector(concatD);
        assertEquals(expectVectorD, vectorD.append(ORIGDARRAY));
    }

    @Test //test append int[]
    public void testAppendInt() {
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("", vector);
    }

    @Test //test Clone
    public void testClone() {
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("", vector);
    }


    @Test //test getlength
    public void testGetLength() {
        MyVector vector = new MyVector(ORIGDARRAY);
        System.out.println("testGetLength");
        int length = vector.getLength();
        assertEquals("4", length);
    }

    @Test //test add vector
    public void testAdd() {
        MyVector vector = new MyVector(ORIGDARRAY);
        System.out.println("");
        assertEquals("", vector);
    }

    @Test //test add double
    public void testAddDouble() {
        double two = 2.0;
        double[] expect = new double[]{0.9, 2, 3, 4.3, 5};
        MyVector vectorD = new MyVector(ORIGDARRAY);
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
        MyVector vectorD1 = new MyVector(ORIGDARRAY);
        MyVector vectorD2 = new MyVector(ORIGDARRAY);
        Double[] tempDouble = new Double[]{3.0, 2.3, 1.0, 0.0, -1.1};
        assertEquals("", vectorD1);
    }

    @Test //test mult double
    public void testMultDouble() {
        MyVector vector = new MyVector(ORIGDARRAY);
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
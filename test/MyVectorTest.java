import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyVectorTest {
    //constant vectors for testing purpose
    private final double[] ORIGDOUBLEARRAY = new double[]{-1.1, 0.0, 1.0, 2.3, 3.0};
    private final int[] ORIGINTARRAY = new int[]{3, 2, 1, 0, -1};
    private final MyVector DOUBLEV = new MyVector(ORIGDOUBLEARRAY);
    private final MyVector INTV = new MyVector(ORIGINTARRAY);
    private final MyVector EMPTYVECTOR = new MyVector();
//inorder to let the test runnable need to implement the get value  and get size function inorder to test field by field
//then implement the equal function and then assert equals function will be able to run to compare two myVector objects

    @Test //test get value
    public void getValue() {
        assertEquals(1.0, DOUBLEV.getValue(3).doubleValue, "test getValue from double vector");
        assertEquals(2.3, DOUBLEV.getValue(4).doubleValue);
        assertEquals(null, DOUBLEV.getValue(6).doubleValue, "test getValue from an index out of bound");
        assertEquals(null, EMPTYVECTOR.getValue(3).doubleValue, "test getValue from empty vector");
        assertEquals(1, INTV.getValue(3).intValue, "test getValue from int vector");
        assertEquals(0, INTV.getValue(4).intValue);
    }

    @Test //test getlength
    public void testGetLength() {
        assertEquals("5", DOUBLEV.getLength(), "length should be 5");
        assertEquals("5", INTV.getLength(), "length should be 5");
        assertEquals(0, EMPTYVECTOR.getLength(), "empty vector return 0 length");
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
        int[] intArray = new int[]{1, 2, 3, 4};
        MyVector vI3 = new MyVector(intArray);
        assertEquals(true, vI1.equal(vI2));
        assertEquals(false, vI1.equal(vI3));
    }

    @Test //test append double[]
    public void testAppendDouble() {
        MyVector initDoubleVector = new MyVector(ORIGDOUBLEARRAY);
        double[] emptyD = new double[0];
        //create a new double array which is a concatenation of two original double array
        double[] concatD = DoubleStream.concat(Arrays.stream(ORIGDOUBLEARRAY), Arrays.stream(ORIGDOUBLEARRAY)).toArray();
        MyVector expectVectorD = new MyVector(concatD);
        MyVector actualDoubleVector = initDoubleVector.append(ORIGDOUBLEARRAY);//vector after append double array
        assertTrue(actualDoubleVector.equal(expectVectorD), "append double array test");
        assertTrue(initDoubleVector.append(emptyD).equal(initDoubleVector), "double vector append empty vector should remain same");
    }

    @Test //test append int[]
    public void testAppendInt() {
        MyVector initIntVector = new MyVector(ORIGINTARRAY);
        int[] emptyI = new int[0];
        int[] concatI = IntStream.concat(Arrays.stream(ORIGINTARRAY), Arrays.stream(ORIGINTARRAY)).toArray();
        MyVector expectIntVector = new MyVector(concatI);
        MyVector actualIntVector = initIntVector.append(ORIGINTARRAY);//vector after append int array
        assertTrue(actualIntVector.equal(expectIntVector), "append int array test");
        assertTrue(initIntVector.append(emptyI).equal(initIntVector), "int vector append empty vector should remain same");
    }

    @Test //test Clone
    public void testClone() {
        MyVector actualEmpty = EMPTYVECTOR.clone();
        MyVector actualIntClone = INTV.clone();
        MyVector actualDoubleClone = DOUBLEV.clone();
        assertTrue(actualDoubleClone.equal(DOUBLEV), "test double clone");
        assertTrue(actualIntClone.equal(INTV), "test int clone");
        assertTrue(actualEmpty.equal(EMPTYVECTOR), "test empty vector clone");
    }


    @Test //test add vector
    public void testAdd() {
        //{-1.1, 0.0, 1.0, 2.3, 3.0} add {-1.1, 0.0, 1.0, 2.3, 3.0}
        MyVector actaulDoubleVector = DOUBLEV.add(DOUBLEV);
        MyVector expectDoubleVector = new MyVector(new double[]{-2.2, 0.0, 2.0, 4.6, 6.0});
        assertTrue(actaulDoubleVector.equal(expectDoubleVector), "test double add double vector");

        //{3, 2, 1, 0, -1} add {3, 2, 1, 0, -1}
        MyVector actualIntVector = INTV.add(INTV);
        MyVector expectIntVector = new MyVector(new int[]{5, 4, 2, 0, -2});
        assertTrue(actualIntVector.equal(expectIntVector), "test int add int vector");

        //{3, 2, 1, 0, -1} add {-1.1, 0.0, 1.0, 2.3, 3.0}
        MyVector actualIntDoubleVector = INTV.add(DOUBLEV);
        MyVector expectIntDoubleVecotr = new MyVector(new double[]{1.9, 2, 2, 2.3, 2});
        assertTrue(actualIntDoubleVector.equal(expectIntDoubleVecotr), "test int add double vector");
        //test vector add empty vector
        assertTrue(INTV.equal(INTV.add(EMPTYVECTOR)),"test empty add empty");
    }

    @Test //test add double
    public void testAddDouble() {
        double two = 2.0;
        double onePointTwo = 1.2;
        MyVector actualDoubleVector = DOUBLEV.add(two);
        //{-1.1, 0.0, 1.0, 2.3, 3.0} original add 2
        double[] expectD = new double[]{0.9, 2.0, 3.0, 4.3, 5.0};
        MyVector expectDResult = new MyVector(expectD);
        assertTrue(actualDoubleVector.equal(expectDResult), "test double vector add double");

        MyVector actualIntVector = INTV.add(onePointTwo);
        //{3, 2, 1, 0, -1} original add 1.2
        double[] expectI = new double[]{4.2, 3.2, 2.2, 1.2, 0.2};
        MyVector expectIntResult = new MyVector(expectI);
        assertTrue(actualIntVector.equal(expectIntResult), "test int vector add double");

        int three = 3 ;
        MyVector actualIntVectorInt = INTV.add(three);
        //{3, 2, 1, 0, -1} original add 3
        double[] expectII = new double[]{6, 5, 4, 3, 2};
        MyVector expectIntResultInt = new MyVector(expectII);
        assertTrue(actualIntVectorInt.equal(expectIntResultInt), "test int vector add int");

        MyVector expectEmpty = EMPTYVECTOR.add(two);
        assertTrue(EMPTYVECTOR.equal(expectEmpty), "test empty vector add double");

        }


    @Test //test sub vector
    public void testSub() {
        //{-1.1, 0.0, 1.0, 2.3, 3.0} Sub {-1.1, 0.0, 1.0, 2.3, 3.0}
        MyVector actaulDoubleVector = DOUBLEV.sub(DOUBLEV);
        MyVector expectDoubleVector = new MyVector(new double[]{0.0, 0.0, 0.0, 0.0, 0.0});
        assertTrue(actaulDoubleVector.equal(expectDoubleVector), "test double sub double vector");

        //{3, 2, 1, 0, -1} add {3, 2, 1, 0, -1}
        MyVector actualIntVector = INTV.sub(INTV);
        MyVector expectIntVector = new MyVector(new int[]{0,0,0,0,0});
        assertTrue(actualIntVector.equal(expectIntVector), "test int sub int vector");

        //{3, 2, 1, 0, -1} add {-1.1, 0.0, 1.0, 2.3, 3.0}
        MyVector actualIntDoubleVector = INTV.sub(DOUBLEV);
        MyVector expectIntDoubleVector = new MyVector(new double[]{4.1, 2.0,0.0,-2.3,-4.0});
        assertTrue(actualIntDoubleVector.equal(expectIntDoubleVector), "test int sub double vector");
        //test vector add empty vector
        assertTrue(INTV.equal(INTV.sub(EMPTYVECTOR)),"test int vector sub empty vector");
        assertTrue(EMPTYVECTOR.equal(EMPTYVECTOR.sub(EMPTYVECTOR)),"test empty sub empty vector");
    }

    @Test //test add double
    public void testSubVector() {
        //{-1.1, 0.0, 1.0, 2.3, 3.0}
        MyVector actualDoubleVector = DOUBLEV.subV(1,3);
        MyVector expectDoubleVector = new MyVector(new double[]{0.0,1.0,2.3});
        assertTrue(DOUBLEV.subV(3,1).equal(expectDoubleVector), "test subV double vector from 3 to 1");
        assertTrue(actualDoubleVector.equal(expectDoubleVector), "test subV double vector from 1 to 3");

        //{3, 2, 1, 0, -1}
        MyVector actualIntVector = INTV.subV(1,3);
        MyVector expectIntVector = new MyVector(new int[]{2,1,0});
        assertTrue(actualIntVector.equal(expectIntVector), "test subV int vector");
        assertEquals(null,INTV.subV(-1,1), "test get sub from impossible index");
        assertEquals(null,DOUBLEV.subV(3,5),"test subV out of bound");
        MyVector expectIntVector1 = new MyVector(new int[]{2});
        assertTrue(expectIntVector1.equal(INTV.subV(1,1)),"get subV from 1 to 1 which is 1");
    }

    @Test //test mult vector
    public void testMult() {
        //{-1.1, 0.0, 1.0, 2.3, 3.0}
        MyVector actaulVectorD = new MyVector(ORIGDOUBLEARRAY);
        MyVector expectVectorD = new MyVector( new double[]{1.21,0.0,1.0,5.29,9});
        assertTrue(actaulVectorD.equal(expectVectorD));
        //{3, 2, 1, 0, -1}
        MyVector actaulVectorI = new MyVector(ORIGDOUBLEARRAY);
        MyVector expectVectorI = new MyVector( new double[]{1.21,0.0,1.0,5.29,9});
        assertTrue(actaulVectorI.equal(expectVectorI));

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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.Verifier
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class MyVectorTest {
    //constant vectors for testing purpose
    //todo operation between different size vector should return what
    private final double[] ORIGINALDOUBLEARRAY = new double[]{-1.1, 0.0, 1.0, 2.3, 3.0};
    private final int[] ORIGINALINTARRAY = new int[]{3, 2, 1, 0, -1};
    private final MyVector DOUBLEV = new MyVector(ORIGINALDOUBLEARRAY);
    private final MyVector INTV = new MyVector(ORIGINALINTARRAY);
    private final MyVector EMPTYVECTOR = new MyVector();

    @BeforeAll
    public static void setUp() {
        MyVector expectIntVector = new MyVector(new int[]{5, 4, 2, 0, -2});
        MyVector expectIntDoubleVector = new MyVector(new double[]{1.9, 2, 2, 2.3, 2});
    }

    @Test //test get value
    public void getValue() {
        assertEquals(2.3, DOUBLEV.getValue(3), "test getValue from double vector");
        assertEquals(0, INTV.getValue(3), "test getValue from int vector");
        assertEquals(-1, INTV.getValue(4));

        try {
            DOUBLEV.getValue(6);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("This index is out of range", ex.getMessage());
        }
    }

    @Test //test getLength
    public void testGetLength() {
        assertEquals(5, DOUBLEV.getLength(), "length should be 5");
        assertEquals(5, INTV.getLength(), "length should be 5");
        assertEquals(0, EMPTYVECTOR.getLength(), "empty vector return 0 length");
    }

    @Test//test equal
    public void testEqual() {
        //todo this is not complete need to compare each elements and the length
        MyVector vD1 = new MyVector(ORIGINALDOUBLEARRAY);
        MyVector vD2 = new MyVector(ORIGINALDOUBLEARRAY);
        double[] doubleArray = new double[]{3.0, 2.3, 1.0, 0.0, -1.1};
        MyVector diffVD3 = new MyVector(doubleArray);
        assertEquals(true, vD1.equal(vD2));
        assertEquals(false, vD1.equal(diffVD3));
        MyVector vI1 = new MyVector(ORIGINALINTARRAY);
        MyVector vI2 = new MyVector(ORIGINALINTARRAY);
        int[] intArray = new int[]{1, 2, 3, 4};
        MyVector vI3 = new MyVector(intArray);
        assertEquals(true, vI1.equal(vI2));
        assertEquals(false, vI1.equal(vI3));
    }

    @Test// append vector
    public void testAppendVector() {
        MyVector actualNormalAppend = DOUBLEV.append(INTV);
        double[] tempDouble = new double[ORIGINALINTARRAY.length];
        for (int i = 0; i < tempDouble.length; i++) tempDouble[i] = ORIGINALINTARRAY[i];
        double[] newDoubleArray = DoubleStream.concat(Arrays.stream(ORIGINALDOUBLEARRAY), Arrays.stream(tempDouble)).toArray();
        MyVector expectNormalAppend = new MyVector(newDoubleArray);
        assertTrue(actualNormalAppend.equal(expectNormalAppend), "test normal append of two vectors");
        assertTrue(DOUBLEV.equal(DOUBLEV.append(EMPTYVECTOR)), "test vector append empty vector");
    }

    @Test // append aDoubles
    public void testAppendADouble() {
        MyVector actualNormalAppend = DOUBLEV.append(2.0);
        MyVector expectNormalAppend = new MyVector(new double[]{-1.1, 0.0, 1.0, 2.3, 3.0, 2.0});
        assertTrue(actualNormalAppend.equal(expectNormalAppend), "test vector append a double");
        MyVector actualEmptyAppend = EMPTYVECTOR.append(2.0);
        MyVector expectEmptyAppend = new MyVector(new double[]{2.0});
        assertTrue(actualEmptyAppend.equal(expectEmptyAppend), "test empty vector append");
    }

    @Test //test append double[]
    public void testAppendDouble() {
        MyVector initDoubleVector = new MyVector(ORIGINALDOUBLEARRAY);
        double[] emptyD = new double[0];
        //create a new double array which is a concatenation of two original double array
        double[] concatD = DoubleStream.concat(Arrays.stream(ORIGINALDOUBLEARRAY), Arrays.stream(ORIGINALDOUBLEARRAY)).toArray();
        MyVector expectVectorD = new MyVector(concatD);
        MyVector actualDoubleVector = initDoubleVector.append(ORIGINALDOUBLEARRAY);//vector after append double array
        assertTrue(actualDoubleVector.equal(expectVectorD), "append double array test");
        assertTrue(initDoubleVector.append(emptyD).equal(initDoubleVector), "double vector append empty vector should remain same");
    }

    @Test //test append int[]
    public void testAppendInt() {
        MyVector initIntVector = new MyVector(ORIGINALINTARRAY);
        int[] emptyI = new int[0];
        int[] concatI = IntStream.concat(Arrays.stream(ORIGINALINTARRAY), Arrays.stream(ORIGINALINTARRAY)).toArray();
        MyVector expectIntVector = new MyVector(concatI);
        MyVector actualIntVector = initIntVector.append(ORIGINALINTARRAY);//vector after append int array
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
        MyVector actualDoubleVector = DOUBLEV.add(DOUBLEV);
        MyVector expectDoubleVector = new MyVector(new double[]{-2.2, 0.0, 2.0, 4.6, 6.0});
        assertTrue(actualDoubleVector.equal(expectDoubleVector), "test double add double vector");
        MyVector differentSizeVector = new MyVector(new double[]{-2.2, 0.0, 2.0, 4.6});

        try {
            MyVector failedVector = DOUBLEV.add(differentSizeVector);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("the length is not equal", ex.getMessage());
        }

        try {        //test vector add empty vector
            INTV.add(EMPTYVECTOR);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("the length is not equal", ex.getMessage());
        }


        //{3, 2, 1, 0, -1} add {3, 2, 1, 0, -1}
        MyVector actualIntVector = INTV.add(INTV);
        MyVector expectIntVector = new MyVector(new int[]{6, 4, 2, 0, -2});
        assertTrue(actualIntVector.equal(expectIntVector), "test int add int vector");

        //{3, 2, 1, 0, -1} add {-1.1, 0.0, 1.0, 2.3, 3.0}
        MyVector actualIntDoubleVector = INTV.add(DOUBLEV);
        MyVector expectIntDoubleVector = new MyVector(new double[]{1.9, 2, 2, 2.3, 2});
        assertTrue(actualIntDoubleVector.equal(expectIntDoubleVector), "test int add double vector");
    }

    @Test //test add double
    public void testAddDouble() {
        double two = 2.0;
        int three = 3;
        double onePointTwo = 1.2;

        MyVector actualDoubleVector = DOUBLEV.add(two);
        //{-1.1, 0.0, 1.0, 2.3, 3.0} original add 2
        double firstElement = actualDoubleVector.getValue(0);
        MyVector expectDResult = new MyVector(new double[]{0.9, 2, 3, 4.3, 5});

        double num0 = actualDoubleVector.getValue(0);
        assertTrue(actualDoubleVector.equal(expectDResult), "test double vector add double");
        MyVector actualIntVector = INTV.add(onePointTwo);
        //{3, 2, 1, 0, -1} original add 1.2
        double[] expectI = new double[]{4.2, 3.2, 2.2, 1.2, 0.2};
        MyVector expectIntResult = new MyVector(expectI);
        assertTrue(actualIntVector.equal(expectIntResult), "test int vector add double");

        MyVector actualIntVectorInt = INTV.add(three);
        //{3, 2, 1, 0, -1} original add 3
        double[] expectII = new double[]{6, 5, 4, 3, 2};
        MyVector expectIntResultInt = new MyVector(expectII);
        assertTrue(actualIntVectorInt.equal(expectIntResultInt), "test int vector add int");
        MyVector expectEmpty = EMPTYVECTOR.add(two);
        assertTrue(EMPTYVECTOR.equal(expectEmpty), "test empty vector add double");
        //todo add test for int add int
    }

    @Test //test sub vector
    public void testSub() {
        //{-1.1, 0.0, 1.0, 2.3, 3.0} Sub {-1.1, 0.0, 1.0, 2.3, 3.0}
        MyVector actualDoubleVector = DOUBLEV.sub(DOUBLEV);
        MyVector expectDoubleVector = new MyVector(new double[]{0.0, 0.0, 0.0, 0.0, 0.0});
        assertTrue(actualDoubleVector.equal(expectDoubleVector), "test double sub double vector");
        MyVector differentSizeVector = new MyVector(new double[]{-2.2, 0.0, 2.0, 4.6});

        try {
            DOUBLEV.sub(differentSizeVector);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("Vector lengths are not equal", ex.getMessage());
        }
        //{3, 2, 1, 0, -1} add {3, 2, 1, 0, -1}
        MyVector actualIntVector = INTV.sub(INTV);
        MyVector expectIntVector = new MyVector(new int[]{0, 0, 0, 0, 0});
        assertTrue(actualIntVector.equal(expectIntVector), "test int sub int vector");

        //{3, 2, 1, 0, -1} add {-1.1, 0.0, 1.0, 2.3, 3.0}
        MyVector actualIntDoubleVector = INTV.sub(DOUBLEV);
        MyVector expectIntDoubleVector = new MyVector(new double[]{4.1, 2.0, 0.0, -2.3, -4.0});
        assertTrue(actualIntDoubleVector.equal(expectIntDoubleVector), "test int sub double vector");
    }

    @Test //test subset of vector
    public void testSubVector() {
        //{-1.1, 0.0, 1.0, 2.3, 3.0}
        MyVector actualDoubleVector = DOUBLEV.subV(1, 3);
        MyVector expectDoubleVector = new MyVector(new double[]{0.0, 1.0, 2.3});
        try {
            DOUBLEV.subV(3, 1);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("Vector lengths are not equal", ex.getMessage());
        }

        assertTrue(actualDoubleVector.equal(expectDoubleVector), "test subV double vector from 1 to 3");

        //{3, 2, 1, 0, -1}
        MyVector actualIntVector = INTV.subV(1, 3);
        MyVector expectIntVector = new MyVector(new int[]{2, 1, 0});
        assertTrue(actualIntVector.equal(expectIntVector), "test subV int vector");
        //exception get sub from impossible index

        try {
            MyVector negSubDoubleVector = INTV.subV(-1, 1);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("Vector lengths are not equal", ex.getMessage());
        }

        //exception subV out of bound index
        try {
            DOUBLEV.subV(3, 5);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("Vector lengths are not equal", ex.getMessage());
        }
        MyVector expectIntVector1 = new MyVector(new int[]{2});
        assertTrue(expectIntVector1.equal(INTV.subV(1, 1)), "get subV from 1 to 1 which is 1");
    }

    @Test //test mult vector
    public void testMult() {
        //{-1.1, 0.0, 1.0, 2.3, 3.0}
        MyVector actualVectorD = DOUBLEV.mult(DOUBLEV);
        MyVector expectVectorD = new MyVector(new double[]{1.21, 0.0, 1.0, 5.29, 9});
        assertTrue(actualVectorD.equal(expectVectorD), "test double v mult double v");

        MyVector differentSizeVector = new MyVector(new double[]{-2.2, 0.0, 2.0, 4.6});

        try {
            DOUBLEV.mult(differentSizeVector);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("Vector lengths are not equal", ex.getMessage());
        }

        MyVector localDouble = new MyVector(new double[]{-1.1, 0.0, 1.0, 2.3, 3.0});
        MyVector localInt = new MyVector(new int[]{3, 2, 1, 0, -1});

        MyVector actualVectorDMultI = localDouble.mult(localInt);
        MyVector expectVectorDMultI = new MyVector(new double[]{-3.3, 0, 1, 0, -3.0});
        assertTrue(actualVectorDMultI.equal(expectVectorDMultI), "test double v mult int v");
        try {
            DOUBLEV.mult(EMPTYVECTOR);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("Vector lengths are not equal", ex.getMessage());
        }
        //{3, 2, 1, 0, -1}
        MyVector actualVectorI = INTV.mult(INTV);
        MyVector expectVectorI = new MyVector(new double[]{9, 4, 1, 0, 1});
        assertTrue(actualVectorI.equal(expectVectorI), "test int v mult int v");
    }

    @Test //test mult double
    public void testMultDouble() {
        //{-1.1, 0.0, 1.0, 2.3, 3.0}
        MyVector localDouble = new MyVector(new double[]{-1.1, 0.0, 1.0, 2.3, 3.0});

        MyVector actualVectorD = localDouble.mult(2.1);
        MyVector expectVectorD = new MyVector(new double[]{-2.31, 0.0, 2.1, 4.83, 6.3});
        assertTrue(actualVectorD.equal(expectVectorD), "test double v mult double");
        //{3, 2, 1, 0, -1}
        MyVector actualVectorI = INTV.mult(1);
        MyVector expectVectorI = new MyVector(new double[]{3, 2, 1, 0, -1});
        assertTrue(actualVectorI.equal(expectVectorI), "test int v mult int");
        MyVector actualVectorI1 = INTV.mult(1.1);
        MyVector expectVectorI1 = new MyVector(new double[]{3.3, 2.2, 1.1, 0.0, -1.1});
        assertTrue(actualVectorI1.equal(expectVectorI1), "test int v mult double");
    }

    @Test //test normalize
    public void testNormalize() {
        //todo double vector with sqrt test is needed or not
        double[] tempDoubleA = new double[]{3.1, 4.1};
        MyVector actualDoubleNorm = (new MyVector(tempDoubleA)).normalize();
        double normal = sqrt(3.1 * 3.1 + 4.1 * 4.1);
        MyVector expectDoubleNorm = new MyVector(new double[]{(3.1 / normal), (4.1 / normal)});

        assertTrue(actualDoubleNorm.equal(expectDoubleNorm), "test int v mult int");

        int[] tempIntA = new int[]{3, 4};
        MyVector actualIntNorm = (new MyVector(tempIntA)).normalize();
        MyVector expectIntNorm = new MyVector(new double[]{3 / (double) 5, 4 / (double) 5});
        assertTrue(actualIntNorm.equal(expectIntNorm), "test int v mult int");

        MyVector emptyNorm = EMPTYVECTOR.normalize();
        assertTrue(EMPTYVECTOR.equal(emptyNorm), "test on empty vector normalization");
    }

    @Test //test euclidean  distance
    public void testEuclideanDistance() {
        MyVector doubleV1 = new MyVector(new double[]{2, -2});
        MyVector doubleV2 = new MyVector(new double[]{-2, 2});
        double actualDoubleVDistance = doubleV1.euclideanDistance(doubleV2);
        assertEquals(sqrt(32), actualDoubleVDistance, "test distance between double v's");
        try {
            MyVector differentSizeVector = new MyVector(new double[]{-2.2, 0.0, 2.0, 4.6});
            doubleV1.euclideanDistance(differentSizeVector);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("Vector lengths are not equal", ex.getMessage());
        }
        try {
            double actualDistanceToEmptyV = doubleV1.euclideanDistance(EMPTYVECTOR);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("Vector lengths are not equal", ex.getMessage());
        }

        MyVector intV1 = new MyVector(new int[]{2, -2});
        MyVector intV2 = new MyVector(new int[]{-2, 2});
        double actualIntVDistance = intV1.euclideanDistance(intV2);
        assertEquals(sqrt(32), actualIntVDistance, "test distance between int v's");

        double actualIntVDoubleVDistance = doubleV1.euclideanDistance(intV2);
        assertEquals(sqrt(32), actualIntVDoubleVDistance, "test distance between double v and int v");


    }
}
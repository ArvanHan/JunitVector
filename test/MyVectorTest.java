import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MyVectorTest {
    @Test //test get value
    public void getValue(){
        double [] doubleVector= new double[] {0.0,1.0,2.0,3.0 };
        MyVector vector = new MyVector(doubleVector);
        assertEquals(2.0,(double)vector.getValue(3));
        assertEquals(3.0,(double)vector.getValue(4));
        int [] intArray = new int[]{1,3,5,7};
        MyVector intVector = new MyVector(intArray);
        assertEquals(5,(int)vector.getValue(3));
        assertEquals(7,(int)vector.getValue(4));

    }

    @Test //test equal
    public void testEqual(){
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("",vector);
    }

    @Test //test append double[]
    public void testAppendDdouble(){
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("",vector);
    }

    @Test //test append int[]
    public void testAppendInt(){
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("",vector);
    }

    @Test //test Clone
    public void testClone(){
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("",vector);
    }


    @Test //test getlength
    public void testGetLength(){
        double [] doubleVector= new double[] {0.0,1.0,2.0,3.0 };
        MyVector vector = new MyVector(doubleVector);
        System.out.println("testGetLength");
        int length = vector.getLength();
        assertEquals("4",length);
    }

    @Test //test add vector
    public void testAdd(){
        double [] original = new double[] {0.0,1.0,2.0,3.0 };
        MyVector vector = new MyVector(original);
        System.out.println("");
        assertEquals( "",vector);
    }

    @Test //test add double
    public void testAddDouble(){
        double two = 2.0;
        double [] original = new double[] {0.0,1.0,2.0,3.0 };
        double [] expect = new double[]{2,3,4,5};
        MyVector vector = new MyVector(original);
        MyVector result = vector.add(two);
        MyVector expectV = new MyVector(expect);
        assertEquals(expectV,result);
    }

    @Test //test sub vector
    public void testSub(){
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("",vector);
    }

    @Test //test add double
    public void testSubDouble(){
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("",vector);
    }

    @Test //test mult vector
    public void testMult(){
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("",vector);
    }

    @Test //test mult double
    public void testMultDouble(){
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("",vector);
    }

    @Test //test normalize
    public void testNormalize(){
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("",vector);
    }

    @Test //test euclidean  distance
    public void testEuclideanDistance(){
        MyVector vector = new MyVector();
        System.out.println("");
        assertEquals("",vector);
    }
}
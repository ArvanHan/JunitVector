class returnType {
    public final int intValue;
    public final double doubleValue;

    public returnType(int iValue, double dValue) {
        this.intValue = iValue;
        this.doubleValue = dValue;
    }
}

public final class MyVector {

    protected final double[] doubleData;
    protected final int[] intData;
    //protected final Object[] data; //Vector itself
    protected final int size; // maximum capacity of the vector

    public MyVector() {
        this(0, 0);
    }

    public MyVector(int size, double D) {
        this.size = size;
        this.doubleData = new double[size]; //creates a vector of size – size
        for (int i = 0; i < size; i++) doubleData[i] = D;// with elements initialized to D
        this.intData = new int[0];
    }

    public MyVector(double[] D) {//creates a vector initialized to array D
        this.size = D.length;
        this.intData = new int[0];
        this.doubleData = new double[size];
        for (int i = 0; i < size; i++) doubleData[i] = D[i];
    }

    public MyVector(int[] I) {//creates a vector initialized to array I
        this.size = I.length;
        doubleData = new double[0];
        this.intData = new int[size];
        for (int i = 0; i < size; i++) intData[i] = I[i];
    }

    public MyVector append(double[] doubleArray) {
        return null;
    }

    public MyVector append(int[] intArray) {
        return null;
    }

    public MyVector append(MyVector V) {
        return null;
    }

    public MyVector append(double aDouble) {
        return null;
    }

    public MyVector clone() {// returns a clone of this
        return null;
    }

    public boolean equal(MyVector V) {//this and V are the same
        return true;
    }

    public int getLength() { //returns number of elements in this
        return 0;
    }

    public returnType getValue(int i) { //returns the value this[i]
        returnType rt = new returnType(-999, -999);
        return rt;
    }

    public MyVector add(MyVector V) {//add this to V, returning a Vector the same size as this
        return null;
    }

    public MyVector add(double aDouble) { //add aDouble to every element of this
        return null;
    }

    public MyVector sub(MyVector V) {//sub this – V
        return null;
    }

    public MyVector subV(int l, int r) {//will return a sub vector between the indices l and r inclusive
        return null;
    }

    public MyVector mult(MyVector V) { //Multiple every element of this by corresponding element in V
        return null;
    }

    public MyVector mult(double aDouble) {//Multiply every element of this by aDouble
        return null;
    }

    public MyVector normalize() {//returns this as a normalized vector
        return null;
    }

    public Double euclidianDistance(MyVector V) {//returns the Euclidian distance between this and V.
        return null;
    }
}

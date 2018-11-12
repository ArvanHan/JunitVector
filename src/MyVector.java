public final class MyVector {

    protected final Object[] data; //Vector itself
    protected final int size; // maximum capacity of the vector

    public MyVector() {
        this(0, 0);
    }

    public MyVector(int size, double D) {
        this.size = size;
        this.data = new Object[size]; //creates a vector of size – size
        for (int i = 0; i < size; i++) data[i] = D;// with elements initialized to D
    }

    public MyVector(double[] D) {//creates a vector initialized to array D
        this.size = D.length;
        data = new Object[size];
        for (int i = 0; i < size; i++) data[i] = D[i];
    }

    public MyVector(int[] I) {//creates a vector initialized to array I
        this.size = I.length;
        data = new Object[size];
        for (int i = 0; i < size; i++) data[i] = I[i];
    }

    public MyVector append() {
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

    public Boolean equal(MyVector V) {//this and V are the same
        return null;
    }

    public int getLength() { //returns number of elements in this
        return 0;
    }

    public <T>T getValue(int i) { //returns the value this[i]
        return null;
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

    public MyVector Mult(MyVector V) { //Multiple every element of this by corresponding element in V
        return null;
    }

    public MyVector Mult(double aDouble) {//Multiply every element of this by aDouble
        return null;
    }

    public MyVector Normalize() {//returns this as a normalized vector
        return null;
    }

    public Double EuclidianDistance(MyVector V) {//returns the Euclidian distance between this and V.
        return null;
    }
}

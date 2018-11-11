public class MyVector {

    protected Object[] data; //Vector itself
    protected int size; // maximum capacity of the vector

    public MyVector() {     //empty
        this(0, 0);
    }

    public MyVector(int size, double D) {//creates a vector of size – size
        this.size = size;// with elements initialized to D
        data = new Object[size];
        for (int i = 0; i < size; i++) data[i] = D;
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

}

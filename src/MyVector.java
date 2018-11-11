public class MyVector <E>{

    protected Object[] data; //Vector itself
    protected int size; // maximum capacity of the vector

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

}

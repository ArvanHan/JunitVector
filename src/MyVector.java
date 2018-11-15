import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public final class MyVector {

    protected double[] doubleData;
    //protected final Object[] data; //Vector itself
    protected final int size; // maximum capacity of the vector

    public MyVector() {
        this(0, 0);
    }

    public MyVector(int size, double D) {
        this.size = size;
        this.doubleData = new double[size]; //creates a vector of size – size
        for (int i = 0; i < size; i++) doubleData[i] = D;// with elements initialized to D
    }

    public MyVector(double[] D) {//creates a vector initialized to array D
        this.size = D.length;
        this.doubleData = new double[size];
        for (int i = 0; i < size; i++) doubleData[i] = D[i];
    }

    public MyVector(int[] I) {//creates a vector initialized to array I
        this.size = I.length;
        double[] tempDouble = new double[size];
        for (int i = 0; i < size; i++) tempDouble[i] = I[i];
        this.doubleData = tempDouble;
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

    public double getValue(int i) { //returns the value this[i]
        return 0;
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
        if (l > r || l > doubleData.length || l < 0 || r > doubleData.length || r < 0) {//if l > r or l or r not reasonable
            throw new ArrayIndexOutOfBoundsException("vector length not equal");
        } else if (l != r) {
            double[] newDouble = new double[abs(l - r) + 1];
            int j = 0;
            if (l < r) {
                for (int i = l; i < r; i++) {
                    newDouble[j] = doubleData[i];
                    j++;
                }
            } else newDouble[0] = doubleData[l];// just return element at l

            MyVector newVector = new MyVector(newDouble);
            return newVector;
        } else
            return null;
    }

    public MyVector mult(MyVector V) { //Multiple every element of this by corresponding element in V
        if (doubleData.length == 0 && V.doubleData.length == 0)//empty vectors mult
            return this;
        if (doubleData.length != 0 && doubleData.length != V.doubleData.length) {
            for (int i = 0; i < doubleData.length; i++)
                doubleData[i] = doubleData[i] * V.doubleData[i];
            return this;
        } else //does not matter it is empty vector time another normal vector
            throw new ArrayIndexOutOfBoundsException("vector length not equal");
    }

    public MyVector mult(double aDouble) {//Multiply every element of this by a Double
        double[] newDouble = new double[doubleData.length];
        if (doubleData.length != 0) {
            for (int i = 0; i < doubleData.length; i++)
                newDouble[i] = doubleData[i] * aDouble;
            return new MyVector(newDouble);
        } else { //current vector is empty vector
            return this.clone();
        }
    }

    public MyVector normalize() {//returns this as a normalized vector
        if (doubleData.length == 0) { //current vector is empty
            return this.clone();
        } else {
            double sum = 0;
            int size = doubleData.length;
            for (int i = 0; i < size; i++) {
                double temp = doubleData[i];
                double tempSum = temp * temp;
                sum += tempSum;
            }
            double[] newDouble = new double[size];
            for (int i = 0; i < size; i++) newDouble[i] = (doubleData[i]) / (sqrt(sum));
            return new MyVector(newDouble);
        }
    }

    public Double euclideanDistance(MyVector V) {//returns the Euclidian distance between this and V.
        //todo what happen if v is empty or double data is empty
        double sum = 0;
        for (int i = 0; i < doubleData.length; i++) {
            double x = doubleData[i];
            double y = V.doubleData[i];
            sum += x * x - y * y;
        }
        double distance = sqrt(sum);
        return distance;
    }
}

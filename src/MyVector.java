import java.util.Arrays;
import java.util.stream.DoubleStream;

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
        double[] newDoubleArray = DoubleStream.concat(Arrays.stream(doubleData), Arrays.stream(doubleArray)).toArray();
        return new MyVector(newDoubleArray);
    }

    public MyVector append(int[] intArray) {
        double[] intToDoubleArray = new double[intArray.length];
        for (int i = 0; i < intArray.length; ++i) {
            intToDoubleArray[i] = intArray[i];
        }
        double[] newDoubleArray = DoubleStream.concat(Arrays.stream(doubleData), Arrays.stream(intToDoubleArray)).toArray();
        return new MyVector(newDoubleArray);
    }

    public MyVector append(MyVector V) {
        double[] newDoubleArray = DoubleStream.concat(Arrays.stream(doubleData), Arrays.stream(V.doubleData)).toArray();
        return new MyVector(newDoubleArray);
    }

    public MyVector append(double aDouble) {
        double[] newDoubleArray = Arrays.copyOf(doubleData, doubleData.length + 1);
        newDoubleArray[newDoubleArray.length - 1] = aDouble;
        return new MyVector(newDoubleArray);
    }

    public MyVector clone() {// returns a clone of this
        return new MyVector(doubleData);
    }

    public boolean equal(MyVector V) {//this and V are the same
        if (Arrays.equals(doubleData, V.doubleData))
            return true;
        else
            return false;
    }

    public int getLength() { //returns number of elements in this
        return doubleData.length;
    }

    public double getValue(int i) { //returns the value this[i]
        if (doubleData.length != 0 && i >=0 && i <= (doubleData.length-1 ))
            return doubleData[i];
        else
            throw new ArrayIndexOutOfBoundsException("This index is out of range");
    }

    public MyVector add(MyVector V) {//add this to V, returning a Vector the same size as this
        double[] newDoubleData = new double[doubleData.length];
        if (doubleData.length == 0 && V.doubleData.length == 0) {
            return this.clone();
        } else if (doubleData.length == V.getLength()) {
            for (int i = 0; i < doubleData.length; i++)
                newDoubleData[i] = doubleData[i] + V.doubleData[i];
            return new MyVector(newDoubleData);
        } else
            throw new ArrayIndexOutOfBoundsException("the length is not equal");
    }

    public MyVector add(double aDouble) { //add aDouble to every element of this
        if (doubleData.length == 0) {
            return new MyVector();
        } else {
            double[] newDouble = new double[doubleData.length];
            for (int i = 0; i < doubleData.length; i++)
                newDouble[i] = Math.round((doubleData[i] + aDouble) * 100000) / 100000.0;
            return new MyVector(newDouble);
        }
    }

    public MyVector sub(MyVector V) {//sub this – V
        if (doubleData.length == 0 && V.doubleData.length == 0) {
            return this.clone();
        } else if (doubleData.length != V.doubleData.length) {
            throw new ArrayIndexOutOfBoundsException("Vector lengths are not equal");
        } else {
            int size = doubleData.length;
            double[] newDouble = new double[doubleData.length];
            for (int i = 0; i < size; i++) {
                newDouble[i] = doubleData[i] - V.doubleData[i];
            }
            MyVector newVector = new MyVector(newDouble);
            return newVector;
        }
    }

    public MyVector subV(int l, int r) {//will return a sub vector between the indices l and r inclusive
        if (l > r || l > doubleData.length || l < 0 || r >= doubleData.length || r < 0) {//if l > r or l or r not reasonable
            throw new ArrayIndexOutOfBoundsException("Vector lengths are not equal");
        } else if (l <= r) {
            double[] newDouble = new double[r - l + 1];
            int j = 0;
            if (l < r) {
                for (int i = l; i <= r; i++) {
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
            return this.clone();
        else if (doubleData.length != 0 && doubleData.length == V.doubleData.length) {
            for (int i = 0; i < doubleData.length; i++)
                doubleData[i] = Math.round (doubleData[i] * V.doubleData[i]*100000)/100000.0;
            return this;
        } else //does not matter it is empty vector time another normal vector
            throw new ArrayIndexOutOfBoundsException("Vector lengths are not equal");
    }

    public MyVector mult(double aDouble) {//Multiply every element of this by a Double
        double[] newDouble = new double[doubleData.length];
        if (doubleData.length != 0) {
            for (int i = 0; i < doubleData.length; i++)
                newDouble[i] = Math.round(doubleData[i] * aDouble * 100000)/100000.0;
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

    public Double euclideanDistance(MyVector V) {//returns the Euclidean distance between this and V.
        if (doubleData.length == 0 && V.doubleData.length == 0) {
            return 0.0;
        } else if (doubleData.length != V.doubleData.length) {
            throw new ArrayIndexOutOfBoundsException("Vector lengths are not equal");
        } else {
            double sum = 0;
            for (int i = 0; i < doubleData.length; i++) {
                double x = doubleData[i];
                double y = V.doubleData[i];
                sum += (y - x) * (y - x);
            }
            double distance = sqrt(sum);
            return distance;
        }
    }
}

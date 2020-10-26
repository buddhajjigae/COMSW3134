public class Rectangle implements Comparable<Rectangle> {

    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    //Gets length
    public int getLength() {
        return length;
    }

    //Gets width
    public int getWidth() {
        return width;
    }

    //CompareTo method for comparing perimeters
    public int compareTo(Rectangle x) {
        int perimeter = length * 2 + width * 2;
        int xperimeter = x.length * 2 + x.width * 2;

        return perimeter - xperimeter;
    }

    //Converts values of length and width to string
    public String toString() {
        return "Rectangle length: " + length + " Rectangle width: " + width;
        
    }
}
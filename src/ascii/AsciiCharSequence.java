package ascii;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {

    public static void main(String[] args) {
    }

    byte [] bytesArray;

    public AsciiCharSequence (byte [] bytesArray) {
        this.bytesArray = bytesArray;
    }

    @Override
    public int length() {
        return bytesArray.length;
    }

    @Override
    public char charAt(int index) {
        return (char)bytesArray [index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < end-1) {
            byte [] b = new byte [end-1 - start];
            for (int i =start; i < bytesArray.length; i++) {
                if (i <= end - 1) {
                    b[i] = bytesArray[i];
                }
            }
            String string = new String(b);
            return string;
        }else {
            byte [] b = new byte [0];
            String string = new String(b);
            return string;
        }
    }

    @Override
    public String toString() {
        String string = new String(bytesArray);
        return string;
    }
}

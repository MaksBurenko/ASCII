package ascii;

public class AsciiCharSequence implements CharSequence {

    public static void main(String[] args) {
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(0, 5));//ello
//проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 72;
        System.out.println(answer.toString());//Hello!
    }

    byte [] bytesArray = {72, 101, 108, 108, 111, 33};

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
        if (start >= 0 && end > start) {
            byte [] b = new byte [(end) - start];
            System.arraycopy(bytesArray, start, b, 0, b.length);
            for (int i=0; i < b.length; i++) {
                System.out.print(b[i] + " ");
            }
            AsciiCharSequence cs = new AsciiCharSequence(b);
            return cs;
        }else {
            byte [] b = {};
            AsciiCharSequence cs = new AsciiCharSequence(b);
            return cs;
        }
    }

    @Override
    public String toString() {
        String string = new String(bytesArray);
        return string;
    }
}

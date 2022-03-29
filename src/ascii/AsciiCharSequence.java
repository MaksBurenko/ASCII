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
        if (start >= 0 && end-1 > start) {
            byte [] b = new byte [(end-1) - start];
            for (int i = start; i <= end-1; i++) {
                    for (int j = i; j<b.length; j++)
                    b[j] = bytesArray[i];
            }
            return new CharSequence(b);
        }else {
            byte [] b = {};
            return new CharSequence(b);
        }
    }

    @Override
    public String toString() {
        String string = new String(bytesArray);
        return string;
    }
}

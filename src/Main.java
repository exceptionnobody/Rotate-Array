//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int size = 10;
        CircularArray<String> array = new CircularArray<>(size);
        for (int i = 0; i < size; i++) {
            array.set(i, String.valueOf(i));
        }

        array.rotate(-3);

        for (int i = 0; i < size; i++) {
            System.out.println(array.get(i));
        }

        System.out.println();

        array.rotate(2);
        for (String s : array) {
            System.out.println(s);
        }
    }

}
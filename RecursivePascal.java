public class RecursivePascal {
    public static void main (String[] args) {
        ManagePascal.newCalculate(20);
    }
}

class ManagePascal {
    public static void newCalculate (int length) {
        int[] array = {1};
        calculate(length, 2, array);
    }

    public static void calculate (int length, int count, int[] array) {
        int[] newArray = new int[count];

        for (int i = 0; i < count - 1; i++) {
            newArray[i] = math(array, count, i);
        }

        printTest(length, count, newArray);
        count++;
        if (count <= length) {
            calculate(length, count, newArray);
        }
    }

    public static int math (int[] array, int count, int number) {
        int addOne = 0;
        if (number < 1) {
            addOne = 0;
        } else {
            addOne = array[number - 1];
        }
        //int addOne = array[number - 1];
        int addTwo = array[number];
        int sum = addOne + addTwo;

        return sum;
    }

    public static void printTest (int length, int count, int[] array) {
        for (int i = 1; i <= length - count; i++) {
            System.out.print("   ");
        }
        String printable = "";
        for (int j = 0; j < array.length - 1; j++) {
            printable = array[j] + "            ";
            printable = printable.substring(0, 6);
            System.out.print(printable);
        }
        System.out.println();
    }
}

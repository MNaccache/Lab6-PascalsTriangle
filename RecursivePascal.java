//M NACCACHE
//Extra credit: I did both lab 6 assignments

public class RecursivePascal { //test class, all in one file because having a file that's 5 lines long is a bit silly
    public static void main (String[] args) {
        ManagePascal.newCalculate(6); //sending out a Pascal's Triangle that's 6 lines long
        ManagePascal.newCalculate(20); //sending out a Pascal's Triangle that's 20 lines long
    }
}

class ManagePascal {
    public static void newCalculate (int length) { //just formats the start of the triangle so the recursion works well
        int[] array = {1}; //makes the first array, it's just the very tip of the triangle
        printTest(length, 1, array);
        calculate(length, 2, array); //here's how tall the triangle needs to be, here's the current row, here's what the last row looks like
    }

    public static void calculate (int length, int count, int[] array) { //recursivly does each row of the triangle
        int[] newArray = new int[count]; //a new array to put the calculated values in

        for (int i = 0; i < count; i++) { //goes through the array and does math into the new array
            newArray[i] = math(array, count, i);
        }

        printTest(length, count, newArray); //prints out the Pascal's Triangle row
        count++; //adds to the count
        if (count <= length) { //if the count is less than or the same as the length, make a new row
            calculate(length, count, newArray); //new array becomes array in the newly called method, creating a cycle
        }
    }

    public static int math (int[] array, int count, int number) { //this does the actual calculations for the arrays
        int addOne = 0;
        int addTwo = 0;

        if (number < 1) { //this is so it doesn't throw an error about -1 not being an index in an array
            addOne = 0;
        } else {
            addOne = array[number - 1];
        }

        if (number >= count - 1) { //this is so it doesn't throw an error about the old array having one less than the current array
            addTwo = 0;
        } else {
            addTwo = array[number];
        }

        int sum = addOne + addTwo; //adds the two numbers above it together 

        return sum;
    }

    public static void printTest (int length, int count, int[] array) {
        for (int i = 1; i <= length - count; i++) { //adds some spaces so it gets printed out in a triangle
            System.out.print("   ");
        }
        String printable; //making the variable outside the for loop so the computer doesn't yell at me
        for (int j = 0; j < array.length; j++) { //prints out each thing of an array
            printable = array[j] + "            "; //so it stays at a consistant length
            printable = printable.substring(0, 6);
            System.out.print(printable);
        }
        System.out.println(); //goes to the next line so it's actually a triangle
    }
}

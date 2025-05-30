package ru.test.HW;

public class HW1 {

    public static int[] twoArr(int[] one, int[] two) {
        int[] arr3 = new int[one.length + two.length];
        int i = 0, j = 0, k = 0;

        while (i < one.length && j < two.length) {
            arr3[k++] = (one[i] <= two[j]) ? one[i++] : two[j++];
        }

        while (i < one.length) {
            arr3[k++] = one[i++];
        }

        while (j < two.length) {
            arr3[k++] = two[j++];
        }

        return arr3;
    }

    public static void main(String[] args) {
        int[] arr = {-5, 0, 1, 1, 2, 3, 6, 8, 22, 45, 678};
        int[] arr2 = {-10, 2, 3, 6, 7, 7, 7, 9, 11, 1000, 1010, 1100};

        int[] arr3 = twoArr(arr, arr2);

        System.out.print("{");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i]);
            if (i < arr3.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}
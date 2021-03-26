package ru.job4j.array;
/*
            if (leftJ != left.length && (rightJ == right.length || left[leftJ] <= right[rightJ])) {
                rsl[i] = left[leftJ++];
            } else {
                rsl[i] = right[rightJ++];
            }
*/
public class Merge {
    public static int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int leftJ = 0, rightJ = 0;
        for (int i = 0; i < rsl.length; i++) {
            rsl[i] = (leftJ != left.length && (rightJ == right.length || left[leftJ] <= right[rightJ])) ? left[leftJ++] : right[rightJ++];
        }
        return rsl;
    }
}

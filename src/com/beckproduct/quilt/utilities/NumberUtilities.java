package com.beckproduct.quilt.utilities;

public class NumberUtilities
{
    public static int getRandomNumber(int limit)
    {
        int[] a = new int[limit];
        for (int i = 0; i < limit; i++) a[i] = i;

        return a[(int) (Math.random() * limit)];
    }
}

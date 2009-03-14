package com.beckproduct.quilt.utilities;

import com.beckproduct.quilt.*;

public class NumberUtilities
{
    public static String getRandomNumber(int size)
    {
        int i = (int) (Math.random() * size);
        return Constants.IDS[i];
    }
}

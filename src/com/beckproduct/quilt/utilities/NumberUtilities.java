package com.beckproduct.quilt.utilities;

import java.util.ArrayList;

public class NumberUtilities
{
    public static String getRandomNumber(String ids)
    {
        ArrayList categories = new ArrayList();
        if (ids.indexOf('0') != -1)
            categories.add("0");
        if (ids.indexOf('1') != -1)
            categories.add("1");
        if (ids.indexOf('2') != -1)
            categories.add("2");
        if (ids.indexOf('3') != -1)
            categories.add("3");

        String[] cats = (String[]) categories.toArray(new String[] {});

        int i = (int) (Math.random() * (cats.length));

        return cats[i];
    }
}

package com.beckproduct.quilt.utilities;

import java.util.ArrayList;

public class NumberUtilities
{
    public static String getRandomNumber(String ids)
    {
        ArrayList<String> categories = new ArrayList<String>();
        if (ids.indexOf('0') != -1)
            categories.add("0");
        if (ids.indexOf('1') != -1)
            categories.add("1");
        if (ids.indexOf('2') != -1)
            categories.add("2");
        if (ids.indexOf('3') != -1)
            categories.add("3");

        String[] cats = categories.toArray(new String[categories.size()]);

        int i = (int) (Math.random() * (cats.length));

        return cats[i];
    }
}

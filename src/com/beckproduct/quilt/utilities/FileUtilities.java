package com.beckproduct.quilt.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 13, 2009
 * Time: 4:08:11 PM
 */
public class FileUtilities
{
    public static byte[] convertToByteArray(File file) throws IOException
    {
        InputStream is = new FileInputStream(file);

        long length = file.length();

        byte[] bytes = new byte[(int)length];

        int offset = 0;
        int numRead;
        
        while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length-offset)) >= 0)
        {
            offset += numRead;
        }

        if (offset < bytes.length)
        {
            throw new IOException("Could not completely read file " + file.getName());
        }

        is.close();
        return bytes;
    }
}

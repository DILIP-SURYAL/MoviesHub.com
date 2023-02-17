package com.proj1.Helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Helpers {

    public static boolean removeImage(String path) {
        boolean t = false;
        try {

            File f = new File("path");
            t = f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static boolean saveImage(InputStream iStream, String path) {
        boolean t = false;
        try {

            byte b[] = new byte[iStream.available()];

            iStream.read(b);

            FileOutputStream oStream = new FileOutputStream(path);

            oStream.write(b);
            oStream.flush();
            oStream.close();

            t = true;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return t;
    }
}

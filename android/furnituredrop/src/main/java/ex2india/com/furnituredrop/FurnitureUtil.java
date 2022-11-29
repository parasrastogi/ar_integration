package ex2india.com.furnituredrop;

import android.graphics.Bitmap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FurnitureUtil {

    /**
     * Saves bitmap object in given imageFile path.
     */
    public static boolean saveBitmap(Bitmap bitmap, File file) {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file.getPath());

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (null != fileOutputStream) {
                    fileOutputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

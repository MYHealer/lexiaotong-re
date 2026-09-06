package client.android.yixiaotong.baseutil;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class QrcodeUtils {
    private QrcodeUtils() {
    }

    public static Bitmap createQrcode(String str) {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        HashMap map = new HashMap();
        map.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        map.put(EncodeHintType.MARGIN, 2);
        try {
            BitMatrix bitMatrixEncode = multiFormatWriter.encode(str, BarcodeFormat.QR_CODE, 480, 480, map);
            int width = bitMatrixEncode.getWidth();
            int height = bitMatrixEncode.getHeight();
            int[] iArr = new int[width * height];
            for (int i = 0; i < height; i++) {
                for (int i2 = 0; i2 < width; i2++) {
                    if (bitMatrixEncode.get(i2, i)) {
                        iArr[(i * width) + i2] = -16777216;
                    } else {
                        iArr[(i * width) + i2] = -1;
                    }
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

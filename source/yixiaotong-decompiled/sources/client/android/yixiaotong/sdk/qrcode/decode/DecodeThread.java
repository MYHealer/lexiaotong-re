package client.android.yixiaotong.sdk.qrcode.decode;

import android.os.Handler;
import android.os.Looper;
import client.android.yixiaotong.sdk.qrcode.utils.IActivityHandler;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class DecodeThread extends Thread {
    public static final int ALL_MODE = 768;
    public static final String BARCODE_BITMAP = "barcode_bitmap";
    public static final int BARCODE_MODE = 256;
    public static final int QRCODE_MODE = 512;
    private final IActivityHandler activityHandler;
    private Handler handler;
    private final CountDownLatch handlerInitLatch = new CountDownLatch(1);
    private final Map<DecodeHintType, Object> hints;

    public DecodeThread(IActivityHandler iActivityHandler, int i) {
        this.activityHandler = iActivityHandler;
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        this.hints = enumMap;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(EnumSet.of(BarcodeFormat.AZTEC));
        arrayList.addAll(EnumSet.of(BarcodeFormat.PDF_417));
        if (i == 256) {
            arrayList.addAll(DecodeFormatManager.getBarCodeFormats());
        } else if (i == 512) {
            arrayList.addAll(DecodeFormatManager.getQrCodeFormats());
        } else if (i == 768) {
            arrayList.addAll(DecodeFormatManager.getBarCodeFormats());
            arrayList.addAll(DecodeFormatManager.getQrCodeFormats());
        }
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
    }

    public Handler getHandler() {
        try {
            this.handlerInitLatch.await();
        } catch (InterruptedException unused) {
        }
        return this.handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.handler = new DecodeHandler(this.activityHandler, this.hints);
        this.handlerInitLatch.countDown();
        Looper.loop();
    }
}

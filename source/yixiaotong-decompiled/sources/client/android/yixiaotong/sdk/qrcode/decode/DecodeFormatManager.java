package client.android.yixiaotong.sdk.qrcode.decode;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class DecodeFormatManager {
    private static final Set<BarcodeFormat> INDUSTRIAL_FORMATS;
    private static final Set<BarcodeFormat> ONE_D_FORMATS;
    private static final Set<BarcodeFormat> PRODUCT_FORMATS;
    private static final Set<BarcodeFormat> QR_CODE_FORMATS;

    public static Collection<BarcodeFormat> getBarCodeFormats() {
        return ONE_D_FORMATS;
    }

    public static Collection<BarcodeFormat> getQrCodeFormats() {
        return QR_CODE_FORMATS;
    }

    static {
        EnumSet enumSetOf = EnumSet.of(BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED);
        PRODUCT_FORMATS = enumSetOf;
        EnumSet enumSetOf2 = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
        INDUSTRIAL_FORMATS = enumSetOf2;
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) enumSetOf);
        ONE_D_FORMATS = enumSetCopyOf;
        enumSetCopyOf.addAll(enumSetOf2);
        QR_CODE_FORMATS = EnumSet.of(BarcodeFormat.QR_CODE);
    }
}

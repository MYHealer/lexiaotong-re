package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.byazt.nys.tt;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pblf {
    private static final String c = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "b3b209", new byte[]{125, 48, 95, 69, Ascii.NAK, 34});

    public static int c(Context context) {
        InputStream inputStreamOpen;
        int i = 255;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            int i2 = 0;
            StringBuilder sbAppend = new StringBuilder().append(tt.c(context).getAbsolutePath()).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a04928", new byte[]{Utf8.REPLACEMENT_BYTE}));
            String str = c;
            String string = sbAppend.append(str).toString();
            File file = new File(string);
            if (file.exists()) {
                i = 2;
                file.delete();
            }
            inputStreamOpen = context.getResources().getAssets().open(str);
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i3 = inputStreamOpen.read(bArr, 0, 4096);
                        if (i3 == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, i3);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(string);
                    fileOutputStream.write(byteArrayOutputStream2.toByteArray());
                    fileOutputStream.close();
                    if (byteArrayOutputStream2.size() <= 0) {
                        i2 = 3;
                    } else if (!new File(string).exists()) {
                        i2 = i;
                    }
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable unused) {
                    }
                    try {
                        byteArrayOutputStream2.close();
                        return i2;
                    } catch (Throwable unused2) {
                        return i2;
                    }
                } catch (Throwable unused3) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7f3c49", new byte[]{39, 103, 127, 16});
                        return i;
                    } finally {
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable unused5) {
                            }
                        }
                    }
                }
            } catch (Throwable unused6) {
            }
        } catch (Throwable unused7) {
            inputStreamOpen = null;
        }
    }
}

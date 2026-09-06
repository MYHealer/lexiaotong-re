package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pbls {
    private static final String c = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "9b2cc3", new byte[]{4, 83, 113, Ascii.CAN, 79, 33, 62});

    /* JADX WARN: Code duplicated, block: B:22:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:25:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ea A[Catch: all -> 0x00f4, TRY_LEAVE, TryCatch #1 {all -> 0x00f4, blocks: (B:23:0x00cc, B:26:0x00ea), top: B:38:0x00cc }] */
    public static boolean c(Context context) {
        String packageName;
        Parcel parcelObtain;
        Parcel parcelObtain2;
        Bundle bundle;
        PackageManager packageManager = context.getPackageManager();
        IBinder iBinder = null;
        if (packageManager != null) {
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(new Intent((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "73b964", new byte[]{39, Utf8.REPLACEMENT_BYTE, Ascii.NAK, 95, 6, 42, 48, 92, 58, 103, 50, 52, Ascii.US, 89, 71, 34, 55, 6, 58, 102, 40, 127, 60, 108, 32, 13}), (Uri) null), 128).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo == null || (bundle = activityInfo.applicationInfo.metaData) == null || bundle.get((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "429766", new byte[]{Base64.padSymbol, 32, 69, 80, 12, 37, 58, 26, 102, 113, 32, 34, 89, 74, 6, 47})) == null) {
                }
            }
            packageName = context.getPackageName();
            String str = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3afefb", new byte[]{35, 96, 1, Ascii.CAN, 79, 124, 36, 89});
            Method declaredMethod = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "519f96", new byte[]{37, Base64.padSymbol, 78, 0, 9, 40, 50, 94, 103, 37, 106, 0, 79, 0, 16, 40, 53, Ascii.NAK, 69, 55, 42, 50, 77, Ascii.ETB, Ascii.DC4})).getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "637ecd", new byte[]{32, 52, 80, 34, 89, 97, 35, Ascii.ESC, 101, 48}), String.class);
            declaredMethod.setAccessible(true);
            iBinder = (IBinder) declaredMethod.invoke(null, str);
            if (iBinder != null) {
                parcelObtain = Parcel.obtain();
                parcelObtain2 = Parcel.obtain();
                parcelObtain.writeInterfaceToken(c);
                parcelObtain.writeInt(2);
                parcelObtain.writeString(packageName);
                parcelObtain.writeStrongBinder(new Binder());
                if (!iBinder.transact(1598837584, parcelObtain, parcelObtain2, 0)) {
                    parcelObtain2.readException();
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            }
            return false;
        }
        packageName = context.getPackageName();
        String str2 = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3afefb", new byte[]{35, 96, 1, Ascii.CAN, 79, 124, 36, 89});
        try {
            Method declaredMethod2 = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "519f96", new byte[]{37, Base64.padSymbol, 78, 0, 9, 40, 50, 94, 103, 37, 106, 0, 79, 0, 16, 40, 53, Ascii.NAK, 69, 55, 42, 50, 77, Ascii.ETB, Ascii.DC4})).getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "637ecd", new byte[]{32, 52, 80, 34, 89, 97, 35, Ascii.ESC, 101, 48}), String.class);
            declaredMethod2.setAccessible(true);
            iBinder = (IBinder) declaredMethod2.invoke(null, str2);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
        if (iBinder != null) {
            parcelObtain = Parcel.obtain();
            parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(c);
                parcelObtain.writeInt(2);
                parcelObtain.writeString(packageName);
                parcelObtain.writeStrongBinder(new Binder());
                if (!iBinder.transact(1598837584, parcelObtain, parcelObtain2, 0)) {
                    parcelObtain2.readException();
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            } catch (Throwable th) {
                try {
                    com.byazt.nr.m.c(th);
                } finally {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            }
        }
        return false;
        return true;
    }
}

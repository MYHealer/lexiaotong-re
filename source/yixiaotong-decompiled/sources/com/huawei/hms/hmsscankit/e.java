package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.scankit.p.h3;
import com.huawei.hms.scankit.p.i3;
import com.huawei.hms.scankit.p.x3;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.UUID;

/* JADX INFO: compiled from: RemoteDecoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile h3 f4125a;
    private static volatile IRemoteDecoderDelegate b;

    /* JADX INFO: compiled from: RemoteDecoder.java */
    class a extends SimpleDateFormat {
        a(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone("UTC"));
        }
    }

    static HmsScan[] a(Context context, Bitmap bitmap, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        HmsScan[] hmsScanArr = new HmsScan[0];
        if (b == null) {
            IRemoteCreator iRemoteCreatorC = f.c(context);
            if (iRemoteCreatorC == null) {
                return hmsScanArr;
            }
            try {
                b = iRemoteCreatorC.newRemoteDecoderDelegate();
            } catch (RemoteException unused) {
                x3.b("RemoteDecoder", "RemoteException");
            }
        }
        if (b == null) {
            return hmsScanArr;
        }
        try {
            Bundle bundle = new Bundle();
            if (hmsScanAnalyzerOptions != null) {
                bundle.putInt(DetailRect.FORMAT_FLAG, hmsScanAnalyzerOptions.mode);
                bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
            }
            bundle.putInt(DetailRect.TYPE_TRANS, 3);
            bundle.putAll(i3.a(context));
            HmsScan[] hmsScanArrDecodeWithBitmap = b.decodeWithBitmap(ObjectWrapper.wrap(bitmap), ObjectWrapper.wrap(bundle));
            return hmsScanArrDecodeWithBitmap != null ? hmsScanArrDecodeWithBitmap : hmsScanArr;
        } catch (RemoteException unused2) {
            x3.b("RemoteDecoder", "RemoteException");
            return hmsScanArr;
        }
    }

    private static void a(Bundle bundle) {
        if (DynamicModuleInitializer.getContext() == null) {
            try {
                f.b(AGConnectInstance.getInstance().getContext());
            } catch (ClassNotFoundException unused) {
                x3.b("RemoteDecoder", "buildBitmapLog ClassNotFoundException");
            } catch (IllegalAccessException unused2) {
                x3.b("RemoteDecoder", "buildBitmapLog IllegalAccessException");
            } catch (Exception unused3) {
                x3.b("RemoteDecoder", "buildBitmapLog Exception");
            } catch (NoClassDefFoundError unused4) {
                x3.b("RemoteDecoder", "buildBitmapLog NoClassDefFoundError");
                return;
            } catch (NoSuchMethodException unused5) {
                x3.b("RemoteDecoder", "buildBitmapLog NoSuchMethodException");
            } catch (InvocationTargetException unused6) {
                x3.b("RemoteDecoder", "buildBitmapLog InvocationTargetException");
            }
        }
        if (f4125a == null) {
            try {
                f4125a = new h3();
                f4125a.c(bundle);
            } catch (RuntimeException unused7) {
                x3.b("RemoteDecoder", "buildBitmapLog RuntimeException");
            } catch (Exception unused8) {
                x3.b("RemoteDecoder", "buildBitmapLog Exception");
            }
        }
    }

    public static Bundle a(String str, int i, int i2, int i3, HmsBuildBitmapOption hmsBuildBitmapOption) {
        Bundle bundle = new Bundle();
        bundle.putInt("contentLength", str == null ? -1 : str.length());
        bundle.putInt("scanType", i);
        bundle.putInt("reqWidth", i2);
        bundle.putInt("reqHeight", i3);
        bundle.putString("buildBitmapOption", hmsBuildBitmapOption == null ? "null" : hmsBuildBitmapOption.toString());
        bundle.putString("apiName", "BuildBitmap");
        bundle.putLong("callTime", System.currentTimeMillis());
        bundle.putString("transId", UUID.randomUUID().toString());
        return bundle;
    }

    public static void a(int i, Bitmap bitmap, Bundle bundle) {
        if (bundle != null) {
            bundle.putInt("result", i);
            bundle.putInt("outputWidth", bitmap == null ? -1 : bitmap.getWidth());
            bundle.putInt("outputHeight", bitmap != null ? bitmap.getHeight() : -1);
            long j = bundle.getLong("callTime");
            bundle.putLong(WiseOpenHianalyticsData.UNION_COSTTIME, System.currentTimeMillis() - j);
            bundle.putString("callTime", new a("yyyyMMddHHmmss.SSS").format(Long.valueOf(j)));
            a(bundle);
        }
    }
}

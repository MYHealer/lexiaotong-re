package com.huawei.hms.mlkit.bcr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorBorderParcel;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorBorderPointParcel;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorOptionsParcel;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorParcel;
import com.huawei.hms.ml.common.utils.SmartLog;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: NativeDecode.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4142a;
    private com.huawei.hms.mlkit.bcr.impl.b b;

    /* JADX INFO: compiled from: NativeDecode.java */
    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.huawei.hms.mlkit.bcr.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NativeDecode.java */
    private static final class C0526b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f4143a = new b(null);
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b b() {
        return C0526b.f4143a;
    }

    private b() {
        this.f4142a = false;
    }

    public int a(Context context) throws RemoteException {
        if (this.f4142a) {
            return 0;
        }
        com.huawei.hms.mlkit.bcr.impl.b bVar = new com.huawei.hms.mlkit.bcr.impl.b();
        this.b = bVar;
        bVar.a(context);
        this.f4142a = true;
        return 0;
    }

    public int a() throws RemoteException {
        if (!this.f4142a) {
            return 0;
        }
        this.f4142a = false;
        return this.b.a() ? 0 : -1;
    }

    public BcrDetectorParcel a(Bitmap bitmap, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) {
        if (this.f4142a) {
            return c.a(this.b.a(bitmap, bcrDetectorOptionsParcel));
        }
        return null;
    }

    /* JADX INFO: compiled from: NativeDecode.java */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Map<String, Integer> f4144a;

        static {
            HashMap map = new HashMap();
            f4144a = map;
            map.put("number", 0);
            f4144a.put("issuer", 1);
            f4144a.put("expire", 2);
            f4144a.put("type", 3);
            f4144a.put("checkFlag", 4);
            f4144a.put("tipsFlag", 5);
            f4144a.put("organization", 6);
        }

        public static BcrDetectorParcel a(com.huawei.hms.mlkit.bcr.impl.a aVar) {
            BcrDetectorParcel bcrDetectorParcel = new BcrDetectorParcel();
            bcrDetectorParcel.original = aVar.b();
            String[] strArrC = aVar.c();
            if (a(strArrC) || strArrC.length < f4144a.size()) {
                SmartLog.i("NativeDecode", "No detect results");
                return bcrDetectorParcel;
            }
            bcrDetectorParcel.retCode = Integer.parseInt(strArrC[f4144a.get("checkFlag").intValue()]) == 0 ? 0 : 1;
            bcrDetectorParcel.tipsCode = Integer.parseInt(strArrC[f4144a.get("tipsFlag").intValue()]);
            if (bcrDetectorParcel.retCode != 0) {
                SmartLog.i("NativeDecode", "detect failure retCode = " + bcrDetectorParcel.retCode + ", tipsCode = " + bcrDetectorParcel.tipsCode);
                return bcrDetectorParcel;
            }
            bcrDetectorParcel.correct = Bitmap.createScaledBitmap(aVar.a(), aVar.b().getWidth(), aVar.b().getHeight(), true);
            String str = strArrC[f4144a.get("number").intValue()];
            String str2 = strArrC[f4144a.get("issuer").intValue()];
            String str3 = strArrC[f4144a.get("expire").intValue()];
            String str4 = strArrC[f4144a.get("type").intValue()];
            String str5 = strArrC[f4144a.get("organization").intValue()];
            float[] fArrA = a(aVar.b(), aVar.a());
            BcrDetectorBorderParcel bcrDetectorBorderParcel = new BcrDetectorBorderParcel();
            bcrDetectorBorderParcel.cardNumber = a(str, fArrA);
            bcrDetectorBorderParcel.cardIssuer = a(str2, fArrA);
            bcrDetectorBorderParcel.cardExpire = a(str3, fArrA);
            bcrDetectorBorderParcel.cardOwner = a(str4, fArrA);
            bcrDetectorParcel.border = bcrDetectorBorderParcel;
            bcrDetectorParcel.cardNumber = a(str);
            bcrDetectorParcel.cardIssuer = a(str2);
            bcrDetectorParcel.cardExpire = a(str3);
            bcrDetectorParcel.cardType = a(str4);
            bcrDetectorParcel.cardOrganization = a(str5);
            return bcrDetectorParcel;
        }

        private static float[] a(Bitmap bitmap, Bitmap bitmap2) {
            float[] fArr = {1.0f, 1.0f};
            if (bitmap2 == null) {
                return fArr;
            }
            int width = bitmap2.getWidth();
            int height = bitmap2.getHeight();
            if (width > 0 && height > 0) {
                fArr[0] = bitmap.getWidth() / width;
                fArr[1] = bitmap.getHeight() / height;
            }
            return fArr;
        }

        private static String a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str.split("\\|")[0];
        }

        private static BcrDetectorBorderPointParcel a(String str, float[] fArr) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] strArrSplit = str.split("\\|");
            if (strArrSplit.length <= 1) {
                return null;
            }
            BcrDetectorBorderPointParcel bcrDetectorBorderPointParcel = new BcrDetectorBorderPointParcel();
            String[] strArrSplit2 = strArrSplit[1].replace(PPSLabelView.Code, "").split(",");
            if (strArrSplit2.length != 8) {
                return null;
            }
            bcrDetectorBorderPointParcel.leftTop = new Point((int) (Integer.parseInt(strArrSplit2[0]) * fArr[0]), (int) (Integer.parseInt(strArrSplit2[1]) * fArr[1]));
            bcrDetectorBorderPointParcel.rightTop = new Point((int) (Integer.parseInt(strArrSplit2[2]) * fArr[0]), (int) (Integer.parseInt(strArrSplit2[3]) * fArr[1]));
            bcrDetectorBorderPointParcel.rightBottom = new Point((int) (Integer.parseInt(strArrSplit2[4]) * fArr[0]), (int) (Integer.parseInt(strArrSplit2[5]) * fArr[1]));
            bcrDetectorBorderPointParcel.leftBottom = new Point((int) (Integer.parseInt(strArrSplit2[6]) * fArr[0]), (int) (Integer.parseInt(strArrSplit2[7]) * fArr[1]));
            return bcrDetectorBorderPointParcel;
        }

        static boolean a(Object[] objArr) {
            return objArr == null || objArr.length == 0;
        }
    }
}

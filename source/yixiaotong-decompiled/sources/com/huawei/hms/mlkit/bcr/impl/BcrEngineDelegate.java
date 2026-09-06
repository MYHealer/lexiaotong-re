package com.huawei.hms.mlkit.bcr.impl;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.huawei.hms.ml.common.utils.SmartLog;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class BcrEngineDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4145a = false;
    private Context b = null;

    public static native int loadSixModel(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, boolean z);

    public static native String[] runOCRTextCurveBankCard(Bitmap bitmap, Bitmap bitmap2, String str, int i, int i2, int i3, boolean z, boolean z2, boolean z3);

    public static native String[] runOCRTextCurveGeneralCard(Bitmap bitmap, Bitmap bitmap2, String str, int i, int i2, int i3, boolean z, boolean z2, boolean z3);

    public static native int unloadModelSync();

    public boolean a(Context context) {
        this.b = context;
        try {
            System.loadLibrary("BankCardRecogeOCR");
            return true;
        } catch (UnsatisfiedLinkError e) {
            SmartLog.e("BcrEngineDelegate", "failed to load native library: " + e.getMessage());
            return false;
        }
    }

    public a a(Bitmap bitmap, int i, int i2, int i3, int i4) {
        Bitmap bitmapCreateScaledBitmap;
        String[] strArrRunOCRTextCurveBankCard;
        a aVar = new a();
        if ((this.f4145a || a(i, i2, i4) == 0) && bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            boolean z = i3 == 1;
            boolean z2 = i4 != 0;
            if (i2 == 1) {
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, 512, 128, true);
                strArrRunOCRTextCurveBankCard = runOCRTextCurveGeneralCard(bitmapCreateScaledBitmap, bitmap, "", width, height, i, true, z, z2);
            } else {
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, 512, 512, true);
                strArrRunOCRTextCurveBankCard = runOCRTextCurveBankCard(bitmapCreateScaledBitmap, bitmap, "", width, height, i, true, z, z2);
            }
            if (strArrRunOCRTextCurveBankCard != null) {
                SmartLog.i("BcrEngineDelegate", "result.length: " + strArrRunOCRTextCurveBankCard.length + " checkFlag: " + strArrRunOCRTextCurveBankCard[strArrRunOCRTextCurveBankCard.length - 3] + " tipsFlag:" + strArrRunOCRTextCurveBankCard[strArrRunOCRTextCurveBankCard.length - 2]);
                aVar.a(strArrRunOCRTextCurveBankCard);
                aVar.b(bitmap);
                aVar.a(bitmapCreateScaledBitmap);
            }
        }
        return aVar;
    }

    public int a(AssetManager assetManager, String str, boolean z, int i, int i2, boolean z2) throws Throwable {
        com.huawei.hms.mlkit.bcr.a aVarA = com.huawei.hms.mlkit.bcr.a.a();
        ByteBuffer byteBufferA = aVarA.a(assetManager, "ml-bcr-text-detect.mslite");
        ByteBuffer byteBufferA2 = aVarA.a(assetManager, String.format(Locale.ENGLISH, "ml-bcr-%d.mslite", Integer.valueOf(i)));
        ByteBuffer byteBufferA3 = aVarA.a(assetManager, "exbankinfo.txt");
        SmartLog.i("BcrEngineDelegate", "load model to buffer");
        return loadSixModel(byteBufferA, byteBufferA2, byteBufferA3, i2, z2);
    }

    public int a() {
        if (!this.f4145a) {
            return -1;
        }
        int iUnloadModelSync = unloadModelSync();
        SmartLog.i("BcrEngineDelegate", "unloadModel retCode: " + iUnloadModelSync);
        return iUnloadModelSync;
    }

    public int a(int i, int i2, int i3) throws Throwable {
        int iA = a(this.b.getAssets(), "", true, i, i2, i3 != 0);
        SmartLog.i("BcrEngineDelegate", "resultCode: " + iA);
        if (iA == 0) {
            this.f4145a = true;
        }
        return iA;
    }
}

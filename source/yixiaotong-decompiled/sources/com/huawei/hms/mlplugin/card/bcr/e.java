package com.huawei.hms.mlplugin.card.bcr;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.ml.common.utils.NV21ToBitmapConverter1;
import com.huawei.hms.ml.common.utils.SmartLog;
import com.huawei.hms.mlsdk.card.MLBcrAnalyzerFactory;
import com.huawei.hms.mlsdk.card.bcr.MLBankCard;
import com.huawei.hms.mlsdk.card.bcr.MLBcrAnalyzer;
import com.huawei.hms.mlsdk.card.bcr.MLBcrAnalyzerSetting;
import com.huawei.hms.mlsdk.common.MLFrame;

/* JADX INFO: compiled from: DecodeHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class e extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f4170a;
    private NV21ToBitmapConverter1 c;
    private MLBcrAnalyzer d;
    private Bitmap f;
    private f g;
    private Context h;
    private boolean e = true;
    private c<String> i = new c<>(8);
    private MLBcrCapture b = MLBcrCapture.c();

    /* JADX INFO: compiled from: DecodeHandler.java */
    class a implements OnFailureListener {
        a() {
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            e.this.d();
        }
    }

    /* JADX INFO: compiled from: DecodeHandler.java */
    class b implements OnSuccessListener<MLBankCard> {
        b() {
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(MLBankCard mLBankCard) {
            e.this.c(mLBankCard);
        }
    }

    public e(Context context, Handler handler, f fVar) {
        this.h = context;
        this.f4170a = handler;
        this.g = fVar;
        this.c = new NV21ToBitmapConverter1(context);
        if (fVar.i()) {
            this.d = MLBcrAnalyzerFactory.getInstance().getBcrAnalyzer(new MLBcrAnalyzerSetting.Factory().setRecType(fVar.e()).setRecMode(fVar.d()).setResultType(fVar.f()).create());
        } else {
            this.d = MLBcrAnalyzerFactory.getInstance().getBcrAnalyzer(new MLBcrAnalyzerSetting.Factory().setRecMode(this.b.a().getRecMode()).setResultType(this.b.a().getResultType()).create());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        MLBcrCaptureResult mLBcrCaptureResult = new MLBcrCaptureResult();
        mLBcrCaptureResult.setOriginalBitmap(this.f);
        Handler handler = this.f4170a;
        if (handler != null) {
            Message.obtain(handler, R.id.mlkit_bcr_rec_failed, mLBcrCaptureResult).sendToTarget();
        }
    }

    private int[] b() {
        int[] iArr = {0, 0};
        if (a(this.h)) {
            return iArr;
        }
        Point pointH = this.g.i() ? com.huawei.hms.mlplugin.card.bcr.b.h() : CaptureActivity.d();
        if (pointH == null) {
            return iArr;
        }
        Point pointE = t.e(this.h);
        iArr[0] = pointH.x - pointE.x;
        iArr[1] = pointH.y - pointE.y;
        return iArr;
    }

    private void c() {
        Handler handler = this.f4170a;
        if (handler != null) {
            Message.obtain(handler, R.id.mlkit_bcr_decode_failed).sendToTarget();
        }
    }

    private void a(byte[] bArr) {
        Point pointC = this.g.c();
        SmartLog.i("DecodeHandler", "BCR decode width = " + pointC.x + ", height = " + pointC.y);
        this.f = this.c.convertYUVtoRGB(bArr, pointC.x, pointC.y);
        if (this.g.i()) {
            Rect rectG = this.g.g();
            if (rectG != null) {
                Bitmap bitmap = this.f;
                this.f = a(bitmap, bitmap.getWidth(), this.f.getHeight(), rectG);
            }
        } else {
            Rect rectB = this.g.b();
            Bitmap bitmap2 = this.f;
            this.f = a(bitmap2, bitmap2.getWidth(), this.f.getHeight(), rectB);
        }
        if (this.f == null) {
            c();
        } else {
            SmartLog.i("DecodeHandler", "bitmapDecode width = " + this.f.getWidth() + ", height = " + this.f.getHeight());
            a(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MLBankCard mLBankCard) {
        SmartLog.i("DecodeHandler", "BCR Analyzer return  getRetCode(): " + mLBankCard.getRetCode() + " getTipsCode(): " + mLBankCard.getTipsCode());
        if (mLBankCard.getTipsCode() == -5) {
            this.g.a(false);
        } else if (mLBankCard.getTipsCode() == -6) {
            this.g.a(true);
        }
        if (mLBankCard.getRetCode() == 0) {
            if (this.g.e() == 1) {
                b(mLBankCard);
                return;
            } else {
                a(mLBankCard);
                return;
            }
        }
        c();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.e) {
            int i = message.what;
            if (i == R.id.mlkit_bcr_decode) {
                a((byte[]) message.obj);
            } else if (i == R.id.mlkit_bcr_quit) {
                this.e = false;
                a();
                Looper.myLooper().quit();
            }
        }
    }

    private void b(MLBankCard mLBankCard) {
        String strOnSnCheck;
        if (this.f4170a != null) {
            MLSnCaptureResult mLSnCaptureResult = new MLSnCaptureResult();
            if (this.g.h() != null && ((strOnSnCheck = this.g.h().onSnCheck(mLBankCard.getNumber())) == null || strOnSnCheck.isEmpty() || !a(strOnSnCheck))) {
                c();
                return;
            }
            mLSnCaptureResult.setNumber(mLBankCard.getNumber());
            mLSnCaptureResult.setNumberBitmap(this.f);
            Message.obtain(this.f4170a, R.id.mlkit_bcr_decode_succeeded, mLSnCaptureResult).sendToTarget();
        }
    }

    private Bitmap a(Bitmap bitmap, int i, int i2, Rect rect) {
        Point pointD;
        Bitmap bitmapA;
        int i3 = rect.right - rect.left;
        int i4 = rect.bottom - rect.top;
        if (this.g.i()) {
            pointD = com.huawei.hms.mlplugin.card.bcr.b.h();
        } else {
            pointD = CaptureActivity.d();
        }
        int iA = this.g.a();
        int[] iArrB = b();
        Matrix matrix = new Matrix();
        matrix.setRotate(iA);
        if (t.g(this.h)) {
            bitmapA = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } else {
            bitmapA = a(bitmap, iA);
        }
        int width = ((rect.left + iArrB[0]) * bitmapA.getWidth()) / pointD.x;
        int height = (rect.top * bitmapA.getHeight()) / pointD.y;
        int width2 = (i3 * bitmapA.getWidth()) / pointD.x;
        int height2 = (i4 * bitmapA.getHeight()) / pointD.y;
        if (width2 + width > bitmapA.getWidth() || height2 + height > bitmapA.getHeight() || width < 0 || height < 0) {
            return null;
        }
        return Bitmap.createBitmap(bitmapA, width, height, width2, height2);
    }

    private Bitmap a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
            SmartLog.i("DecodeHandler", "adjustPhotoRotation2 error: " + e.getMessage());
            return null;
        }
    }

    private boolean a(Context context) {
        return ((Activity) context).getWindow().getDecorView().getLayoutDirection() == 0;
    }

    private void a() {
        if (this.b.a().b()) {
            SmartLog.d("DecodeHandler", "this is remote,excute close method");
        } else {
            this.d.stop();
        }
    }

    private void a(Bitmap bitmap) {
        MLFrame mLFrameFromBitmap = MLFrame.fromBitmap(bitmap);
        if (this.b.a().b()) {
            SmartLog.d("DecodeHandler", "this is remote, excute analyzer method");
        } else {
            a(mLFrameFromBitmap);
        }
    }

    private boolean a(String str) {
        c<String> cVar = this.i;
        if (cVar.b() || cVar.contains(str)) {
            return true;
        }
        cVar.offer(str);
        return false;
    }

    private void a(MLBankCard mLBankCard) {
        if (this.f4170a != null) {
            MLBcrCaptureResult mLBcrCaptureResult = new MLBcrCaptureResult();
            mLBcrCaptureResult.setNumber(mLBankCard.getNumber());
            if (this.b.a().getResultType() == 1 || this.g.f() == 1) {
                mLBcrCaptureResult.setExpire(mLBankCard.getExpire());
            }
            mLBcrCaptureResult.setOriginalBitmap(mLBankCard.getOriginalBitmap());
            mLBcrCaptureResult.setNumberBitmap(mLBankCard.getNumberBitmap());
            if (this.b.a().getResultType() == 2 || this.g.f() == 2) {
                mLBcrCaptureResult.setExpire(mLBankCard.getExpire());
                mLBcrCaptureResult.setIssuer(mLBankCard.getIssuer());
                mLBcrCaptureResult.setType(mLBankCard.getType());
                mLBcrCaptureResult.setOrganization(mLBankCard.getOrganization());
                if ((mLBcrCaptureResult.getOrganization() == null || TextUtils.isEmpty(mLBcrCaptureResult.getOrganization())) && mLBankCard.getNumber() != null) {
                    mLBcrCaptureResult.setOrganization(n.a().a(mLBankCard.getNumber()));
                }
            }
            Message.obtain(this.f4170a, R.id.mlkit_bcr_decode_succeeded, mLBcrCaptureResult).sendToTarget();
        }
    }

    private void a(MLFrame mLFrame) {
        this.d.asyncAnalyseFrame(mLFrame).addOnSuccessListener(new b()).addOnFailureListener(new a());
    }
}

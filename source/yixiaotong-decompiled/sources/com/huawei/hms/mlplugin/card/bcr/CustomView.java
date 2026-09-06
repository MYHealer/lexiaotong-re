package com.huawei.hms.mlplugin.card.bcr;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.huawei.hms.mlplugin.card.bcr.common.CustomInfo;
import com.huawei.hms.mlplugin.card.bcr.view.ProviderView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class CustomView extends FrameLayout implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4157a;
    private ProviderView b;
    private SurfaceView c;
    private boolean d;
    private b e;
    private Rect f;
    private int g;
    private int h;
    private int i;
    private OnBcrResultCallback j;
    private OnSnResultCallback k;
    private OnSnCheckRule l;

    public static class Builder {
        public static final int RESULT_ALL = 2;
        public static final int RESULT_NUM_ONLY = 0;
        public static final int RESULT_SIMPLE = 1;
        public static final int SIMPLE_MODE = 0;
        public static final int SN_TYPE = 1;
        public static final int STRICT_MODE = 1;
        OnBcrResultCallback mBcrResultCallback;
        Activity mContext;
        Rect mRect;
        OnSnCheckRule mSnCheckRule;
        OnSnResultCallback mSnResultCallback;
        boolean mIsCustomed = true;
        int mRecType = 0;
        int mRecMode = 1;
        int mResultType = 1;

        public CustomView build() {
            return new CustomView(this.mContext, this.mIsCustomed, this.mRect, this.mRecType, this.mRecMode, this.mResultType, this.mBcrResultCallback, this.mSnResultCallback, this.mSnCheckRule);
        }

        public Builder setBoundingBox(Rect rect) {
            this.mRect = rect;
            return this;
        }

        public Builder setContext(Activity activity) {
            this.mContext = activity;
            return this;
        }

        public Builder setIsCustomView(boolean z) {
            this.mIsCustomed = z;
            return this;
        }

        public Builder setOnBcrResultCallback(OnBcrResultCallback onBcrResultCallback) {
            this.mBcrResultCallback = onBcrResultCallback;
            return this;
        }

        public Builder setOnSnCheckRule(OnSnCheckRule onSnCheckRule) {
            this.mSnCheckRule = onSnCheckRule;
            return this;
        }

        public Builder setOnSnResultCallback(OnSnResultCallback onSnResultCallback) {
            this.mSnResultCallback = onSnResultCallback;
            return this;
        }

        public Builder setRecMode(int i) {
            this.mRecMode = i;
            return this;
        }

        public Builder setRecType(int i) {
            this.mRecType = i;
            return this;
        }

        public Builder setResultType(int i) {
            this.mResultType = i;
            return this;
        }
    }

    public interface OnBcrResultCallback {
        void onBcrResult(MLBcrCaptureResult mLBcrCaptureResult);
    }

    public interface OnSnCheckRule {
        String onSnCheck(String str);
    }

    public interface OnSnResultCallback {
        void onSnResult(MLSnCaptureResult mLSnCaptureResult);
    }

    CustomView(Activity activity, boolean z, Rect rect, int i, int i2, int i3, OnBcrResultCallback onBcrResultCallback, OnSnResultCallback onSnResultCallback, OnSnCheckRule onSnCheckRule) {
        super(activity);
        this.f4157a = activity;
        this.d = z;
        this.f = rect;
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.j = onBcrResultCallback;
        this.k = onSnResultCallback;
        this.l = onSnCheckRule;
        if (i == 0) {
            activity.getWindow().setFlags(8192, 8192);
        }
    }

    public void onCreate(Bundle bundle) {
        ProviderView providerView = new ProviderView(this.f4157a, this.d);
        this.b = providerView;
        this.c = (SurfaceView) providerView.findViewById(R.id.IDpreview_view);
        removeAllViews();
        addView(this.b);
        b bVar = new b(this.f4157a, this, this.c, new CustomInfo(true, this.f, this.g, this.h, this.i), this.l);
        this.e = bVar;
        bVar.b();
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.huawei.hms.mlplugin.card.bcr.h
    public void a(MLBcrCaptureResult mLBcrCaptureResult) {
        OnBcrResultCallback onBcrResultCallback = this.j;
        if (onBcrResultCallback != null) {
            onBcrResultCallback.onBcrResult(mLBcrCaptureResult);
        }
    }

    public boolean getLightStatus() {
        b bVar = this.e;
        if (bVar != null) {
            return bVar.a();
        }
        return false;
    }

    public final void onDestroy() {
        b bVar = this.e;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void onPause() {
        b bVar = this.e;
        if (bVar != null) {
            bVar.d();
        }
    }

    public final void onResume() {
        b bVar = this.e;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void switchLight() {
        b bVar = this.e;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.huawei.hms.mlplugin.card.bcr.h
    public void a(MLSnCaptureResult mLSnCaptureResult) {
        OnSnResultCallback onSnResultCallback = this.k;
        if (onSnResultCallback != null) {
            onSnResultCallback.onSnResult(mLSnCaptureResult);
        }
    }
}

package com.huawei.hms.mlkit.bcr;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorFrameParcel;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorOptionsParcel;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorParcel;
import com.huawei.hms.ml.common.card.bcr.IRemoteBcrDecoderDelegate;
import com.huawei.hms.ml.common.utils.NV21ToBitmapConverter1;
import com.huawei.hms.mlkit.common.ha.HianalyticsLog;
import com.huawei.hms.mlkit.common.ha.HianalyticsLogProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class BcrDecoderImpl extends IRemoteBcrDecoderDelegate.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4138a;
    private NV21ToBitmapConverter1 b;
    private HianalyticsLogProvider c;
    private HianalyticsLog d;

    static /* synthetic */ class a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static BcrDecoderImpl f4139a = new BcrDecoderImpl(null);
    }

    /* synthetic */ BcrDecoderImpl(a aVar) {
        this();
    }

    private int a(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 90;
        }
        if (i == 2) {
            return 180;
        }
        if (i != 3) {
            return i;
        }
        return 270;
    }

    public static BcrDecoderImpl a() {
        return b.f4139a;
    }

    @Override // com.huawei.hms.ml.common.card.bcr.IRemoteBcrDecoderDelegate
    public int destroy() throws RemoteException {
        HianalyticsLogProvider.getInstance().reportAndCancelTimer("MLKitBCR");
        return com.huawei.hms.mlkit.bcr.b.b().a();
    }

    @Override // com.huawei.hms.ml.common.card.bcr.IRemoteBcrDecoderDelegate
    public BcrDetectorParcel detect(Bundle bundle, BcrDetectorFrameParcel bcrDetectorFrameParcel, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) throws RemoteException {
        if (bundle == null) {
            throw new RemoteException("Argument:bundle must be mandatory");
        }
        if (bcrDetectorFrameParcel == null) {
            throw new RemoteException("Argument:frame must be mandatory");
        }
        a(this.f4138a, bundle);
        BcrDetectorParcel bcrDetectorParcelA = com.huawei.hms.mlkit.bcr.b.b().a(a(bcrDetectorFrameParcel), bcrDetectorOptionsParcel);
        this.c.logEnd(this.d);
        return bcrDetectorParcelA;
    }

    @Override // com.huawei.hms.ml.common.card.bcr.IRemoteBcrDecoderDelegate
    public int initial(IObjectWrapper iObjectWrapper, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) throws RemoteException {
        Bundle bundle;
        HianalyticsLogProvider.getInstance().initTimer("MLKitBCR");
        this.f4138a = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.b = new NV21ToBitmapConverter1(this.f4138a);
        if (bcrDetectorOptionsParcel != null && (bundle = bcrDetectorOptionsParcel.bundle) != null) {
            a(this.f4138a, bundle);
        }
        return com.huawei.hms.mlkit.bcr.b.b().a(this.f4138a);
    }

    private BcrDecoderImpl() {
        this.f4138a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    private void a(Context context, Bundle bundle) {
        HianalyticsLogProvider hianalyticsLogProvider = HianalyticsLogProvider.getInstance();
        this.c = hianalyticsLogProvider;
        this.d = hianalyticsLogProvider.logBegin(context, bundle).setApiName("MLKitBCR").setModuleName("MLKitBCR").setApkVersion("3.7.0.302");
    }

    private Bitmap a(BcrDetectorFrameParcel bcrDetectorFrameParcel) {
        if (bcrDetectorFrameParcel.bytes == null) {
            return bcrDetectorFrameParcel.bitmap;
        }
        if (this.b == null) {
            return Bitmap.createBitmap(32, 32, Bitmap.Config.ARGB_8888);
        }
        int i = bcrDetectorFrameParcel.width;
        int i2 = bcrDetectorFrameParcel.height;
        int iA = a(bcrDetectorFrameParcel.rotation);
        boolean z = iA == 0 || iA == 180;
        return this.b.convert(bcrDetectorFrameParcel.bytes, i, i2, z ? i : i2, z ? i2 : i, iA);
    }

    public int initial(Context context, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) throws RemoteException {
        HianalyticsLogProvider.getInstance().initTimer("MLKitBCR");
        this.f4138a = context;
        this.b = new NV21ToBitmapConverter1(this.f4138a);
        Bundle bundle = bcrDetectorOptionsParcel.bundle;
        if (bundle != null) {
            a(this.f4138a, bundle);
        }
        return com.huawei.hms.mlkit.bcr.b.b().a(this.f4138a);
    }
}

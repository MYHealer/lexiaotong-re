package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.scankit.p.i3;
import com.huawei.hms.scankit.p.x3;

/* JADX INFO: compiled from: HmsRemoteDecoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile IRemoteHmsDecoderDelegate f4121a;

    static HmsScan[] a(Context context, MLFrame mLFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        DetailRect detailRect;
        HmsScan[] hmsScanArrDetectWithByteBuffer;
        int i;
        HmsScan[] hmsScanArr = new HmsScan[0];
        if (f4121a == null) {
            IRemoteCreator iRemoteCreatorC = f.c(context);
            if (iRemoteCreatorC == null) {
                return hmsScanArr;
            }
            try {
                f4121a = iRemoteCreatorC.newRemoteHmsDecoderDelegate();
            } catch (RemoteException unused) {
                x3.b("exception", "RemoteException");
            }
        }
        if (f4121a != null) {
            try {
                if (mLFrame.acquireProperty() != null) {
                    detailRect = new DetailRect(mLFrame.acquireProperty().getWidth(), mLFrame.acquireProperty().getHeight());
                } else {
                    detailRect = new DetailRect();
                }
                Bundle bundle = new Bundle();
                if (hmsScanAnalyzerOptions != null && (i = hmsScanAnalyzerOptions.mode) != 0) {
                    bundle.putInt(DetailRect.FORMAT_FLAG, i);
                }
                bundle.putInt(DetailRect.TYPE_TRANS, 3);
                bundle.putAll(i3.a(context));
                if (mLFrame.readBitmap() != null) {
                    hmsScanArrDetectWithByteBuffer = f4121a.decodeInBitmap(detailRect, ObjectWrapper.wrap(mLFrame.readBitmap()), ObjectWrapper.wrap(bundle));
                } else {
                    hmsScanArrDetectWithByteBuffer = f4121a.detectWithByteBuffer(detailRect, ObjectWrapper.wrap(mLFrame.acquireGrayByteBuffer()), ObjectWrapper.wrap(bundle));
                }
                if (hmsScanArrDetectWithByteBuffer != null) {
                    return hmsScanArrDetectWithByteBuffer;
                }
            } catch (RemoteException unused2) {
                x3.b("exception", "RemoteException");
            }
        }
        return hmsScanArr;
    }
}

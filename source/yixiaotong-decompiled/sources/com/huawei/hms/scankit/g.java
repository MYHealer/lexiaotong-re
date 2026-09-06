package com.huawei.hms.scankit;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.g3;
import com.huawei.hms.scankit.p.v5;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.y6;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: IRemoteHmsDecoderDelegateImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class g extends IRemoteHmsDecoderDelegate.Stub {
    private static volatile g b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile g3 f4204a = null;

    static g a() {
        return b;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
    public HmsScan[] decodeInBitmap(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Bundle bundleA = a(iObjectWrapper2);
        if (this.f4204a == null) {
            try {
                this.f4204a = new g3(bundleA, "MultiProcessor");
            } catch (RuntimeException unused) {
                x3.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                x3.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        return a(iObjectWrapper, iObjectWrapper2);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
    public HmsScan[] detectWithByteBuffer(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Bundle bundleA = a(iObjectWrapper2);
        if (this.f4204a == null) {
            try {
                this.f4204a = new g3(bundleA, "MultiProcessor");
            } catch (RuntimeException unused) {
                x3.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                x3.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        return a(detailRect, iObjectWrapper, iObjectWrapper2);
    }

    private Bundle a(IObjectWrapper iObjectWrapper) {
        return (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) ? new Bundle() : (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z;
        boolean z2;
        int iB;
        if (iObjectWrapper == null) {
            x3.b("ScankitRemoteS", "bitmap is null");
            return new HmsScan[0];
        }
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z = false;
            z2 = false;
            iB = 0;
        } else {
            z2 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PHOTO_MODE, false);
            iB = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            int i = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i;
            z = i >= 2;
            if (z) {
                iB = y6.b(iB);
            }
        }
        if (!(objUnwrap instanceof Bitmap)) {
            return new HmsScan[0];
        }
        HmsScan[] hmsScanArrA = v5.a().a((Bitmap) objUnwrap, iB, z2, this.f4204a);
        return !z ? y6.a(hmsScanArrA) : hmsScanArrA;
    }

    private HmsScan[] a(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z;
        int i;
        boolean z2;
        if (iObjectWrapper == null) {
            x3.b("ScankitRemoteS", "bytebuffer is null");
            return new HmsScan[0];
        }
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z = false;
            i = 0;
            z2 = false;
        } else {
            int iB = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            boolean z3 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PHOTO_MODE, false);
            int i2 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i2;
            z = i2 >= 2;
            if (z) {
                iB = y6.b(iB);
            }
            i = iB;
            z2 = z3;
        }
        if (!(objUnwrap instanceof ByteBuffer)) {
            return new HmsScan[0];
        }
        HmsScan[] hmsScanArrA = v5.a().a((ByteBuffer) objUnwrap, detailRect == null ? 1000 : detailRect.width, detailRect == null ? 1000 : detailRect.height, i, z2, this.f4204a);
        return !z ? y6.a(hmsScanArrA) : hmsScanArrA;
    }
}

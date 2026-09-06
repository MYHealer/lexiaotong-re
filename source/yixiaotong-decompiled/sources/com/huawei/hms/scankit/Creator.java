package com.huawei.hms.scankit;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.y6;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class Creator extends IRemoteCreator.Stub {
    private static final String TAG = "Creator";
    private e iRemoteViewDelegate = null;
    private f iRemoteDecoderDelegate = null;
    private g iRemoteHmsDecoderDelegate = null;

    @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
    public IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException {
        x3.c(TAG, "newRemoteDecoderDelegate()");
        f fVarA = f.a();
        this.iRemoteDecoderDelegate = fVarA;
        return fVarA;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
    public IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException {
        x3.c(TAG, "newRemoteHmsDecoderDelegate()");
        g gVarA = g.a();
        this.iRemoteHmsDecoderDelegate = gVarA;
        return gVarA;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009a  */
    /* JADX WARN: Code duplicated, block: B:32:0x009e  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c4  */
    @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
    public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcelable parcelable;
        boolean z;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        if (iObjectWrapper == null) {
            x3.b("ScankitRemoteS", "Context is null");
            return null;
        }
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        boolean z4 = false;
        if (iObjectWrapper2 != null) {
            Object objUnwrap2 = ObjectWrapper.unwrap(iObjectWrapper2);
            if (objUnwrap2 instanceof Bundle) {
                Bundle bundle = (Bundle) objUnwrap2;
                boolean z5 = bundle.getBoolean(DetailRect.CUSTOMED_FLAG, false);
                int iB = bundle.getInt(DetailRect.FORMAT_FLAG, 0);
                Parcelable parcelable2 = bundle.getParcelable(DetailRect.RECT_FLAG);
                int i3 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
                DetailRect.HMSSCAN_SDK_VALUE = i3;
                boolean z6 = i3 >= 2;
                if (z6) {
                    iB = y6.b(iB);
                }
                boolean z7 = bundle.getBoolean(DetailRect.RETURN_BITMAP, false);
                z2 = bundle.getBoolean(DetailRect.SCAN_NEW_UI, false);
                int i4 = bundle.getInt(DetailRect.SCAN_VIEWTYPE_FLAG, 0);
                if (z2 && (objUnwrap instanceof Context)) {
                    try {
                        com.huawei.hms.hmsscankit.f.b((Context) objUnwrap);
                    } catch (ClassNotFoundException unused) {
                        x3.a(TAG, "ClassNotFoundException");
                    } catch (IllegalAccessException unused2) {
                        x3.a(TAG, "IllegalAccessException");
                    } catch (NoSuchMethodException unused3) {
                        x3.a(TAG, "NoSuchMethodException");
                    } catch (InvocationTargetException unused4) {
                        x3.a(TAG, "InvocationTargetException");
                    }
                }
                z = z6;
                z3 = z7;
                parcelable = parcelable2;
                i2 = iB;
                z4 = z5;
                i = i4;
            }
            if (z4) {
                if (objUnwrap instanceof Context) {
                    this.iRemoteViewDelegate = new e((Context) objUnwrap, i2, parcelable, iObjectWrapper2, z, z3, !z2);
                }
            } else if (objUnwrap instanceof Context) {
                if (z2) {
                    this.iRemoteViewDelegate = new h((Context) objUnwrap, i2, iObjectWrapper2, z, false, i);
                } else {
                    this.iRemoteViewDelegate = new i((Context) objUnwrap, i2, iObjectWrapper2, z, true);
                }
            }
            return this.iRemoteViewDelegate;
        }
        iObjectWrapper2 = ObjectWrapper.wrap(new Bundle());
        parcelable = null;
        z = false;
        i = 0;
        i2 = 0;
        z2 = false;
        z3 = false;
        if (z4) {
            if (objUnwrap instanceof Context) {
                this.iRemoteViewDelegate = new e((Context) objUnwrap, i2, parcelable, iObjectWrapper2, z, z3, !z2);
            }
        } else if (objUnwrap instanceof Context) {
            if (z2) {
                this.iRemoteViewDelegate = new h((Context) objUnwrap, i2, iObjectWrapper2, z, false, i);
            } else {
                this.iRemoteViewDelegate = new i((Context) objUnwrap, i2, iObjectWrapper2, z, true);
            }
        }
        return this.iRemoteViewDelegate;
    }
}

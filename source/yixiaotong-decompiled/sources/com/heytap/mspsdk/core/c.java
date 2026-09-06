package com.heytap.mspsdk.core;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.heytap.msp.ipc.a.f;
import com.heytap.msp.ipc.a.g;
import com.heytap.msp.ipc.annotation.IPCType;
import com.heytap.mspsdk.constants.MspSdkCode;
import com.heytap.mspsdk.exception.MspSdkException;
import com.heytap.mspsdk.log.MspLog;
import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {

    /* JADX INFO: renamed from: com.heytap.mspsdk.core.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3460a;

        static {
            int[] iArr = new int[IPCType.values().length];
            f3460a = iArr;
            try {
                iArr[IPCType.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3460a[IPCType.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3460a[IPCType.PROVIDER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3460a[IPCType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static <T> g a(Context context, Class<T> cls, Parcelable parcelable, Bundle bundle) {
        com.heytap.msp.ipc.annotation.b bVar;
        Annotation[] annotations = cls.getAnnotations();
        int length = annotations.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                bVar = null;
                break;
            }
            Annotation annotation = annotations[i];
            MspLog.iIgnore("ProxyCompat", "annotation name is " + annotation.annotationType().getSimpleName());
            if (annotation instanceof com.heytap.msp.ipc.annotation.b) {
                bVar = (com.heytap.msp.ipc.annotation.b) annotation;
                MspLog.iIgnore("ProxyCompat", "ipcModule is " + bVar);
                break;
            }
            i++;
        }
        if (bVar == null) {
            throw new MspSdkException(2007, MspSdkCode.EXCEPTION_MSG_2007_NO_VALID_ANNOTATION);
        }
        int i2 = AnonymousClass1.f3460a[bVar.a().ordinal()];
        if (i2 == 1) {
            return new com.heytap.msp.ipc.a.d(context, bVar, bundle);
        }
        if (i2 == 2) {
            return new f(context, bVar, parcelable, bundle);
        }
        if (i2 == 3) {
            return new com.heytap.msp.ipc.a.e(context, bVar, parcelable, bundle);
        }
        throw new MspSdkException(2007, MspSdkCode.EXCEPTION_MSG_2007_ANNOTATION_ERROR);
    }
}

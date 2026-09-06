package com.fancy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface _hn extends IInterface {

    public static class _a implements _hn {
        public IBinder _a;

        public _a(IBinder iBinder) {
            this._a = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this._a;
        }
    }

    public static abstract class _b extends Binder implements _hn {
        public static final /* synthetic */ int _a = 0;
    }
}

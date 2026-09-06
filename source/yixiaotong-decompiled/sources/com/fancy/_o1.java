package com.fancy;

import com.fancy.adsdk.lib.constants.PtgErrorCode;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _o1 implements Runnable {
    public final /* synthetic */ _o2 _a;

    public _o1(_o2 _o2Var) {
        this._a = _o2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _o2 _o2Var;
        _v _vVar;
        if (this._a._p || (_vVar = (_o2Var = this._a)._c) == null) {
            return;
        }
        _vVar._a(_o2Var, PtgErrorCode.SDK_RESOURCE_ERROR, new Exception("开屏模版素材加载失败"));
    }
}

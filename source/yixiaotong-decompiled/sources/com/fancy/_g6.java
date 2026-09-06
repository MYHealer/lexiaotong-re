package com.fancy;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _g6 {

    public class _a implements _a4 {
        public final /* synthetic */ _a4 _a;

        public _a(_a4 _a4Var) {
            this._a = _a4Var;
        }

        @Override // com.fancy._a4
        public final void _a(String str) {
            _a4 _a4Var = this._a;
            if (_a4Var != null) {
                _a4Var._a(str);
            }
        }
    }

    public static void _a(Context context, _a4 _a4Var) {
        try {
            new _g5(context)._a(new _a(_a4Var));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

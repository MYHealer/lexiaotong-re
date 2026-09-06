package com.masget.base.volley;

import com.android.volley.VolleyError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class StringResponseHandler {
    public abstract void onFail(VolleyError volleyError);

    public abstract void onSuccess(String str);
}

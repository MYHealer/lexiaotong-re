package com.baidu.oauth.sdkbqt.auth;

import android.text.TextUtils;
import android.webkit.JsPromptResult;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1895a;
    final /* synthetic */ JsPromptResult b;
    final /* synthetic */ String[] c;
    final /* synthetic */ u d;

    w(u uVar, String str, JsPromptResult jsPromptResult, String[] strArr) {
        this.d = uVar;
        this.f1895a = str;
        this.b = jsPromptResult;
        this.c = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        i.e eVarA = i.e.a(this.f1895a);
        if (eVarA != null) {
            String strA = eVarA.a();
            if ("oauth_sso_hash".equals(strA)) {
                this.d.f1893a.u = this.b;
            }
            if (!TextUtils.isEmpty(strA) && this.d.f1893a.d.get(strA) != null) {
                this.c[0] = ((i.a) this.d.f1893a.d.get(strA)).a(eVarA);
            }
            if (eVarA.b().size() > 2 && "prompt_on_cancel".equals(eVarA.b().get(2))) {
                this.b.cancel();
                return;
            } else {
                if ("oauth_sso_hash".equals(strA)) {
                    return;
                }
                this.b.confirm(this.c[0]);
                return;
            }
        }
        this.b.cancel();
    }
}

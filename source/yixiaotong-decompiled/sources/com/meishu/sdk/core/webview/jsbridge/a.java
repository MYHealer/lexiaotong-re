package com.meishu.sdk.core.webview.jsbridge;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.utils.a1;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.o0;
import com.meishu.sdk.core.utils.u;
import com.meishu.sdk.core.webview.jsbridge.bean.InvokeDeepLinkParam;
import com.meishu.sdk.platform.ms.c;

/* JADX INFO: compiled from: InvokeDeepLink.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.meishu.sdk.core.webview.jsbridge.bean.a f4982a;
    public final c b;

    /* JADX INFO: renamed from: com.meishu.sdk.core.webview.jsbridge.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: InvokeDeepLink.java */
    public interface InterfaceC0823a {
        void a(int i, String str);
    }

    public a(c cVar) {
        this.b = cVar;
        if (cVar != null) {
            try {
                if (cVar.a() != null) {
                    Gson gson = u.f4948a;
                    this.f4982a = (com.meishu.sdk.core.webview.jsbridge.bean.a) gson.fromJson(gson.toJson(cVar.a()), com.meishu.sdk.core.webview.jsbridge.bean.a.class);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(InvokeDeepLinkParam invokeDeepLinkParam, final InterfaceC0823a interfaceC0823a) {
        String string;
        try {
            if (TextUtils.isEmpty(invokeDeepLinkParam.getDeep_link())) {
                if (interfaceC0823a != null) {
                    interfaceC0823a.a(1002, "depp_link为空");
                    return;
                }
                return;
            }
            a1.a(this.f4982a, 22, 0, "js_dp_start");
            if (f.a(invokeDeepLinkParam.getDeep_link())) {
                this.f4982a.deep_link = invokeDeepLinkParam.getDeep_link();
                f.a(AdSdk.getContext(), this.f4982a, this.b, false, true, new o0.a() { // from class: com.meishu.sdk.core.webview.jsbridge.a$$ExternalSyntheticLambda0
                    @Override // com.meishu.sdk.core.utils.o0.a
                    public final void a(boolean z) {
                        this.f$0.a(interfaceC0823a, z);
                    }
                });
            } else if (interfaceC0823a != null) {
                interfaceC0823a.a(1001, "唤起失败. 未安装");
            }
        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder sb = new StringBuilder("未知错误:");
            try {
                string = e.toString();
            } catch (Exception unused) {
                string = "";
            }
            String string2 = sb.append(string).toString();
            if (interfaceC0823a != null) {
                interfaceC0823a.a(1002, string2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC0823a interfaceC0823a, boolean z) {
        if (!z) {
            if (interfaceC0823a != null) {
                interfaceC0823a.a(1001, "唤起失败");
            }
        } else {
            a1.a(this.f4982a, 23, 0, "js_dp_success");
            if (interfaceC0823a != null) {
                interfaceC0823a.a(1000, "唤起成功");
            }
        }
    }
}

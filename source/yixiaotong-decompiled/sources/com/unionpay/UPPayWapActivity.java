package com.unionpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.stub.StubApp;
import com.ubixnow.ooooo.oOOOoo00;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UPPayWapActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f9303a = "ex_mode";
    private WebView b;
    private WebViewJavascriptBridge c;
    private AlertDialog d;
    private boolean e = false;
    private String f = "";
    private String g;
    private View h;
    private ab i;

    static {
        StubApp.interface11(54254);
    }

    private View a(RelativeLayout relativeLayout, View.OnClickListener onClickListener) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundDrawable(com.unionpay.utils.g.a(com.unionpay.utils.h.b));
        int iA = com.unionpay.utils.f.a(this, 24.0f);
        int iA2 = com.unionpay.utils.f.a(this, 18.0f);
        int iA3 = com.unionpay.utils.f.a(this, 14.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(10, -1);
        layoutParams.setMargins(iA2, iA3, 0, 0);
        relativeLayout.addView(imageView, layoutParams);
        if (onClickListener == null) {
            imageView.setOnClickListener(new m(this));
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        return imageView;
    }

    static /* synthetic */ void a(UPPayWapActivity uPPayWapActivity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(uPPayWapActivity);
        uPPayWapActivity.d = builder.create();
        builder.setMessage(com.unionpay.utils.k.a().f9365a);
        builder.setTitle(com.unionpay.utils.k.a().d);
        builder.setPositiveButton(com.unionpay.utils.k.a().b, new o(uPPayWapActivity));
        builder.setNegativeButton(com.unionpay.utils.k.a().c, new p(uPPayWapActivity));
        builder.create().show();
    }

    static /* synthetic */ void a(UPPayWapActivity uPPayWapActivity, boolean z) {
        View view = uPPayWapActivity.h;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("pay_result", str);
        intent.putExtra("result_data", str2);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject("{\"code\":\"0\",\"msg\":\"success\"}");
            if (str != null) {
                jSONObject.put("code", str);
            }
            if (str2 != null) {
                jSONObject.put("msg", str2);
            }
            if (str3 != null) {
                jSONObject.put(oOOOoo00.OooOo0o, str3);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject("{\"code\":\"0\",\"msg\":\"success\"}");
            if (str != null) {
                jSONObject2.put("code", str);
            }
            if (str2 != null) {
                jSONObject2.put("msg", str2);
            }
            if (jSONObject != null) {
                jSONObject2.put(oOOOoo00.OooOo0o, jSONObject);
            }
            return jSONObject2.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String string;
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String str = "";
                    if (extras.containsKey("pay_result")) {
                        string = extras.getString("pay_result");
                    } else {
                        string = extras.containsKey("code") ? extras.getString("code") : "";
                    }
                    if (TextUtils.isEmpty(string)) {
                        string = "";
                    }
                    String string2 = extras.containsKey("data") ? extras.getString("data") : "";
                    if (!TextUtils.isEmpty(string2)) {
                        str = string2;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", string);
                    jSONObject.put("data", str);
                    ab abVar = this.i;
                    if (abVar != null) {
                        abVar.a(b("0", (String) null, jSONObject));
                    }
                } else {
                    ab abVar2 = this.i;
                    if (abVar2 != null) {
                        abVar2.a(b("1", "No pay result", (String) null));
                    }
                }
            } catch (Exception unused) {
                ab abVar3 = this.i;
                if (abVar3 != null) {
                    abVar3.a(b("1", "No pay result", (String) null));
                }
            }
            this.i = null;
        }
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.e) {
            WebView webView = this.b;
            if (webView != null && webView.canGoBack()) {
                this.b.goBack();
                return true;
            }
            a(Constant.CASH_LOAD_CANCEL, (String) null);
        } else {
            onPause();
        }
        return true;
    }
}

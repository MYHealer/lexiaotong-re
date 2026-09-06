package com.hihonor.adsdk.base.widget.web.jsbridge;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class JsBridgeWebView extends MyWebView {
    private static final String hnadso = "dsBridge";
    private static final String hnadsp = "_dsbridge";
    private final Map<String, Object> hnadsi;
    private final InnerJavascriptInterface hnadsj;
    private final Handler hnadsk;
    private final Map<Integer, b> hnadsl;
    private int hnadsm;
    private ArrayList<a> hnadsn;

    private class InnerJavascriptInterface {

        class a implements com.hihonor.adsdk.base.widget.web.jsbridge.a<Object> {
            final /* synthetic */ String hnadsa;

            a(String str) {
                this.hnadsa = str;
            }

            @Override // com.hihonor.adsdk.base.widget.web.jsbridge.a
            public void hnadsa(Object obj) {
                hnadsa(obj, false);
            }

            @Override // com.hihonor.adsdk.base.widget.web.jsbridge.a
            public void hnadsb(Object obj) {
                hnadsa(obj, true);
            }

            private void hnadsa(Object obj, boolean z) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put("data", obj);
                    String str = this.hnadsa;
                    if (str != null) {
                        String str2 = String.format(Locale.ENGLISH, "%s(%s.data);", str, jSONObject);
                        if (z) {
                            str2 = str2 + "delete window." + this.hnadsa;
                        }
                        JsBridgeWebView.this.hnadsa(str2);
                    }
                } catch (Exception e) {
                    com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "complete, Exception: " + e.getMessage(), new Object[0]);
                }
            }

            @Override // com.hihonor.adsdk.base.widget.web.jsbridge.a
            public void hnadsb() {
                hnadsa(null, true);
            }
        }

        private InnerJavascriptInterface() {
        }

        @JavascriptInterface
        public String call(String str, String str2) {
            boolean z;
            Method method;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", -1);
            } catch (JSONException e) {
                com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "call, ret JSONException: " + e.getMessage(), new Object[0]);
            }
            if (TextUtils.isEmpty(str)) {
                com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "call methodName is null", new Object[0]);
                return jSONObject.toString();
            }
            String[] strArrHnadse = JsBridgeWebView.this.hnadse(str.trim());
            if (strArrHnadse == null || strArrHnadse.length < 2) {
                com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "call,parseNamespace return is null or array.length < 2", new Object[0]);
                return jSONObject.toString();
            }
            String str3 = strArrHnadse[1];
            Object obj = JsBridgeWebView.this.hnadsi.get(strArrHnadse[0]);
            if (obj == null) {
                com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "Js bridge  called, but can't find a corresponded JavascriptInterface object , please check your code!", new Object[0]);
                return jSONObject.toString();
            }
            try {
                JSONObject jSONObject2 = new JSONObject(str2);
                String string = jSONObject2.has("_dscbstub") ? jSONObject2.getString("_dscbstub") : null;
                Object obj2 = jSONObject2.has("data") ? jSONObject2.get("data") : null;
                Class<?> cls = obj.getClass();
                try {
                    method = cls.getMethod(str3, Object.class, com.hihonor.adsdk.base.widget.web.jsbridge.a.class);
                    z = true;
                } catch (Exception e2) {
                    com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "call, class get method object and completionhandler error, Exception: " + e2.getMessage(), new Object[0]);
                    try {
                        method = cls.getMethod(str3, Object.class);
                        z = false;
                    } catch (Exception e3) {
                        com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "call, class get method object error, Exception: " + e3.getMessage(), new Object[0]);
                        z = false;
                        method = null;
                    }
                }
                if (method == null) {
                    com.hihonor.adsdk.common.b.b.hnadsa(JsBridgeWebView.hnadso, (Object) ("Not find method \"" + str3 + "\" implementation! please check if the  signature or namespace of the method is right "));
                    return jSONObject.toString();
                }
                if (((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) == null) {
                    com.hihonor.adsdk.common.b.b.hnadsa(JsBridgeWebView.hnadso, (Object) ("Method " + str3 + " is not invoked, since it is not declared with JavascriptInterface annotation! "));
                    return jSONObject.toString();
                }
                method.setAccessible(true);
                try {
                    if (z) {
                        method.invoke(obj, obj2, new a(string));
                        return jSONObject.toString();
                    }
                    Object objInvoke = method.invoke(obj, obj2);
                    jSONObject.put("code", 0);
                    jSONObject.put("data", objInvoke);
                    return jSONObject.toString();
                } catch (Exception e4) {
                    com.hihonor.adsdk.common.b.b.hnadsa(JsBridgeWebView.hnadso, (Object) String.format(Locale.ENGLISH, "Call failed：The parameter of \"%s\" in Java is invalid: %s", str3, e4.getMessage()));
                    return jSONObject.toString();
                }
            } catch (JSONException unused) {
                com.hihonor.adsdk.common.b.b.hnadsa(JsBridgeWebView.hnadso, (Object) String.format(Locale.ENGLISH, "The argument of \"%s\" must be a JSON object string!", str3));
                return jSONObject.toString();
            }
        }
    }

    private static class a {
        private final String hnadsa;
        private final int hnadsb;
        private final String hnadsc;

        a(String str, int i, Object[] objArr) {
            this.hnadsa = new JSONArray((Collection) Arrays.asList(objArr == null ? new Object[0] : objArr)).toString();
            this.hnadsb = i;
            this.hnadsc = str;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", this.hnadsc);
                jSONObject.put("callbackId", this.hnadsb);
                jSONObject.put("data", this.hnadsa);
            } catch (JSONException e) {
                com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "toString, Exception: " + e.getMessage(), new Object[0]);
            }
            return jSONObject.toString();
        }
    }

    public JsBridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hnadsi = new HashMap();
        this.hnadsj = new InnerJavascriptInterface();
        this.hnadsk = new Handler(Looper.getMainLooper());
        this.hnadsl = new HashMap();
        this.hnadsm = 0;
        hnadsd();
    }

    private void addInternalJavascriptObject() {
        hnadsa(new Object() { // from class: com.hihonor.adsdk.base.widget.web.jsbridge.JsBridgeWebView.1

            /* JADX INFO: renamed from: com.hihonor.adsdk.base.widget.web.jsbridge.JsBridgeWebView$1$a */
            class a implements Runnable {
                final /* synthetic */ Object hnadsd;

                a(Object obj) {
                    this.hnadsd = obj;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Object obj = this.hnadsd;
                    if (!(obj instanceof JSONObject)) {
                        com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "returnValue,obj is not instanceof JSONObject", new Object[0]);
                        return;
                    }
                    JSONObject jSONObject = (JSONObject) obj;
                    try {
                        int i = jSONObject.getInt("id");
                        boolean z = jSONObject.getBoolean("complete");
                        b bVar = (b) JsBridgeWebView.this.hnadsl.get(Integer.valueOf(i));
                        Object obj2 = jSONObject.has("data") ? jSONObject.get("data") : null;
                        if (bVar != null) {
                            bVar.hnadsa(obj2);
                            if (z) {
                                JsBridgeWebView.this.hnadsl.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (JSONException e) {
                        com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "returnValue, JSONException: " + e.getMessage(), new Object[0]);
                    }
                }
            }

            @JavascriptInterface
            public String closePage(Object obj) throws JSONException {
                return null;
            }

            @JavascriptInterface
            public void disableJavascriptDialogBlock(Object obj) throws JSONException {
            }

            @JavascriptInterface
            public void dsinit(Object obj) {
                JsBridgeWebView.this.hnadsc();
            }

            @JavascriptInterface
            public boolean hasNativeMethod(Object obj) throws JSONException {
                Method method;
                boolean z;
                if (!(obj instanceof JSONObject)) {
                    com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "hasNativeMethod,obj is not instanceof JSONObject", new Object[0]);
                    return false;
                }
                JSONObject jSONObject = (JSONObject) obj;
                String strTrim = jSONObject.getString("name").trim();
                String strTrim2 = jSONObject.getString("type").trim();
                String[] strArrHnadse = JsBridgeWebView.this.hnadse(strTrim);
                if (strArrHnadse == null || strArrHnadse.length < 2) {
                    com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "hasNativeMethod,parseNamespace return is null or array.length < 2", new Object[0]);
                    return false;
                }
                Object obj2 = JsBridgeWebView.this.hnadsi.get(strArrHnadse[0]);
                if (obj2 == null) {
                    com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "hasNativeMethod,javaScriptNamespaceInterfaces not contains this obj", new Object[0]);
                    return false;
                }
                Class<?> cls = obj2.getClass();
                try {
                    method = cls.getMethod(strArrHnadse[1], Object.class, com.hihonor.adsdk.base.widget.web.jsbridge.a.class);
                    z = true;
                } catch (Exception e) {
                    com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "hasNativeMethod, class getMethod object and completionHandler error, Exception: " + e.getMessage(), new Object[0]);
                    try {
                        method = cls.getMethod(strArrHnadse[1], Object.class);
                    } catch (Exception e2) {
                        com.hihonor.adsdk.common.b.b.hnadsb(JsBridgeWebView.hnadso, "hasNativeMethod, class getMethod object error, Exception: " + e2.getMessage(), new Object[0]);
                        method = null;
                    }
                    z = false;
                }
                if (method == null || ((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) == null) {
                    return false;
                }
                return TtmlNode.COMBINE_ALL.equals(strTrim2) || (z && "asyn".equals(strTrim2)) || (!z && "syn".equals(strTrim2));
            }

            @JavascriptInterface
            public void returnValue(Object obj) {
                JsBridgeWebView.this.hnadsa(new a(obj));
            }
        }, "_dsb");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] hnadse(String str) {
        String strSubstring = "";
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring = str.substring(0, iLastIndexOf);
            str = str.substring(iLastIndexOf + 1);
        }
        return new String[]{strSubstring, str};
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.hnadsk.removeCallbacksAndMessages(null);
        this.hnadsl.clear();
        this.hnadsi.clear();
        stopLoading();
        setWebChromeClient(null);
        super.destroy();
    }

    public void hnadsf(String str) {
        if (str == null) {
            str = "";
        }
        this.hnadsi.remove(str);
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String str) {
        hnadsa(new Runnable() { // from class: com.hihonor.adsdk.base.widget.web.jsbridge.JsBridgeWebView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsd(str);
            }
        });
    }

    @Override // android.webkit.WebView
    public void reload() {
        hnadsa(new Runnable() { // from class: com.hihonor.adsdk.base.widget.web.jsbridge.JsBridgeWebView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadse();
            }
        });
    }

    private void hnadsd() {
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        removeJavascriptInterface("searchBoxJavaBridge_");
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowContentAccess(false);
        settings.setGeolocationEnabled(false);
        settings.setSavePassword(false);
        addInternalJavascriptObject();
        addJavascriptInterface(this.hnadsj, hnadsp);
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String str, final Map<String, String> map) {
        hnadsa(new Runnable() { // from class: com.hihonor.adsdk.base.widget.web.jsbridge.JsBridgeWebView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsa(str, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hnadsb, reason: merged with bridge method [inline-methods] */
    public void hnadsc(String str) {
        super.evaluateJavascript(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void hnadsc() {
        ArrayList<a> arrayList = this.hnadsn;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                hnadsa(it.next());
            }
            this.hnadsn = null;
        }
    }

    public void hnadsb(String str, b<Boolean> bVar) {
        hnadsa("_hasJavascriptMethod", new Object[]{str}, bVar);
    }

    public void hnadsa(final String str) {
        hnadsa(new Runnable() { // from class: com.hihonor.adsdk.base.widget.web.jsbridge.JsBridgeWebView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsc(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(String str, Map map) {
        if (str != null) {
            if (str.startsWith("javascript:")) {
                super.loadUrl(str, map);
            } else {
                this.hnadsn = new ArrayList<>();
                super.loadUrl(str, map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadse() {
        this.hnadsn = new ArrayList<>();
        super.reload();
    }

    private void hnadsa(a aVar) {
        hnadsa(String.format("window._handleMessageFromNative(%s)", aVar.toString()));
    }

    public synchronized <T> void hnadsa(String str, Object[] objArr, b<T> bVar) {
        int i = this.hnadsm + 1;
        this.hnadsm = i;
        a aVar = new a(str, i, objArr);
        if (bVar != null) {
            this.hnadsl.put(Integer.valueOf(aVar.hnadsb), bVar);
        }
        ArrayList<a> arrayList = this.hnadsn;
        if (arrayList != null) {
            arrayList.add(aVar);
        } else {
            hnadsa(aVar);
        }
    }

    public JsBridgeWebView(Context context) {
        super(context);
        this.hnadsi = new HashMap();
        this.hnadsj = new InnerJavascriptInterface();
        this.hnadsk = new Handler(Looper.getMainLooper());
        this.hnadsl = new HashMap();
        this.hnadsm = 0;
        hnadsd();
    }

    public void hnadsa(String str, Object[] objArr) {
        hnadsa(str, objArr, (b) null);
    }

    public <T> void hnadsa(String str, b<T> bVar) {
        hnadsa(str, (Object[]) null, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsd(String str) {
        if (str.startsWith("javascript:")) {
            super.loadUrl(str);
        } else {
            this.hnadsn = new ArrayList<>();
            super.loadUrl(str);
        }
    }

    public void hnadsa(Object obj, String str) {
        if (str == null) {
            str = "";
        }
        if (obj != null) {
            this.hnadsi.put(str, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsa(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.hnadsk.post(runnable);
        }
    }
}

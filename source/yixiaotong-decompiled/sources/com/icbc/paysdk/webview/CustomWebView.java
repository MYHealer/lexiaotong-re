package com.icbc.paysdk.webview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.JsPromptResult;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import com.alipay.sdk.util.i;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.icbc.paysdk.constants.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class CustomWebView extends WebView {
    private static final String KEY_ARG_ARRAY = "args";
    private static final String KEY_FUNCTION_NAME = "func";
    private static final String KEY_INTERFACE_NAME = "obj";
    private static final String MSG_PROMPT_HEADER = "ICBCBridge:";
    private static final String VAR_ARG_PREFIX = "arg";
    private EditText amountEditTmp;
    private boolean isUseAmountKeyBoard;
    private String isUseAmountKeyBoardFormName;
    private HashMap<String, Object> mJsInterfaceMap;
    private String mJsStringCache;
    private CustomWebView mWebView;
    public static final Boolean JS_BUG_HANDLE_FLAG = true;
    public static final Boolean JS_BUG_ALLVERSION_HANDLEFLAG = false;
    private static final String[] mFilterMethods = {"getClass", "hashCode", "notify", "notifyAll", "equals", "toString", "wait"};

    public void cleanUseAmountKeyBoard() {
        this.isUseAmountKeyBoardFormName = "";
        this.isUseAmountKeyBoard = false;
    }

    public void setUseAmountKeyBoard(String str) {
        this.isUseAmountKeyBoardFormName = str;
        this.isUseAmountKeyBoard = true;
    }

    public CustomWebView(Context context) {
        super(context);
        this.mJsInterfaceMap = new HashMap<>();
        this.mJsStringCache = null;
        this.isUseAmountKeyBoardFormName = "";
        this.isUseAmountKeyBoard = false;
        this.amountEditTmp = new EditText(getContext());
        init();
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mJsInterfaceMap = new HashMap<>();
        this.mJsStringCache = null;
        this.isUseAmountKeyBoardFormName = "";
        this.isUseAmountKeyBoard = false;
        this.amountEditTmp = new EditText(getContext());
        init();
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mJsInterfaceMap = new HashMap<>();
        this.mJsStringCache = null;
        this.isUseAmountKeyBoardFormName = "";
        this.isUseAmountKeyBoard = false;
        this.amountEditTmp = new EditText(getContext());
        init();
    }

    public void setContext(Context context) {
        try {
            Field declaredField = View.class.getDeclaredField("mContext");
            declaredField.setAccessible(true);
            declaredField.set(this, context);
            Field declaredField2 = WebView.class.getDeclaredField("mProvider");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(this);
            Field declaredField3 = obj.getClass().getDeclaredField("mAwContents");
            declaredField3.setAccessible(true);
            Object obj2 = declaredField3.get(obj);
            Field declaredField4 = obj2.getClass().getDeclaredField("mContentViewCore");
            declaredField4.setAccessible(true);
            Object obj3 = declaredField4.get(obj2);
            Field declaredField5 = obj3.getClass().getDeclaredField("mContext");
            declaredField5.setAccessible(true);
            declaredField5.set(obj3, context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        initWebviewSetting();
    }

    private void initWebviewSetting() {
        this.mWebView = this;
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(getContext().getDir("geodatabase", 0).getPath());
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAppCacheMaxSize(8388608L);
        settings.setAppCachePath(getContext().getDir("cache", 0).getPath());
        settings.setDatabasePath(getContext().getDir("database", 0).getPath());
        removeSystemJavaScriptInterface();
    }

    public void setWebViewUserAgent(String str) {
        WebSettings settings = getSettings();
        settings.setUserAgentString(str + PPSLabelView.Code + settings.getUserAgentString() + " BSComponentVersion:3.6");
    }

    private void removeSystemJavaScriptInterface() {
        if (!isLargeHoneycomb() || isLargeJellyBean()) {
            return;
        }
        super.removeJavascriptInterface("searchBoxJavaBridge_");
        super.removeJavascriptInterface("accessibility");
        super.removeJavascriptInterface("accessibilityTraversal");
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        try {
            if (this.isUseAmountKeyBoard) {
                editorInfo.inputType = 8194;
            } else if (editorInfo.inputType == 8194) {
                editorInfo.inputType = 1;
            }
        } catch (Exception unused) {
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        if (!JS_BUG_HANDLE_FLAG.booleanValue()) {
            super.addJavascriptInterface(obj, str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (isLargeJellyBean()) {
            super.addJavascriptInterface(obj, str);
            this.mJsInterfaceMap.put(str, obj);
        } else {
            this.mJsInterfaceMap.put(str, obj);
        }
    }

    @Override // android.webkit.WebView
    public void removeJavascriptInterface(String str) {
        if (!JS_BUG_HANDLE_FLAG.booleanValue()) {
            super.removeJavascriptInterface(str);
        } else {
            if (isLargeJellyBean()) {
                super.removeJavascriptInterface(str);
                return;
            }
            this.mJsInterfaceMap.remove(str);
            this.mJsStringCache = null;
            injectJavascriptInterfaces();
        }
    }

    public void injectJavascriptInterfaces() {
        if (JS_BUG_HANDLE_FLAG.booleanValue()) {
            if (!TextUtils.isEmpty(this.mJsStringCache)) {
                loadJavascriptInterfaces();
            } else {
                this.mJsStringCache = genJavascriptInterfacesString();
                loadJavascriptInterfaces();
            }
        }
    }

    private void loadJavascriptInterfaces() {
        evaluateJavascript(this.mJsStringCache, null);
    }

    private String genJavascriptInterfacesString() {
        if (this.mJsInterfaceMap.size() == 0) {
            this.mJsStringCache = null;
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:(function JsAddJavascriptInterface_(){");
        for (Map.Entry<String, Object> entry : this.mJsInterfaceMap.entrySet()) {
            try {
                createJsMethod(entry.getKey(), entry.getValue(), sb);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        sb.append("})()");
        return sb.toString();
    }

    private void createJsMethod(String str, Object obj, StringBuilder sb) {
        if (TextUtils.isEmpty(str) || obj == null || sb == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        sb.append("if(typeof(window.").append(str).append(")!='undefined'){");
        sb.append("}else {");
        sb.append("    window.").append(str).append("={");
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            if (!filterMethods(name)) {
                sb.append("        ").append(name).append(":function(");
                int length = method.getParameterTypes().length;
                if (length > 0) {
                    int i = length - 1;
                    for (int i2 = 0; i2 < i; i2++) {
                        sb.append(VAR_ARG_PREFIX).append(i2).append(",");
                    }
                    sb.append(VAR_ARG_PREFIX).append(i);
                }
                sb.append(") {");
                if (method.getReturnType() != Void.TYPE) {
                    sb.append("            return ").append("prompt('").append(MSG_PROMPT_HEADER).append("'+");
                } else {
                    sb.append("            prompt('").append(MSG_PROMPT_HEADER).append("'+");
                }
                sb.append("JSON.stringify({");
                sb.append("obj").append(":'").append(str).append("',");
                sb.append("func").append(":'").append(name).append("',");
                sb.append("args").append(":[");
                if (length > 0) {
                    int i3 = length - 1;
                    for (int i4 = 0; i4 < i3; i4++) {
                        sb.append(VAR_ARG_PREFIX).append(i4).append(",");
                    }
                    sb.append(VAR_ARG_PREFIX).append(i3);
                }
                sb.append("]})");
                sb.append(");");
                sb.append("        }, ");
            }
        }
        sb.append("    };");
        sb.append(i.d);
    }

    public boolean handleJsInterface(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        int length;
        Object[] objArr = null;
        if (!str2.startsWith(MSG_PROMPT_HEADER)) {
            String[] strArrSplit = str2.split("[.]");
            if (this.mJsInterfaceMap.containsKey(strArrSplit[0])) {
                String str4 = strArrSplit[0];
                String str5 = strArrSplit[1];
                if (!TextUtils.isEmpty(str3) && str3.startsWith("{") && str3.endsWith(i.d) && str3.length() > 2) {
                    objArr = new Object[]{str3};
                }
                if (invokeJSInterfaceMethod(jsPromptResult, str4, str5, objArr)) {
                    return true;
                }
            }
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2.substring(11));
            String string = jSONObject.getString("obj");
            String string2 = jSONObject.getString("func");
            JSONArray jSONArray = jSONObject.getJSONArray("args");
            if (jSONArray != null && (length = jSONArray.length()) > 0) {
                objArr = new Object[length];
                for (int i = 0; i < length; i++) {
                    Object obj = jSONArray.get(i);
                    objArr[i] = obj;
                    if (obj == JSONObject.NULL) {
                        objArr[i] = "";
                    }
                }
            }
            if (invokeJSInterfaceMethod(jsPromptResult, string, string2, objArr)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jsPromptResult.cancel();
        return false;
    }

    private boolean invokeJSInterfaceMethod(JsPromptResult jsPromptResult, String str, String str2, Object[] objArr) {
        Class<?>[] clsArr;
        Object obj = this.mJsInterfaceMap.get(str);
        if (obj == null) {
            jsPromptResult.cancel();
            return false;
        }
        int length = objArr != null ? objArr.length : 0;
        if (length > 0) {
            clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = getClassFromJsonObject(objArr[i]);
            }
        } else {
            clsArr = null;
        }
        try {
            Log.i(Constants.LogFlag, "obj = " + obj.getClass().getName() + "   methodName = " + str2);
            Object objInvoke = obj.getClass().getMethod(str2, clsArr).invoke(obj, objArr);
            jsPromptResult.confirm((objInvoke == null || objInvoke.getClass() == Void.TYPE) ? "" : objInvoke.toString());
            jsPromptResult.cancel();
            return true;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private Class<?> getClassFromJsonObject(Object obj) {
        Class<?> cls = obj.getClass();
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return String.class;
    }

    private boolean filterMethods(String str) {
        for (String str2 : mFilterMethods) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean isLargeHoneycomb() {
        JS_BUG_ALLVERSION_HANDLEFLAG.booleanValue();
        return true;
    }

    private boolean isLargeJellyBean() {
        return !JS_BUG_ALLVERSION_HANDLEFLAG.booleanValue();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        super.loadUrl(str, map);
    }

    @Override // android.webkit.WebView
    public void postUrl(String str, byte[] bArr) {
        super.postUrl(str, bArr);
    }
}

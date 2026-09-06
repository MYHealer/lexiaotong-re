package com.baidu.oauth.sdkbqt.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.oauth.sdkbqt.auth.BdOauthSdk;
import com.baidu.oauth.sdkbqt.result.OauthResult;
import com.baidu.passbqt.http.HttpHashMap;
import com.baidu.passbqt.http.PassHttpClient;
import com.baidu.passbqt.http.PassHttpClientRequest;
import com.baidu.passbqt.http.PassHttpParamDTO;
import com.baidu.passbqt.http.ReqPriority;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class a {
    private boolean c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PassHttpClient f1852a = PassHttpClient.a();
    private Context b = BdOauthSdk.getAuthInfo().getContext();

    public void a(String str, f fVar) {
        a(str, null, null, null, fVar);
    }

    public void a(String str, g gVar, f fVar) {
        a(str, gVar, null, null, fVar);
    }

    public void a(String str, g gVar, List<HttpCookie> list, String str2, f fVar) {
        a(str, gVar, (HashMap<String, String>) null, list, str2, 0, fVar);
    }

    public PassHttpClientRequest a(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, int i, f fVar) {
        return a(str, reqPriority, httpHashMap, null, list, str2, i, fVar);
    }

    public PassHttpClientRequest a(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> map, List<HttpCookie> list, String str2, int i, f fVar) {
        new Handler(Looper.getMainLooper()).post(new b(this, fVar));
        if (a(fVar)) {
            return this.f1852a.a(this.b, a(str, reqPriority, httpHashMap, map, list, str2, i), new c(this, Looper.getMainLooper(), fVar.c(), fVar));
        }
        return null;
    }

    private PassHttpParamDTO a(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> map, List<HttpCookie> list, String str2, int i) {
        PassHttpParamDTO passHttpParamDTOA = a(str, httpHashMap, map, list, str2, i);
        passHttpParamDTOA.g = reqPriority;
        return passHttpParamDTOA;
    }

    private PassHttpParamDTO a(String str, HttpHashMap httpHashMap, HashMap<String, String> map, List<HttpCookie> list, String str2, int i) {
        PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
        passHttpParamDTO.f1937a = str;
        passHttpParamDTO.d = httpHashMap;
        passHttpParamDTO.h = map;
        passHttpParamDTO.b = list;
        passHttpParamDTO.c = str2;
        passHttpParamDTO.e = i;
        return passHttpParamDTO;
    }

    public void a(String str, g gVar, HashMap<String, String> map, List<HttpCookie> list, String str2, int i, f fVar) {
        fVar.a();
        if (a(fVar)) {
            this.f1852a.a(this.b, a(str, gVar, map, list, str2, i), new d(this, Looper.getMainLooper(), fVar.c(), fVar, str, gVar, map, list, str2, i));
        }
    }

    public void b(String str, g gVar, f fVar) {
        b(str, gVar, null, null, fVar);
    }

    public void b(String str, g gVar, List<HttpCookie> list, String str2, f fVar) {
        b(str, gVar, null, list, str2, 0, fVar);
    }

    public void b(String str, g gVar, HashMap<String, String> map, List<HttpCookie> list, String str2, int i, f fVar) {
        fVar.a();
        if (a(fVar)) {
            this.f1852a.b(this.b, a(str, gVar, map, list, str2, i), new e(this, Looper.getMainLooper(), fVar.c(), fVar, str, gVar, map, list, str2, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, Throwable th, String str) {
        fVar.a(th, (th == null || !SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) ? OauthResult.ERROR_CODE_UNKNOW_ERROR : OauthResult.ERROR_CODE_NETWORK_EXCEPTION, str);
    }

    private boolean a(f fVar) {
        Context context = this.b;
        if (context == null) {
            fVar.a((Throwable) null, OauthResult.ERROR_CODE_SDK_NOT_INIT, OauthResult.ERROR_MSG_SDK_NOT_INIT);
            fVar.b();
            return false;
        }
        if (com.baidu.oauth.sdkbqt.a.h.a(context)) {
            return true;
        }
        fVar.a((Throwable) null, OauthResult.ERROR_CODE_NETWORK_EXCEPTION, OauthResult.RESULT_MSG_NETWORK_EXCEPTION);
        fVar.b();
        return false;
    }

    private PassHttpParamDTO a(String str, g gVar, HashMap<String, String> map, List<HttpCookie> list, String str2, int i) {
        PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
        passHttpParamDTO.f1937a = str;
        passHttpParamDTO.d = gVar;
        passHttpParamDTO.h = map;
        passHttpParamDTO.b = list;
        passHttpParamDTO.c = str2;
        passHttpParamDTO.e = i;
        return passHttpParamDTO;
    }
}

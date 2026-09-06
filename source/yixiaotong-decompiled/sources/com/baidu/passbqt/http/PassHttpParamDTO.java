package com.baidu.passbqt.http;

import com.baidu.passbqt.NoProguard;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class PassHttpParamDTO implements NoProguard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1937a;
    public List<HttpCookie> b;
    public String c;
    public int e;
    public String i;
    public HttpHashMap d = new HttpHashMap();
    public boolean f = false;
    public ReqPriority g = ReqPriority.NORMAL;
    public HashMap<String, String> h = new HashMap<>(1);
    public int j = 443;
}

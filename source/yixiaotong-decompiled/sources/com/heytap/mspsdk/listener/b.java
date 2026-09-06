package com.heytap.mspsdk.listener;

import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3469a;
    private String b;
    private HashMap<String, String> c;

    public void a(int i) {
        this.f3469a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(HashMap<String, String> map) {
        this.c = map;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Result{code='").append(this.f3469a).append("', message='").append(this.b).append("', item='");
        HashMap<String, String> map = this.c;
        return sbAppend.append(map != null ? map.toString() : null).append("'}").toString();
    }
}

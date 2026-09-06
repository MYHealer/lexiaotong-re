package com.meishu.sdk.core.utils;

import java.io.IOException;

/* JADX INFO: compiled from: SplashLoadImageUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f4915a;
    public final Object b = new Object();

    public static void a(j1 j1Var, IOException iOException) {
        j1Var.getClass();
        try {
            synchronized (j1Var.b) {
                try {
                    w wVar = j1Var.f4915a;
                    if (wVar != null) {
                        wVar.onFailure(iOException);
                        j1Var.f4915a = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

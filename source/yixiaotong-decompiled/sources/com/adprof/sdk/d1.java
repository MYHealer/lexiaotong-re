package com.adprof.sdk;

import android.util.SparseArray;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c1 f1121a = new c1();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Lazy f207a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) b1.f1063a);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SparseArray f208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList f209a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public JSONObject f210a;
    public SparseArray b;

    public final e2 a(int i) {
        SparseArray sparseArray = this.f208a;
        if (sparseArray != null) {
            return (e2) sparseArray.get(i);
        }
        return null;
    }
}

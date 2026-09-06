package com.huawei.hms.mlplugin.card.bcr;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: IINRuler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<m> f4175a;

    /* JADX INFO: compiled from: IINRuler.java */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: IINRuler.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final n f4176a = new n(null);
    }

    /* synthetic */ n(a aVar) {
        this();
    }

    public static n a() {
        return b.f4176a;
    }

    private n() {
        this.f4175a = new ArrayList();
        a(new j());
        a(new l());
        a(new p());
        a(new k());
        a(new o());
        a(new q());
    }

    public void a(m mVar) {
        this.f4175a.add(mVar);
    }

    public String a(String str) {
        Iterator<m> it = this.f4175a.iterator();
        while (it.hasNext()) {
            String strA = it.next().a(str);
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        return null;
    }
}

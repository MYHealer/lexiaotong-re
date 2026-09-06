package com.byazt.rs;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 34})
public class a {
    public static volatile a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tt f2682a;
    public ve n;
    public Context uj;
    public int sp = 30;
    public boolean x = false;
    public final Map<String, List<WeakReference<sp>>> tt = new ConcurrentHashMap();
    public final Map<String, n> ve = new ConcurrentHashMap();

    public void c(tt ttVar) {
        this.f2682a = ttVar;
    }

    public void c(ve veVar) {
        this.n = veVar;
    }

    public void c(boolean z) {
        this.x = z;
    }

    public tt tt() {
        return this.f2682a;
    }

    public boolean ve() {
        return this.x;
    }

    private a() {
    }

    public static a c() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public void c(Context context) {
        if (context == null || this.uj != null) {
            return;
        }
        this.uj = StubApp.getOrigApplicationContext(context.getApplicationContext());
        x.c().c(context);
        x.c().c(this.sp);
        c.c().c(context);
    }

    public void c(int i) {
        if (this.sp == i) {
            return;
        }
        this.sp = i;
        x.c().c(i);
    }

    public void c(final uj ujVar, final sp spVar) {
        if (ujVar == null || TextUtils.isEmpty(ujVar.c())) {
            c(spVar, ujVar, 1001, "Invalid zip config");
        } else if (this.x) {
            c(spVar, ujVar, 1001, "Zip download is disabled");
        } else {
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("") { // from class: com.byazt.rs.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.tt(ujVar, spVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(uj ujVar, sp spVar) {
        final String strC = ujVar.c();
        if (c(ujVar)) {
            c(spVar, ujVar);
            return;
        }
        synchronized (this) {
            List<WeakReference<sp>> list = this.tt.get(strC);
            if (list != null && !list.isEmpty()) {
                list.add(new WeakReference<>(spVar));
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new WeakReference(spVar));
            this.tt.put(strC, arrayList);
            n nVar = new n(this.uj);
            this.ve.put(strC, nVar);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            nVar.c(ujVar, new sp() { // from class: com.byazt.rs.a.2
                @Override // com.byazt.rs.sp
                public void c(uj ujVar2) {
                    a.this.c(ujVar2, true, System.currentTimeMillis() - jCurrentTimeMillis, 0, (String) null);
                    a.this.c(strC, true, ujVar2, 0, (String) null);
                    a.this.c(strC);
                }

                @Override // com.byazt.rs.sp
                public void c(uj ujVar2, int i, String str) {
                    a.this.c(ujVar2, false, System.currentTimeMillis() - jCurrentTimeMillis, i, str);
                    a.this.c(strC, false, ujVar2, i, str);
                    a.this.c(strC);
                }
            });
        }
    }

    public static boolean c(uj ujVar) {
        Context context;
        File fileTt;
        if (ujVar == null || TextUtils.isEmpty(ujVar.c()) || (context = c().uj) == null || (fileTt = com.byazt.nys.tt.tt(context)) == null) {
            return false;
        }
        String strUj = x.uj(ujVar.c());
        String strVe = ujVar.ve();
        if (TextUtils.isEmpty(strVe)) {
            strVe = "img_0.png";
        }
        return new File(fileTt, "tt_lottie_imgcac" + File.separator + strUj + File.separator + strVe).exists();
    }

    private void c(final sp spVar, final uj ujVar) {
        if (spVar != null) {
            da.tt().post(new Runnable() { // from class: com.byazt.rs.a.3
                @Override // java.lang.Runnable
                public void run() {
                    spVar.c(ujVar);
                }
            });
        }
    }

    private void c(final sp spVar, final uj ujVar, final int i, final String str) {
        if (spVar != null) {
            da.tt().post(new Runnable() { // from class: com.byazt.rs.a.4
                @Override // java.lang.Runnable
                public void run() {
                    spVar.c(ujVar, i, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, boolean z, uj ujVar, int i, String str2) {
        List<WeakReference<sp>> listRemove;
        synchronized (this) {
            listRemove = this.tt.remove(str);
        }
        if (listRemove == null || listRemove.isEmpty()) {
            return;
        }
        Iterator<WeakReference<sp>> it = listRemove.iterator();
        while (it.hasNext()) {
            sp spVar = it.next().get();
            if (spVar != null) {
                if (z) {
                    c(spVar, ujVar);
                } else {
                    c(spVar, ujVar, i, str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        this.ve.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(uj ujVar, boolean z, long j, int i, String str) {
        if (this.n == null || ujVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", z);
            jSONObject.put("duration_ms", j);
            jSONObject.put("url", ujVar.c());
            if (!z) {
                jSONObject.put("error_code", i);
                jSONObject.put("error_desc", str);
            }
            this.n.c("lot_download", jSONObject);
        } catch (Exception e) {
            m.c(e);
        }
    }
}

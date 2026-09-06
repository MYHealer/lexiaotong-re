package com.byazt.wdw;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.byazt.aas.nb;
import com.byazt.aas.rl;
import com.byazt.bzd.x;
import com.byazt.cr.a;
import com.byazt.ddx.i;
import com.byazt.eia.da;
import com.byazt.ete.hq;
import com.byazt.ete.ic;
import com.byazt.nr.h;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.gu;
import com.byazt.omf.p;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.openalliance.ad.constant.ba;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, 46})
public class n {
    public static volatile boolean sp;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hq f2838a;
    public Toast c;
    public Map<String, Object> da;
    public final boolean i;
    public boolean n;
    public final Context tt;
    public String uj;
    public int ve;
    public final da x;

    public interface c {
        void c();

        void c(com.byazt.cr.c cVar);
    }

    public static void c(boolean z) {
        sp = z;
    }

    public static boolean c() {
        return sp;
    }

    public n c(int i) {
        this.ve = i;
        return this;
    }

    public n c(String str) {
        this.uj = str;
        return this;
    }

    public n c(Map<String, Object> map) {
        this.da = map;
        return this;
    }

    public n tt(boolean z) {
        this.n = z;
        return this;
    }

    public n(da daVar, Context context, boolean z) {
        this.x = daVar;
        this.tt = context;
        this.i = z;
    }

    public boolean c(c cVar) {
        if (this.f2838a == null) {
            da daVar = this.x;
            this.f2838a = daVar != null ? daVar.A_() : null;
        }
        if (this.f2838a == null) {
            return false;
        }
        if (this.i) {
            da daVar2 = this.x;
            if (daVar2 instanceof com.byazt.eia.uj) {
                return c(((com.byazt.eia.uj) daVar2).da(), cVar);
            }
        }
        return tt(cVar);
    }

    private boolean tt(c cVar) {
        int iVe;
        int iTt = this.f2838a.tt();
        if (iTt != 1) {
            if (iTt != 2 || (iVe = ve()) == 0) {
                return false;
            }
            if (iVe == 1) {
                c(cVar, this.f2838a);
                return true;
            }
            if (TextUtils.isEmpty(this.f2838a.c())) {
                return false;
            }
            c(cVar, this.f2838a, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            return true;
        }
        if (this.n) {
            if (TextUtils.isEmpty(this.f2838a.x())) {
                return true;
            }
            if (ve() == 1) {
                c(cVar, this.f2838a);
                return true;
            }
        }
        return false;
    }

    private boolean c(int i, c cVar) {
        if (i == 1) {
            c(cVar, this.f2838a);
            return true;
        }
        if (i == 2) {
            if (TextUtils.isEmpty(this.f2838a.c())) {
                return false;
            }
            c(cVar, this.f2838a, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            return true;
        }
        if (i != 3 || !this.n) {
            return false;
        }
        c(cVar, this.f2838a);
        return true;
    }

    private int ve() {
        hq hqVar = this.f2838a;
        if (hqVar == null) {
            return 0;
        }
        if (hqVar.a() == 1 && uj.ve().c()) {
            return TextUtils.isEmpty(this.f2838a.sp()) ? 0 : 1;
        }
        return 2;
    }

    private void c(final c cVar, hq hqVar) {
        uj();
        da daVar = this.x;
        if ((daVar instanceof com.byazt.eia.uj) && !TextUtils.isEmpty(((com.byazt.eia.uj) daVar).sp()) && !TextUtils.isEmpty(((com.byazt.eia.uj) this.x).i())) {
            uj ujVarVe = uj.ve();
            da daVar2 = this.x;
            ujVarVe.c(daVar2, ((com.byazt.eia.uj) daVar2).i(), ((com.byazt.eia.uj) this.x).sp(), cVar, this.uj, this.n, this.da);
        } else {
            gt.c().c(hqVar, this.x.x(), this.x.w_(), new tt(cVar, hqVar, this.c) { // from class: com.byazt.wdw.n.1
                @Override // com.byazt.wdw.n.tt, com.byazt.omf.gu.ve
                public void c(JSONObject jSONObject) {
                    String strOptString = jSONObject.optString("userName");
                    String strOptString2 = jSONObject.optString("path");
                    if (!TextUtils.isEmpty(strOptString)) {
                        if (n.this.c != null) {
                            n.this.c.cancel();
                        }
                        uj.ve().c(n.this.x, strOptString, strOptString2, cVar, n.this.uj, n.this.n, n.this.da);
                        return;
                    }
                    c(605, " userName or path is null!");
                }

                @Override // com.byazt.wdw.n.tt, com.byazt.omf.gu.ve
                public void c(int i, String str) {
                    a aVar;
                    n.this.f2838a.tt(0);
                    if (n.this.c != null) {
                        n.this.c.cancel();
                    }
                    if (i == 606) {
                        aVar = a.da;
                    } else {
                        aVar = a.i;
                    }
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.c(aVar);
                    }
                }
            }, 1, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    private void c(c cVar, hq hqVar, long j) {
        uj();
        gt.c().c(hqVar, this.x.x(), this.x.w_(), new tt(cVar, hqVar, this.c), 2, j);
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, 934})
    class tt implements gu.ve<JSONObject> {
        public final c c;
        public final hq tt;
        public final Toast uj;

        public tt(c cVar, hq hqVar, Toast toast) {
            this.c = cVar;
            this.tt = hqVar;
            this.uj = toast;
        }

        @Override // com.byazt.omf.gu.ve
        public void c(int i, String str) {
            a aVar;
            m.tt("WechatClickHandler", "getWechatLink failed:" + i + ", " + str);
            this.tt.tt(0);
            Toast toast = this.uj;
            if (toast != null) {
                toast.cancel();
            }
            if (i == 606) {
                aVar = a.f2058a;
            } else {
                aVar = a.n;
            }
            c cVar = this.c;
            if (cVar != null) {
                cVar.c(aVar);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.byazt.omf.gu.ve
        public void c(JSONObject jSONObject) {
            String strOptString = jSONObject.optString("scheme");
            if (!TextUtils.isEmpty(strOptString)) {
                n.this.c(strOptString, this.tt, this.c);
            } else {
                c(606, " scheme is null!");
            }
        }
    }

    private void uj() {
        x.c(new Runnable() { // from class: com.byazt.wdw.n.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (n.this.c != null) {
                        n.this.c.cancel();
                    }
                    n nVar = n.this;
                    nVar.c = h.c(nVar.tt, "即将跳转微信...", 1, 17, 0, 0);
                    n.this.c.show();
                } catch (Throwable th) {
                    m.ve("toast error:" + th.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, final hq hqVar, final c cVar) {
        Toast toast = this.c;
        if (toast != null) {
            toast.cancel();
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        final String strC = rl.tt(tt()) ? this.uj : nb.c(this.ve);
        HashMap map = new HashMap();
        map.put(ba.at, "WechatClickProcesser");
        map.put("scheme", nb.c(str));
        com.byazt.ddx.uj.c(tt(), strC, (Map<String, Object>) map, false);
        com.byazt.nr.tt.c(this.tt, intent, new com.byazt.nr.tt.c() { // from class: com.byazt.wdw.n.3
            @Override // com.byazt.nr.tt.c
            public void c() {
                hqVar.tt(1);
                com.byazt.ddx.uj.c(n.this.tt(), strC, (Throwable) null, false, true);
                com.byazt.ddx.x.c().c(n.this.tt(), strC, false, false, new i.c() { // from class: com.byazt.wdw.n.3.1
                    @Override // com.byazt.ddx.i.c
                    public void c(String str2) {
                    }

                    @Override // com.byazt.ddx.i.c
                    public void c(long j) {
                        if (cVar != null) {
                            cVar.c(a.x);
                        }
                    }

                    @Override // com.byazt.ddx.i.c
                    public void c(boolean z) {
                        if (cVar != null) {
                            cVar.c();
                        }
                    }
                });
            }

            @Override // com.byazt.nr.tt.c
            public void c(Throwable th) {
                com.byazt.ddx.uj.c(n.this.tt(), strC, th, false, false);
                hqVar.tt(0);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(a.sp);
                }
            }
        }, TextUtils.equals(p.x, UMModuleRegister.INNER));
    }

    public ic tt() {
        return com.byazt.ppf.ve.c(this.x, this.da);
    }
}

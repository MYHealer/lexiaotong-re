package com.byazt.z;

import android.app.Activity;
import android.content.Context;
import com.byazt.c.IDownloadFileUriProvider;
import com.byazt.c.IDownloadListener;
import com.byazt.c.eo;
import com.byazt.c.gr;
import com.byazt.c.rh;
import com.byazt.c.u;
import com.byazt.c.yp;
import com.byazt.ev.EnqueueType;
import com.byazt.tk.AdBaseConstants;
import com.byazt.zz.my;
import com.byazt.zz.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2909a;
    public gr aw;
    public long b;
    public IDownloadFileUriProvider bm;
    public int bx;
    public Activity c;
    public boolean cu;
    public boolean d;
    public String eo;
    public String gr;
    public my gt;
    public boolean gu;
    public int h;
    public com.byazt.s.a hd;
    public yp ic;
    public boolean kk;
    public int kp;
    public boolean l;
    public eo lo;
    public rh lr;
    public JSONObject lt;
    public x my;
    public String n;
    public boolean nu;
    public boolean or;
    public String oz;
    public boolean p;
    public boolean pu;
    public int q;
    public boolean qp;
    public boolean qy;
    public int[] r;
    public com.byazt.zz.sp rh;
    public com.byazt.n.c rl;
    public String sp;
    public String to;
    public Context tt;
    public IDownloadListener u;
    public List<String> uj;
    public String v;
    public String ve;
    public List<com.byazt.t.ve> x;
    public IDownloadListener yp;
    public long yv;
    public String z;
    public String zm;
    public boolean i = true;
    public boolean da = false;
    public boolean sl = true;
    public boolean t = false;
    public String m = AdBaseConstants.MIME_APK;
    public int md = 5;
    public boolean zb = true;
    public EnqueueType nb = EnqueueType.ENQUEUE_NONE;
    public int pf = 150;
    public boolean sv = true;
    public List<u> tk = new ArrayList();
    public boolean tx = true;
    public boolean os = true;

    public n a(int i) {
        this.kp = i;
        return this;
    }

    public n a(String str) {
        this.m = str;
        return this;
    }

    public n a(boolean z) {
        this.gu = z;
        return this;
    }

    public boolean a() {
        return this.da;
    }

    public yp aw() {
        return this.ic;
    }

    public boolean b() {
        return this.kk;
    }

    public eo bm() {
        return this.lo;
    }

    public String bx() {
        return this.f2909a;
    }

    public n c(long j) {
        this.yv = j;
        return this;
    }

    public n c(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.bm = iDownloadFileUriProvider;
        return this;
    }

    public n c(IDownloadListener iDownloadListener) {
        this.u = iDownloadListener;
        return this;
    }

    public n c(rh rhVar) {
        this.lr = rhVar;
        return this;
    }

    public n c(EnqueueType enqueueType) {
        this.nb = enqueueType;
        return this;
    }

    public n c(String str) {
        this.n = str;
        return this;
    }

    public n c(List<com.byazt.t.ve> list) {
        this.x = list;
        return this;
    }

    public n c(JSONObject jSONObject) {
        this.lt = jSONObject;
        return this;
    }

    public n c(boolean z) {
        this.i = z;
        return this;
    }

    public String c() {
        return this.ve;
    }

    public void c(int i) {
        this.q = i;
    }

    public boolean cu() {
        return this.sv;
    }

    public int d() {
        return this.pf;
    }

    public IDownloadListener da() {
        return this.yp;
    }

    public n da(String str) {
        this.oz = str;
        return this;
    }

    public n da(boolean z) {
        this.or = z;
        return this;
    }

    public int eo() {
        return this.bx;
    }

    public Activity getActivity() {
        return this.c;
    }

    public Context getContext() {
        return this.tt;
    }

    public int gr() {
        return this.h;
    }

    public String gt() {
        return this.gr;
    }

    public int gu() {
        return this.md;
    }

    public my h() {
        return this.gt;
    }

    public IDownloadFileUriProvider hd() {
        return this.bm;
    }

    public IDownloadListener i() {
        return this.u;
    }

    public n i(String str) {
        this.eo = str;
        return this;
    }

    public n i(boolean z) {
        this.zb = z;
        return this;
    }

    public com.byazt.s.a ic() {
        return this.hd;
    }

    public String kk() {
        return this.to;
    }

    public int[] kp() {
        return this.r;
    }

    public String l() {
        return this.v;
    }

    public boolean lo() {
        return this.pu;
    }

    public List<u> lr() {
        return this.tk;
    }

    public long lt() {
        return this.b;
    }

    public n m(boolean z) {
        this.tx = z;
        return this;
    }

    public com.byazt.zz.sp m() {
        return this.rh;
    }

    public boolean md() {
        return this.or;
    }

    public int my() {
        return this.q;
    }

    public n n(int i) {
        this.bx = i;
        return this;
    }

    public n n(String str) {
        this.z = str;
        return this;
    }

    public n n(boolean z) {
        this.qy = z;
        return this;
    }

    public boolean n() {
        return this.i;
    }

    public EnqueueType nb() {
        return this.nb;
    }

    public boolean nu() {
        return this.qy;
    }

    public boolean or() {
        return this.qp;
    }

    public JSONObject os() {
        return this.lt;
    }

    public boolean p() {
        return this.zb;
    }

    public boolean pf() {
        return this.p;
    }

    public int pu() {
        return this.kp;
    }

    public boolean q() {
        return this.tx;
    }

    public boolean qp() {
        return this.l;
    }

    public long qy() {
        return this.yv;
    }

    public boolean rh() {
        return this.gu;
    }

    public String rl() {
        return this.zm;
    }

    public n sl(String str) {
        this.to = str;
        return this;
    }

    public n sl(boolean z) {
        this.cu = z;
        return this;
    }

    public String sl() {
        return this.z;
    }

    public n sp(String str) {
        this.gr = str;
        return this;
    }

    public n sp(boolean z) {
        this.d = z;
        return this;
    }

    public boolean sp() {
        return this.sl;
    }

    public gr sv() {
        return this.aw;
    }

    public n t(boolean z) {
        this.qp = z;
        return this;
    }

    public String t() {
        return this.m;
    }

    public String tk() {
        return this.oz;
    }

    public boolean to() {
        return this.os;
    }

    public n tt(int i) {
        this.md = i;
        return this;
    }

    public n tt(String str) {
        this.f2909a = str;
        return this;
    }

    public n tt(List<String> list) {
        this.uj = list;
        return this;
    }

    public n tt(boolean z) {
        this.da = z;
        return this;
    }

    public String tt() {
        return this.n;
    }

    public List<String> tx() {
        return this.uj;
    }

    public n u(boolean z) {
        this.sv = z;
        return this;
    }

    public boolean u() {
        return this.nu;
    }

    public n uj(int i) {
        this.pf = i;
        return this;
    }

    public n uj(String str) {
        this.v = str;
        return this;
    }

    public n uj(boolean z) {
        this.nu = z;
        return this;
    }

    public List<com.byazt.t.ve> uj() {
        return this.x;
    }

    public rh v() {
        return this.lr;
    }

    public n ve(int i) {
        this.h = i;
        return this;
    }

    public n ve(String str) {
        this.sp = str;
        return this;
    }

    public n ve(boolean z) {
        this.t = z;
        return this;
    }

    public String ve() {
        return this.sp;
    }

    public n x(String str) {
        this.zm = str;
        return this;
    }

    public n x(boolean z) {
        this.l = z;
        return this;
    }

    public boolean x() {
        return this.t;
    }

    public com.byazt.n.c yp() {
        return this.rl;
    }

    public n yp(boolean z) {
        this.p = z;
        return this;
    }

    public String yv() {
        return this.eo;
    }

    public n z(boolean z) {
        this.kk = z;
        return this;
    }

    public x z() {
        return this.my;
    }

    public boolean zb() {
        return this.cu;
    }

    public boolean zm() {
        return this.d;
    }

    public n(Context context, String str) {
        this.tt = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.ve = str;
    }

    public n c(u uVar) {
        synchronized (this.tk) {
            if (uVar != null) {
                if (!this.tk.contains(uVar)) {
                    this.tk.add(uVar);
                    return this;
                }
            }
            return this;
        }
    }
}

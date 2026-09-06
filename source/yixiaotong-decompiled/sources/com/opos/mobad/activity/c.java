package com.opos.mobad.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.huawei.openalliance.ad.constant.br;
import com.opos.mobad.f.e;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.ui.a.d;
import com.opos.mobad.ui.a.h;
import com.opos.mobad.ui.a.k;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AdItemData f6594a;
    protected a b;

    public interface a {
        void a(Bitmap bitmap, String str);
    }

    public c(Context context, d dVar, FrameLayout frameLayout) {
        super(context, dVar, frameLayout, true);
        this.b = new a() { // from class: com.opos.mobad.activity.c.1
            @Override // com.opos.mobad.activity.c.a
            public void a(final Bitmap bitmap, final String str) {
                if (c.this.m == null || bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                c.this.H.post(new Runnable() { // from class: com.opos.mobad.activity.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.m == null || bitmap.isRecycled() || TextUtils.isEmpty(str) || !str.equals(c.this.m.getTag())) {
                            return;
                        }
                        c.this.m.setImageBitmap(bitmap);
                    }
                });
            }
        };
    }

    @Override // com.opos.mobad.ui.a.a
    protected void a() {
        l();
    }

    @Override // com.opos.mobad.ui.a.e
    public void a(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("MediaCreative", "onErrorRetryClick " + k.a().c(this.B));
        if (com.opos.cmn.an.h.c.a.d(this.c)) {
            aa();
            if (k.a().c(this.B) == -1) {
                k kVarA = k.a();
                Context context = this.c;
                String str = this.B;
                AdItemData adItemData = this.f6594a;
                kVarA.c(context, str, adItemData != null ? adItemData.V() : com.opos.mobad.j.b.c.b(), this.o, this, this.F);
                return;
            }
            k kVarA2 = k.a();
            Context context2 = this.c;
            String str2 = this.B;
            AdItemData adItemData2 = this.f6594a;
            kVarA2.a(context2, str2, adItemData2 != null ? adItemData2.V() : com.opos.mobad.j.b.c.b(), this.o, this, this.F);
        }
    }

    @Override // com.opos.mobad.ui.a.a
    public void a(View view, int[] iArr, int i) {
        if (i != 1 && i != 2) {
            if (i == 3 && k.a().c(this.B) == 2) {
                U();
                k.a().b(this.B);
                return;
            }
            return;
        }
        if (k.a().c(this.B) == -1 || k.a().c(this.B) == 0 || k.a().c(this.B) == 5) {
            N();
            k kVarA = k.a();
            Context context = this.c;
            String str = this.B;
            AdItemData adItemData = this.f6594a;
            kVarA.a(context, str, adItemData != null ? adItemData.V() : com.opos.mobad.j.b.c.b(), this.o, this, this.F);
        } else {
            k.a().a(this.B, this.o);
        }
        V();
    }

    public void a(AdItemData adItemData, String str) {
        if (adItemData != null) {
            this.f6594a = adItemData;
            this.B = str;
            if (this.E != null) {
                b(!this.f6594a.I());
            }
            com.opos.cmn.an.f.a.b("MediaCreative", "mAdItemData:" + this.f6594a);
            MaterialData materialData = adItemData.i().get(0);
            if (materialData != null) {
                List<MaterialFileData> listE = materialData.e();
                if (listE != null && listE.size() > 0 && listE.get(0) != null) {
                    String strA = listE.get(0).a();
                    if (!TextUtils.isEmpty(strA) && (!strA.equals(this.m.getTag()) || this.n == null)) {
                        a(strA);
                    }
                }
                a(this.o, 4);
                if (!com.opos.cmn.an.h.c.a.d(this.c)) {
                    ah();
                    if (this.v != null) {
                        HashMap map = new HashMap();
                        map.put(br.f.m, String.valueOf(10403));
                        map.put(FileDownloadModel.ERR_MSG, "no net,can't play video.");
                        this.v.a(map);
                        return;
                    }
                    return;
                }
                if (!com.opos.cmn.an.h.c.a.e(this.c) && !materialData.U()) {
                    Z();
                    return;
                }
                Y();
                k kVarA = k.a();
                Context context = this.c;
                AdItemData adItemData2 = this.f6594a;
                kVarA.b(context, str, adItemData2 != null ? adItemData2.V() : com.opos.mobad.j.b.c.b(), this.o, this, this.F);
            }
        }
    }

    @Override // com.opos.mobad.ui.a.h
    protected void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.m.setTag(str);
        e.a().a(str, (String) null, com.opos.cmn.an.h.f.a.b(this.c), (com.opos.cmn.an.h.f.a.b(this.c) * 9) / 16, new com.opos.mobad.d.a.InterfaceC0955a() { // from class: com.opos.mobad.activity.c.2
            @Override // com.opos.mobad.d.a.InterfaceC0955a
            public void a(int i, Bitmap bitmap) {
                c.this.n = bitmap;
                if (c.this.n != null) {
                    c.this.b.a(c.this.n, str);
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000f A[Catch: Exception -> 0x0014, TRY_LEAVE, TryCatch #0 {Exception -> 0x0014, blocks: (B:3:0x0002, B:5:0x000a, B:6:0x000f), top: B:12:0x0002 }] */
    public void a(boolean z) {
        if (z) {
            try {
                if (com.opos.cmn.an.h.b.a.b(this.c) == 0) {
                    c(false);
                } else {
                    c(true);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MediaCreative", "", (Throwable) e);
            }
        } else {
            c(true);
        }
    }

    public void b() {
        this.v = null;
    }

    @Override // com.opos.mobad.ui.a.e
    public void b(View view, int[] iArr) {
        if (k.a() != null) {
            aa();
            k kVarA = k.a();
            Context context = this.c;
            String str = this.B;
            AdItemData adItemData = this.f6594a;
            kVarA.a(context, str, adItemData != null ? adItemData.V() : com.opos.mobad.j.b.c.b(), this.o, this, this.F);
        }
    }
}

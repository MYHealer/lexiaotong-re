package com.byazt.jl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 157, 13})
public class tt extends i<com.byazt.on.c, com.byazt.on.tt> {
    public final c da;
    public final Paint i;
    public com.byazt.on.tt sp;
    public int x;

    /* JADX INFO: renamed from: com.byazt.jl.tt$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 157, 28})
    static /* synthetic */ class AnonymousClass1 {
    }

    @Override // com.byazt.jl.i
    public int tt() {
        return this.x;
    }

    @com.byazt.zqa.c(c = {0, 1, 157, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    private static class c {
        public byte c;
        public Rect tt;
        public ByteBuffer ve;

        private c() {
            this.tt = new Rect();
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public tt(com.byazt.zt.tt ttVar, i.c cVar) {
        super(ttVar, cVar);
        Paint paint = new Paint();
        this.i = paint;
        this.da = new c(null);
        paint.setAntiAlias(true);
    }

    @Override // com.byazt.jl.i
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.byazt.on.tt uj() {
        if (this.sp == null) {
            this.sp = new com.byazt.on.tt();
        }
        return this.sp;
    }

    @Override // com.byazt.jl.i
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.byazt.on.c ve(com.byazt.on.a aVar) {
        return new com.byazt.on.c(aVar);
    }

    @Override // com.byazt.jl.i
    public void ve() {
        this.da.ve = null;
        this.sp = null;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.byazt.jl.i
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Rect tt(com.byazt.on.c cVar) throws IOException {
        List<n> listC = uj.c(cVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        ve veVar = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        for (n nVar : listC) {
            if (nVar instanceof com.byazt.jl.c) {
                this.x = ((com.byazt.jl.c) nVar).ve;
                z = true;
            } else if (nVar instanceof a) {
                veVar = new ve(cVar, (a) nVar);
                veVar.n = arrayList;
                veVar.ve = bArr;
                this.c.add(veVar);
            } else if (nVar instanceof sp) {
                if (veVar != null) {
                    veVar.uj.add(nVar);
                }
            } else if (nVar instanceof da) {
                if (!z) {
                    u uVar = new u(cVar);
                    uVar.x = i;
                    uVar.i = i2;
                    this.c.add(uVar);
                    this.x = 1;
                    break;
                }
                if (veVar != null) {
                    veVar.uj.add(nVar);
                }
            } else if (nVar instanceof t) {
                t tVar = (t) nVar;
                i = tVar.tt;
                i2 = tVar.ve;
                bArr = tVar.x;
            } else if (!(nVar instanceof sl)) {
                arrayList.add(nVar);
            }
        }
        int i3 = i * i2;
        this.n = ByteBuffer.allocate(((i3 / (this.ve * this.ve)) + 1) * 4);
        this.da.ve = ByteBuffer.allocate(((i3 / (this.ve * this.ve)) + 1) * 4);
        return new Rect(0, 0, i, i2);
    }

    @Override // com.byazt.jl.i
    public void c(x<com.byazt.on.c, com.byazt.on.tt> xVar) {
        if (xVar == null || this.f2382a == null) {
            return;
        }
        try {
            Bitmap bitmapC = c(this.f2382a.width() / this.ve, this.f2382a.height() / this.ve);
            Canvas canvas = this.uj.get(bitmapC);
            if (canvas == null) {
                canvas = new Canvas(bitmapC);
                this.uj.put(bitmapC, canvas);
            }
            Canvas canvas2 = canvas;
            if (xVar instanceof ve) {
                this.n.rewind();
                bitmapC.copyPixelsFromBuffer(this.n);
                if (this.tt == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.da.tt);
                    byte b = this.da.c;
                    if (b == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b == 2) {
                        this.da.ve.rewind();
                        bitmapC.copyPixelsFromBuffer(this.da.ve);
                    }
                    canvas2.restore();
                }
                if (((ve) xVar).tt == 2 && this.da.c != 2) {
                    this.da.ve.rewind();
                    bitmapC.copyPixelsToBuffer(this.da.ve);
                }
                this.da.c = ((ve) xVar).tt;
                canvas2.save();
                if (((ve) xVar).c == 0) {
                    canvas2.clipRect(xVar.da / this.ve, xVar.sl / this.ve, (xVar.da + xVar.x) / this.ve, (xVar.sl + xVar.i) / this.ve);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                this.da.tt.set(xVar.da / this.ve, xVar.sl / this.ve, (xVar.da + xVar.x) / this.ve, (xVar.sl + xVar.i) / this.ve);
                canvas2.restore();
            }
            Bitmap bitmapC2 = c(xVar.x, xVar.i);
            c(xVar.c(canvas2, this.i, this.ve, bitmapC2, uj()));
            c(bitmapC2);
            this.n.rewind();
            bitmapC.copyPixelsToBuffer(this.n);
            c(bitmapC);
        } catch (Exception e) {
            m.c(e);
        }
    }
}

package com.byazt.hp;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import com.byazt.nr.m;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1019, 54})
public class ve extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f2307a;
    public LinearGradient da;
    public PorterDuffXfermode i;
    public float n;
    public Matrix sl;
    public Paint sp;
    public float uj;
    public String ve;
    public Paint x;

    public ve(com.byazt.xj.ve veVar, JSONObject jSONObject) {
        super(veVar, jSONObject);
        this.f2307a = this.tt.i();
        Paint paint = new Paint();
        this.sp = paint;
        paint.setAntiAlias(true);
        this.f2307a.setLayerType(2, null);
        this.i = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.x = new Paint();
        this.sl = new Matrix();
    }

    @Override // com.byazt.hp.c
    public void tt() {
        this.ve = this.c.optString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, TtmlNode.LEFT);
    }

    @Override // com.byazt.hp.c
    public void c(Canvas canvas) {
        ve(canvas);
    }

    @Override // com.byazt.hp.c
    public void tt(Canvas canvas) {
        ve(canvas);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005d  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void ve(Canvas canvas) {
        byte b;
        try {
            if (this.tt.lo() > 0.0f) {
                int iLo = (int) (this.uj * this.tt.lo());
                int iLo2 = (int) (this.n * this.tt.lo());
                this.sp.setXfermode(this.i);
                String str = this.ve;
                switch (str.hashCode()) {
                    case -1383228885:
                        if (!str.equals("bottom")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 115029:
                        if (!str.equals(Constant.MAP_KEY_TOP)) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    case 3317767:
                        if (!str.equals(TtmlNode.LEFT)) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 108511772:
                        if (!str.equals(TtmlNode.RIGHT)) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    float f = iLo;
                    canvas.drawRect(f, 0.0f, this.uj, this.n, this.sp);
                    this.sl.setTranslate(f, this.n);
                    this.da.setLocalMatrix(this.sl);
                    this.x.setShader(this.da);
                    if (this.tt.lo() <= 1.0f && this.tt.lo() > 0.9f) {
                        this.x.setAlpha((int) (255.0f - (this.tt.lo() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, f, this.n, this.x);
                    return;
                }
                if (b == 1) {
                    float f2 = iLo;
                    canvas.drawRect(0.0f, 0.0f, this.uj - f2, this.n, this.sp);
                    this.sl.setTranslate(this.uj - f2, 0.0f);
                    this.da.setLocalMatrix(this.sl);
                    this.x.setShader(this.da);
                    if (this.tt.lo() <= 1.0f && this.tt.lo() > 0.9f) {
                        this.x.setAlpha((int) (255.0f - (this.tt.lo() * 255.0f)));
                    }
                    float f3 = this.uj;
                    canvas.drawRect(f3, this.n, f3 - f2, 0.0f, this.x);
                    return;
                }
                if (b == 2) {
                    float f4 = iLo2;
                    canvas.drawRect(0.0f, f4, this.uj, this.n, this.sp);
                    this.sl.setTranslate(0.0f, f4);
                    this.da.setLocalMatrix(this.sl);
                    this.x.setShader(this.da);
                    if (this.tt.lo() <= 1.0f && this.tt.lo() > 0.9f) {
                        this.x.setAlpha((int) (255.0f - (this.tt.lo() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, this.uj, f4, this.x);
                    return;
                }
                if (b != 3) {
                    return;
                }
                float f5 = iLo2;
                canvas.drawRect(0.0f, 0.0f, this.uj, this.n - f5, this.sp);
                this.sl.setTranslate(0.0f, this.n - f5);
                this.da.setLocalMatrix(this.sl);
                this.x.setShader(this.da);
                if (this.tt.lo() <= 1.0f && this.tt.lo() > 0.9f) {
                    this.x.setAlpha((int) (255.0f - (this.tt.lo() * 255.0f)));
                }
                float f6 = this.uj;
                float f7 = this.n;
                canvas.drawRect(f6, f7, 0.0f, f7 - f5, this.x);
                return;
            }
            this.sp.setXfermode(this.i);
            canvas.drawRect(0.0f, 0.0f, this.uj, this.n, this.sp);
        } catch (Throwable th) {
            m.uj("BaseEffectWrapper", th.getMessage());
        }
    }

    @Override // com.byazt.hp.c
    public void c(int i, int i2) {
        this.uj = i;
        this.n = i2;
        String str = this.ve;
        str.hashCode();
        switch (str) {
            case "bottom":
                this.da = new LinearGradient(0.0f, -this.n, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.da = new LinearGradient(0.0f, this.n, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.da = new LinearGradient(this.uj, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "right":
                this.da = new LinearGradient(-this.uj, 0.0f, 0.0f, this.n, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }

    @Override // com.byazt.hp.c
    public List<PropertyValuesHolder> ve() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.byazt.rb.n.ALPHA.tt(), 0.0f, 1.0f));
        return arrayList;
    }
}

package com.byazt.hp;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.ViewGroup;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1019, 13})
public class tt extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f2305a;
    public int n;
    public int uj;
    public int ve;

    public tt(com.byazt.xj.ve veVar, JSONObject jSONObject) {
        super(veVar, jSONObject);
        Paint paint = new Paint();
        this.f2305a = paint;
        paint.setAntiAlias(true);
    }

    @Override // com.byazt.hp.c
    public void tt() {
        this.ve = com.byazt.cd.c.c(this.c.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR), -1);
    }

    @Override // com.byazt.hp.c
    public void c(Canvas canvas) {
        ve(canvas);
    }

    @Override // com.byazt.hp.c
    public void tt(Canvas canvas) {
        ve(canvas);
    }

    private void ve(Canvas canvas) {
        try {
            if (this.tt.bm() > 0.0f) {
                this.f2305a.setColor(this.ve);
                this.f2305a.setAlpha((int) ((1.0f - this.tt.bm()) * 255.0f));
                ((ViewGroup) this.tt.i().getParent()).setClipChildren(true);
                int i = this.uj;
                int i2 = this.n;
                canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * this.tt.bm(), this.f2305a);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.hp.c
    public void c(int i, int i2) {
        this.uj = i / 2;
        this.n = i2 / 2;
    }

    @Override // com.byazt.hp.c
    public List<PropertyValuesHolder> ve() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(uj(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}

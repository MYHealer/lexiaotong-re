package com.byazt.si;

import android.content.Context;
import com.byazt.ga.LottieAnimationView;
import com.byazt.sa.uj;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 608, 2031})
public class UgenLottieView extends LottieAnimationView {
    public uj c;

    public void c(uj ujVar) {
        this.c = ujVar;
    }

    public UgenLottieView(Context context) {
        super(context);
    }

    @Override // com.byazt.ga.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.n();
        }
    }

    @Override // com.byazt.ga.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.a();
        }
    }
}

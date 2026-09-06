package com.adprof.sdk;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.adprof.sdk.base.view.gif.GifImageView2;
import com.adprof.sdk.xb.a;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class hf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1212a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ LinearLayout f357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ RelativeLayout.LayoutParams f358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pf f359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ List f360a;

    public hf(pf pfVar, ViewGroup viewGroup, List list, RelativeLayout.LayoutParams layoutParams, LinearLayout linearLayout) {
        this.f359a = pfVar;
        this.f1212a = viewGroup;
        this.f360a = list;
        this.f358a = layoutParams;
        this.f357a = linearLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        int iA;
        int iA2;
        if (this.f1212a == null) {
            return;
        }
        for (int i = 0; i < this.f360a.size(); i++) {
            try {
                GifImageView2 gifImageView2 = new GifImageView2(this.f1212a.getContext());
                xb xbVarA = xb.a(AdprofSdk.getInstance().getContext());
                String str = (String) this.f360a.get(i);
                xbVarA.getClass();
                xbVarA.new a(str).a(gifImageView2);
                int measuredWidth = (this.f1212a.getMeasuredWidth() - h8.a(20.0f)) / 3;
                int i2 = (measuredWidth * 2) / 3;
                if (this.f359a.b > 40) {
                    i2 = this.f358a.height;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(measuredWidth, i2);
                if (i == 0) {
                    iA2 = h8.a(5.0f);
                    iA = 0;
                } else {
                    if (i == 1) {
                        iA = h8.a(5.0f);
                        iA2 = h8.a(5.0f);
                    } else {
                        layoutParams.setMargins(h8.a(5.0f), 0, 0, 0);
                    }
                    this.f357a.addView(gifImageView2, layoutParams);
                }
                layoutParams.setMargins(iA, 0, iA2, 0);
                this.f357a.addView(gifImageView2, layoutParams);
            } catch (Throwable th) {
                pk.a(th);
                oh.b(th);
                return;
            }
        }
    }
}

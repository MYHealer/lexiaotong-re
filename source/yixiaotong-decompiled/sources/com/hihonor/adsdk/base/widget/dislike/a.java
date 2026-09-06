package com.hihonor.adsdk.base.widget.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.NegativeFeedback;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.bean.DislikeInfo;
import com.hihonor.adsdk.base.callback.DislikeItemClickListener;
import com.hihonor.adsdk.base.widget.BaseItemDecoration;
import com.hihonor.adsdk.common.b.b;
import com.hihonor.adsdk.common.f.j;
import com.hihonor.adsdk.common.f.u;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends PopupWindow {
    private static final int hnadsf = 49;
    private static final int hnadsg = 8;
    private static final NegativeFeedback[] hnadsh = {NegativeFeedback.NOT_INTERESTED, NegativeFeedback.POOR_QUALITY_CONTENT, NegativeFeedback.POOR_CANCEL};
    private View hnadsa;
    private RecyclerView hnadsb;
    private DislikeItemClickListener hnadsc;
    private boolean hnadsd;
    private ViewTreeObserver.OnWindowFocusChangeListener hnadse;

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.widget.dislike.a$a, reason: collision with other inner class name */
    class C0453a implements DislikeItemClickListener {
        C0453a() {
        }

        @Override // com.hihonor.adsdk.base.callback.DislikeItemClickListener
        public void onCancel() {
            if (a.this.hnadsc != null) {
                a.this.hnadsc.onCancel();
            }
            a.this.dismiss();
        }

        @Override // com.hihonor.adsdk.base.callback.DislikeItemClickListener
        public void onFeedItemClick(int i, DislikeInfo dislikeInfo, View view) {
            if (a.this.hnadsc != null) {
                a.this.hnadsc.onFeedItemClick(i, dislikeInfo, view);
            }
            a.this.dismiss();
        }

        @Override // com.hihonor.adsdk.base.callback.DislikeItemClickListener
        public void onShow() {
            if (a.this.hnadsc != null) {
                a.this.hnadsc.onShow();
            }
        }
    }

    public a() {
        this.hnadsd = false;
        this.hnadse = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.hihonor.adsdk.base.widget.dislike.a$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z) {
                this.f$0.hnadsa(z);
            }
        };
        hnadsa();
    }

    private void hnadsb() {
        Context context = HnAds.get().getContext();
        ArrayList arrayList = new ArrayList(hnadsh.length);
        int i = 0;
        while (true) {
            NegativeFeedback[] negativeFeedbackArr = hnadsh;
            if (i >= negativeFeedbackArr.length) {
                DislikeListAdapter dislikeListAdapter = new DislikeListAdapter(arrayList);
                dislikeListAdapter.hnadsa(new C0453a());
                this.hnadsb.setAdapter(dislikeListAdapter);
                this.hnadsb.setLayoutManager(new LinearLayoutManager(context, 1, false));
                this.hnadsb.addItemDecoration(new BaseItemDecoration(j.hnadsa(context, 16.0f), j.hnadsa(context, 0.25f)));
                return;
            }
            DislikeInfo dislikeInfo = new DislikeInfo();
            dislikeInfo.setId(i);
            dislikeInfo.setText(negativeFeedbackArr[i].getDesc());
            arrayList.add(dislikeInfo);
            i++;
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        this.hnadsd = false;
        this.hnadsa.getViewTreeObserver().removeOnWindowFocusChangeListener(this.hnadse);
    }

    public void hnadsa(DislikeItemClickListener dislikeItemClickListener) {
        this.hnadsc = dislikeItemClickListener;
    }

    @Override // android.widget.PopupWindow
    public void setContentView(View view) {
        super.setContentView(view);
        this.hnadsa = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(boolean z) {
        b.hnadsc("DislikePopupWindow", "hasFocus = %s, isShown = %s", Boolean.valueOf(z), Boolean.valueOf(this.hnadsd));
        if (z || !this.hnadsd) {
            return;
        }
        dismiss();
    }

    private void hnadsa() {
        Context context = HnAds.get().getContext();
        setWidth(-2);
        setHeight((j.hnadsa(context, 49.0f) * 3) + (j.hnadsa(context, 8.0f) * 2));
        setFocusable(true);
        setOutsideTouchable(true);
        setElevation(16.0f);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.honor_ads_dislike_layout, (ViewGroup) null, false);
        this.hnadsa = viewInflate;
        this.hnadsb = (RecyclerView) viewInflate.findViewById(R.id.dislike_recycler_view);
        setContentView(this.hnadsa);
        hnadsb();
    }

    public a(View view, int i, int i2) {
        super(view, i, i2);
        this.hnadsd = false;
        this.hnadse = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.hihonor.adsdk.base.widget.dislike.a$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z) {
                this.f$0.hnadsa(z);
            }
        };
        hnadsa();
    }

    private int[] hnadsa(View view) {
        int[] iArr = new int[2];
        int width = view.getWidth();
        this.hnadsa.measure(0, 0);
        iArr[0] = u.hnadsk() ? 0 : -Math.abs(this.hnadsa.getMeasuredWidth() - width);
        return iArr;
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hnadsd = false;
        this.hnadse = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.hihonor.adsdk.base.widget.dislike.a$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z) {
                this.f$0.hnadsa(z);
            }
        };
        hnadsa();
    }

    public void hnadsb(View view) {
        showAsDropDown(view, hnadsa(view)[0], 0, 0);
        this.hnadsd = true;
        this.hnadsa.getViewTreeObserver().addOnWindowFocusChangeListener(this.hnadse);
        DislikeItemClickListener dislikeItemClickListener = this.hnadsc;
        if (dislikeItemClickListener != null) {
            dislikeItemClickListener.onShow();
        }
    }

    public a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.hnadsd = false;
        this.hnadse = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.hihonor.adsdk.base.widget.dislike.a$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z) {
                this.f$0.hnadsa(z);
            }
        };
        hnadsa();
    }
}

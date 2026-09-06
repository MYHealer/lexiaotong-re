package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.l.c;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.DividerView;
import com.kwad.sdk.wrapper.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class RewardTaskStepView extends LinearLayout {
    private List<c> FK;
    private String tS;

    public RewardTaskStepView(Context context) {
        super(context);
        this.FK = new ArrayList();
        lK();
    }

    public RewardTaskStepView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FK = new ArrayList();
        lK();
    }

    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.FK = new ArrayList();
        lK();
    }

    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.FK = new ArrayList();
        lK();
    }

    private void lK() {
        setOrientation(1);
    }

    public final void a(List<c> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.tS = str;
        this.FK.clear();
        this.FK.addAll(list);
        lL();
    }

    private void lL() {
        int size = this.FK.size();
        int i = 0;
        while (i < size) {
            c cVar = this.FK.get(i);
            int i2 = i + 1;
            a(i2, cVar.la(), cVar.lb(), cVar.isCompleted());
            if (i < size - 1) {
                af(this.FK.get(i2).isCompleted());
            }
            i = i2;
        }
    }

    private void a(int i, String str, String str2, boolean z) {
        int i2;
        if (z) {
            i2 = R.layout.ksad_reward_task_step_item_checked;
        } else {
            i2 = R.layout.ksad_reward_task_step_item_unchecked;
        }
        ViewGroup viewGroup = (ViewGroup) m.a(getContext(), i2, this, false);
        if (z) {
            a(viewGroup, str);
        } else {
            a(viewGroup, i, str2);
        }
        addView(viewGroup);
    }

    private void af(boolean z) {
        DividerView dividerView = (DividerView) m.a(getContext(), R.layout.ksad_reward_task_dialog_dash, this, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_icon_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_divider_height);
        dividerView.setDividerColor(getResources().getColor(z ? R.color.ksad_reward_main_color : R.color.ksad_reward_undone_color));
        addView(dividerView, dimensionPixelSize, dimensionPixelSize2);
    }

    private static void a(ViewGroup viewGroup, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(str);
    }

    private void a(ViewGroup viewGroup, int i, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(String.format(str, this.tS));
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_icon_text)).setText(String.valueOf(i));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

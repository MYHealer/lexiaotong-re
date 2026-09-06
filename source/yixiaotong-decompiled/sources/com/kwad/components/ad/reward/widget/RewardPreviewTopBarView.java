package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class RewardPreviewTopBarView extends KSFrameLayout implements View.OnClickListener {
    private String FC;
    private String FD;
    private ProgressBar FE;
    private TextView FF;
    private long FG;
    private long FH;
    private boolean FI;
    private a FJ;
    private ImageView cH;
    private TextView wU;

    public interface a {
        void H(boolean z);

        void I(boolean z);
    }

    public final boolean lJ() {
        return this.FI;
    }

    public void setTopBarListener(a aVar) {
        this.FJ = aVar;
    }

    public RewardPreviewTopBarView(Context context) {
        super(context);
        this.FC = " 秒后即可获得奖励";
        this.FD = "恭喜你获得奖励";
        this.FG = -1L;
        this.FI = false;
    }

    public RewardPreviewTopBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FC = " 秒后即可获得奖励";
        this.FD = "恭喜你获得奖励";
        this.FG = -1L;
        this.FI = false;
    }

    public RewardPreviewTopBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.FC = " 秒后即可获得奖励";
        this.FD = "恭喜你获得奖励";
        this.FG = -1L;
        this.FI = false;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(Context context, AttributeSet attributeSet) {
        super.init(context, attributeSet);
        inflate(getContext(), R.layout.ksad_activity_preview_topbar, this);
        this.FE = (ProgressBar) findViewById(R.id.ksad_preview_topbar_progress);
        this.wU = (TextView) findViewById(R.id.ksad_preview_topbar_reward_tips);
        this.FF = (TextView) findViewById(R.id.ksad_preview_topbar_reward_count);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_preview_topbar_close);
        this.cH = imageView;
        imageView.setVisibility(8);
        this.cH.setOnClickListener(this);
    }

    public void setRewardTips(String str) {
        TextView textView = this.wU;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void setCloseBtnDelayShowDuration(long j) {
        this.FH = j;
        if (j <= 0) {
            this.cH.setVisibility(0);
        }
    }

    public void setTotalCountDuration(long j) {
        this.FG = j;
        this.FE.setMax((int) j);
    }

    public final void v(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        TextView textView = this.FF;
        if (textView != null) {
            textView.setText(iCeil + this.FC);
        }
        e(j, this.FG);
        if (this.FG - j >= this.FH && this.cH.getVisibility() != 0) {
            this.cH.setVisibility(0);
        }
        if (iCeil <= 0) {
            f(true, false);
        }
    }

    private void f(boolean z, boolean z2) {
        if (!this.FI) {
            this.wU.setVisibility(8);
            this.FF.setText(this.FD);
            a aVar = this.FJ;
            if (aVar != null) {
                aVar.I(false);
            }
        } else {
            this.wU.setVisibility(0);
        }
        this.FI = true;
    }

    private void e(long j, long j2) {
        this.FE.setProgress((int) (j2 - j));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (!view.equals(this.cH) || (aVar = this.FJ) == null) {
            return;
        }
        aVar.H(this.FI);
    }
}

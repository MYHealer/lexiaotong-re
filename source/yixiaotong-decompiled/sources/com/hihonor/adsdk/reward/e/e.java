package com.hihonor.adsdk.reward.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.TextView;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.api.reward.RewardItem;
import com.hihonor.adsdk.reward.R;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.math.BigDecimal;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e extends AlertDialog implements DialogInterface.OnClickListener {
    private static final String d = "RetentionDialog";
    public static final String e = "androidhwext:style/Theme." + com.hihonor.adsdk.base.j.m.hnadsc() + ".Dialog.Alert";
    public static final String f = "androidhwext:style/Theme." + com.hihonor.adsdk.base.j.m.hnadsc() + ".Dark.Emphasize.Dialog";
    private static final int g = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f3568a;
    private final BaseAd b;
    private final a c;

    public interface a {
        void a();

        void b();
    }

    public e(Activity activity, BaseAd baseAd, RewardItem rewardItem, long j, a aVar) {
        super(activity, a(activity));
        this.f3568a = activity;
        this.c = aVar;
        this.b = baseAd;
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getResources().getString(R.string.ads_reward_retention_tip_before_other, Long.valueOf(j)));
        boolean z = true;
        if (Objects.nonNull(baseAd) && Objects.nonNull(baseAd.getVideo()) && baseAd.getVideo().getReward() != 1) {
            z = false;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(d, "RetentionDialog,isShowReward: " + z + ",hasRewardItem: " + Objects.nonNull(rewardItem), new Object[0]);
        if (Objects.nonNull(rewardItem) && z) {
            sb.append(new BigDecimal(String.valueOf(rewardItem.getAmount())).stripTrailingZeros().toPlainString() + PPSLabelView.Code + rewardItem.getType()).append(System.lineSeparator());
        }
        sb.append(activity.getResources().getString(com.hihonor.adsdk.base.R.string.ads_reward_retention_tip_after));
        TextView textView = new TextView(activity);
        textView.setText(sb.toString());
        textView.setGravity(17);
        textView.setPadding(0, (int) activity.getResources().getDimension(R.dimen.dimens_24), 0, 0);
        textView.setTextSize(16.0f);
        textView.setTextColor(activity.getResources().getColor(R.color.honor_ads_magic_text_primary));
        setView(textView);
        setButton(-1, activity.getString(com.hihonor.adsdk.base.R.string.ads_download_button_resume), this);
        setButton(-2, activity.getString(com.hihonor.adsdk.base.R.string.ads_reward_video_give_up), this);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        com.hihonor.adsdk.reward.c.a(getWindow());
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -2) {
            if (Objects.nonNull(this.b)) {
                com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.b);
                new com.hihonor.adsdk.base.g.j.d.g1.a(String.valueOf(2), this.b.getAdUnitId(), aVarHnadsa).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsk, String.valueOf(0)).hnadse();
                new com.hihonor.adsdk.base.g.j.d.g(this.b.getAdUnitId(), aVarHnadsa, "RewardActivity Finish ").hnadse();
            }
            a aVar = this.c;
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (i != -1) {
            return;
        }
        if (Objects.nonNull(this.b)) {
            new com.hihonor.adsdk.base.g.j.d.g1.a(String.valueOf(2), this.b.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.b)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsk, String.valueOf(1)).hnadse();
        }
        a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        if (!com.hihonor.adsdk.common.f.h.hnadsa(this.f3568a)) {
            com.hihonor.adsdk.common.b.b.hnadse(d, "showRetentionDialog activity is finish", new Object[0]);
            return;
        }
        super.show();
        Button button = getButton(-2);
        if (button != null) {
            button.setAllCaps(false);
            button.setTextColor(com.hihonor.adsdk.common.f.s.hnadsa().getColor(R.color.honor_ads_magic_color_text_secondary));
        }
        Button button2 = getButton(-1);
        if (button2 != null) {
            button2.setAllCaps(false);
        }
    }

    static int a(Context context) {
        String str = e;
        if (com.hihonor.adsdk.common.f.u.hnadsi()) {
            str = f;
        }
        return context.getResources().getIdentifier(str, null, null);
    }
}

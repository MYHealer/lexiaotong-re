package com.yfanads.android.core.act;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.stub.StubApp;
import com.yfanads.ads.R;
import com.yfanads.android.core.inter.YFAdInterEventCallback;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdInterV2ViewHolder;
import com.yfanads.android.custom.view.AdInterV3ViewHolder;
import com.yfanads.android.custom.view.NewCustomStyleDialog;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.model.template.InterV3TemplateData;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.YFLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFInterstitialActivity extends Activity {
    public static final String EXTRA_INSTANCE_ID = "instance_id";
    public static final String EXTRA_LAYOUT_ID = "layout_id";
    public static final String EXTRA_OFFSET_TOP = "offset_top";
    public static final String EXTRA_ORIENTATION = "orientation";
    public static final String EXTRA_TEMPLATE_CONF = "template_conf";
    public static final String EXTRA_TEMPLATE_KEY = "template_key";
    private static final Map<String, WeakReference<YFInterstitialActivity>> activityRefs;
    private NewCustomStyleDialog customDialog;
    private YFAdInterEventCallback eventCallback;
    private String instanceId;
    private int layoutId;
    private int offsetTop;
    private int orientation;
    private TemplateConf templateConf;
    private InterTemplateData templateData;
    private String templateKey;

    public class a implements NewCustomStyleDialog.NewDialogBindData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AdBaseViewHolder f9636a;

        public a() {
        }

        @Override // com.yfanads.android.custom.view.NewCustomStyleDialog.NewDialogBindData
        public final void actualExposureTime() {
            if (YFInterstitialActivity.this.eventCallback != null) {
                YFInterstitialActivity.this.eventCallback.onAdExposed();
            }
        }

        @Override // com.yfanads.android.custom.view.BaseDialogFragment.DialogBindData
        public final void bindViewData(View view) {
            if (TemplateRes.INT_V_3.equals(YFInterstitialActivity.this.templateKey)) {
                this.f9636a = new AdInterV3ViewHolder(view, null);
            } else {
                this.f9636a = new AdInterV2ViewHolder(view, null);
            }
            if (YFInterstitialActivity.this.eventCallback != null) {
                YFAdInterEventCallback yFAdInterEventCallback = YFInterstitialActivity.this.eventCallback;
                YFInterstitialActivity yFInterstitialActivity = YFInterstitialActivity.this;
                yFAdInterEventCallback.bindAdData(yFInterstitialActivity, yFInterstitialActivity.templateData, this.f9636a);
            }
        }

        @Override // com.yfanads.android.custom.view.NewCustomStyleDialog.NewDialogBindData
        public final ViewGroup getRootView() {
            return null;
        }

        @Override // com.yfanads.android.custom.view.NewCustomStyleDialog.NewDialogBindData
        public final void onConfigurationChanged(Context context, int i) {
            YFInterstitialActivity.this.templateData.updNativeSize(context, i, false);
            if (YFInterstitialActivity.this.customDialog != null) {
                YFInterstitialActivity.this.customDialog.adjustWindow(YFInterstitialActivity.this.templateData.popWidth, YFInterstitialActivity.this.templateData.popHeight);
            }
            AdBaseViewHolder adBaseViewHolder = this.f9636a;
            if (adBaseViewHolder != null) {
                adBaseViewHolder.updateNativeView(YFInterstitialActivity.this.templateData);
                this.f9636a.updateShowView(context, YFInterstitialActivity.this.templateData);
            }
            if (YFInterstitialActivity.this.eventCallback != null) {
                YFInterstitialActivity.this.eventCallback.onAdConfigurationChanged(this.f9636a, YFInterstitialActivity.this.templateData, i);
            }
        }
    }

    static {
        StubApp.interface11(56467);
        activityRefs = new ConcurrentHashMap();
    }

    public static void closeByInstanceId(String str) {
        Map<String, WeakReference<YFInterstitialActivity>> map = activityRefs;
        WeakReference<YFInterstitialActivity> weakReference = map.get(str);
        if (weakReference != null) {
            YFInterstitialActivity yFInterstitialActivity = weakReference.get();
            if (yFInterstitialActivity == null || yFInterstitialActivity.isFinishing()) {
                map.remove(str);
            } else {
                yFInterstitialActivity.closeSelf();
            }
        }
    }

    private InterTemplateData createTemplateData(String str, TemplateConf templateConf, int i) {
        return Objects.equals(str, TemplateRes.INT_V_3) ? new InterV3TemplateData(this, str, templateConf, i) : new InterTemplateData(this, str, templateConf, i);
    }

    private boolean parseIntentData() {
        String str;
        TemplateConf templateConf;
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        this.templateKey = intent.getStringExtra(EXTRA_TEMPLATE_KEY);
        this.layoutId = intent.getIntExtra(EXTRA_LAYOUT_ID, 0);
        this.orientation = intent.getIntExtra("orientation", 1);
        this.offsetTop = intent.getIntExtra(EXTRA_OFFSET_TOP, 0);
        this.templateConf = (TemplateConf) intent.getParcelableExtra(EXTRA_TEMPLATE_CONF);
        this.instanceId = intent.getStringExtra(EXTRA_INSTANCE_ID);
        if (this.layoutId == 0 || (str = this.templateKey) == null || (templateConf = this.templateConf) == null) {
            YFLog.error("InterstitialAdActivity: Missing required data");
            return false;
        }
        this.templateData = createTemplateData(str, templateConf, this.orientation);
        return true;
    }

    private void showAdDialog() {
        try {
            NewCustomStyleDialog.CustomDialogBuilder tag = new NewCustomStyleDialog.CustomDialogBuilder().setLayoutId(this.layoutId).setCloseId(R.id.ad_close).setTag(MediationConstant.RIT_TYPE_INTERSTITIAL);
            InterTemplateData interTemplateData = this.templateData;
            NewCustomStyleDialog newCustomStyleDialogBindData = tag.setSize(interTemplateData.popWidth, interTemplateData.popHeight).setGravity(17).setOffsetTop(this.offsetTop).setClickClose(this.templateData.isClickClose()).setTablet(YFAdsPhone.getInstance().isTablet).build().bindData(new a());
            this.customDialog = newCustomStyleDialogBindData;
            newCustomStyleDialogBindData.setCancelable(this.templateData.isPhyClose());
            this.customDialog.show(this);
        } catch (Exception e) {
            YFLog.error("InterstitialAdActivity: Failed to show ad dialog");
            e.printStackTrace();
            finish();
        }
    }

    public void closeSelf() {
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        InterTemplateData interTemplateData = this.templateData;
        if (interTemplateData == null || !interTemplateData.isPhyClose()) {
            return;
        }
        dismissDialog();
        finish();
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        dismissDialog();
        super.onDestroy();
    }

    private void dismissDialog() {
        NewCustomStyleDialog newCustomStyleDialog = this.customDialog;
        if (newCustomStyleDialog != null) {
            newCustomStyleDialog.hide();
            this.customDialog = null;
        }
    }
}

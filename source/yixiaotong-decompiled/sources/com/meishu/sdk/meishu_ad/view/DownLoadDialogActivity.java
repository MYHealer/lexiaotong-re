package com.meishu.sdk.meishu_ad.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.meishu.sdk.R;
import com.meishu.sdk.activity.MeishuDownloadDetailActivity;
import com.meishu.sdk.activity.MeishuWebviewActivity;
import com.meishu.sdk.activity.a;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.safe.SafeAppCompatActivity;
import com.meishu.sdk.core.utils.DownloadDialogBean;
import com.meishu.sdk.core.utils.DownloadUtils;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.k0;
import com.meishu.sdk.platform.ms.c;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DownLoadDialogActivity extends SafeAppCompatActivity {
    public static c y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f5111a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public View s;
    public List<MeishuAdInfo.PermissionBean> t;
    public String u;
    public String v;
    public TextView w;
    public TextView x;

    @Override // com.meishu.sdk.core.safe.SafeAppCompatActivity
    public void safeOnClick(View view) {
        try {
            if (view.getId() == R.id.ms_dialog_meishu_download_appdetail) {
                if (!TextUtils.isEmpty(this.v)) {
                    try {
                        String str = this.v;
                        Intent intent = new Intent(this, (Class<?>) MeishuWebviewActivity.class);
                        intent.putExtra(MeishuWebviewActivity.EXTRA_AD_DURL_KEY, new String[]{str});
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (!TextUtils.isEmpty(this.m)) {
                    DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                    downloadDialogBean.setApp_intro(this.m);
                    MeishuDownloadDetailActivity.startActivity(this, downloadDialogBean);
                }
            } else if (view.getId() == R.id.ms_dialog_meishu_download_permission) {
                if (!TextUtils.isEmpty(this.u)) {
                    try {
                        String str2 = this.u;
                        Intent intent2 = new Intent(this, (Class<?>) MeishuWebviewActivity.class);
                        intent2.putExtra(MeishuWebviewActivity.EXTRA_AD_DURL_KEY, new String[]{str2});
                        startActivity(intent2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (this.t != null) {
                    DownloadDialogBean downloadDialogBean2 = new DownloadDialogBean();
                    downloadDialogBean2.setApp_permission(this.t);
                    MeishuDownloadDetailActivity.startActivity(this, downloadDialogBean2);
                }
            } else if (view.getId() == R.id.ms_dialog_meishu_download_privacy) {
                try {
                    String str3 = this.r;
                    Intent intent3 = new Intent(this, (Class<?>) MeishuWebviewActivity.class);
                    intent3.putExtra(MeishuWebviewActivity.EXTRA_AD_DURL_KEY, new String[]{str3});
                    startActivity(intent3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } else if (view.getId() == R.id.ms_dialog_meishu_download_downloadBtn) {
                String[] strArrA = f.a(y.a().getDn_start(), y);
                String[] strArrA2 = f.a(y.a().getDn_succ(), y);
                String[] strArrA3 = f.a(y.a().getDn_inst_start(), y);
                String[] strArrA4 = f.a(y.a().getDn_inst_succ(), y);
                String appName = y.a().getAppName();
                if (appName == null) {
                    appName = "";
                }
                String str4 = appName;
                Map<Integer, k0> map = DownloadUtils.h;
                DownloadUtils.c.f4872a.a(StubApp.getOrigApplicationContext(getApplicationContext()), y.a().getdUrl()[0], str4, this.i, strArrA, strArrA2, strArrA3, strArrA4);
                Toast.makeText(this, "开始下载", 0).show();
                finish();
            } else if (view.getId() == R.id.ms_dialog_meishu_download_cancel) {
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.safe.SafeAppCompatActivity
    public void safeOnCreate(Bundle bundle) {
        AdSlot adSlotA;
        super.safeOnCreate(bundle);
        if (getResources().getConfiguration().orientation == 2) {
            setContentView(R.layout.ms_dialog_meishu_download_landscape);
        } else {
            setContentView(R.layout.ms_dialog_meishu_download);
        }
        this.f5111a = (ImageView) findViewById(R.id.ms_dialog_meishu_download_imageview);
        this.b = (TextView) findViewById(R.id.ms_dialog_meishu_download_title);
        this.c = (TextView) findViewById(R.id.ms_dialog_meishu_download_version);
        this.w = (TextView) findViewById(R.id.ms_dialog_meishu_download_size);
        this.d = (TextView) findViewById(R.id.ms_dialog_meishu_download_owner);
        this.e = (TextView) findViewById(R.id.ms_dialog_meishu_download_appdetail);
        this.s = findViewById(R.id.ms_dialog_meishu_download_divider);
        this.x = (TextView) findViewById(R.id.ms_dialog_meishu_download_permission);
        this.f = (TextView) findViewById(R.id.ms_dialog_meishu_download_privacy);
        this.g = (TextView) findViewById(R.id.ms_dialog_meishu_download_downloadBtn);
        this.h = (TextView) findViewById(R.id.ms_dialog_meishu_download_cancel);
        this.e.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        c cVar = y;
        if (cVar != null && (adSlotA = cVar.a()) != null) {
            try {
                this.j = adSlotA.getAppName();
                this.i = adSlotA.getPackageName();
                this.k = adSlotA.getIcon();
                this.l = adSlotA.getDeveloper();
                this.m = adSlotA.getApp_intro();
                this.n = adSlotA.getApp_feature();
                this.o = adSlotA.getPayment_types();
                this.p = adSlotA.getApp_ver();
                this.q = adSlotA.getApp_size();
                adSlotA.getApp_privacy();
                this.r = adSlotA.getPrivacy_agreement();
                if (adSlotA instanceof BaseAdSlot) {
                    this.t = ((BaseAdSlot) adSlotA).getApp_permission();
                    this.u = ((BaseAdSlot) adSlotA).getApp_permission_url();
                    this.v = ((BaseAdSlot) adSlotA).getApp_intor_url();
                }
            } catch (Exception e) {
                Log.e("DownLoadDialog", a.a("DownLoadDialog: ").append(e.getMessage()).toString());
                e.printStackTrace();
            }
        }
        try {
            if (!TextUtils.isEmpty(this.k)) {
                i iVar = new i((Context) null);
                iVar.d = this.f5111a;
                iVar.a(this.k, false);
            }
            if (TextUtils.isEmpty(this.j)) {
                this.b.setVisibility(8);
            } else {
                this.b.setText(this.j);
            }
            if (TextUtils.isEmpty(this.p)) {
                this.c.setVisibility(8);
            } else {
                this.c.setText("版本号 ：" + this.p);
            }
            if (TextUtils.isEmpty(this.q)) {
                this.w.setVisibility(8);
            } else {
                this.w.setText("大小 ：" + this.q);
            }
            if (TextUtils.isEmpty(this.l)) {
                this.d.setVisibility(8);
            } else {
                this.d.setText(this.l);
            }
            if (TextUtils.isEmpty(this.r)) {
                this.s.setVisibility(8);
                this.f.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.j) && TextUtils.isEmpty(this.n) && TextUtils.isEmpty(this.m) && TextUtils.isEmpty(this.q) && TextUtils.isEmpty(this.l) && TextUtils.isEmpty(this.o)) {
                this.s.setVisibility(8);
                this.e.setVisibility(8);
            }
        } catch (Exception e2) {
            Log.e("DownLoadDialog", a.a("initData: ").append(e2.getMessage()).toString());
        }
    }

    @Override // com.meishu.sdk.core.safe.SafeAppCompatActivity
    public void safeOnDestroy() {
        super.safeOnDestroy();
        y = null;
    }
}

package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.byazt.bv.BaseConstants;
import com.byazt.dd.tt;
import com.byazt.de.n;
import com.byazt.di.da;
import com.byazt.gq.t;
import com.byazt.gq.z;
import com.byazt.hu.u;
import com.byazt.hu.x;
import com.byazt.nn.a;
import com.byazt.nr.m;
import com.byazt.ok.c;
import com.byazt.ou.rl;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import com.byazt.z.ve;
import com.byazt.zz.Downloader;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class TTDelegateActivity extends Activity {
    private static c uj;
    protected Intent c = null;
    private boolean tt;
    private tt ve;

    static {
        StubApp.interface11(41996);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void c(String str, String[] strArr) {
        Intent intent = new Intent(t.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (t.getContext() != null) {
            t.getContext().startActivity(intent);
        }
    }

    public static void c(String str, com.byazt.dd.c cVar) {
        Intent intentVe = ve(cVar);
        intentVe.addFlags(268435456);
        intentVe.putExtra("type", 2);
        intentVe.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        if (t.getContext() != null) {
            t.getContext().startActivity(intentVe);
        }
    }

    public static void tt(String str, com.byazt.dd.c cVar) {
        Intent intentVe = ve(cVar);
        intentVe.addFlags(268435456);
        intentVe.putExtra("type", 11);
        intentVe.putExtra("package_name", str);
        if (t.getContext() != null) {
            t.getContext().startActivity(intentVe);
        }
    }

    public static void c(com.byazt.dd.c cVar) {
        Intent intentVe = ve(cVar);
        intentVe.addFlags(268435456);
        intentVe.putExtra("type", 4);
        intentVe.putExtra("model_id", cVar.tt());
        if (t.getContext() != null) {
            t.getContext().startActivity(intentVe);
        }
    }

    public static void c(com.byazt.dd.c cVar, c cVar2) {
        Intent intentVe = ve(cVar);
        intentVe.addFlags(268435456);
        intentVe.putExtra("type", 9);
        uj = cVar2;
        if (t.getContext() != null) {
            t.getContext().startActivity(intentVe);
        }
    }

    public static void c(long j) {
        Intent intent = new Intent(t.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (t.getContext() != null) {
            t.getContext().startActivity(intent);
        }
    }

    public static void c(String str, long j, String str2, JSONObject jSONObject) {
        Intent intent = new Intent(t.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (t.getContext() != null) {
            t.getContext().startActivity(intent);
        }
    }

    public static void c(String str, long j, String str2) {
        Intent intent = new Intent(t.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 13);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra(BaseConstants.VIVO_MARKET_NEED_COMMENT, str2);
        if (t.getContext() != null) {
            t.getContext().startActivity(intent);
        }
    }

    public static void tt(String str, long j, String str2) {
        Intent intent = new Intent(t.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 14);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("market_app_id", str2);
        if (t.getContext() != null) {
            t.getContext().startActivity(intent);
        }
    }

    public static void c(String str, long j) {
        Intent intent = new Intent(t.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 15);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        if (t.getContext() != null) {
            t.getContext().startActivity(intent);
        }
    }

    private static Intent ve(com.byazt.dd.c cVar) {
        return new Intent(t.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    public static void tt(com.byazt.dd.c cVar) {
        c(cVar, 5, "", "", "", "");
    }

    public static void c(com.byazt.dd.c cVar, String str) {
        c(cVar, 19, "", "", "", str);
    }

    public static void c(com.byazt.dd.c cVar, String str, String str2, String str3) {
        c(cVar, 8, str, str2, str3, "");
    }

    public static void c(com.byazt.dd.c cVar, String str, String str2, String str3, String str4) {
        c(cVar, 21, str, str2, str3, str4);
    }

    public static void tt(com.byazt.dd.c cVar, String str, String str2, String str3) {
        c(cVar, 7, str, str2, str3, "");
    }

    public static void tt(com.byazt.dd.c cVar, String str, String str2, String str3, String str4) {
        c(cVar, 20, str, str2, str3, str4);
    }

    private static void c(com.byazt.dd.c cVar, int i, String str, String str2, String str3, String str4) {
        Intent intentVe = ve(cVar);
        intentVe.addFlags(268435456);
        intentVe.putExtra("type", i);
        if (!TextUtils.isEmpty(str2)) {
            intentVe.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intentVe.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            intentVe.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            intentVe.putExtra("message_text", str);
        }
        intentVe.putExtra("model_id", cVar.tt());
        if (t.getContext() != null) {
            t.getContext().startActivity(intentVe);
        }
    }

    private void tt() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.c = intent;
        t.tt(this);
        c();
    }

    @Override // android.app.Activity
    protected void onStop() {
        tt ttVar;
        DownloadInfo downloadInfoTt;
        super.onStop();
        if (!this.tt || (ttVar = this.ve) == null) {
            return;
        }
        if (!TextUtils.isEmpty(ttVar.oz())) {
            downloadInfoTt = da.c(t.getContext()).c(this.ve.oz(), null, true);
        } else {
            downloadInfoTt = da.c(t.getContext()).tt(this.ve.c());
        }
        if (downloadInfoTt == null || downloadInfoTt.getCurBytes() < downloadInfoTt.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void c() {
        Intent intent = this.c;
        if (intent != null) {
            switch (intent.getIntExtra("type", 0)) {
                case 1:
                    tt(this.c.getStringExtra("permission_id_key"), this.c.getStringArrayExtra("permission_content_key"));
                    break;
                case 2:
                    c(this.c.getStringExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL));
                    break;
                case 3:
                case 6:
                case 17:
                case 18:
                default:
                    ve.c((Activity) this);
                    break;
                case 4:
                    tt(this.c.getLongExtra("model_id", 0L));
                    break;
                case 5:
                    c(this.c.getLongExtra("model_id", 0L), "");
                    break;
                case 7:
                case 8:
                case 20:
                case 21:
                    ve();
                    break;
                case 9:
                    c cVar = uj;
                    if (cVar != null) {
                        cVar.c();
                    }
                    ve.c((Activity) this);
                    break;
                case 10:
                    ve(this.c.getLongExtra("app_info_id", 0L));
                    break;
                case 11:
                    tt(this.c.getStringExtra("package_name"));
                    break;
                case 12:
                    x.c(this, this.c.getStringExtra("package_name"), this.c.getLongExtra("model_id", 0L), this.c.getStringExtra("param"), this.c.getStringExtra("ext_json"));
                    ve.c((Activity) this);
                    break;
                case 13:
                    x.c(this, this.c.getStringExtra("package_name"), this.c.getLongExtra("model_id", 0L), this.c.getStringExtra(BaseConstants.VIVO_MARKET_NEED_COMMENT));
                    ve.c((Activity) this);
                    break;
                case 14:
                    x.tt(this, this.c.getStringExtra("package_name"), this.c.getLongExtra("model_id", 0L), this.c.getStringExtra("market_app_id"));
                    ve.c((Activity) this);
                    break;
                case 15:
                    x.c((Activity) this, this.c.getStringExtra("package_name"), this.c.getLongExtra("model_id", 0L));
                    ve.c((Activity) this);
                    break;
                case 16:
                    x.c((Context) this, this.c.getStringExtra("package_name"), this.c.getLongExtra("model_id", 0L));
                    ve.c((Activity) this);
                    break;
                case 19:
                    c(this.c.getLongExtra("model_id", 0L), this.c.getStringExtra("delete_button_text"));
                    break;
            }
            this.c = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0098  */
    private void ve() {
        int iC;
        int i;
        int i2;
        CharSequence charSequence;
        DownloadInfo downloadInfoTt;
        long longExtra = this.c.getLongExtra("model_id", 0L);
        String stringExtra = this.c.getStringExtra("message_text");
        String stringExtra2 = this.c.getStringExtra("positive_button_text");
        String stringExtra3 = this.c.getStringExtra("negative_button_text");
        String stringExtra4 = this.c.getStringExtra("delete_button_text");
        int intExtra = this.c.getIntExtra("type", 0);
        tt ttVarUj = a.c().uj(longExtra);
        if (ttVarUj == null) {
            iC = -1;
            i = 0;
            i2 = 0;
        } else {
            if (!TextUtils.isEmpty(ttVarUj.oz())) {
                downloadInfoTt = da.c(t.getContext()).c(ttVarUj.oz(), null, true);
            } else {
                downloadInfoTt = da.c(t.getContext()).tt(ttVarUj.c());
            }
            if (downloadInfoTt != null) {
                long curBytes = downloadInfoTt.getCurBytes();
                long totalBytes = downloadInfoTt.getTotalBytes();
                if (curBytes <= 0 || totalBytes <= 0) {
                    iC = -1;
                    i = 0;
                    i2 = 0;
                } else {
                    i2 = (int) (curBytes / 1048576);
                    i = (int) (totalBytes / 1048576);
                    iC = com.byazt.gq.da.c(downloadInfoTt.getId(), (int) ((curBytes * 100) / totalBytes));
                }
            } else {
                iC = -1;
                i = 0;
                i2 = 0;
            }
        }
        n.c cVarVe = new n.c(this).c(false).c(stringExtra).tt(stringExtra2).ve(stringExtra3);
        if (intExtra == 7) {
            if (com.byazt.tg.a.c() == null) {
                return;
            }
            cVarVe.c(com.byazt.tg.a.c());
            cVarVe.c().show();
            charSequence = "download_percent";
        } else if (intExtra == 8) {
            if (com.byazt.tg.c.c() == null) {
                return;
            }
            cVarVe.c(com.byazt.tg.c.c());
            cVarVe.c().show();
            charSequence = "apk_size";
        } else if (intExtra == 20) {
            if (com.byazt.tg.ve.c() == null || com.byazt.tg.ve.tt() == null) {
                return;
            }
            cVarVe.c(com.byazt.tg.ve.c()).uj(stringExtra4).c(com.byazt.tg.ve.tt());
            cVarVe.c().show();
            charSequence = "download_percent_cancel";
        } else if (intExtra != 21) {
            charSequence = "";
        } else {
            if (com.byazt.tg.tt.c() == null || com.byazt.tg.tt.tt() == null) {
                return;
            }
            cVarVe.c(com.byazt.tg.tt.c()).uj(stringExtra4).c(com.byazt.tg.tt.tt());
            cVarVe.c().show();
            charSequence = "apk_size_cancel";
        }
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.tt = true;
        this.ve = ttVarUj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", charSequence);
            jSONObject.putOpt("pause_optimise_action", "show_dialog");
            jSONObject.putOpt("download_percent", Integer.valueOf(iC));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i));
        } catch (JSONException e) {
            m.c(e);
        }
        if (TextUtils.equals(charSequence, "download_percent") || TextUtils.equals(charSequence, "apk_size")) {
            com.byazt.zn.c.c().c("pause_optimise", jSONObject, ttVarUj);
        } else if (TextUtils.equals(charSequence, "download_percent_cancel") || TextUtils.equals(charSequence, "apk_size_cancel")) {
            com.byazt.zn.c.c().c("pause_cancel_optimise", jSONObject, ttVarUj);
        }
    }

    private void c(long j, String str) {
        if (z.c() == null) {
            return;
        }
        tt ttVarUj = a.c().uj(j);
        if (ttVarUj != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(ttVarUj.my());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - ttVarUj.lo()));
                jSONObject.putOpt("click_download_size", Long.valueOf(ttVarUj.pu()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (downloadInfo.getCurBytes() / 1048576)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (downloadInfo.getTotalBytes() / 1048576)));
                }
            } catch (Exception e) {
                m.c(e);
            }
            if (!TextUtils.isEmpty(str)) {
                com.byazt.zn.c.c().c("cancel_pause_reserve_wifi_dialog_show", jSONObject, ttVarUj);
            } else {
                com.byazt.zn.c.c().tt("pause_reserve_wifi_dialog_show", jSONObject, ttVarUj);
            }
        }
        n.c cVarC = new n.c(this).c(false).c(z.c());
        if (!TextUtils.isEmpty(str)) {
            cVarC.uj(str).c(z.tt());
        }
        cVarC.c().show();
        this.tt = true;
        this.ve = ttVarUj;
    }

    private void tt(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            ve.c((Activity) this);
            return;
        }
        rl rlVar = new rl() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
            public WeakReference<Activity> ve;

            {
                this.ve = new WeakReference<>(TTDelegateActivity.this);
            }

            @Override // com.byazt.ou.rl
            public void c() {
                com.byazt.hu.da.c(str);
                ve.c(this.ve.get());
            }

            @Override // com.byazt.ou.rl
            public void c(String str2) {
                com.byazt.hu.da.c(str, str2);
                ve.c(this.ve.get());
            }
        };
        try {
            t.n().c(this, strArr, rlVar);
        } catch (Exception e) {
            t.gt().c(e, "requestPermission");
            rlVar.c();
        }
    }

    private void c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                ve.c((Activity) this);
                return;
            }
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            intent.addFlags(268435456);
            if (com.byazt.k.c.ve().c("fix_app_link_flag")) {
                intent.addFlags(67108864);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            startActivity(intent);
        } catch (Exception e) {
            m.c(e);
        } finally {
            ve.c((Activity) this);
        }
    }

    private void tt(String str) {
        Intent intentSp = u.sp(this, str);
        if (intentSp == null) {
            ve.c((Activity) this);
            return;
        }
        try {
            intentSp.addFlags(268435456);
            intentSp.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            startActivity(intentSp);
        } catch (Exception e) {
            m.c(e);
        } finally {
            ve.c((Activity) this);
        }
    }

    private void tt(long j) {
        final tt ttVarUj = a.c().uj(j);
        if (ttVarUj == null) {
            com.byazt.dm.ve.c().c("showOpenAppDialogInner nativeModel null");
            ve.c((Activity) this);
            return;
        }
        com.byazt.ou.u uVarVe = t.ve();
        com.byazt.e.tt.c cVarC = new com.byazt.e.tt.c(this).c("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(ttVarUj.aw()) ? "刚刚下载的应用" : ttVarUj.aw();
        uVarVe.tt(cVarC.tt(String.format("%1$s已安装完成，是否立即打开？", objArr)).ve("打开").uj("取消").c(false).c(u.uj(this, ttVarUj.n())).c(new com.byazt.e.tt.InterfaceC0141tt() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.byazt.e.tt.InterfaceC0141tt
            public void c(DialogInterface dialogInterface) {
                com.byazt.us.c.tt(ttVarUj);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                ve.c((Activity) TTDelegateActivity.this);
            }

            @Override // com.byazt.e.tt.InterfaceC0141tt
            public void tt(DialogInterface dialogInterface) {
                com.byazt.zn.c.c().tt("market_openapp_cancel", ttVarUj);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                ve.c((Activity) TTDelegateActivity.this);
            }

            @Override // com.byazt.e.tt.InterfaceC0141tt
            public void ve(DialogInterface dialogInterface) {
                ve.c((Activity) TTDelegateActivity.this);
            }
        }).c(2).c());
        com.byazt.zn.c.c().tt("market_openapp_window_show", ttVarUj);
    }

    private void ve(long j) {
        new com.byazt.lr.c(this, j).show();
    }
}

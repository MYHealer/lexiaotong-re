package com.yfanads.android.adx.download.dialog;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stub.StubApp;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.core.load.SPManager;
import com.yfanads.android.adx.core.model.NativeSourceNew;
import com.yfanads.android.adx.download.DownloaderMgr;
import com.yfanads.android.adx.service.d;
import com.yfanads.android.adx.thirdpart.filedownload.FileDownloader;
import com.yfanads.android.adx.webview.AdxWebViewActivity;
import com.yfanads.android.custom.view.CustomDialog;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFUtil;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: DownloadService.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b {
    public CustomDialog b;
    public com.yfanads.android.adx.download.dialog.c c;
    public boolean d;
    public volatile boolean e;
    public String f;
    public String g;
    public final com.yfanads.android.adx.download.infs.b i;
    public int h = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9598a = d.a();

    /* JADX INFO: compiled from: DownloadService.java */
    public class a implements CustomDialog.NewDialogBindData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.yfanads.android.adx.model.a f9599a;

        public a(com.yfanads.android.adx.model.a aVar) {
            this.f9599a = aVar;
        }

        @Override // com.yfanads.android.custom.view.BaseDialogFragment.DialogBindData
        public final void bindViewData(View view) {
            b.this.a(new com.yfanads.android.adx.download.dialog.c(view), this.f9599a);
        }

        @Override // com.yfanads.android.custom.view.CustomDialog.NewDialogBindData
        public final void onConfigurationChanged(Context context, int i) {
            this.f9599a.a(context, i);
            CustomDialog customDialog = b.this.b;
            if (customDialog != null) {
                com.yfanads.android.adx.model.a aVar = this.f9599a;
                customDialog.adjustWindow(aVar.d, aVar.e);
            }
            com.yfanads.android.adx.download.dialog.c cVar = b.this.c;
            if (cVar != null) {
                cVar.a(this.f9599a);
            }
        }
    }

    /* JADX INFO: renamed from: com.yfanads.android.adx.download.dialog.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadService.java */
    public interface InterfaceC1171b {
        void onDismiss();
    }

    public b(com.yfanads.android.adx.download.infs.b bVar) {
        this.i = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, View view) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(this.f9598a, (Class<?>) AdxWebViewActivity.class);
        intent.putExtra("url", str);
        intent.setFlags(268435456);
        this.f9598a.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str, View view) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(this.f9598a, (Class<?>) AdxWebViewActivity.class);
        intent.putExtra("url", str);
        intent.setFlags(268435456);
        this.f9598a.startActivity(intent);
    }

    public final void a(com.yfanads.android.adx.download.dialog.c cVar, com.yfanads.android.adx.model.a aVar) {
        NativeSourceNew nativeSourceNew;
        this.c = cVar;
        final TextView textView = cVar.o;
        if (aVar == null || (nativeSourceNew = aVar.f9611a) == null || !nativeSourceNew.hasDownload()) {
            com.yfanads.android.adx.utils.a.b("bindData nativeSource is null, return.");
            return;
        }
        this.c.a(aVar);
        NativeSourceNew.Download download = aVar.f9611a.ad.download;
        this.f = download.Url;
        final String str = download.appIconUrl;
        if (!TextUtils.isEmpty(str)) {
            ViewUtils.loadCircleImage(str, this.c.c, 25);
        }
        final String str2 = download.appName;
        if (!TextUtils.isEmpty(str2)) {
            this.c.d.setText(str2);
        }
        final long j = download.fileSize;
        if (j > 0) {
            this.c.h.setText(YFUtil.formatSize(j));
        }
        if (!TextUtils.isEmpty(this.f)) {
            if (com.yfanads.android.adx.utils.b.a(2, this.f)) {
                com.yfanads.android.adx.utils.a.a("has apk");
                TextView textView2 = this.c.o;
                textView2.setBackgroundResource(R.drawable.download_download_radius_bg);
                textView2.setText(R.string.adx_install);
            } else if (com.yfanads.android.adx.utils.b.a(1, this.f)) {
                com.yfanads.android.adx.utils.a.a("has apk.temp");
                textView.setText(R.string.adx_continue);
                textView.setBackgroundResource(R.drawable.download_download_radius_bg);
            } else {
                com.yfanads.android.adx.utils.a.a("no download");
            }
        }
        String str3 = download.developerName;
        if (!TextUtils.isEmpty(str3)) {
            this.c.f.setText(str3);
        }
        this.c.g.setText("5");
        LinearLayout linearLayout = this.c.j;
        linearLayout.removeAllViews();
        if (!TextUtils.isEmpty("5")) {
            boolean z = false;
            for (int i = 0; i < 5; i++) {
                if (i <= Integer.parseInt("5") - 1) {
                    int i2 = R.mipmap.download_star;
                    ImageView imageView = new ImageView(this.f9598a);
                    imageView.setLayoutParams(new AbsListView.LayoutParams(37, 37));
                    imageView.setBackgroundResource(i2);
                    linearLayout.addView(imageView);
                } else if (Integer.parseInt("5") <= 0 || z) {
                    int i3 = R.mipmap.download_empty_star;
                    ImageView imageView2 = new ImageView(this.f9598a);
                    imageView2.setLayoutParams(new AbsListView.LayoutParams(37, 37));
                    imageView2.setBackgroundResource(i3);
                    linearLayout.addView(imageView2);
                } else {
                    int i4 = R.mipmap.download_half_star;
                    ImageView imageView3 = new ImageView(this.f9598a);
                    imageView3.setLayoutParams(new AbsListView.LayoutParams(37, 37));
                    imageView3.setBackgroundResource(i4);
                    linearLayout.addView(imageView3);
                    z = true;
                }
            }
        }
        String str4 = download.appDesc;
        if (!TextUtils.isEmpty(str4)) {
            this.c.i.setText(str4);
        }
        String str5 = download.appVer;
        if (!TextUtils.isEmpty(str5)) {
            this.c.k.setText(this.f9598a.getResources().getString(R.string.adx_version) + str5);
        }
        TextView textView3 = this.c.l;
        TextPaint paint = textView3.getPaint();
        paint.setFlags(8);
        paint.setAntiAlias(true);
        TextView textView4 = this.c.m;
        TextPaint paint2 = textView4.getPaint();
        paint2.setFlags(8);
        paint2.setAntiAlias(true);
        TextView textView5 = this.c.n;
        TextPaint paint3 = textView5.getPaint();
        paint3.setFlags(8);
        paint3.setAntiAlias(true);
        final String str6 = download.privacyUrl;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.download.dialog.b$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(str6, view);
            }
        });
        final String str7 = download.permissionUrl;
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.download.dialog.b$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(str7, view);
            }
        });
        final String str8 = download.appInfoUrl;
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.download.dialog.b$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.c(str8, view);
            }
        });
        this.c.p.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.download.dialog.b$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(textView, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.download.dialog.b$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(textView, str, str2, j, view);
            }
        });
        this.c.b.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.download.dialog.b$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
    }

    /* JADX INFO: compiled from: DownloadService.java */
    public static class c implements com.yfanads.android.adx.download.dialog.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SoftReference<b> f9600a;

        public c(b bVar) {
            this.f9600a = new SoftReference<>(bVar);
        }

        @Override // com.yfanads.android.adx.download.dialog.a
        public final void a() {
            if (this.f9600a.get() != null) {
                b bVar = this.f9600a.get();
                if (bVar.c == null || bVar.e) {
                    com.yfanads.android.adx.utils.a.a("completed not viewHolder is null or dismiss");
                    com.yfanads.android.adx.utils.b.c(TextUtils.isEmpty(bVar.g) ? com.yfanads.android.adx.utils.b.b(bVar.f) : bVar.g);
                    return;
                }
                com.yfanads.android.adx.download.infs.b bVar2 = bVar.i;
                if (bVar2 != null) {
                    bVar2.a(4, 5);
                }
                TextView textView = bVar.c.o;
                textView.setBackgroundResource(R.drawable.download_download_radius_bg);
                textView.setText(R.string.adx_install);
                com.yfanads.android.adx.utils.b.c(TextUtils.isEmpty(bVar.g) ? com.yfanads.android.adx.utils.b.b(bVar.f) : bVar.g);
                bVar.d = false;
            }
        }

        @Override // com.yfanads.android.adx.download.dialog.a
        public final void a(int i, int i2) {
            if (this.f9600a.get() != null) {
                b bVar = this.f9600a.get();
                if (bVar.c == null || bVar.e) {
                    return;
                }
                com.yfanads.android.adx.utils.a.a("soFarBytes " + i + " , " + i2 + " , ");
                bVar.c.q.setMax(i2);
                bVar.c.q.setProgress(i);
                bVar.d = true;
            }
        }

        @Override // com.yfanads.android.adx.download.dialog.a
        public final void a(boolean z) {
            if (this.f9600a.get() != null) {
                b bVar = this.f9600a.get();
                if (bVar.c == null || bVar.e) {
                    return;
                }
                if (z) {
                    bVar.c.o.setText(R.string.adx_downloading);
                } else {
                    bVar.c.o.setText(R.string.adx_continue);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, View view) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(this.f9598a, (Class<?>) AdxWebViewActivity.class);
        intent.putExtra("url", str);
        intent.setFlags(268435456);
        this.f9598a.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x0091  */
    public void a(TextView textView, View view) {
        if (this.c == null) {
            return;
        }
        String strB = TextUtils.isEmpty(this.g) ? com.yfanads.android.adx.utils.b.b(this.f) : this.g;
        int i = this.h;
        if (i != -1) {
            ConcurrentHashMap concurrentHashMap = DownloaderMgr.b;
            DownloaderMgr downloaderMgr = DownloaderMgr.b.f9596a;
            boolean z = this.d;
            String str = this.f;
            downloaderMgr.getClass();
            com.yfanads.android.adx.utils.a.a("clear download");
            if (!TextUtils.isEmpty(strB) && i != -1) {
                if (z) {
                    strB = strB + ".temp";
                }
                NotificationManager notificationManager = downloaderMgr.f9594a;
                if (notificationManager != null) {
                    notificationManager.cancel(i);
                }
                ConcurrentHashMap concurrentHashMap2 = DownloaderMgr.b;
                com.yfanads.android.adx.download.a aVar = (com.yfanads.android.adx.download.a) concurrentHashMap2.get(str);
                if (aVar != null) {
                    long j = aVar.l;
                    long j2 = SPManager.getLong(d.b, "downloadSize");
                    if (j > 0 && j2 > 0) {
                        SPManager.saveLong(d.b, "downloadSize", j2 - j);
                        concurrentHashMap2.remove(str);
                    }
                }
                if (FileDownloader.getImpl().clear(i, strB)) {
                    textView.setText(R.string.adx_download_now);
                    this.d = false;
                    textView.setBackgroundResource(R.drawable.download_download_radius_bg);
                }
            } else {
                textView.setText(R.string.adx_download_now);
                this.d = false;
                textView.setBackgroundResource(R.drawable.download_download_radius_bg);
            }
        } else {
            File file = new File(strB);
            if (file.exists()) {
                file.delete();
            }
        }
        textView.setText(R.string.adx_download_now);
        this.d = false;
        textView.setBackgroundResource(R.drawable.download_download_radius_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, String str, String str2, long j, View view) {
        com.yfanads.android.adx.download.a aVarA = null;
        if (textView.getText().equals(this.f9598a.getString(R.string.adx_download_now))) {
            textView.setBackgroundResource(0);
            textView.setText(R.string.adx_downloading);
            if (!TextUtils.isEmpty(this.f)) {
                com.yfanads.android.adx.download.infs.b bVar = this.i;
                if (bVar != null) {
                    bVar.a(3);
                }
                ConcurrentHashMap concurrentHashMap = DownloaderMgr.b;
                aVarA = DownloaderMgr.b.f9596a.a(this.f, str, str2, j, new c(this));
            }
            this.g = aVarA != null ? aVarA.b : "";
            this.h = aVarA != null ? aVarA.f9597a : -1;
            return;
        }
        if (textView.getText().equals(this.f9598a.getString(R.string.adx_install))) {
            com.yfanads.android.adx.utils.b.c(TextUtils.isEmpty(this.g) ? com.yfanads.android.adx.utils.b.b(this.f) : this.g);
            this.b.dismissAllowingStateLoss();
            this.b = null;
            this.c = null;
            return;
        }
        if (textView.getText().equals(this.f9598a.getString(R.string.adx_downloading))) {
            ConcurrentHashMap concurrentHashMap2 = DownloaderMgr.b;
            DownloaderMgr.b.f9596a.a(this.h, this.f);
            textView.setText(R.string.adx_continue);
            return;
        }
        textView.setBackgroundResource(0);
        textView.setText(R.string.adx_downloading);
        if (!TextUtils.isEmpty(this.f)) {
            com.yfanads.android.adx.download.infs.b bVar2 = this.i;
            if (bVar2 != null) {
                bVar2.a(3);
            }
            ConcurrentHashMap concurrentHashMap3 = DownloaderMgr.b;
            aVarA = DownloaderMgr.b.f9596a.a(this.f, str, str2, j, new c(this));
        }
        this.g = aVarA != null ? aVarA.b : "";
        this.h = aVarA != null ? aVarA.f9597a : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.b.dismissAllowingStateLoss();
        this.b = null;
        this.c = null;
    }

    public final void a(Activity activity, Bundle bundle, final InterfaceC1171b interfaceC1171b) {
        int i = activity.getResources().getConfiguration().orientation;
        NativeSourceNew nativeSourceNew = (NativeSourceNew) bundle.getParcelable("nativeSource");
        Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        int i2 = R.layout.dialog_software_download_layout;
        com.yfanads.android.adx.model.a aVar = new com.yfanads.android.adx.model.a(origApplicationContext, i2, nativeSourceNew, i);
        CustomDialog customDialogBindData = new CustomDialog.CustomDialogBuilder().setLayoutId(i2).setCloseId(R.id.im_close).setIsTablet(aVar.q).setSize(aVar.d, aVar.e).setGravity(80).build().bindData(new a(aVar));
        this.b = customDialogBindData;
        customDialogBindData.setCancelable(true);
        if (interfaceC1171b != null) {
            this.e = false;
            this.b.setDismiss(new CustomDialog.DialogDismiss() { // from class: com.yfanads.android.adx.download.dialog.b$$ExternalSyntheticLambda6
                @Override // com.yfanads.android.custom.view.CustomDialog.DialogDismiss
                public final void onDismiss() {
                    this.f$0.a(interfaceC1171b);
                }
            });
        }
        this.b.show(activity.getFragmentManager(), "download");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(InterfaceC1171b interfaceC1171b) {
        this.e = true;
        interfaceC1171b.onDismiss();
    }
}

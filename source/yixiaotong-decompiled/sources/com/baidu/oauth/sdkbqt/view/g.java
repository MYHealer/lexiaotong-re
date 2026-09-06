package com.baidu.oauth.sdkbqt.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.oauth.sdkbqt.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class g extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ListView f1912a;
    private i b;

    public interface b {
        void a(a aVar);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1913a;
        public Object b;
        public b c;

        public Object a() {
            return this.b;
        }

        public a(String str, b bVar) {
            this.f1913a = str;
            this.c = bVar;
        }

        public a(String str, b bVar, Object obj) {
            this.f1913a = str;
            this.c = bVar;
            this.b = obj;
        }
    }

    public g(Context context) {
        super(context);
        a();
    }

    public g(Context context, int i) {
        super(context, i);
        a();
    }

    protected g(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.bd_oauth_sdk_transparent);
        setContentView(R.layout.layout_bd_oauth_sdk_dialog_list);
        ListView listView = (ListView) findViewById(R.id.sapi_dialog_list_container);
        this.f1912a = listView;
        listView.setAdapter((ListAdapter) this.b);
        this.f1912a.setOnItemClickListener(new h(this));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.horizontalMargin = 0.1f;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.bd_oauth_sdk_transparent);
    }

    private void a() {
        this.b = new i(getContext());
        requestWindowFeature(1);
    }

    public void a(a aVar) {
        this.b.a(aVar);
    }
}

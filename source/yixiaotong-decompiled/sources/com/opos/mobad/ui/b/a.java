package com.opos.mobad.ui.b;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements com.opos.mobad.ui.b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ListView f8295a;
    c b;

    /* JADX INFO: renamed from: com.opos.mobad.ui.b.a$a, reason: collision with other inner class name */
    public static class C1029a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8296a;
        public final String b;

        public C1029a(String str, String str2) {
            this.f8296a = str;
            this.b = str2;
        }
    }

    public static class b extends RelativeLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f8297a;
        private TextView b;

        public b(Context context) {
            super(context);
            a(context);
        }

        private void a(Context context) {
            int iA = com.opos.cmn.an.h.f.a.a(context, 12.0f);
            int iA2 = com.opos.cmn.an.h.f.a.a(context, 24.0f);
            setPadding(iA2, iA, iA2, iA);
            TextView textView = new TextView(getContext());
            this.f8297a = textView;
            textView.setId(View.generateViewId());
            this.f8297a.setTextColor(Color.parseColor("#D9000000"));
            this.f8297a.setTextSize(1, 16.0f);
            this.f8297a.setGravity(17);
            this.f8297a.setGravity(51);
            this.f8297a.setLineSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 1.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            addView(this.f8297a, layoutParams);
            TextView textView2 = new TextView(getContext());
            this.b = textView2;
            textView2.setTextColor(Color.parseColor("#C4000000"));
            this.b.setTextSize(1, 12.0f);
            this.b.setGravity(17);
            this.b.setGravity(51);
            this.b.setLineSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 1.0f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(3, this.f8297a.getId());
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(context, 3.0f);
            addView(this.b, layoutParams2);
        }

        public void a(C1029a c1029a) {
            TextView textView;
            int i;
            if (c1029a == null) {
                return;
            }
            this.f8297a.setText(TextUtils.isEmpty(c1029a.f8296a) ? "" : c1029a.f8296a);
            if (TextUtils.isEmpty(c1029a.b)) {
                textView = this.b;
                i = 8;
            } else {
                this.b.setText(c1029a.b);
                textView = this.b;
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private static class c extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<C1029a> f8298a = new ArrayList();

        public void a(List<C1029a> list) {
            this.f8298a.clear();
            this.f8298a.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f8298a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f8298a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C1029a c1029a = (C1029a) getItem(i);
            d dVarA = d.a(view, viewGroup);
            dVarA.f8299a.a(c1029a);
            return dVarA.f8299a;
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f8299a;

        private d(b bVar) {
            this.f8299a = bVar;
        }

        public static final d a(View view, View view2) {
            if (view != null) {
                return (d) view.getTag();
            }
            b bVar = new b(view2.getContext());
            d dVar = new d(bVar);
            bVar.setTag(dVar);
            return dVar;
        }
    }

    public a(Context context) {
        ListView listView = new ListView(context);
        this.f8295a = listView;
        listView.setDividerHeight(0);
        c cVar = new c();
        this.b = cVar;
        this.f8295a.setAdapter((ListAdapter) cVar);
    }

    public static List<C1029a> b(Map<String, String> map) {
        com.opos.cmn.an.f.a.b("ComplianceListView", "transformMapToList = " + map);
        ArrayList arrayList = new ArrayList();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new C1029a(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.ui.b.d
    public int a() {
        return 1;
    }

    @Override // com.opos.mobad.ui.b.d
    public void a(String str) {
    }

    @Override // com.opos.mobad.ui.b.d
    public void a(Map<String, String> map) {
        this.b.a(b(map));
    }

    @Override // com.opos.mobad.ui.b.d
    public View b() {
        return this.f8295a;
    }

    @Override // com.opos.mobad.ui.b.d
    public void c() {
    }
}

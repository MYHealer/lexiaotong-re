package com.gnete.upbc.cashier.d;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.gnete.upbc.cashier.GnetePayChannel;
import com.gnete.upbc.cashier.GnetePayListener;
import com.gnete.upbc.cashier.R;
import com.gnete.upbc.cashier.a.g;
import com.gnete.upbc.cashier.b.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: compiled from: CashierFragment.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class a extends DialogFragment implements DialogInterface.OnKeyListener, View.OnClickListener {
    private static long v = 0;
    private static int w = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f3281a;
    private RelativeLayout b;
    private RelativeLayout c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private RelativeLayout h;
    private ImageView i;
    private TextView j;
    private Button k;
    private LinearLayout l;
    private Animation m;
    private Animation n;
    private Animation o;
    private Animation p;
    private com.gnete.upbc.cashier.b.b q;
    private GnetePayListener r;
    private boolean s = false;
    private List<com.gnete.upbc.cashier.f.c<f>> t;
    private Stack<View> u;

    /* JADX INFO: renamed from: com.gnete.upbc.cashier.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CashierFragment.java */
    class ViewOnClickListenerC0383a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f3282a;

        ViewOnClickListenerC0383a(f fVar) {
            this.f3282a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f3282a);
        }
    }

    /* JADX INFO: compiled from: CashierFragment.java */
    class b implements com.gnete.upbc.cashier.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ GnetePayChannel f3283a;

        b(GnetePayChannel gnetePayChannel) {
            this.f3283a = gnetePayChannel;
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a(com.gnete.upbc.cashier.b.a aVar) {
            com.gnete.upbc.cashier.e.f.a(a.this.getActivity(), a.this.q.a(a.this.q.e()), (GnetePayListener) null).a(aVar.b(), new C0384a());
        }

        /* JADX INFO: renamed from: com.gnete.upbc.cashier.d.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CashierFragment.java */
        class C0384a implements com.gnete.upbc.cashier.e.b.InterfaceC0387b {
            C0384a() {
            }

            @Override // com.gnete.upbc.cashier.e.b.InterfaceC0387b
            public void a() {
                b bVar = b.this;
                com.gnete.upbc.cashier.g.b.a(bVar.f3283a, a.this.r);
                a.this.dismissAllowingStateLoss();
            }

            @Override // com.gnete.upbc.cashier.e.b.InterfaceC0387b
            public void a(String str, Throwable th) {
                com.gnete.upbc.cashier.g.c.c(a.this.getActivity(), str);
                a.this.a(str, th);
            }
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a(String str, Throwable th) {
            com.gnete.upbc.cashier.g.c.c(a.this.getActivity(), str);
            a.this.a(str, th);
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a() {
            a.this.a();
        }
    }

    /* JADX INFO: compiled from: CashierFragment.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d.setEnabled(true);
            a.this.h.setEnabled(true);
            a.this.k.setEnabled(true);
        }
    }

    /* JADX INFO: compiled from: CashierFragment.java */
    class d implements com.gnete.upbc.cashier.f.a.InterfaceC0390a {
        d() {
        }

        @Override // com.gnete.upbc.cashier.f.a.InterfaceC0390a
        public void a() {
            com.gnete.upbc.cashier.g.b.a(a.this.getActivity(), a.this.q, a.this.r);
            a.this.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: compiled from: CashierFragment.java */
    static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3287a;

        static {
            int[] iArr = new int[GnetePayChannel.values().length];
            f3287a = iArr;
            try {
                iArr[GnetePayChannel.WXPAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3287a[GnetePayChannel.ALIPAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3287a[GnetePayChannel.CUPPAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a() {
        setStyle(0, R.style.gneteCashierTheme);
    }

    private void h() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        new com.gnete.upbc.cashier.f.a().a("您的订单尚未完成, 是否继续支付?").a("继续支付", (com.gnete.upbc.cashier.f.a.b) null).a(new d()).show(activity.getFragmentManager(), "CASHIER_CLOSE_ALERT");
    }

    public void a(GnetePayListener gnetePayListener) {
        this.r = gnetePayListener;
    }

    public void a(com.gnete.upbc.cashier.b.b bVar) {
        this.q = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (b(id)) {
            return;
        }
        if (id == R.id.gnete_cashier_image_close) {
            h();
            return;
        }
        if (id == R.id.gnete_cashier_r_layout_pay_type) {
            if (this.q.e().b().size() > 1) {
                a(this.c);
            }
        } else if (id == R.id.gnete_pay_type_image_back) {
            g();
        } else if (id == R.id.gnete_cashier_button_pay) {
            e();
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3281a = layoutInflater.inflate(R.layout.gnete_fragment_cashier, viewGroup);
        d();
        c();
        return this.f3281a;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            return g();
        }
        return false;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(this);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.gneteCashierAnimStyle);
                window.setBackgroundDrawable(new ColorDrawable(0));
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = (getResources().getDisplayMetrics().heightPixels * 7) / 10;
                attributes.gravity = 80;
                window.setAttributes(attributes);
            }
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    private boolean b(int i) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = v;
        long j2 = jUptimeMillis - j;
        if (w == i && j > 0 && j2 < 1000) {
            return true;
        }
        v = jUptimeMillis;
        w = i;
        return false;
    }

    private void c() {
        this.u.push(this.b);
        this.e.setText(this.q.e().c());
        this.f.setText(this.q.e().a());
        this.g.setText(this.q.e().d());
        this.k.setText("支付￥".concat(this.q.e().c()));
        List<f> listB = this.q.e().b();
        for (f fVar : listB) {
            com.gnete.upbc.cashier.f.c<f> cVar = new com.gnete.upbc.cashier.f.c<>(getActivity(), fVar);
            cVar.setOnClickListener(new ViewOnClickListenerC0383a(fVar));
            this.l.addView(cVar);
            this.t.add(cVar);
        }
        a(listB.get(0));
    }

    private void d() {
        this.b = (RelativeLayout) a(R.id.gnete_cashier_r_layout);
        this.c = (RelativeLayout) a(R.id.gnete_pay_type_r_layout);
        this.d = (ImageView) a(R.id.gnete_cashier_image_close);
        this.e = (TextView) a(R.id.gnete_cashier_text_amount);
        this.f = (TextView) a(R.id.gnete_cashier_text_busi_mer_name_content);
        this.g = (TextView) a(R.id.gnete_cashier_text_subject_content);
        this.h = (RelativeLayout) a(R.id.gnete_cashier_r_layout_pay_type);
        this.i = (ImageView) a(R.id.gnete_cashier_image_pay_type);
        this.j = (TextView) a(R.id.gnete_cashier_text_pay_type_content);
        this.k = (Button) a(R.id.gnete_cashier_button_pay);
        ImageView imageView = (ImageView) a(R.id.gnete_pay_type_image_back);
        this.l = (LinearLayout) a(R.id.gnete_pay_type_l_layout_list);
        this.m = AnimationUtils.loadAnimation(getActivity(), R.anim.gnete_layout_left_in);
        this.n = AnimationUtils.loadAnimation(getActivity(), R.anim.gnete_layout_left_out);
        this.o = AnimationUtils.loadAnimation(getActivity(), R.anim.gnete_layout_right_in);
        this.p = AnimationUtils.loadAnimation(getActivity(), R.anim.gnete_layout_right_out);
        this.t = new ArrayList();
        this.u = new Stack<>();
        this.d.setOnClickListener(this);
        this.h.setOnClickListener(this);
        imageView.setOnClickListener(this);
        this.k.setOnClickListener(this);
    }

    private void e() {
        GnetePayChannel gnetePayChannelF = this.q.f();
        int i = e.f3287a[gnetePayChannelF.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            b();
            g.a(this.q.a()).a(new b(gnetePayChannelF));
        }
    }

    private void f() {
        if (this.u.size() > 1) {
            View viewPop = this.u.pop();
            viewPop.startAnimation(this.p);
            viewPop.setVisibility(8);
            while (this.u.size() > 1) {
                this.u.pop();
            }
            View viewPeek = this.u.peek();
            viewPeek.startAnimation(this.m);
            viewPeek.setVisibility(0);
        }
    }

    private boolean g() {
        if (!this.s) {
            if (this.u.size() > 1) {
                View viewPop = this.u.pop();
                viewPop.startAnimation(this.p);
                viewPop.setVisibility(8);
                View viewPeek = this.u.peek();
                viewPeek.startAnimation(this.m);
                viewPeek.setVisibility(0);
            } else {
                h();
            }
        }
        return true;
    }

    private <V extends View> V a(int i) {
        return (V) this.f3281a.findViewById(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Throwable th) {
        g.c(this.q.a(new com.gnete.upbc.cashier.b.e.a(getActivity()).a(com.gnete.upbc.cashier.b.g.NORMAL).a(this.q.f()).a(str).a(th).a())).a(null);
    }

    private void b() {
        this.s = true;
        this.d.setEnabled(false);
        this.h.setEnabled(false);
        this.k.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        this.q.a(fVar.d());
        Iterator<com.gnete.upbc.cashier.f.c<f>> it = this.t.iterator();
        while (it.hasNext()) {
            it.next().setChecked(fVar);
        }
        this.i.setImageResource(fVar.a());
        this.j.setText(fVar.b());
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.s = false;
        getActivity().runOnUiThread(new c());
    }

    private void a(View view) {
        View viewPeek = this.u.peek();
        viewPeek.startAnimation(this.n);
        viewPeek.setVisibility(8);
        view.startAnimation(this.o);
        view.setVisibility(0);
        this.u.push(view);
    }
}

package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.ad.reward.view.RewardMaskBView;
import com.miui.zeus.mimo.sdk.view.guide.GuideBuildException;
import com.miui.zeus.mimo.sdk.view.guide.GuideBuilder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f2 implements e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q8 f5421a;
    public e2.a b;

    public class a implements GuideBuilder.a {
        public a() {
        }

        @Override // com.miui.zeus.mimo.sdk.view.guide.GuideBuilder.a
        public void a() {
            e2.a aVar = f2.this.b;
            if (aVar != null) {
                ((j2.l.a) aVar).a();
            }
        }

        @Override // com.miui.zeus.mimo.sdk.view.guide.GuideBuilder.a
        public void b() {
            e2.a aVar = f2.this.b;
            if (aVar != null) {
                ((j2.l.a) aVar).b();
            }
        }
    }

    public class b implements r8 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5423a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ Activity c;

        public b(f2 f2Var, View view, String[] strArr, Activity activity) {
            this.f5423a = view;
            this.b = strArr;
            this.c = activity;
        }

        @Override // com.miui.zeus.mimo.sdk.r8
        public int a() {
            int iD = f9.d(y8.f5752a);
            if (this.c.getResources().getConfiguration().orientation == 2) {
                iD = f9.c(y8.f5752a);
            }
            if (this.f5423a.getWidth() > iD / 2) {
                return f9.a(y8.f5752a, 30.0f);
            }
            return 0;
        }

        @Override // com.miui.zeus.mimo.sdk.r8
        public View a(ViewGroup viewGroup) {
            RewardMaskBView rewardMaskBView = (RewardMaskBView) LayoutInflater.from(this.f5423a.getContext()).inflate(a0.Y2, viewGroup, false);
            String[] strArr = this.b;
            rewardMaskBView.a(strArr[0], strArr[1]);
            rewardMaskBView.setMaxWith(((this.f5423a.getMeasuredWidth() * 3) / 5) - a());
            return rewardMaskBView;
        }

        @Override // com.miui.zeus.mimo.sdk.r8
        public int b() {
            return 2;
        }

        @Override // com.miui.zeus.mimo.sdk.r8
        public int c() {
            return f9.a(y8.f5752a, 2.0f);
        }

        @Override // com.miui.zeus.mimo.sdk.r8
        public int d() {
            return 32;
        }
    }

    @Override // com.miui.zeus.mimo.sdk.e2
    public void a(Activity activity, String[] strArr, View view, e2.a aVar) {
        if (activity == null || strArr == null || view == null) {
            return;
        }
        this.b = aVar;
        q8 q8Var = this.f5421a;
        if (q8Var != null) {
            q8Var.a();
            this.f5421a = null;
        }
        GuideBuilder guideBuilder = new GuideBuilder();
        if (guideBuilder.d) {
            throw new GuideBuildException(ijiami_1011.s.s.s.d(new byte[]{115, 14, 66, 87, 86, 85, Ascii.CAN, 68, 5, 16, 84, 4, 70, 7, 84, Ascii.FS, Ascii.ETB, 67, 4, 6, 19, 11, 93, 1, Ascii.DC2, 3, 16, 92, 82, 70, 65, 11, 8, 7, Ascii.US}, "2b0271"));
        }
        guideBuilder.f5715a.f5598a = view;
        GuideBuilder guideBuilderA = guideBuilder.a(0);
        if (guideBuilderA.d) {
            throw new GuideBuildException(ijiami_1011.s.s.s.d(new byte[]{119, 14, 17, 86, 0, 2, Ascii.CAN, 68, 5, 16, 84, 4, 66, 7, 7, Ascii.GS, 65, Ascii.DC4, 4, 6, 19, 11, 93, 1, Ascii.SYN, 3, 67, 93, 4, 17, 65, 11, 8, 7, Ascii.US}, "6bc3af"));
        }
        s8 s8Var = guideBuilderA.f5715a;
        s8Var.p = 0;
        s8Var.g = false;
        guideBuilderA.b(0);
        a aVar2 = new a();
        boolean z = guideBuilder.d;
        if (z) {
            throw new GuideBuildException(ijiami_1011.s.s.s.d(new byte[]{120, 94, 65, 87, 7, 7, Ascii.CAN, 68, 5, 16, 84, 4, 77, 87, 87, Ascii.RS, 70, 17, 4, 6, 19, 11, 93, 1, Ascii.EM, 83, 19, 92, 3, Ascii.DC4, 65, 11, 8, 7, Ascii.US}, "9232fc"));
        }
        guideBuilder.c = aVar2;
        b bVar = new b(this, view, strArr, activity);
        if (z) {
            throw new GuideBuildException(ijiami_1011.s.s.s.d(new byte[]{119, 84, 70, 83, 3, 80, Ascii.CAN, 68, 5, 16, 84, 4, 66, 93, 80, 26, 66, 70, 4, 6, 19, 11, 93, 1, Ascii.SYN, 89, Ascii.DC4, 88, 7, 67, 65, 11, 8, 7, Ascii.US}, "6846b4"));
        }
        guideBuilder.b.add(bVar);
        q8 q8VarA = guideBuilder.a();
        this.f5421a = q8VarA;
        q8VarA.a(activity);
    }

    @Override // com.miui.zeus.mimo.sdk.e2, android.content.DialogInterface
    public void dismiss() {
        q8 q8Var = this.f5421a;
        if (q8Var != null) {
            q8Var.a();
            this.f5421a = null;
        }
        e2.a aVar = this.b;
        if (aVar != null) {
            ((j2.l.a) aVar).a();
            this.b = null;
        }
    }
}

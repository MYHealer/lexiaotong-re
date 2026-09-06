package com.miui.zeus.mimo.sdk;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;
import com.miui.zeus.mimo.sdk.view.component.RootICP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o7 extends RootICP {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5551a;
    public int b;
    public int c;
    public ValueAnimator d;
    public c[] e;
    public final List<b> f;
    public d g;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o7.a(o7.this);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f5553a;
        public ImageView b;
        public int c;
        public int d;
        public int e;
        public int f;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5554a;
        public String b;
    }

    public interface d {
        void a(ClickAreaType clickAreaType, n6 n6Var);
    }

    public o7(Context context, AttributeSet attributeSet) {
        this(context, null, -1);
    }

    public o7(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 5000;
        this.f = new ArrayList();
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0120  */
    public static void a(o7 o7Var) {
        int iIntValue;
        int i;
        o7Var.removeAllViews();
        if (!o7Var.f.isEmpty()) {
            o7Var.f.clear();
        }
        int iRound = Math.round((o7Var.c * 12) / 5000.0f);
        int i2 = 0;
        while (i2 < iRound) {
            List<b> list = o7Var.f;
            b bVar = new b();
            int[] iArr = {0, 2};
            c cVar = null;
            b bVar2 = i2 >= 1 ? list.get(i2 - 1) : null;
            int i3 = i2 % 3;
            if (i3 == 0) {
                iIntValue = iArr[new Random().nextInt(2)];
            } else if (i3 == 1) {
                int i4 = bVar2 != null ? bVar2.f : -1;
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = iArr[i5];
                    if (i6 != i4) {
                        arrayList.add(Integer.valueOf(i6));
                    }
                }
                iIntValue = ((Integer) arrayList.get(new Random().nextInt(arrayList.size()))).intValue();
            } else {
                iIntValue = 1;
            }
            bVar.f = iIntValue;
            int randomWH = o7Var.getRandomWH();
            bVar.e = randomWH;
            bVar.c = (((iIntValue * 2) + 1) * (o7Var.f5551a / 6)) - (randomWH / 2);
            bVar.d = i2 <= 0 ? randomWH * (-1) : o7Var.f.get(i2 - 1).d - ((new Random().nextInt(100) + randomWH) - 50);
            c[] cVarArr = o7Var.e;
            if (cVarArr != null && cVarArr.length > 0) {
                if (cVarArr.length == 1) {
                    cVar = cVarArr[0];
                } else if (i2 <= 1) {
                    cVar = cVarArr[new Random().nextInt(o7Var.e.length)];
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (b bVar3 : o7Var.f) {
                        if (bVar3 != null && bVar3.f == iIntValue) {
                            arrayList2.add(bVar3);
                        }
                    }
                    int size = arrayList2.size();
                    if (size >= 2) {
                        b bVar4 = (b) arrayList2.get(size - 1);
                        b bVar5 = (b) arrayList2.get(size - 2);
                        i = bVar4.f5553a.f5554a;
                        if (i != bVar5.f5553a.f5554a) {
                            i = -1;
                        }
                    } else {
                        i = -1;
                    }
                    b bVar6 = o7Var.f.get(i2 - 1);
                    b bVar7 = o7Var.f.get(i2 - 2);
                    int i7 = bVar6.f5553a.f5554a;
                    int i8 = i7 == bVar7.f5553a.f5554a ? i7 : -1;
                    ArrayList arrayList3 = new ArrayList();
                    for (c cVar2 : o7Var.e) {
                        int i9 = cVar2.f5554a;
                        if (i9 != i && i9 != i8) {
                            arrayList3.add(cVar2);
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        for (c cVar3 : o7Var.e) {
                            if (cVar3.f5554a != i) {
                                arrayList3.add(cVar3);
                            }
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        cVar = (c) arrayList3.get(new Random().nextInt(arrayList3.size()));
                    }
                }
            }
            if (cVar != null) {
                ImageICP imageICP = new ImageICP(o7Var.getContext());
                imageICP.setLayoutParams(new FrameLayout.LayoutParams(randomWH, randomWH));
                imageICP.setVisibility(4);
                imageICP.setOnClickListener(new r7(o7Var));
                o7Var.addView(imageICP);
                Glide.with(y8.f5752a).load(cVar.b).into(imageICP);
                bVar.b = imageICP;
                bVar.f5553a = cVar;
            }
            list.add(bVar);
            i2++;
        }
        ValueAnimator valueAnimator = o7Var.d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, o7Var.getTotalTranslation());
        o7Var.d = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new p7(o7Var));
        o7Var.d.addListener(new q7(o7Var));
        o7Var.d.setInterpolator(new LinearInterpolator());
        o7Var.d.setDuration(o7Var.c);
        o7Var.d.start();
    }

    private int getRandomWH() {
        int[] iArr = {240, 180};
        int width = getParent() instanceof View ? ((View) getParent()).getWidth() : 0;
        int[] iArrCopyOf = Arrays.copyOf(iArr, 2);
        if (width > 0 && width < 1080) {
            double d2 = ((double) width) / 1080.0d;
            for (int i = 0; i < 2; i++) {
                int i2 = iArr[i];
                iArrCopyOf[i] = Math.max((int) (((double) i2) * d2), i2 / 2);
            }
        }
        return iArrCopyOf[new Random().nextInt(2)];
    }

    private int getTotalTranslation() {
        if (this.f.size() <= 0) {
            return this.b;
        }
        List<b> list = this.f;
        return Math.abs(list.get(list.size() - 1).d);
    }

    public void a() {
        post(new a());
    }

    public void b() {
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.d.removeAllUpdateListeners();
            this.d.removeAllListeners();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size <= 0 || size2 <= 0) {
            return;
        }
        this.f5551a = size;
        this.b = size2;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            i = 5000;
        }
        this.c = i;
    }

    public void setImages(List<String> list) {
        if (list == null || list.size() <= 0) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        this.e = new c[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            c cVar = new c();
            cVar.f5554a = i;
            cVar.b = (String) arrayList.get(i);
            this.e[i] = cVar;
        }
    }

    public void setRedPacketItemClickListener(d dVar) {
        this.g = dVar;
    }
}

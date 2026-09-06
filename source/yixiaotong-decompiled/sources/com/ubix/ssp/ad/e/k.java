package com.ubix.ssp.ad.e;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class k extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayout f8831a;
    private int b;
    private String c;
    private String d;

    public k(Context context, int i, int i2, boolean z, boolean z2) {
        this(context, i, i2, z, z2, false, "", "");
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0086  */
    /* JADX WARN: Code duplicated, block: B:17:0x008a  */
    /* JADX WARN: Code duplicated, block: B:20:0x008f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0091  */
    /* JADX WARN: Code duplicated, block: B:23:0x0097  */
    /* JADX WARN: Code duplicated, block: B:29:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:34:0x0107  */
    /* JADX WARN: Code duplicated, block: B:37:0x0123  */
    /* JADX WARN: Code duplicated, block: B:39:0x0137 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0139  */
    /* JADX WARN: Code duplicated, block: B:43:0x0146  */
    /* JADX WARN: Code duplicated, block: B:44:0x0148  */
    /* JADX WARN: Code duplicated, block: B:47:0x015f  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    public k(Context context, int i, int i2, boolean z, boolean z2, boolean z3, String str, String str2) {
        View view;
        boolean z4;
        TextView textView;
        TextView textView2;
        int iA;
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout;
        Context context2;
        String str3;
        LinearLayout.LayoutParams layoutParams3;
        ImageView imageView;
        View view2;
        super(context);
        this.c = "摇动手机";
        this.d = "跳转详情页或第三方应用";
        this.b = i;
        setGravity(17);
        setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.f8831a = linearLayout2;
        linearLayout2.setOrientation(1);
        this.f8831a.setGravity(17);
        if (i != 0) {
            if (i == 1) {
                j jVar = new j(getContext());
                jVar.b();
                view2 = jVar;
            } else if (i != 2) {
                imageView = null;
            } else {
                p pVar = new p(getContext());
                pVar.b();
                view2 = pVar;
            }
            z4 = false;
            view = view2;
            textView = new TextView(getContext());
            textView2 = new TextView(getContext());
            view.setId(910101);
            textView.setId(910102);
            textView2.setId(910103);
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    this.c = str;
                }
                if (!TextUtils.isEmpty(str2)) {
                }
                textView.setText(this.c);
                textView2.setText(this.d);
                textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
                textView.setTextColor(-1);
                textView.getPaint().setFakeBoldText(true);
                textView.setTextSize(16.0f);
                textView.setGravity(1);
                textView2.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
                textView2.setTextColor(-1);
                textView2.setTextSize(12.0f);
                textView2.setGravity(1);
                if (i2 != -1) {
                    view.setPadding(30, 30, 30, 30);
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                iA = (int) (com.ubix.ssp.ad.e.a0.r.a().a(getContext()) * 20.0f * 4.0f);
                if (z) {
                    int i3 = (int) (((double) iA) * 0.8d);
                    layoutParams = new LinearLayout.LayoutParams(i3, i3);
                } else {
                    int i4 = (int) (((double) iA) * 1.1d);
                    layoutParams = new LinearLayout.LayoutParams(i4, i4);
                }
                layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(0, 20, 0, 20);
                if (i2 == 1) {
                    if (i2 == 0) {
                        linearLayout = this.f8831a;
                        context2 = getContext();
                        str3 = "#40000000";
                    }
                    LinearLayout linearLayout3 = this.f8831a;
                    if (z4) {
                        layoutParams3 = layoutParams;
                    } else {
                        layoutParams3 = new LinearLayout.LayoutParams(layoutParams.width - 60, layoutParams.height - 60);
                    }
                    linearLayout3.addView(view, layoutParams3);
                    addView(this.f8831a, layoutParams);
                    if (z2) {
                        addView(textView, layoutParams2);
                        addView(textView2, layoutParams2);
                    }
                }
                linearLayout = this.f8831a;
                context2 = getContext();
                str3 = "#73ffffff";
                linearLayout.setBackground(com.ubix.ssp.ad.e.a0.c.a(context2, Color.parseColor(str3), MediaPlayer.MEDIA_PLAYER_OPTION_SPADE));
                LinearLayout linearLayout4 = this.f8831a;
                if (z4) {
                    layoutParams3 = layoutParams;
                } else {
                    layoutParams3 = new LinearLayout.LayoutParams(layoutParams.width - 60, layoutParams.height - 60);
                }
                linearLayout4.addView(view, layoutParams3);
                addView(this.f8831a, layoutParams);
                if (z2) {
                    addView(textView, layoutParams2);
                    addView(textView2, layoutParams2);
                }
            }
            this.c = str == null ? "" : str;
            if (str2 == null) {
                str2 = "";
            }
            this.d = str2;
            textView.setText(this.c);
            textView2.setText(this.d);
            textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
            textView.setTextColor(-1);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(16.0f);
            textView.setGravity(1);
            textView2.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
            textView2.setTextColor(-1);
            textView2.setTextSize(12.0f);
            textView2.setGravity(1);
            if (i2 != -1) {
                view.setPadding(30, 30, 30, 30);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            iA = (int) (com.ubix.ssp.ad.e.a0.r.a().a(getContext()) * 20.0f * 4.0f);
            if (z) {
                int i5 = (int) (((double) iA) * 0.8d);
                layoutParams = new LinearLayout.LayoutParams(i5, i5);
            } else {
                int i6 = (int) (((double) iA) * 1.1d);
                layoutParams = new LinearLayout.LayoutParams(i6, i6);
            }
            layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 20, 0, 20);
            if (i2 == 1) {
                if (i2 == 0) {
                    linearLayout = this.f8831a;
                    context2 = getContext();
                    str3 = "#40000000";
                }
                LinearLayout linearLayout5 = this.f8831a;
                if (z4) {
                    layoutParams3 = layoutParams;
                } else {
                    layoutParams3 = new LinearLayout.LayoutParams(layoutParams.width - 60, layoutParams.height - 60);
                }
                linearLayout5.addView(view, layoutParams3);
                addView(this.f8831a, layoutParams);
                if (z2) {
                    addView(textView, layoutParams2);
                    addView(textView2, layoutParams2);
                }
            }
            linearLayout = this.f8831a;
            context2 = getContext();
            str3 = "#73ffffff";
            linearLayout.setBackground(com.ubix.ssp.ad.e.a0.c.a(context2, Color.parseColor(str3), MediaPlayer.MEDIA_PLAYER_OPTION_SPADE));
            LinearLayout linearLayout6 = this.f8831a;
            if (z4) {
                layoutParams3 = layoutParams;
            } else {
                layoutParams3 = new LinearLayout.LayoutParams(layoutParams.width - 60, layoutParams.height - 60);
            }
            linearLayout6.addView(view, layoutParams3);
            addView(this.f8831a, layoutParams);
            if (z2) {
                addView(textView, layoutParams2);
                addView(textView2, layoutParams2);
            }
        }
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageDrawable(q.a("ubix/ic_hand_shake.webp"));
        imageView2.setVisibility(0);
        imageView = imageView2;
        z4 = true;
        view = imageView;
        textView = new TextView(getContext());
        textView2 = new TextView(getContext());
        view.setId(910101);
        textView.setId(910102);
        textView2.setId(910103);
        if (z3) {
            if (!TextUtils.isEmpty(str)) {
                this.c = str;
            }
            if (!TextUtils.isEmpty(str2)) {
            }
            textView.setText(this.c);
            textView2.setText(this.d);
            textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
            textView.setTextColor(-1);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(16.0f);
            textView.setGravity(1);
            textView2.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
            textView2.setTextColor(-1);
            textView2.setTextSize(12.0f);
            textView2.setGravity(1);
            if (i2 != -1) {
                view.setPadding(30, 30, 30, 30);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            iA = (int) (com.ubix.ssp.ad.e.a0.r.a().a(getContext()) * 20.0f * 4.0f);
            if (z) {
                int i7 = (int) (((double) iA) * 0.8d);
                layoutParams = new LinearLayout.LayoutParams(i7, i7);
            } else {
                int i8 = (int) (((double) iA) * 1.1d);
                layoutParams = new LinearLayout.LayoutParams(i8, i8);
            }
            layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 20, 0, 20);
            if (i2 == 1) {
                if (i2 == 0) {
                    linearLayout = this.f8831a;
                    context2 = getContext();
                    str3 = "#40000000";
                }
                LinearLayout linearLayout7 = this.f8831a;
                if (z4) {
                    layoutParams3 = layoutParams;
                } else {
                    layoutParams3 = new LinearLayout.LayoutParams(layoutParams.width - 60, layoutParams.height - 60);
                }
                linearLayout7.addView(view, layoutParams3);
                addView(this.f8831a, layoutParams);
                if (z2) {
                    addView(textView, layoutParams2);
                    addView(textView2, layoutParams2);
                }
            }
            linearLayout = this.f8831a;
            context2 = getContext();
            str3 = "#73ffffff";
            linearLayout.setBackground(com.ubix.ssp.ad.e.a0.c.a(context2, Color.parseColor(str3), MediaPlayer.MEDIA_PLAYER_OPTION_SPADE));
            LinearLayout linearLayout8 = this.f8831a;
            if (z4) {
                layoutParams3 = layoutParams;
            } else {
                layoutParams3 = new LinearLayout.LayoutParams(layoutParams.width - 60, layoutParams.height - 60);
            }
            linearLayout8.addView(view, layoutParams3);
            addView(this.f8831a, layoutParams);
            if (z2) {
                addView(textView, layoutParams2);
                addView(textView2, layoutParams2);
            }
        }
        this.c = str == null ? "" : str;
        if (str2 == null) {
            str2 = "";
        }
        this.d = str2;
        textView.setText(this.c);
        textView2.setText(this.d);
        textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
        textView.setTextColor(-1);
        textView.getPaint().setFakeBoldText(true);
        textView.setTextSize(16.0f);
        textView.setGravity(1);
        textView2.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
        textView2.setTextColor(-1);
        textView2.setTextSize(12.0f);
        textView2.setGravity(1);
        if (i2 != -1) {
            view.setPadding(30, 30, 30, 30);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        iA = (int) (com.ubix.ssp.ad.e.a0.r.a().a(getContext()) * 20.0f * 4.0f);
        if (z) {
            int i9 = (int) (((double) iA) * 0.8d);
            layoutParams = new LinearLayout.LayoutParams(i9, i9);
        } else {
            int i10 = (int) (((double) iA) * 1.1d);
            layoutParams = new LinearLayout.LayoutParams(i10, i10);
        }
        layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 20, 0, 20);
        if (i2 == 1) {
            if (i2 == 0) {
                linearLayout = this.f8831a;
                context2 = getContext();
                str3 = "#40000000";
            }
            LinearLayout linearLayout9 = this.f8831a;
            if (z4) {
                layoutParams3 = layoutParams;
            } else {
                layoutParams3 = new LinearLayout.LayoutParams(layoutParams.width - 60, layoutParams.height - 60);
            }
            linearLayout9.addView(view, layoutParams3);
            addView(this.f8831a, layoutParams);
            if (z2) {
                addView(textView, layoutParams2);
                addView(textView2, layoutParams2);
            }
        }
        linearLayout = this.f8831a;
        context2 = getContext();
        str3 = "#73ffffff";
        linearLayout.setBackground(com.ubix.ssp.ad.e.a0.c.a(context2, Color.parseColor(str3), MediaPlayer.MEDIA_PLAYER_OPTION_SPADE));
        LinearLayout linearLayout10 = this.f8831a;
        if (z4) {
            layoutParams3 = layoutParams;
        } else {
            layoutParams3 = new LinearLayout.LayoutParams(layoutParams.width - 60, layoutParams.height - 60);
        }
        linearLayout10.addView(view, layoutParams3);
        addView(this.f8831a, layoutParams);
        if (z2) {
            addView(textView, layoutParams2);
            addView(textView2, layoutParams2);
        }
    }

    public void a(boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int iA = (int) (com.ubix.ssp.ad.e.a0.r.a().a(getContext()) * 20.0f * 4.0f);
        if (z) {
            int i = (int) (((double) iA) * 0.8d);
            layoutParams = new LinearLayout.LayoutParams(i, i);
        } else {
            int i2 = (int) (((double) iA) * 1.1d);
            layoutParams = new LinearLayout.LayoutParams(i2, i2);
        }
        int i3 = this.b;
        if (i3 == 0) {
            findViewById(910101).setLayoutParams(layoutParams);
        } else if (i3 == 1 || i3 == 2) {
            findViewById(910101).setLayoutParams(new LinearLayout.LayoutParams(layoutParams.width - 60, layoutParams.height - 60));
        }
        this.f8831a.setLayoutParams(layoutParams);
    }
}

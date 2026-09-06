package com.opos.mobad.ui.c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.opos.mobad.cmn.func.b.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {

    public interface a {
        boolean a();
    }

    public interface b {
        void a(Bitmap bitmap);
    }

    public static final void a(final String str, String str2, int i, int i2, com.opos.mobad.d.a aVar, final ViewGroup viewGroup, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, a aVar2) {
        if (TextUtils.isEmpty(str) || aVar == null || viewGroup == null) {
            return;
        }
        viewGroup.setTag(str);
        a(str, str2, Integer.valueOf(i), Integer.valueOf(i2), aVar, interfaceC1003a, new b() { // from class: com.opos.mobad.ui.c.e.2
            @Override // com.opos.mobad.ui.c.e.b
            public void a(Bitmap bitmap) {
                BitmapDrawable bitmapDrawableA;
                Object tag = viewGroup.getTag();
                if (tag instanceof String) {
                    String str3 = (String) tag;
                    if (TextUtils.isEmpty(str3) || !str3.equals(str) || (bitmapDrawableA = h.a(viewGroup.getContext(), bitmap)) == null) {
                        return;
                    }
                    h.a(viewGroup, bitmapDrawableA);
                }
            }
        }, aVar2);
    }

    public static final void a(final String str, String str2, int i, int i2, com.opos.mobad.d.a aVar, final ImageView imageView, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, a aVar2) {
        if (TextUtils.isEmpty(str) || aVar == null || imageView == null) {
            return;
        }
        imageView.setTag(str);
        a(str, str2, Integer.valueOf(i), Integer.valueOf(i2), aVar, interfaceC1003a, new b() { // from class: com.opos.mobad.ui.c.e.1
            @Override // com.opos.mobad.ui.c.e.b
            public void a(Bitmap bitmap) {
                Object tag = imageView.getTag();
                if (tag instanceof String) {
                    String str3 = (String) tag;
                    if (TextUtils.isEmpty(str3) || !str3.equals(str)) {
                        return;
                    }
                    imageView.setImageBitmap(bitmap);
                    imageView.setVisibility(0);
                }
            }
        }, aVar2);
    }

    public static final void a(String str, String str2, int i, int i2, com.opos.mobad.d.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, b bVar, a aVar2) {
        a(str, str2, Integer.valueOf(i), Integer.valueOf(i2), aVar, interfaceC1003a, bVar, aVar2);
    }

    private static final void a(String str, String str2, Integer num, Integer num2, com.opos.mobad.d.a aVar, final com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, final b bVar, final a aVar2) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a = new com.opos.mobad.d.a.InterfaceC0955a() { // from class: com.opos.mobad.ui.c.e.3
            @Override // com.opos.mobad.d.a.InterfaceC0955a
            public void a(int i, final Bitmap bitmap) {
                com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a2;
                a aVar3 = aVar2;
                if (aVar3 == null || !aVar3.a()) {
                    if (i == 0 || i == 1) {
                        if (i == 1 && (interfaceC1003a2 = interfaceC1003a) != null) {
                            interfaceC1003a2.c(i);
                        }
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.ui.c.e.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if ((aVar2 != null && aVar2.a()) || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                bVar.a(bitmap);
                            }
                        });
                        return;
                    }
                    com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a3 = interfaceC1003a;
                    if (interfaceC1003a3 != null) {
                        interfaceC1003a3.c(i);
                    }
                }
            }
        };
        if (num == null || num2 == null) {
            aVar.a(str, str2, interfaceC0955a);
        } else {
            aVar.a(str, str2, num.intValue(), num2.intValue(), interfaceC0955a);
        }
    }
}

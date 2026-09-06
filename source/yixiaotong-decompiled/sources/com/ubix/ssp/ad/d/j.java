package com.ubix.ssp.ad.d;

import android.text.TextUtils;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.nativee.UBiXImage;
import com.ubix.ssp.open.nativee.UBiXVideo;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class j extends ParamsReview {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8617a;
    private ArrayList<String> b;
    private boolean c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private ArrayList<UBiXImage> k = new ArrayList<>();
    private UBiXVideo l = new UBiXVideo();
    private String m;

    private j(com.ubix.ssp.ad.e.y.a.a aVar, boolean z, boolean z2, boolean z3) {
        String str;
        String str2;
        String str3;
        String str4;
        this.b = new ArrayList<>();
        String str5 = "";
        this.m = "";
        if (z2) {
            com.ubix.ssp.ad.e.y.a.a.b bVar = aVar.d;
            str2 = bVar.o;
            str3 = bVar.n;
            str = bVar.m;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (z) {
            if (!z3) {
                if (!TextUtils.isEmpty(aVar.d.k.c)) {
                    arrayList.add(aVar.d.k.c);
                }
                if (!TextUtils.isEmpty(aVar.d.k.b)) {
                    str5 = aVar.d.k.b;
                    arrayList.add(str5);
                }
            } else if (!TextUtils.isEmpty(aVar.d.k.k)) {
                str5 = aVar.d.k.k;
                arrayList.add(str5);
            }
            this.l.setWidth(aVar.d.k.f);
            this.l.setHeight(aVar.d.k.g);
            this.l.setVideoUrl(aVar.d.k.b);
            this.l.setCoverUrl(aVar.d.k.c);
            this.l.setMaterialId(aVar.d.k.k);
            this.l.setDuration((long) (aVar.d.k.d * 1000.0f));
            this.f8617a = str5;
        } else {
            boolean z4 = aVar.d.s == 2005;
            int i = 0;
            while (true) {
                if (i >= (!z4 ? 1 : aVar.d.j.length)) {
                    break;
                }
                com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b = aVar.d.j[i];
                if (z3) {
                    if (!TextUtils.isEmpty(c1109b.f)) {
                        str4 = c1109b.f;
                        arrayList.add(str4);
                    }
                } else if (!TextUtils.isEmpty(c1109b.c)) {
                    str4 = c1109b.c;
                    arrayList.add(str4);
                }
                UBiXImage uBiXImage = new UBiXImage();
                uBiXImage.setUrl(c1109b.c);
                uBiXImage.setWidth(c1109b.d);
                uBiXImage.setHeight(c1109b.e);
                uBiXImage.setMaterialId(c1109b.f);
                this.k.add(uBiXImage);
                i++;
            }
            if (!arrayList.isEmpty()) {
                this.f8617a = arrayList.get(0);
            }
        }
        this.m = aVar.m;
        this.b = arrayList;
        this.c = z;
        com.ubix.ssp.ad.e.y.a.a.b bVar2 = aVar.d;
        this.d = bVar2.e;
        this.e = bVar2.f;
        this.f = bVar2.b;
        this.j = bVar2.h;
        this.g = str2;
        this.i = str3;
        this.h = str;
    }

    public static ParamsReview a(com.ubix.ssp.ad.e.y.a.a aVar, boolean z, boolean z2, boolean z3) {
        return new j(aVar, z, z2, z3);
    }

    private String getPR() {
        return this.m;
    }

    @Override // com.ubix.ssp.open.ParamsReview
    public String getAppPackageName() {
        return this.j;
    }

    @Override // com.ubix.ssp.open.ParamsReview
    public String getCreativeId() {
        return this.f;
    }

    @Override // com.ubix.ssp.open.ParamsReview
    public String getDeeplinkUrl() {
        return this.g;
    }

    @Override // com.ubix.ssp.open.ParamsReview
    public String getDesc() {
        return this.e;
    }

    @Override // com.ubix.ssp.open.ParamsReview
    public String getDownloadUrl() {
        return this.i;
    }

    @Override // com.ubix.ssp.open.ParamsReview
    public String getLandingPageUrl() {
        return this.h;
    }

    @Override // com.ubix.ssp.open.ParamsReview
    public String getTitle() {
        return this.d;
    }

    @Override // com.ubix.ssp.open.ParamsReview
    public ArrayList<UBiXImage> getUBiXImageList() {
        return this.k;
    }

    @Override // com.ubix.ssp.open.ParamsReview
    public UBiXVideo getUBiXVideo() {
        return this.l;
    }

    @Override // com.ubix.ssp.open.ParamsReview
    public String getUrl() {
        return TextUtils.isEmpty(this.f8617a) ? "" : this.f8617a;
    }

    @Override // com.ubix.ssp.open.ParamsReview
    public ArrayList<String> getUrlList() {
        return this.b;
    }

    @Override // com.ubix.ssp.open.ParamsReview
    public boolean isVideo() {
        return this.c;
    }
}

package com.jd.ad.sdk.jad_vg;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_ju.jad_ly;
import com.jd.ad.sdk.jad_mx.jad_xk;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er implements jad_ly<Uri, Drawable> {
    public final Context jad_an;

    public jad_er(Context context) {
        this.jad_an = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public jad_xk jad_an(Uri uri) {
        Context contextCreatePackageContext;
        int identifier;
        String authority = uri.getAuthority();
        if (authority.equals(this.jad_an.getPackageName())) {
            contextCreatePackageContext = this.jad_an;
        } else {
            try {
                contextCreatePackageContext = this.jad_an.createPackageContext(authority, 0);
            } catch (PackageManager.NameNotFoundException e) {
                if (!authority.contains(this.jad_an.getPackageName())) {
                    throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
                }
                contextCreatePackageContext = this.jad_an;
            }
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            List<String> pathSegments2 = uri.getPathSegments();
            String authority2 = uri.getAuthority();
            String str = pathSegments2.get(0);
            String str2 = pathSegments2.get(1);
            identifier = contextCreatePackageContext.getResources().getIdentifier(str2, str, authority2);
            if (identifier == 0) {
                identifier = Resources.getSystem().getIdentifier(str2, str, "android");
            }
            if (identifier == 0) {
                throw new IllegalArgumentException("Failed to find resource id for: " + uri);
            }
        } else {
            if (pathSegments.size() != 1) {
                throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
            }
            try {
                identifier = Integer.parseInt(uri.getPathSegments().get(0));
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
            }
        }
        Drawable drawableJad_an = jad_bo.jad_an(this.jad_an, contextCreatePackageContext, identifier, null);
        if (drawableJad_an != null) {
            return new jad_dq(drawableJad_an);
        }
        return null;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ jad_xk<Drawable> jad_an(Uri uri, int i, int i2, jad_jw jad_jwVar) {
        return jad_an(uri);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(Uri uri, jad_jw jad_jwVar) {
        return uri.getScheme().equals("android.resource");
    }
}

package com.miui.zeus.mimo.sdk;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class g4 {
    public static g4 f;
    public d b;
    public final LocationListener c = new a();
    public final LocationListener d = new b();
    public final LocationListener e = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LocationManager f5435a = (LocationManager) y8.a().getSystemService(ijiami_1011.s.s.s.d(new byte[]{14, 11, 87, 87, 71, 15, 14, 10}, "bd463f"));

    public class a implements LocationListener {
        public a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            g4.a(g4.this, location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public class b implements LocationListener {
        public b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            g4.a(g4.this, location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public class c implements LocationListener {
        public c() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            g4.a(g4.this, location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public interface d {
    }

    public static void a(g4 g4Var, Location location) {
        g4Var.getClass();
        x8.e(new h4(g4Var, location));
    }

    public final void a(LocationListener locationListener) {
        try {
            LocationManager locationManager = this.f5435a;
            if (locationManager == null || locationListener == null) {
                return;
            }
            locationManager.removeUpdates(locationListener);
        } catch (Exception unused) {
        }
    }

    public final boolean b() {
        boolean z;
        if (!a()) {
            return false;
        }
        if (this.f5435a != null) {
            a(this.c);
            a(this.d);
            a(this.e);
        }
        try {
            if (this.f5435a.isProviderEnabled(ijiami_1011.s.s.s.d(new byte[]{12, 4, Ascii.ETB, Ascii.DC4, 87, 16, 10}, "bacc8b")) && (a(ijiami_1011.s.s.s.d(new byte[]{82, 10, 80, 16, 95, 95, 5, 74, Ascii.SYN, 7, 67, 8, 90, Ascii.ETB, 71, 11, 95, 88, 79, 37, 37, 33, 116, 54, 96, 59, 114, 43, 126, 115, 62, 40, 41, 33, 112, 49, 122, 43, 122}, "3d4b06")) || a(ijiami_1011.s.s.s.d(new byte[]{84, 93, 7, 69, 92, 94, 5, 74, Ascii.SYN, 7, 67, 8, 92, SignedBytes.MAX_POWER_OF_TWO, 16, 94, 92, 89, 79, 37, 37, 33, 116, 54, 102, 108, 32, 120, 114, 101, 50, 33, 57, 46, 126, 38, 116, 103, 42, 120, 125}, "53c737")))) {
                this.f5435a.requestLocationUpdates(ijiami_1011.s.s.s.d(new byte[]{91, 92, 70, 17, 91, Ascii.ETB, 10}, "592f4e"), 1000L, 100.0f, this.c);
                z = true;
            } else {
                z = false;
            }
            if (a(ijiami_1011.s.s.s.d(new byte[]{87, 12, 80, 71, 88, 92, 5, 74, Ascii.SYN, 7, 67, 8, 95, 17, 71, 92, 88, 91, 79, 37, 37, 33, 116, 54, 101, Base64.padSymbol, 114, 124, 121, 112, 62, 40, 41, 33, 112, 49, 127, 45, 122}, "6b4575"))) {
                if (this.f5435a.isProviderEnabled(ijiami_1011.s.s.s.d(new byte[]{83, 71, Ascii.DC2}, "47aeba"))) {
                    this.f5435a.requestLocationUpdates(ijiami_1011.s.s.s.d(new byte[]{83, SignedBytes.MAX_POWER_OF_TWO, 69}, "406b95"), 1000L, 100.0f, this.d);
                    z = true;
                }
                if (this.f5435a.isProviderEnabled(ijiami_1011.s.s.s.d(new byte[]{66, 88, 66, 70, 91, 70, 4}, "291520"))) {
                    this.f5435a.requestLocationUpdates(ijiami_1011.s.s.s.d(new byte[]{17, 4, 17, Ascii.DC2, 13, 71, 4}, "aebad1"), 1000L, 100.0f, this.e);
                    return true;
                }
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean a() {
        if (this.f5435a == null) {
            this.f5435a = (LocationManager) y8.f5752a.getSystemService(ijiami_1011.s.s.s.d(new byte[]{8, 14, 86, 89, 65, 80, 14, 10}, "da5859"));
        }
        return this.f5435a != null;
    }

    public final boolean a(String str) {
        return ContextCompat.checkSelfPermission(y8.f5752a, str) == 0;
    }
}

package s_a.s_a.s_a.a;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f9740a;
    public final /* synthetic */ List b;
    public final /* synthetic */ b c;

    public a(b bVar, Context context, List list) {
        this.c = bVar;
        this.f9740a = context;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.f9740a, this.b, true);
    }
}

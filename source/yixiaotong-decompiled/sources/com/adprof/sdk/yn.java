package com.adprof.sdk;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class yn extends li {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final un f1543a;

    public yn(String str, int i, int i2, un unVar) {
        super(0, str, unVar);
        this.f1543a = unVar;
        if (i < 0) {
            i = 0;
        } else if (i > 3) {
            i = 3;
        }
        a(true);
        a(new q7(i2, i2, i, 0.0f));
    }

    @Override // com.adprof.sdk.li
    public int a() {
        return 100;
    }

    @Override // com.adprof.sdk.li
    public void a(jp jpVar) {
        pi piVar;
        pk.b("send tracking: 1 fail url = " + m674a());
        synchronized (((li) this).f446a) {
            piVar = ((li) this).f444a;
        }
        if (piVar != null) {
            un unVar = (un) piVar;
            StringBuilder sbAppend = new StringBuilder("TrackManager  onErrorResponse   inQueue = ").append(unVar.f759a).append("  retryNum = ");
            int i = unVar.f1465a.f528a;
            int i2 = 0;
            if (i == null) {
                i = 0;
            }
            pk.a(sbAppend.append(i).append("  isRetrySend =  ").append(unVar.b).append("  error = ").append(jpVar.f1255a).toString());
            if (unVar.f759a) {
                if (unVar.b) {
                    o2 o2Var = unVar.f1465a;
                    o2Var.b = Integer.valueOf(o2Var.b.intValue() + 1);
                    if (unVar.f1465a.b.intValue() >= 10) {
                        pk.a("TrackManager  onErrorResponse do-nothing, maxRetryNum = 10");
                    } else {
                        pk.a("TrackManager  onErrorResponse   updateToDB , maxRetryNum =  10");
                        o2 o2Var2 = unVar.f1465a;
                        o2Var2.getClass();
                        try {
                            pk.b("updateToDB  id = " + o2Var2.f529a.toString() + "  retryNum = " + o2Var2.b);
                            String str = " where id=" + o2Var2.f529a.toString();
                            HashMap map = new HashMap();
                            map.put("retryNum", o2Var2.b);
                            StringBuilder sb = new StringBuilder("update ");
                            sb.append("tracks");
                            sb.append(" set ");
                            Iterator it = map.keySet().iterator();
                            while (it.hasNext()) {
                                String str2 = (String) it.next();
                                sb.append(str2 + " = " + map.get(str2));
                                if (it.hasNext()) {
                                    sb.append(", ");
                                }
                            }
                            if (!TextUtils.isEmpty(str)) {
                                sb.append(PPSLabelView.Code + str);
                            }
                            String string = sb.toString();
                            tk tkVar = tk.f1443a;
                            SQLiteDatabase writableDatabase = tk.f1443a.getWritableDatabase();
                            tkVar.getClass();
                            writableDatabase.beginTransaction();
                            try {
                                writableDatabase.execSQL(string, new Object[0]);
                                writableDatabase.setTransactionSuccessful();
                            } catch (Throwable th) {
                                try {
                                    pk.b("SQL Track transaction error2: ", th);
                                } catch (Throwable th2) {
                                    writableDatabase.endTransaction();
                                    throw th2;
                                }
                            }
                            writableDatabase.endTransaction();
                        } catch (Throwable th3) {
                            pk.b("updateToDB e =  " + th3.getMessage());
                        }
                    }
                } else {
                    pk.a("TrackManager  onErrorResponse   insertToDB ");
                    o2 o2Var3 = unVar.f1465a;
                    o2Var3.getClass();
                    try {
                        pk.b("insertToDB    mUrl = " + o2Var3.d);
                        HashMap map2 = new HashMap();
                        int i3 = o2Var3.f1334a.ordinal() != 1 ? 0 : 1;
                        map2.put("url", o2Var3.d);
                        map2.put("request_id", o2Var3.f532b);
                        map2.put(NotificationCompat.CATEGORY_EVENT, o2Var3.f530a);
                        map2.put(com.huawei.openalliance.ad.constant.ba.at, o2Var3.c);
                        map2.put("retryNum", o2Var3.b);
                        map2.put(com.alipay.sdk.tid.b.f, Long.valueOf(System.currentTimeMillis()));
                        map2.put("extInfo", o2Var3.e);
                        map2.put("messageType", Integer.valueOf(i3));
                        SQLiteDatabase writableDatabase2 = tk.f1443a.getWritableDatabase();
                        List listAsList = Arrays.asList(map2.keySet().toArray());
                        StringBuilder sb2 = new StringBuilder("insert or replace into ");
                        sb2.append("tracks");
                        StringBuilder sb3 = new StringBuilder("(");
                        StringBuilder sb4 = new StringBuilder("(");
                        while (i2 < listAsList.size()) {
                            sb3.append(listAsList.get(i2));
                            sb4.append("?");
                            i2++;
                            if (i2 < listAsList.size()) {
                                sb3.append(", ");
                                sb4.append(", ");
                            }
                        }
                        sb3.append(")");
                        sb4.append(")");
                        sb2.append((CharSequence) sb3).append(" values ").append((CharSequence) sb4);
                        qk qkVar = new qk();
                        qkVar.f681a = listAsList;
                        qkVar.f682a = map2;
                        qkVar.f1388a = sb2.toString();
                        tk.a(writableDatabase2, qkVar, new l2(o2Var3, null));
                    } catch (Throwable th4) {
                        pk.b("AdTracker insertToDB error", th4);
                    }
                }
            }
            wn wnVar = unVar.f758a;
            if (wnVar != null) {
                wnVar.a(unVar.f1465a, jpVar);
            }
            pk.b("\n\n  TrackManager  onErrorResponse  error = " + jpVar.getMessage() + "  \n\n");
        }
    }

    @Override // com.adprof.sdk.li
    public void a(Object obj) {
        un unVar;
        l7 l7Var;
        fg fgVar = (fg) obj;
        synchronized (((li) this).f446a) {
            unVar = this.f1543a;
        }
        if (pk.f594a) {
            pk.d("\n  send tracking: 4  success   url = " + m674a() + " \n");
        }
        if (unVar != null) {
            o2 o2Var = unVar.f1465a;
            if (o2Var.f529a != null) {
                try {
                    pk.a("deleteDB  id = " + o2Var.f529a);
                    String str = "id ='" + o2Var.f529a + "'";
                    synchronized (l7.class) {
                        l7Var = l7.f1280a;
                    }
                    l7Var.a(tk.f1443a.getWritableDatabase(), "tracks", str, new m2(o2Var));
                } catch (Throwable th) {
                    pk.b(" deleteDB e = " + th.getMessage());
                }
            }
            wn wnVar = unVar.f758a;
            if (wnVar != null) {
                wnVar.a(unVar.f1465a, fgVar);
            }
        }
    }

    @Override // com.adprof.sdk.li
    public ri a(fg fgVar) {
        return new ri(fgVar);
    }
}

package com.jg.ids.meizu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import com.ubixnow.ooooo.oOOOoo00;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class a {
    private static final a b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BroadcastReceiver f4615a = null;
    private b c = null;

    static a a() {
        return b;
    }

    private a() {
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004e  */
    public final boolean a(Context context) throws Throwable {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            if (context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) {
                return false;
            }
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
            if (cursorQuery != null) {
                try {
                    cursorQuery.moveToFirst();
                    d dVarA = a(cursorQuery);
                    if (dVarA != null) {
                        boolean zEquals = "0".equals(dVarA.f4616a);
                        if (cursorQuery == null) {
                            return zEquals;
                        }
                        cursorQuery.close();
                        return zEquals;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursorQuery;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
        if (cursor != null) {
            cursor.close();
        }
        return false;
    }

    private static d a(Cursor cursor) {
        d dVar = null;
        d dVar2 = new d(null, 0);
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(oOOOoo00.OooOo0o);
                    if (columnIndex >= 0) {
                        dVar2.f4616a = cursor.getString(columnIndex);
                    }
                    int columnIndex2 = cursor.getColumnIndex("code");
                    if (columnIndex2 >= 0) {
                        dVar2.b = cursor.getInt(columnIndex2);
                    }
                    int columnIndex3 = cursor.getColumnIndex("expired");
                    if (columnIndex3 >= 0) {
                        dVar2.c = cursor.getLong(columnIndex3);
                        return dVar2;
                    }
                }
            } catch (Throwable th) {
            }
        }
        dVar = dVar2;
        return dVar;
    }

    public final String b(Context context) throws Throwable {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"aaid"}, null);
            if (cursorQuery != null) {
                try {
                    d dVarA = a(cursorQuery);
                    if (dVarA != null) {
                        if (dVarA.b != 1000) {
                            e(context);
                        }
                        String str = dVarA.f4616a;
                        if (cursorQuery == null) {
                            return str;
                        }
                        cursorQuery.close();
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursorQuery;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return "";
    }

    public final String c(Context context) throws Throwable {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery != null) {
                try {
                    d dVarA = a(cursorQuery);
                    if (dVarA != null) {
                        if (dVarA.b != 1000) {
                            e(context);
                        }
                        String str = dVarA.f4616a;
                        if (cursorQuery == null) {
                            return str;
                        }
                        cursorQuery.close();
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursorQuery;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return "";
    }

    public final String d(Context context) throws Throwable {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"vaid"}, null);
            if (cursorQuery != null) {
                try {
                    d dVarA = a(cursorQuery);
                    if (dVarA != null) {
                        if (dVarA.b != 1000) {
                            e(context);
                        }
                        String str = dVarA.f4616a;
                        if (cursorQuery == null) {
                            return str;
                        }
                        cursorQuery.close();
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursorQuery;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return "";
    }

    public final void a(b bVar) {
        this.c = bVar;
    }

    public final void a(int i) {
        if (this.c != null) {
            this.c.a(i);
        }
    }

    private synchronized void e(Context context) {
        try {
            if (this.f4615a == null) {
                this.f4615a = new MeiZuReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
                context.registerReceiver(this.f4615a, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
            }
        } catch (Throwable th) {
        }
    }
}

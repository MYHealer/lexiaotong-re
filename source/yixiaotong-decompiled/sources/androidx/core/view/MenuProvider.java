package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public interface MenuProvider {
    void onCreateMenu(Menu menu, MenuInflater menuInflater);

    default void onMenuClosed(Menu menu) {
    }

    boolean onMenuItemSelected(MenuItem menuItem);

    default void onPrepareMenu(Menu menu) {
    }
}

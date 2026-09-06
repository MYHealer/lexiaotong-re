package client.android.yixiaotong.v4.ui.app.electricitymeter;

import android.content.Context;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.huawei.openalliance.ad.constant.x;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ElecMarkerView extends MarkerView {
    private LineChart mChart;
    private List<String> mLends;
    private final TextView mTvDate;
    private final TextView mTvLabel;
    private final TextView mTvUnit;
    private final TextView mTvValue;

    public void setLends(List<String> list) {
        this.mLends = list;
    }

    public void setLineChart(LineChart lineChart) {
        this.mChart = lineChart;
    }

    public ElecMarkerView(Context context) {
        super(context, R.layout.marker_view_elec);
        this.mTvDate = (TextView) findViewById(R.id.tv_marker_date);
        TextView textView = (TextView) findViewById(R.id.tv_marker_label);
        this.mTvLabel = textView;
        this.mTvValue = (TextView) findViewById(R.id.tv_marker_value);
        this.mTvUnit = (TextView) findViewById(R.id.tv_marker_unit);
        textView.setText("用量");
    }

    @Override // com.github.mikephil.charting.components.MarkerView, com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry entry, Highlight highlight) {
        if (entry != null) {
            this.mTvDate.setText(getDateLabel(entry, highlight));
            this.mTvValue.setText(String.format(Locale.CHINA, "%.2f", Float.valueOf(entry.getY())));
            this.mTvUnit.setText(getUnitText());
        }
        super.refreshContent(entry, highlight);
    }

    @Override // com.github.mikephil.charting.components.MarkerView, com.github.mikephil.charting.components.IMarker
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), (-getHeight()) - 8);
    }

    @Override // com.github.mikephil.charting.components.MarkerView, com.github.mikephil.charting.components.IMarker
    public MPPointF getOffsetForDrawingAtPoint(float f, float f2) {
        MPPointF offset = getOffset();
        LineChart lineChart = this.mChart;
        if (lineChart == null) {
            return offset;
        }
        float width = lineChart.getWidth();
        if (offset.x + f < 0.0f) {
            offset.x = (-f) + 8.0f;
        } else if (getWidth() + f + offset.x > width) {
            offset.x = ((width - f) - getWidth()) - 8.0f;
        }
        if (offset.y + f2 < 0.0f) {
            offset.y = (-f2) + 8.0f;
        }
        return offset;
    }

    private String getDateLabel(Entry entry, Highlight highlight) {
        List<String> list = this.mLends;
        if (list != null && !list.isEmpty()) {
            int iRound = Math.round(highlight != null ? highlight.getX() : entry.getX());
            if (iRound >= 0 && iRound < this.mLends.size()) {
                return formatDateLabel(this.mLends.get(iRound));
            }
        }
        return "";
    }

    private String formatDateLabel(String str) {
        if (str == null) {
            return "";
        }
        String strTrim = str.replace("日", "").replace("年", x.A).replace("月", x.A).trim();
        return (strTrim.length() >= 10 && strTrim.charAt(4) == '-' && strTrim.charAt(7) == '-') ? strTrim.substring(5, 10) : strTrim;
    }

    private String getUnitText() {
        LineChart lineChart = this.mChart;
        if (lineChart == null || lineChart.getDescription() == null) {
            return "";
        }
        String text = this.mChart.getDescription().getText();
        if (text != null && text.contains("L")) {
            return "升";
        }
        if (text == null) {
            return "";
        }
        if (text.contains("kWh") || text.contains("度")) {
            return isEnglishLanguage() ? "kWh" : "度";
        }
        return "";
    }

    private boolean isEnglishLanguage() {
        String lanuage = LocalDataUtil.getLanuage(getContext());
        return StringUtils.isNotEmpty(lanuage) && lanuage.equals(BaseActivity.LANGUAGEEN);
    }
}

package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.DateDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.google.android.material.timepicker.TimeModel;
import com.huawei.openalliance.ad.constant.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import kotlin.text.Typography;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CalendarCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CalendarCodec instance = new CalendarCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        char[] charArray;
        SerializeWriter writer = jSONSerializer.getWriter();
        if (obj == null) {
            writer.writeNull();
            return;
        }
        Calendar calendar = (Calendar) obj;
        if (jSONSerializer.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
            if (jSONSerializer.isEnabled(SerializerFeature.UseSingleQuotes)) {
                writer.append('\'');
            } else {
                writer.append(Typography.quote);
            }
            int i2 = calendar.get(1);
            int i3 = calendar.get(2) + 1;
            int i4 = calendar.get(5);
            int i5 = calendar.get(11);
            int i6 = calendar.get(12);
            int i7 = calendar.get(13);
            int i8 = calendar.get(14);
            if (i8 != 0) {
                charArray = "0000-00-00T00:00:00.000".toCharArray();
                IOUtils.getChars(i8, 23, charArray);
                IOUtils.getChars(i7, 19, charArray);
                IOUtils.getChars(i6, 16, charArray);
                IOUtils.getChars(i5, 13, charArray);
                IOUtils.getChars(i4, 10, charArray);
                IOUtils.getChars(i3, 7, charArray);
                IOUtils.getChars(i2, 4, charArray);
            } else if (i7 == 0 && i6 == 0 && i5 == 0) {
                charArray = "0000-00-00".toCharArray();
                IOUtils.getChars(i4, 10, charArray);
                IOUtils.getChars(i3, 7, charArray);
                IOUtils.getChars(i2, 4, charArray);
            } else {
                charArray = "0000-00-00T00:00:00".toCharArray();
                IOUtils.getChars(i7, 19, charArray);
                IOUtils.getChars(i6, 16, charArray);
                IOUtils.getChars(i5, 13, charArray);
                IOUtils.getChars(i4, 10, charArray);
                IOUtils.getChars(i3, 7, charArray);
                IOUtils.getChars(i2, 4, charArray);
            }
            writer.write(charArray);
            int rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
            if (rawOffset == 0) {
                writer.append("Z");
            } else if (rawOffset > 0) {
                writer.append("+").append((CharSequence) String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(rawOffset))).append(":00");
            } else {
                writer.append(x.A).append((CharSequence) String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(-rawOffset))).append(":00");
            }
            if (jSONSerializer.isEnabled(SerializerFeature.UseSingleQuotes)) {
                writer.append('\'');
                return;
            } else {
                writer.append(Typography.quote);
                return;
            }
        }
        jSONSerializer.write(calendar.getTime());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.util.Calendar] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t = (T) DateDeserializer.instance.deserialze(defaultJSONParser, type, obj);
        if (t instanceof Calendar) {
            return t;
        }
        Date date = (Date) t;
        if (date == null) {
            return null;
        }
        ?? r3 = (T) Calendar.getInstance();
        r3.setTime(date);
        return r3;
    }
}

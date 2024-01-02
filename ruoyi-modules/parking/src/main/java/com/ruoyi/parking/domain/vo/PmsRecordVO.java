package com.ruoyi.parking.domain.vo;

import com.ruoyi.parking.domain.PmsRecord;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 出入记录展示对象
 *
 * @author chennan
 * @date 2023-12-05
 */
public class PmsRecordVO extends PmsRecord {
    /**
     * 所属分区名称
     */
    private String zoneNane;

    public String getZoneName() {
        return zoneNane;
    }

    public void setZoneName(String zoneNane) {
        this.zoneNane = zoneNane;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("recordId", getRecordId())
                .append("plate", getPlate())
                .append("type", getType())
                .append("time", getTime())
                .append("zoneId", getZoneId())
                .append("zoneName", getZoneName())
                .toString();
    }
}

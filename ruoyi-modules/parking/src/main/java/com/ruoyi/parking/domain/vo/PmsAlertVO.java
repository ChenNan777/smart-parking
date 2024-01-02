package com.ruoyi.parking.domain.vo;

import com.ruoyi.parking.domain.PmsAlert;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 告警管理展示对象
 *
 * @author chennan
 * @date 2023-12-05
 */
public class PmsAlertVO extends PmsAlert {
    /**
     * 告警分区名称
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
                .append("alertId", getAlertId())
                .append("type", getType())
                .append("description", getDescription())
                .append("zoneId", getZoneId())
                .append("time", getTime())
                .append("status", getStatus())
                .append("zoneNane", getZoneName())
                .toString();
    }
}

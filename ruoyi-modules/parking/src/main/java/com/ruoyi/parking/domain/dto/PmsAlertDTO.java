package com.ruoyi.parking.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.parking.domain.PmsAlert;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;
import java.util.List;

/**
 * 告警管理操作对象
 *
 * @author chennan
 * @date 2023-11-24
 */
public class PmsAlertDTO extends PmsAlert {
    /**
     * 时间范围
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "时间范围", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private List<Date> timeRange;

    public List<Date> getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(List<Date> timeRange) {
        this.timeRange = timeRange;
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
                .append("timeRange", getTimeRange())
                .toString();
    }
}

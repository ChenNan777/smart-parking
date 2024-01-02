package com.ruoyi.parking.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.parking.domain.PmsRecord;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 出入记录操作对象
 *
 * @author chennan
 * @date 2023-12-05
 */
public class PmsRecordDTO extends PmsRecord {
    /**
     * 时间范围
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
                .append("recordId", getRecordId())
                .append("plate", getPlate())
                .append("type", getType())
                .append("time", getTime())
                .append("zoneId", getZoneId())
                .append("timeRange", getTimeRange())
                .toString();
    }
}

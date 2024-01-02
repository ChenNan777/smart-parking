package com.ruoyi.parking.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 告警管理对象 pms_alert
 * 
 * @author chennan
 * @date 2023-11-15
 */
public class PmsAlert extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 告警ID */
    private Long alertId;

    /** 告警类型（info/warning/error） */
    @Excel(name = "告警类型", readConverterExp = "i=nfo/warning/error")
    private String type;

    /** 告警信息描述 */
    @Excel(name = "告警信息描述")
    private String description;

    /** 告警分区 */
    @Excel(name = "告警分区")
    private Long zoneId;

    /** 时间戳 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "时间戳", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    /** 告警状态（1开启/0关闭） */
    @Excel(name = "告警状态", readConverterExp = "1=开启/0关闭")
    private Long status;

    public void setAlertId(Long alertId) 
    {
        this.alertId = alertId;
    }

    public Long getAlertId() 
    {
        return alertId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setZoneId(Long zoneId) 
    {
        this.zoneId = zoneId;
    }

    public Long getZoneId() 
    {
        return zoneId;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("alertId", getAlertId())
            .append("type", getType())
            .append("description", getDescription())
            .append("zoneId", getZoneId())
            .append("time", getTime())
            .append("status", getStatus())
            .toString();
    }
}

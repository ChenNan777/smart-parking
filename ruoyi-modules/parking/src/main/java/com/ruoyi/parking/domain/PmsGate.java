package com.ruoyi.parking.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 出入口管理对象 pms_gate
 * 
 * @author chennan
 * @date 2023-11-15
 */
public class PmsGate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出入口ID */
    private Long gateId;

    /** 所属分区 */
    @Excel(name = "所属分区")
    private Long zoneId;

    /** 使用设备 */
    @Excel(name = "使用设备")
    private Long deviceId;

    /** 出入口类型（0入口/1出口） */
    @Excel(name = "出入口类型", readConverterExp = "0=入口/1出口")
    private Integer type;

    /** 出入口位置 */
    @Excel(name = "出入口位置")
    private String location;

    /** 使用状态（0停用/1启用） */
    @Excel(name = "使用状态", readConverterExp = "0=停用/1启用")
    private Integer status;

    public void setGateId(Long gateId) 
    {
        this.gateId = gateId;
    }

    public Long getGateId() 
    {
        return gateId;
    }
    public void setZoneId(Long zoneId) 
    {
        this.zoneId = zoneId;
    }

    public Long getZoneId() 
    {
        return zoneId;
    }
    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("gateId", getGateId())
            .append("zoneId", getZoneId())
            .append("deviceId", getDeviceId())
            .append("type", getType())
            .append("location", getLocation())
            .append("status", getStatus())
            .toString();
    }
}

package com.ruoyi.parking.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 设备管理对象 pms_device
 * 
 * @author chennan
 * @date 2023-11-15
 */
public class PmsDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备ID */
    private Long deviceId;

    /** 设备mac地址 */
    private String mac;

    /** 设备最近连接时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "设备最近连接时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date connectionTime;

    /** 设备状态（0离线/1在线） */
    @Excel(name = "设备状态", readConverterExp = "0=离线/1在线")
    private Integer status;

    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
    }
    public void setMac(String mac) 
    {
        this.mac = mac;
    }

    public String getMac() 
    {
        return mac;
    }
    public void setConnectionTime(Date connectionTime) 
    {
        this.connectionTime = connectionTime;
    }

    public Date getConnectionTime() 
    {
        return connectionTime;
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
            .append("deviceId", getDeviceId())
            .append("mac", getMac())
            .append("connectionTime", getConnectionTime())
            .append("status", getStatus())
            .toString();
    }
}

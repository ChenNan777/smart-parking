package com.ruoyi.parking.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 分区管理对象 pms_zone
 * 
 * @author chennan
 * @date 2023-11-15
 */
public class PmsZone extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分区ID */
    private Long zoneId;

    /** 分区名称 */
    @Excel(name = "分区名称")
    private String name;

    /** 分区车位数 */
    @Excel(name = "分区车位数")
    private Long total;

    /** 分区位置 */
    @Excel(name = "分区位置")
    private String location;

    /** 使用状态（0停用/1启用） */
    @Excel(name = "使用状态", readConverterExp = "0=停用/1启用")
    private Long status;

    public void setZoneId(Long zoneId) 
    {
        this.zoneId = zoneId;
    }

    public Long getZoneId() 
    {
        return zoneId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTotal(Long total) 
    {
        this.total = total;
    }

    public Long getTotal() 
    {
        return total;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
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
            .append("zoneId", getZoneId())
            .append("name", getName())
            .append("total", getTotal())
            .append("location", getLocation())
            .append("status", getStatus())
            .toString();
    }
}

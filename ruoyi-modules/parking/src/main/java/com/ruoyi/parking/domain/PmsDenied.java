package com.ruoyi.parking.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 黑名单管理对象 pms_denied
 * 
 * @author chennan
 * @date 2023-11-15
 */
public class PmsDenied extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 黑名单ID */
    private Long deniedId;

    /** 车牌号码 */
    @Excel(name = "车牌号码")
    private String plate;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 使用状态（0停用/1启用） */
    @Excel(name = "使用状态", readConverterExp = "0=停用/1启用")
    private Integer status;

    public void setDeniedId(Long deniedId) 
    {
        this.deniedId = deniedId;
    }

    public Long getDeniedId() 
    {
        return deniedId;
    }
    public void setPlate(String plate) 
    {
        this.plate = plate;
    }

    public String getPlate() 
    {
        return plate;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
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
            .append("deniedId", getDeniedId())
            .append("plate", getPlate())
            .append("description", getDescription())
            .append("status", getStatus())
            .toString();
    }
}

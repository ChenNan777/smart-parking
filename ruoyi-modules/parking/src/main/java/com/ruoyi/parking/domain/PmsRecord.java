package com.ruoyi.parking.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 出入库记录对象 pms_record
 * 
 * @author chennan
 * @date 2023-11-26
 */
public class PmsRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long recordId;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String plate;

    /** 操作类型（0入库/1出库） */
    @Excel(name = "操作类型", readConverterExp = "0=入库/1出库")
    private Long type;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    /** 进出分区 */
    @Excel(name = "进出分区")
    private Long zoneId;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setPlate(String plate) 
    {
        this.plate = plate;
    }

    public String getPlate() 
    {
        return plate;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setZoneId(Long zoneId) 
    {
        this.zoneId = zoneId;
    }

    public Long getZoneId() 
    {
        return zoneId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("plate", getPlate())
            .append("type", getType())
            .append("time", getTime())
            .append("zoneId", getZoneId())
            .toString();
    }
}

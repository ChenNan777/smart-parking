package com.ruoyi.parking.mapper;

import java.util.List;
import com.ruoyi.parking.domain.PmsZone;

/**
 * 分区管理Mapper接口
 * 
 * @author chennan
 * @date 2023-11-15
 */
public interface PmsZoneMapper 
{
    /**
     * 查询分区管理
     * 
     * @param zoneId 分区管理主键
     * @return 分区管理
     */
    public PmsZone selectPmsZoneByZoneId(Long zoneId);

    /**
     * 查询分区管理列表
     * 
     * @param pmsZone 分区管理
     * @return 分区管理集合
     */
    public List<PmsZone> selectPmsZoneList(PmsZone pmsZone);

    /**
     * 新增分区管理
     * 
     * @param pmsZone 分区管理
     * @return 结果
     */
    public int insertPmsZone(PmsZone pmsZone);

    /**
     * 修改分区管理
     * 
     * @param pmsZone 分区管理
     * @return 结果
     */
    public int updatePmsZone(PmsZone pmsZone);

    /**
     * 删除分区管理
     * 
     * @param zoneId 分区管理主键
     * @return 结果
     */
    public int deletePmsZoneByZoneId(Long zoneId);

    /**
     * 批量删除分区管理
     * 
     * @param zoneIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsZoneByZoneIds(Long[] zoneIds);
}

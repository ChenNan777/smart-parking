package com.ruoyi.parking.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.parking.mapper.PmsZoneMapper;
import com.ruoyi.parking.domain.PmsZone;
import com.ruoyi.parking.service.IPmsZoneService;

/**
 * 分区管理Service业务层处理
 * 
 * @author chennan
 * @date 2023-11-15
 */
@Service
public class PmsZoneServiceImpl implements IPmsZoneService 
{
    @Autowired
    private PmsZoneMapper pmsZoneMapper;

    /**
     * 查询分区管理
     * 
     * @param zoneId 分区管理主键
     * @return 分区管理
     */
    @Override
    public PmsZone selectPmsZoneByZoneId(Long zoneId)
    {
        return pmsZoneMapper.selectPmsZoneByZoneId(zoneId);
    }

    /**
     * 查询分区管理列表
     * 
     * @param pmsZone 分区管理
     * @return 分区管理
     */
    @Override
    public List<PmsZone> selectPmsZoneList(PmsZone pmsZone)
    {
        return pmsZoneMapper.selectPmsZoneList(pmsZone);
    }

    /**
     * 新增分区管理
     * 
     * @param pmsZone 分区管理
     * @return 结果
     */
    @Override
    public int insertPmsZone(PmsZone pmsZone)
    {
        return pmsZoneMapper.insertPmsZone(pmsZone);
    }

    /**
     * 修改分区管理
     * 
     * @param pmsZone 分区管理
     * @return 结果
     */
    @Override
    public int updatePmsZone(PmsZone pmsZone)
    {
        return pmsZoneMapper.updatePmsZone(pmsZone);
    }

    /**
     * 批量删除分区管理
     * 
     * @param zoneIds 需要删除的分区管理主键
     * @return 结果
     */
    @Override
    public int deletePmsZoneByZoneIds(Long[] zoneIds)
    {
        return pmsZoneMapper.deletePmsZoneByZoneIds(zoneIds);
    }

    /**
     * 删除分区管理信息
     * 
     * @param zoneId 分区管理主键
     * @return 结果
     */
    @Override
    public int deletePmsZoneByZoneId(Long zoneId)
    {
        return pmsZoneMapper.deletePmsZoneByZoneId(zoneId);
    }
}

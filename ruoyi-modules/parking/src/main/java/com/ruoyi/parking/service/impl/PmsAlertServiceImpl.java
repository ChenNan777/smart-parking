package com.ruoyi.parking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.parking.mapper.PmsAlertMapper;
import com.ruoyi.parking.domain.PmsAlert;
import com.ruoyi.parking.service.IPmsAlertService;

/**
 * 告警管理Service业务层处理
 * 
 * @author chennan
 * @date 2023-11-15
 */
@Service
public class PmsAlertServiceImpl implements IPmsAlertService 
{
    @Autowired(required = false)
    private PmsAlertMapper pmsAlertMapper;

    /**
     * 查询告警管理
     * 
     * @param alertId 告警管理主键
     * @return 告警管理
     */
    @Override
    public PmsAlert selectPmsAlertByAlertId(Long alertId)
    {
        return pmsAlertMapper.selectPmsAlertByAlertId(alertId);
    }

    /**
     * 查询告警管理列表
     * 
     * @param pmsAlert 告警管理
     * @return 告警管理
     */
    @Override
    public List<PmsAlert> selectPmsAlertList(PmsAlert pmsAlert)
    {
        return pmsAlertMapper.selectPmsAlertList(pmsAlert);
    }

    /**
     * 新增告警管理
     * 
     * @param pmsAlert 告警管理
     * @return 结果
     */
    @Override
    public int insertPmsAlert(PmsAlert pmsAlert)
    {
        return pmsAlertMapper.insertPmsAlert(pmsAlert);
    }

    /**
     * 修改告警管理
     * 
     * @param pmsAlert 告警管理
     * @return 结果
     */
    @Override
    public int updatePmsAlert(PmsAlert pmsAlert)
    {
        return pmsAlertMapper.updatePmsAlert(pmsAlert);
    }

    /**
     * 批量删除告警管理
     * 
     * @param alertIds 需要删除的告警管理主键
     * @return 结果
     */
    @Override
    public int deletePmsAlertByAlertIds(Long[] alertIds)
    {
        return pmsAlertMapper.deletePmsAlertByAlertIds(alertIds);
    }

    /**
     * 删除告警管理信息
     * 
     * @param alertId 告警管理主键
     * @return 结果
     */
    @Override
    public int deletePmsAlertByAlertId(Long alertId)
    {
        return pmsAlertMapper.deletePmsAlertByAlertId(alertId);
    }
}

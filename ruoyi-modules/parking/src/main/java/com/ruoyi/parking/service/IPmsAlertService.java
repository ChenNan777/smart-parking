package com.ruoyi.parking.service;

import java.util.List;
import com.ruoyi.parking.domain.PmsAlert;

/**
 * 告警管理Service接口
 * 
 * @author chennan
 * @date 2023-11-15
 */
public interface IPmsAlertService 
{
    /**
     * 查询告警管理
     * 
     * @param alertId 告警管理主键
     * @return 告警管理
     */
    public PmsAlert selectPmsAlertByAlertId(Long alertId);

    /**
     * 查询告警管理列表
     * 
     * @param pmsAlert 告警管理
     * @return 告警管理集合
     */
    public List<PmsAlert> selectPmsAlertList(PmsAlert pmsAlert);

    /**
     * 新增告警管理
     * 
     * @param pmsAlert 告警管理
     * @return 结果
     */
    public int insertPmsAlert(PmsAlert pmsAlert);

    /**
     * 修改告警管理
     * 
     * @param pmsAlert 告警管理
     * @return 结果
     */
    public int updatePmsAlert(PmsAlert pmsAlert);

    /**
     * 批量删除告警管理
     * 
     * @param alertIds 需要删除的告警管理主键集合
     * @return 结果
     */
    public int deletePmsAlertByAlertIds(Long[] alertIds);

    /**
     * 删除告警管理信息
     * 
     * @param alertId 告警管理主键
     * @return 结果
     */
    public int deletePmsAlertByAlertId(Long alertId);
}

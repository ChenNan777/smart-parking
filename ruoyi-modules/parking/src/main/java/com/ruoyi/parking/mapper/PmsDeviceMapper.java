package com.ruoyi.parking.mapper;

import java.util.List;
import com.ruoyi.parking.domain.PmsDevice;

/**
 * 设备管理Mapper接口
 * 
 * @author chennan
 * @date 2023-11-15
 */
public interface PmsDeviceMapper 
{
    /**
     * 查询设备管理
     * 
     * @param deviceId 设备管理主键
     * @return 设备管理
     */
    public PmsDevice selectPmsDeviceByDeviceId(Long deviceId);

    /**
     * 查询设备管理列表
     * 
     * @param pmsDevice 设备管理
     * @return 设备管理集合
     */
    public List<PmsDevice> selectPmsDeviceList(PmsDevice pmsDevice);

    /**
     * 新增设备管理
     * 
     * @param pmsDevice 设备管理
     * @return 结果
     */
    public int insertPmsDevice(PmsDevice pmsDevice);

    /**
     * 修改设备管理
     * 
     * @param pmsDevice 设备管理
     * @return 结果
     */
    public int updatePmsDevice(PmsDevice pmsDevice);

    /**
     * 删除设备管理
     * 
     * @param deviceId 设备管理主键
     * @return 结果
     */
    public int deletePmsDeviceByDeviceId(Long deviceId);

    /**
     * 批量删除设备管理
     * 
     * @param deviceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsDeviceByDeviceIds(Long[] deviceIds);
}

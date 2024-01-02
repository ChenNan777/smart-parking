package com.ruoyi.parking.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.parking.mapper.PmsDeviceMapper;
import com.ruoyi.parking.domain.PmsDevice;
import com.ruoyi.parking.service.IPmsDeviceService;

/**
 * 设备管理Service业务层处理
 * 
 * @author chennan
 * @date 2023-11-15
 */
@Service
public class PmsDeviceServiceImpl implements IPmsDeviceService 
{
    @Autowired
    private PmsDeviceMapper pmsDeviceMapper;

    /**
     * 查询设备管理
     * 
     * @param deviceId 设备管理主键
     * @return 设备管理
     */
    @Override
    public PmsDevice selectPmsDeviceByDeviceId(Long deviceId)
    {
        return pmsDeviceMapper.selectPmsDeviceByDeviceId(deviceId);
    }

    /**
     * 查询设备管理列表
     * 
     * @param pmsDevice 设备管理
     * @return 设备管理
     */
    @Override
    public List<PmsDevice> selectPmsDeviceList(PmsDevice pmsDevice)
    {
        return pmsDeviceMapper.selectPmsDeviceList(pmsDevice);
    }

    /**
     * 新增设备管理
     * 
     * @param pmsDevice 设备管理
     * @return 结果
     */
    @Override
    public int insertPmsDevice(PmsDevice pmsDevice)
    {
        return pmsDeviceMapper.insertPmsDevice(pmsDevice);
    }

    /**
     * 修改设备管理
     * 
     * @param pmsDevice 设备管理
     * @return 结果
     */
    @Override
    public int updatePmsDevice(PmsDevice pmsDevice)
    {
        return pmsDeviceMapper.updatePmsDevice(pmsDevice);
    }

    /**
     * 批量删除设备管理
     * 
     * @param deviceIds 需要删除的设备管理主键
     * @return 结果
     */
    @Override
    public int deletePmsDeviceByDeviceIds(Long[] deviceIds)
    {
        return pmsDeviceMapper.deletePmsDeviceByDeviceIds(deviceIds);
    }

    /**
     * 删除设备管理信息
     * 
     * @param deviceId 设备管理主键
     * @return 结果
     */
    @Override
    public int deletePmsDeviceByDeviceId(Long deviceId)
    {
        return pmsDeviceMapper.deletePmsDeviceByDeviceId(deviceId);
    }
}

package com.ruoyi.parking.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.parking.domain.PmsDevice;
import com.ruoyi.parking.service.IPmsDeviceService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 设备管理Controller
 * 
 * @author chennan
 * @date 2023-11-15
 */
@RestController
@RequestMapping("/device")
public class PmsDeviceController extends BaseController
{
    @Autowired
    private IPmsDeviceService pmsDeviceService;

    /**
     * 查询设备管理列表
     */
    @RequiresPermissions("parking:device:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsDevice pmsDevice)
    {
        startPage();
        List<PmsDevice> list = pmsDeviceService.selectPmsDeviceList(pmsDevice);
        return getDataTable(list);
    }

    /**
     * 导出设备管理列表
     */
    @RequiresPermissions("parking:device:export")
    @Log(title = "设备管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsDevice pmsDevice)
    {
        List<PmsDevice> list = pmsDeviceService.selectPmsDeviceList(pmsDevice);
        ExcelUtil<PmsDevice> util = new ExcelUtil<PmsDevice>(PmsDevice.class);
        util.exportExcel(response, list, "设备管理数据");
    }

    /**
     * 获取设备管理详细信息
     */
    @RequiresPermissions("parking:device:query")
    @GetMapping(value = "/{deviceId}")
    public AjaxResult getInfo(@PathVariable("deviceId") Long deviceId)
    {
        return success(pmsDeviceService.selectPmsDeviceByDeviceId(deviceId));
    }

    /**
     * 新增设备管理
     */
    @RequiresPermissions("parking:device:add")
    @Log(title = "设备管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsDevice pmsDevice)
    {
        return toAjax(pmsDeviceService.insertPmsDevice(pmsDevice));
    }

    /**
     * 修改设备管理
     */
    @RequiresPermissions("parking:device:edit")
    @Log(title = "设备管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsDevice pmsDevice)
    {
        return toAjax(pmsDeviceService.updatePmsDevice(pmsDevice));
    }

    /**
     * 删除设备管理
     */
    @RequiresPermissions("parking:device:remove")
    @Log(title = "设备管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deviceIds}")
    public AjaxResult remove(@PathVariable Long[] deviceIds)
    {
        return toAjax(pmsDeviceService.deletePmsDeviceByDeviceIds(deviceIds));
    }
}

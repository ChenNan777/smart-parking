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
import com.ruoyi.parking.domain.PmsZone;
import com.ruoyi.parking.service.IPmsZoneService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 分区管理Controller
 * 
 * @author chennan
 * @date 2023-11-15
 */
@RestController
@RequestMapping("/zone")
public class PmsZoneController extends BaseController
{
    @Autowired
    private IPmsZoneService pmsZoneService;

    /**
     * 查询分区管理列表
     */
    @RequiresPermissions("parking:zone:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsZone pmsZone)
    {
        startPage();
        List<PmsZone> list = pmsZoneService.selectPmsZoneList(pmsZone);
        return getDataTable(list);
    }

    /**
     * 导出分区管理列表
     */
    @RequiresPermissions("parking:zone:export")
    @Log(title = "分区管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsZone pmsZone)
    {
        List<PmsZone> list = pmsZoneService.selectPmsZoneList(pmsZone);
        ExcelUtil<PmsZone> util = new ExcelUtil<PmsZone>(PmsZone.class);
        util.exportExcel(response, list, "分区管理数据");
    }

    /**
     * 获取分区管理详细信息
     */
    @RequiresPermissions("parking:zone:query")
    @GetMapping(value = "/{zoneId}")
    public AjaxResult getInfo(@PathVariable("zoneId") Long zoneId)
    {
        return success(pmsZoneService.selectPmsZoneByZoneId(zoneId));
    }

    /**
     * 新增分区管理
     */
    @RequiresPermissions("parking:zone:add")
    @Log(title = "分区管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsZone pmsZone)
    {
        return toAjax(pmsZoneService.insertPmsZone(pmsZone));
    }

    /**
     * 修改分区管理
     */
    @RequiresPermissions("parking:zone:edit")
    @Log(title = "分区管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsZone pmsZone)
    {
        return toAjax(pmsZoneService.updatePmsZone(pmsZone));
    }

    /**
     * 删除分区管理
     */
    @RequiresPermissions("parking:zone:remove")
    @Log(title = "分区管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{zoneIds}")
    public AjaxResult remove(@PathVariable Long[] zoneIds)
    {
        return toAjax(pmsZoneService.deletePmsZoneByZoneIds(zoneIds));
    }
}

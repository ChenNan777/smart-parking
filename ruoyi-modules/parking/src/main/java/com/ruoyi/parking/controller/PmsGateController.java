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
import com.ruoyi.parking.domain.PmsGate;
import com.ruoyi.parking.service.IPmsGateService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 出入口管理Controller
 * 
 * @author chennan
 * @date 2023-11-15
 */
@RestController
@RequestMapping("/gate")
public class PmsGateController extends BaseController
{
    @Autowired
    private IPmsGateService pmsGateService;

    /**
     * 查询出入口管理列表
     */
    @RequiresPermissions("parking:gate:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsGate pmsGate)
    {
        startPage();
        List<PmsGate> list = pmsGateService.selectPmsGateList(pmsGate);
        return getDataTable(list);
    }

    /**
     * 导出出入口管理列表
     */
    @RequiresPermissions("parking:gate:export")
    @Log(title = "出入口管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsGate pmsGate)
    {
        List<PmsGate> list = pmsGateService.selectPmsGateList(pmsGate);
        ExcelUtil<PmsGate> util = new ExcelUtil<PmsGate>(PmsGate.class);
        util.exportExcel(response, list, "出入口管理数据");
    }

    /**
     * 获取出入口管理详细信息
     */
    @RequiresPermissions("parking:gate:query")
    @GetMapping(value = "/{gateId}")
    public AjaxResult getInfo(@PathVariable("gateId") Long gateId)
    {
        return success(pmsGateService.selectPmsGateByGateId(gateId));
    }

    /**
     * 新增出入口管理
     */
    @RequiresPermissions("parking:gate:add")
    @Log(title = "出入口管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsGate pmsGate)
    {
        return toAjax(pmsGateService.insertPmsGate(pmsGate));
    }

    /**
     * 修改出入口管理
     */
    @RequiresPermissions("parking:gate:edit")
    @Log(title = "出入口管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsGate pmsGate)
    {
        return toAjax(pmsGateService.updatePmsGate(pmsGate));
    }

    /**
     * 删除出入口管理
     */
    @RequiresPermissions("parking:gate:remove")
    @Log(title = "出入口管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{gateIds}")
    public AjaxResult remove(@PathVariable Long[] gateIds)
    {
        return toAjax(pmsGateService.deletePmsGateByGateIds(gateIds));
    }
}

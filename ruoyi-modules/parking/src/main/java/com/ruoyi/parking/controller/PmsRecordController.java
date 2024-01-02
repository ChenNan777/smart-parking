package com.ruoyi.parking.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.parking.domain.dto.PmsRecordDTO;
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
import com.ruoyi.parking.domain.PmsRecord;
import com.ruoyi.parking.service.IPmsRecordService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 出入库记录Controller
 * 
 * @author chennan
 * @date 2023-11-26
 */
@RestController
@RequestMapping("/record")
public class PmsRecordController extends BaseController
{
    @Autowired
    private IPmsRecordService pmsRecordService;

    /**
     * 查询出入库记录列表
     */
    @RequiresPermissions("parking:record:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsRecordDTO pmsRecord)
    {
        startPage();
        List<PmsRecord> list = pmsRecordService.selectPmsRecordList(pmsRecord);
        return getDataTable(list);
    }

    /**
     * 导出出入库记录列表
     */
    @RequiresPermissions("parking:record:export")
    @Log(title = "出入库记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsRecordDTO pmsRecord)
    {
        List<PmsRecord> list = pmsRecordService.selectPmsRecordList(pmsRecord);
        ExcelUtil<PmsRecord> util = new ExcelUtil<PmsRecord>(PmsRecord.class);
        util.exportExcel(response, list, "出入库记录数据");
    }

    /**
     * 获取出入库记录详细信息
     */
    @RequiresPermissions("parking:record:query")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(pmsRecordService.selectPmsRecordByRecordId(recordId));
    }

    /**
     * 新增出入库记录
     */
    @RequiresPermissions("parking:record:add")
    @Log(title = "出入库记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsRecord pmsRecord)
    {
        return toAjax(pmsRecordService.insertPmsRecord(pmsRecord));
    }

    /**
     * 修改出入库记录
     */
    @RequiresPermissions("parking:record:edit")
    @Log(title = "出入库记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsRecord pmsRecord)
    {
        return toAjax(pmsRecordService.updatePmsRecord(pmsRecord));
    }

    /**
     * 删除出入库记录
     */
    @RequiresPermissions("parking:record:remove")
    @Log(title = "出入库记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(pmsRecordService.deletePmsRecordByRecordIds(recordIds));
    }
}

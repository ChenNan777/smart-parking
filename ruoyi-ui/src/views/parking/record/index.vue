<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-form-item label="车牌号" prop="plate">
        <el-input
          v-model="queryParams.plate"
          placeholder="请输入车牌号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="进出分区" prop="zoneId">
        <el-select
          v-model="queryParams.zoneId"
          placeholder="请选择分区"
          @change="handleQuery"
        >
          <el-option
            v-for="zone in this.zoneList"
            :key="zone.zoneId"
            :label="zone.name"
            :value="zone.zoneId"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="操作类型" prop="type">
        <el-select
          v-model="queryParams.type"
          placeholder="请选择操作类型"
          @change="handleQuery"
          clearable
        >
          <el-option
            v-for="dict in dict.type.pms_record_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="操作时间">
        <el-date-picker
          v-model="queryParams.timeRange"
          style="width: 240px"
          value-format="yyyy-MM-dd HH:mm:ss"
          type="datetimerange"
          range-separator="-"
          start-placeholder="开始时间"
          end-placeholder="结束时间"
          @change="handleQuery"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <!-- <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['parking:record:add']"
          >新增</el-button
        >
      </el-col> -->
      <!-- <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['parking:record:edit']"
          >修改</el-button
        >
      </el-col> -->
      <!-- <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['parking:record:remove']"
          >删除</el-button
        >
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['parking:record:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="recordList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="记录ID" align="center" prop="recordId" />
      <el-table-column label="车牌号" align="center" prop="plate" />
      <el-table-column label="操作类型" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.pms_record_type"
            :value="scope.row.type"
          />
        </template>
      </el-table-column>
      <el-table-column label="操作时间" align="center" prop="time" width="180">
        <template slot-scope="scope">
          <span>{{
            parseTime(scope.row.time, "{y}-{m}-{d} {h}:{i}:{s}")
          }}</span>
        </template>
      </el-table-column>
      <el-table-column label="进出分区" align="center" prop="zoneName" />
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <!-- <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['parking:record:edit']"
            >修改</el-button
          > -->
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['parking:record:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改出入库记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="车牌号" prop="plate">
          <el-input v-model="form.plate" placeholder="请输入车牌号" />
        </el-form-item>
        <el-form-item label="操作类型" prop="type">
          <el-radio-group v-model="form.type">
            <el-radio
              v-for="dict in dict.type.pms_record_type"
              :key="dict.value"
              :label="parseInt(dict.value)"
              >{{ dict.label }}</el-radio
            >
          </el-radio-group>
        </el-form-item>
        <el-form-item label="操作时间" prop="time">
          <el-date-picker
            clearable
            v-model="form.time"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择操作时间"
          >
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listRecord,
  getRecord,
  delRecord,
  addRecord,
  updateRecord,
} from "@/api/parking/record";
import { listZone } from "@/api/parking/zone";

export default {
  name: "Record",
  dicts: ["pms_record_type"],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 出入库记录表格数据
      recordList: [],
      // 分区数据
      zoneList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 进出分区时间范围
      daterangeTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        plate: null,
        type: null,
        time: null,
        zoneId: null,
        timeRange: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        plate: [
          { required: true, message: "车牌号不能为空", trigger: "blur" },
          {
            pattern:
              /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/,
            message: "车牌格式错误",
            trigger: "blur",
          },
        ],
        type: [
          { required: true, message: "操作类型不能为空", trigger: "change" },
        ],
        time: [
          { required: true, message: "操作时间不能为空", trigger: "blur" },
        ],
        zoneId: [
          { required: true, message: "进出分区不能为空", trigger: "change" },
        ],
      },
    };
  },
  created() {
    this.getList();
    this.getZoneList();
  },
  methods: {
    /** 查询出入库记录列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeTime && "" != this.daterangeTime) {
        this.queryParams.params["beginTime"] = this.daterangeTime[0];
        this.queryParams.params["endTime"] = this.daterangeTime[1];
      }
      listRecord(this.queryParams).then((response) => {
        this.recordList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询分区列表 */
    getZoneList() {
      listZone().then((response) => {
        this.zoneList = response.rows;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        recordId: null,
        plate: null,
        type: null,
        time: null,
        zoneId: null,
        timeRange: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.queryParams.timeRange = null;
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.recordId);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加出入库记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const recordId = row.recordId || this.ids;
      getRecord(recordId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改出入库记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.recordId != null) {
            updateRecord(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRecord(this.form).then((response) => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const recordIds = row.recordId || this.ids;
      this.$modal
        .confirm('是否确认删除出入库记录编号为"' + recordIds + '"的数据项？')
        .then(function () {
          return delRecord(recordIds);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "parking/record/export",
        {
          ...this.queryParams,
        },
        `record_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>

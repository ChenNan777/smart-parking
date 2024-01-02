import request from '@/utils/request'

// 查询告警管理列表
export function listAlert(query) {
  return request({
    url: '/parking/alert/list',
    method: 'get',
    params: query
  })
}

// 查询告警管理详细
export function getAlert(alertId) {
  return request({
    url: '/parking/alert/' + alertId,
    method: 'get'
  })
}

// 新增告警管理
export function addAlert(data) {
  return request({
    url: '/parking/alert',
    method: 'post',
    data: data
  })
}

// 修改告警管理
export function updateAlert(data) {
  return request({
    url: '/parking/alert',
    method: 'put',
    data: data
  })
}

// 删除告警管理
export function delAlert(alertId) {
  return request({
    url: '/parking/alert/' + alertId,
    method: 'delete'
  })
}

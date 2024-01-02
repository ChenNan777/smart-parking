import request from '@/utils/request'

// 查询出入口管理列表
export function listGate(query) {
  return request({
    url: '/parking/gate/list',
    method: 'get',
    params: query
  })
}

// 查询出入口管理详细
export function getGate(gateId) {
  return request({
    url: '/parking/gate/' + gateId,
    method: 'get'
  })
}

// 新增出入口管理
export function addGate(data) {
  return request({
    url: '/parking/gate',
    method: 'post',
    data: data
  })
}

// 修改出入口管理
export function updateGate(data) {
  return request({
    url: '/parking/gate',
    method: 'put',
    data: data
  })
}

// 删除出入口管理
export function delGate(gateId) {
  return request({
    url: '/parking/gate/' + gateId,
    method: 'delete'
  })
}

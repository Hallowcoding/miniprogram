//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
		levels: [],
    cur_level: 0,
  },
  onLoad: function (options) {
		let self = this, level_id = options.level_id;
		//1.查询用户关卡列表
		wx.cloud.callFunction({
			name: 'levelQuery',
			data: {
				curLevel: self.data.cur_level
			},
			success: res => {
				let data = res.result
				if (level_id != undefined) {
					for (var i in data) {
						if (level_id == data[i].level_id) {
							data[i].passor = 1
							if (i + 1 < data.length) {
								data[i + 1].passor = 0
							}
						}
			    }
				}
				self.setData({
					levels: data
				})
			},
			fail: err => {
				console.log('[云函数] [levelUserQuery] 调用失败，错误信息：', err)
			}
		})
  },
	levelClick: function(e) {
		//跳转至关卡详情页面，带返回按钮
		let data = e.currentTarget.dataset.item
		wx.redirectTo({
			url: '../level/level?level_id='+ e.currentTarget.id + '&passor=' + data.passor
		})
	}
})

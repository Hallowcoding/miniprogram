//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
		levels: [],
    user_level_number: 1,
    user_id: "1"
  },
  onLoad: function () {
		// 1. 获取数据库引用
		const db = wx.cloud.database({
		  env: 'hallowcode'
		})
		let self = this;
		// 2. 查询关卡列表
		db.collection('level').where({
		}).get({
		  success: function(res) {
				self.setData({
					levels: res.data
				})
			}
		})
		//3.查询用户最大关数
		db.collection('level_user').where({
			user_id: this.data.user_id
		}).get({
		  success: function(res) {
				self.setData({
					user_level_number: res.data[0].level_number
				})
			}
		})
  },
	levelClick: function(e) {
		//跳转至关卡详情页面，带返回按钮
		let data = e.currentTarget.dataset, user_level_number = this.data.user_level_number
		wx.navigateTo({
			url: '../level/level?level_id='+ e.currentTarget.id + '&passor=' + (data.level_number <= user_level_number)
		})
	}
})

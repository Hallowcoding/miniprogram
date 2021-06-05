//app.js

App({
  onLaunch: function () {
    wx.cloud.init()
    
    if (!wx.cloud) {
      console.error('请使用 2.2.3 或以上的基础库以使用云能力')
    } else {
      wx.cloud.init({
        traceUser: true,
				env: 'hallowcode'
      })
    }
		//获取用户openid
		let self = this;
		wx.cloud.callFunction({
			name: 'login',
			data: {},
			success: res => {
				self.globalData.openid = res.result.openid
			},
			fail: err => {
				console.log('[云函数] [login] 获取 openid 失败，请检查是否有部署云函数，错误信息：', err)
			}
		})
  },
  globalData: {
		openid: null,
    userInfo: null
  }
})
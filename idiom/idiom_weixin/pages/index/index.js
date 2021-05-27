//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
	level: {"levelId":1,
	"words":[[null,null,null,null,null,null,null,null],
	[null,null,null,null,{"v":"顺","vor":"1"},null,null,null],
	[null,{"v":"爱","vor":"1"},{"v":"不","vor":"0"},{"v":"释","vor":"1"},{"v":"手","vor":"0"},null,null,null],
	[null,null,null,null,{"v":"牵","vor":"0"},null,null,null],
	[null,null,null,{"v":"亡","vor":"0"},{"v":"羊","vor":"1"},{"v":"补","vor":"0"},{"v":"牢","vor":"1"},null],
	[null,null,null,null,null,null,null,null]],
	"answers":["亡","牵","补","手","不"]},
	rows: 6,
	columns: 8,
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})

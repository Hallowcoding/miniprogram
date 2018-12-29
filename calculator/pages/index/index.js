//index.js

Page({
  data: {
    tool: [
      {field:'贷款计算', icon:'../../image/loancalculator.png', url:'../loancalculator/loancalculator'},
      {field:'亲戚称呼计算', icon:'../../image/relativecalculator.png', url:'../relativecalculator/relativecalculator'}
    ]
  },
  //事件处理函数
  bindViewTap: function(e) {
    wx.navigateTo({
      url: e.target.dataset.next
    })
  }
})

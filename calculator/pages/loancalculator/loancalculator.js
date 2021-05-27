// pages/loancalculator/loancalculator.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    fieldData: [
      {title: '贷款总额(￥)', type:'input', field: 'amount'},
      {title: '年利率(%)', type:'input', field: 'apr'},
      {title: '贷款期限(年)', type:'input', field: 'years'},
      {title: '', type:'button'},
      {title: '月付', field: 'payment'},
      {title: '全部付款', field: 'total'},
      {title: '总利息', field: 'totalinterest'}
    ],
    formData: {
      amount: '',
      apr: '',
      years: '',
      payment:'',
      total:'',
      totalinterest:''
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  /**
   * 从<input>元素中读取数据,计算贷款赔付信息,并将结果显示在<view>元素中
   */
  calculate: function () {
    let principal = this.data.formData.amount;
    let interest = this.data.formData.apr / 100 / 12;
    let payments = this.data.formData.years * 12;

    let x = Math.pow(1 + interest, payments);
    let monthly = (principal * x * interest) / (x - 1);

    let payment, total, totalinterest;
    if(isFinite(monthly)){
      payment = monthly.toFixed(2);
      total = (monthly * payments).toFixed(2);
      totalinterest = (monthly * payments - principal).toFixed(2);

      this.setData({
        ['formData.payment'] : '￥'+payment,
        ['formData.total'] : '￥'+total,
        ['formData.totalinterest'] : '￥'+totalinterest
      })
    }
  },

  /**
   * 获取<input>元素中数据
   */
  getInput: function(e) {
    let formData = this.data.formData
    formData[e.target.dataset.item] = e.detail.value
    this.setData({
      formData
    })
  }
})
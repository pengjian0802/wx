//index.js
//获取应用实例
var app = getApp()
Page({
  data: {
    userInfo: {},
    dataList: {},
    isHiddenLoading: false,
    isHiddenToast: true
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    console.log('onLoad')
    this.queryData()
  },
  showDetail: function (event) {
    var id = event.currentTarget.dataset.id
    console.log("id:"+id)
    wx.navigateTo({
      url: '../itemDetail/itemDetail?itemId='+id
    });
  },
  //查询数据
  queryData: function () {
    console.log("queryData");
    var that = this
    wx.request({
      url: 'https://scm.butterfly.mopaasapp.com/queryItem',
      data: {},
      method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function(res){
        console.log("success");
        that.setData({
          dataList: res.data.dataList,
          isHiddenLoading: true
        });
      },
      fail: function() {
        console.log("fail");
      },
      complete: function() {
        // complete
      }
    })
  },
  //下拉刷新
  onPullDownRefresh: function(){
    console.log("下拉刷新");
    this.closeToast();
  },
  //上拉触底
  onReachBottom: function(){
    console.log("上拉触底");
  },
   closeToast: function( e ) {
    this.setData( {
      isHiddenToast: true
    });
  }
})

var url="http://localhost:8080/Badminton/ShowStatistical/StatisticalResultsJSON"
//二维数组存储数据
$("#showGraph").click(function(){
  var areaDataArray = new Array();
  var timeArray = new Array(32).fill(0);
  var moneyArray = new Array(32).fill(0);
  var tmp1 = 1;
  var tmp2 = 1;
  var chooseMonth = $(".selectedMonth").val();
  var chooseYear = ['2019-'+chooseMonth]
   var beginDay ='2019-'+chooseMonth+'-01';
    if (parseInt(chooseMonth) < 9) {
        var endDay ='2019-0'+(parseInt(chooseMonth)+1)+'-01';
    }else
    {
        var endDay ='2019-'+(parseInt(chooseMonth)+1)+'-01';
    }
    //使用getJSON方法取得JSON数据
      $.getJSON(
          url,
  //处理数据 data指向的是返回来的JSON数据
          function(data){
              $.each(data,function(i,data){
                  areaDataArray[i]=new Array();
                  //场地名字和价格
                  areaDataArray[i].push(data.areaname);
                  // console.log(data.areaname)
                  // console.log("数组"+areaDataArray[i][0])
                  areaDataArray[i].push(data.price);
                  // console.log(data.price)
                  $(data.reservation).each(function(k,reservation){
                      //日期，开始和结束时间
                      areaDataArray[i].push(reservation.preDate.substring(5,10));
                      areaDataArray[i].push(reservation.stoptime - reservation.starttime);
                      // console.log(reservation.preDate)
                      // console.log(reservation.starttime)
                      // console.log(reservation.stoptime)
                  });
                  //盈利
                  areaDataArray[i].push((areaDataArray[i][3])*areaDataArray[i][1]);

              });
              for (var i = 0; i < areaDataArray.length; i++) {
                if (areaDataArray[i][2].substring(0,2) != chooseMonth) {
                      console.log("cishu："+i)
                    console.log("预选："+chooseMonth)
                    console.log("截取："+areaDataArray[i][2].substring(0,2))
                    console.log("判断"+areaDataArray[i][2].substring(0,2) != chooseMonth)
                    areaDataArray[i].fill('999999');
                }
              }
              console.log(areaDataArray);

              for (var i = 0;i < areaDataArray.length ;i++){
                if (areaDataArray[i][2] != '999999') {
                  timeArray[parseInt(areaDataArray[i][2].substring(3,5))] += areaDataArray[i][3];
                  moneyArray[parseInt(areaDataArray[i][2].substring(3,5))] += areaDataArray[i][4];
                }

              }
              console.log(timeArray);
              console.log(moneyArray);

              var app = {};
              var myChart = echarts.init(document.getElementById('main'));

              var cellSize = [100, 100];
              var pieRadius =40;

              function getVirtulData() {
                  var date = +echarts.number.parseDate(beginDay);
                  var end = +echarts.number.parseDate(endDay);
                  var dayTime = 3600 * 24 * 1000;
                  var data = [];
                  for (var time = date; time < end; time += dayTime) {
                      data.push([
                          echarts.format.formatTime('yyyy-MM-dd', time),
                          Math.floor(Math.random() * 10000)
                      ]);
                  }
                  return data;
              }

              function getPieSeries(scatterData, chart) {
                  return echarts.util.map(scatterData, function (item, index) {
                      var center = chart.convertToPixel('calendar', item);
                      return {
                          id: index + 'pie',
                          type: 'pie',
                          center: center,
                          label: {
                              normal: {
                                  formatter: '{c}',
                                  position: 'inside'
                              }
                          },
                          radius: pieRadius,
                          data: [
                              {name: "所有场地共经营时长/小时", value: timeArray[tmp1++]},
                              {name: '总盈利/千元', value:  moneyArray[tmp2++]/1000}
                          ]
                      };
                  });
              }

              function getPieSeriesUpdate(scatterData, chart) {
                  return echarts.util.map(scatterData, function (item, index) {
                      var center = chart.convertToPixel('calendar', item);
                      return {
                          id: index + 'pie',
                          center: center
                      };
                  });
              }

              var scatterData = getVirtulData();

              option = {
                  title : {
                      show:true,//显示策略，默认值true,可选为：true（显示） | false（隐藏）
                      text: '场地总营业时间统计图【按月查看】\n',//主标题文本，'\n'指定换行
                      //subtext: '副标题',//副标题文本，'\n'指定换行
                      sublink: '',//副标题文本超链接
                      subtarget: null,//指定窗口打开副标题超链接，支持'self' | 'blank'，不指定等同为'blank'（新窗口）
                      x:'center',//水平安放位置，默认为'left'，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
                      y: '30px',//垂直安放位置，默认为top，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
                      textAlign: 'center',//水平对齐方式，默认根据x设置自动调整，可选为： left' | 'right' | 'center
                      padding: 5,//标题内边距，单位px，默认各方向内边距为5，接受数组分别设定上右下左边距
                      itemGap: 10,//主副标题纵向间隔，单位px，默认为10
                      textStyle: {//主标题文本样式
                          // {"fontSize": 18,"fontWeight": "bolder","color": "#333"}
                          fontFamily: 'Arial, Verdana, sans...',
                          fontSize: 30,
                          fontStyle: 'normal',
                          fontWeight: "bolder",
                          color:'#f00'
                      }
                  },
                  tooltip : {},
                  legend: {
                      data: ['所有场地共经营时长/小时', '总盈利/千元'],
                      bottom: 20
                  },
                  calendar: {
                      top: 'middle',
                      left: 'center',
                      orient: 'vertical',
                      cellSize: cellSize,
                      yearLabel: {
                          show: true,
                          textStyle: {
                              fontSize: 30
                          }
                      },
                      dayLabel: {
                          margin: 20,
                          firstDay: 1,
                          nameMap: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六']
                      },
                      monthLabel: {
                          show: true
                      },
                      range: chooseYear
                  },
                  series: [{
                      id: 'label',
                      type: 'scatter',
                      coordinateSystem: 'calendar',
                      symbolSize: 1,
                      label: {
                          normal: {
                              show: true,
                              formatter: function (params) {
                                  return echarts.format.formatTime('dd', params.value[0]);
                              },
                              offset: [-cellSize[0] / 2 + 10, -cellSize[1] / 2 + 10],
                              textStyle: {
                                  color: '#000',
                                  fontSize: 15
                              }
                          }
                      },
                      data: scatterData
                  }]
              };

              if (!app.inNode) {
                  var pieInitialized;
                  setTimeout(function () {
                      pieInitialized = true;
                      myChart.setOption({
                          series: getPieSeries(scatterData, myChart)
                      });
                  }, 10);

                  app.onresize = function () {
                      if (pieInitialized) {
                          myChart.setOption({
                              series: getPieSeriesUpdate(scatterData, myChart)
                          });
                      }
                  };
              }
              myChart.setOption(option);
          })

})
$("#pageleft").click(function(){
  var areaDataArray = new Array();
  var timeArray = new Array(32).fill(0);
  var moneyArray = new Array(32).fill(0);
  var tmp1 = 1;
  var tmp2 = 1;
  var chooseMonth = $(".selectedMonth").val();

  if (parseInt(chooseMonth) > 10) {
      chooseMonth = parseInt(chooseMonth)-1
  }else
  {
    chooseMonth = '0'+(parseInt(chooseMonth)-1)
  }

  if(chooseMonth =='00' ){
    chooseMonth = '12'
  }
  var chooseYear = ['2019-'+chooseMonth]
   var beginDay ='2019-'+chooseMonth+'-01';
    if (parseInt(chooseMonth) < 9) {
        var endDay ='2019-0'+(parseInt(chooseMonth)+1)+'-01';
    }else
    {
        var endDay ='2019-'+(parseInt(chooseMonth)+1)+'-01';
    }


    //使用getJSON方法取得JSON数据
      $.getJSON(
          url,
  //处理数据 data指向的是返回来的JSON数据
          function(data){
              $.each(data,function(i,data){
                  areaDataArray[i]=new Array();
                  //场地名字和价格
                  areaDataArray[i].push(data.areaname);
                  // console.log(data.areaname)
                  // console.log("数组"+areaDataArray[i][0])
                  areaDataArray[i].push(data.price);
                  // console.log(data.price)
                  $(data.reservation).each(function(k,reservation){
                      //日期，开始和结束时间
                      areaDataArray[i].push(reservation.preDate.substring(5,10));
                      areaDataArray[i].push(reservation.stoptime - reservation.starttime);
                      // console.log(reservation.preDate)
                      // console.log(reservation.starttime)
                      // console.log(reservation.stoptime)
                  });
                  //盈利
                  areaDataArray[i].push((areaDataArray[i][3])*areaDataArray[i][1]);

              });
              for (var i = 0; i < areaDataArray.length; i++) {
                if (areaDataArray[i][2].substring(0,2) != chooseMonth) {
                      console.log("cishu："+i)
                    console.log("预选："+chooseMonth)
                    console.log("截取："+areaDataArray[i][2].substring(0,2))
                    console.log("判断"+areaDataArray[i][2].substring(0,2) != chooseMonth)
                    areaDataArray[i].fill('999999');
                }
              }
              console.log(areaDataArray);

              for (var i = 0;i < areaDataArray.length ;i++){
                if (areaDataArray[i][2] != '999999') {
                  timeArray[parseInt(areaDataArray[i][2].substring(3,5))] += areaDataArray[i][3];
                  moneyArray[parseInt(areaDataArray[i][2].substring(3,5))] += areaDataArray[i][4];
                }

              }
              console.log(timeArray);
              console.log(moneyArray);

              var app = {};
              var myChart = echarts.init(document.getElementById('main'));

              var cellSize = [100, 100];
              var pieRadius =40;

              function getVirtulData() {
                  var date = +echarts.number.parseDate(beginDay);
                  var end = +echarts.number.parseDate(endDay);
                  var dayTime = 3600 * 24 * 1000;
                  var data = [];
                  for (var time = date; time < end; time += dayTime) {
                      data.push([
                          echarts.format.formatTime('yyyy-MM-dd', time),
                          Math.floor(Math.random() * 10000)
                      ]);
                  }
                  return data;
              }

              function getPieSeries(scatterData, chart) {
                  return echarts.util.map(scatterData, function (item, index) {
                      var center = chart.convertToPixel('calendar', item);
                      return {
                          id: index + 'pie',
                          type: 'pie',
                          center: center,
                          label: {
                              normal: {
                                  formatter: '{c}',
                                  position: 'inside'
                              }
                          },
                          radius: pieRadius,
                          data: [
                              {name: "所有场地共经营时长/小时", value: timeArray[tmp1++]},
                              {name: '总盈利/千元', value:  moneyArray[tmp2++]/1000}
                          ]
                      };
                  });
              }

              function getPieSeriesUpdate(scatterData, chart) {
                  return echarts.util.map(scatterData, function (item, index) {
                      var center = chart.convertToPixel('calendar', item);
                      return {
                          id: index + 'pie',
                          center: center
                      };
                  });
              }

              var scatterData = getVirtulData();

              option = {
                  title : {
                      show:true,//显示策略，默认值true,可选为：true（显示） | false（隐藏）
                      text: '场地总营业时间统计图【按月查看】\n',//主标题文本，'\n'指定换行
                      //subtext: '副标题',//副标题文本，'\n'指定换行
                      sublink: '',//副标题文本超链接
                      subtarget: null,//指定窗口打开副标题超链接，支持'self' | 'blank'，不指定等同为'blank'（新窗口）
                      x:'center',//水平安放位置，默认为'left'，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
                      y: '30px',//垂直安放位置，默认为top，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
                      textAlign: 'center',//水平对齐方式，默认根据x设置自动调整，可选为： left' | 'right' | 'center
                      padding: 5,//标题内边距，单位px，默认各方向内边距为5，接受数组分别设定上右下左边距
                      itemGap: 10,//主副标题纵向间隔，单位px，默认为10
                      textStyle: {//主标题文本样式
                          // {"fontSize": 18,"fontWeight": "bolder","color": "#333"}
                          fontFamily: 'Arial, Verdana, sans...',
                          fontSize: 30,
                          fontStyle: 'normal',
                          fontWeight: "bolder",
                          color:'#f00'
                      }
                  },
                  tooltip : {},
                  legend: {
                      data: ['所有场地共经营时长/小时', '总盈利/千元'],
                      bottom: 20
                  },
                  calendar: {
                      top: 'middle',
                      left: 'center',
                      orient: 'vertical',
                      cellSize: cellSize,
                      yearLabel: {
                          show: true,
                          textStyle: {
                              fontSize: 30
                          }
                      },
                      dayLabel: {
                          margin: 20,
                          firstDay: 1,
                          nameMap: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六']
                      },
                      monthLabel: {
                          show: true
                      },
                      range: chooseYear
                  },
                  series: [{
                      id: 'label',
                      type: 'scatter',
                      coordinateSystem: 'calendar',
                      symbolSize: 1,
                      label: {
                          normal: {
                              show: true,
                              formatter: function (params) {
                                  return echarts.format.formatTime('dd', params.value[0]);
                              },
                              offset: [-cellSize[0] / 2 + 10, -cellSize[1] / 2 + 10],
                              textStyle: {
                                  color: '#000',
                                  fontSize: 15
                              }
                          }
                      },
                      data: scatterData
                  }]
              };

              if (!app.inNode) {
                  var pieInitialized;
                  setTimeout(function () {
                      pieInitialized = true;
                      myChart.setOption({
                          series: getPieSeries(scatterData, myChart)
                      });
                  }, 10);

                  app.onresize = function () {
                      if (pieInitialized) {
                          myChart.setOption({
                              series: getPieSeriesUpdate(scatterData, myChart)
                          });
                      }
                  };
              }
              myChart.setOption(option);
              $(".selectedMonth").val(chooseMonth);
          })

})
$("#pageright").click(function(){
  var areaDataArray = new Array();
  var timeArray = new Array(32).fill(0);
  var moneyArray = new Array(32).fill(0);
  var tmp1 = 1;
  var tmp2 = 1;
  var chooseMonth = $(".selectedMonth").val();

  if (parseInt(chooseMonth) >= 9) {
      chooseMonth = parseInt(chooseMonth)+1
  }else
  {
    chooseMonth = '0'+(parseInt(chooseMonth)+1)
  }

  if(chooseMonth =='12' ){
    chooseMonth = '01'
  }
  var chooseYear = ['2019-'+chooseMonth]
   var beginDay ='2019-'+chooseMonth+'-01';
    if (parseInt(chooseMonth) < 9) {
        var endDay ='2019-0'+(parseInt(chooseMonth)+1)+'-01';
    }else
    {
        var endDay ='2019-'+(parseInt(chooseMonth)+1)+'-01';
    }


    //使用getJSON方法取得JSON数据
      $.getJSON(
          url,
  //处理数据 data指向的是返回来的JSON数据
          function(data){
              $.each(data,function(i,data){
                  areaDataArray[i]=new Array();
                  //场地名字和价格
                  areaDataArray[i].push(data.areaname);
                  // console.log(data.areaname)
                  // console.log("数组"+areaDataArray[i][0])
                  areaDataArray[i].push(data.price);
                  // console.log(data.price)
                  $(data.reservation).each(function(k,reservation){
                      //日期，开始和结束时间
                      areaDataArray[i].push(reservation.preDate.substring(5,10));
                      areaDataArray[i].push(reservation.stoptime - reservation.starttime);
                      // console.log(reservation.preDate)
                      // console.log(reservation.starttime)
                      // console.log(reservation.stoptime)
                  });
                  //盈利
                  areaDataArray[i].push((areaDataArray[i][3])*areaDataArray[i][1]);

              });
              for (var i = 0; i < areaDataArray.length; i++) {
                if (areaDataArray[i][2].substring(0,2) != chooseMonth) {
                      console.log("cishu："+i)
                    console.log("预选："+chooseMonth)
                    console.log("截取："+areaDataArray[i][2].substring(0,2))
                    console.log("判断"+areaDataArray[i][2].substring(0,2) != chooseMonth)
                    areaDataArray[i].fill('999999');
                }
              }
              console.log(areaDataArray);

              for (var i = 0;i < areaDataArray.length ;i++){
                if (areaDataArray[i][2] != '999999') {
                  timeArray[parseInt(areaDataArray[i][2].substring(3,5))] += areaDataArray[i][3];
                  moneyArray[parseInt(areaDataArray[i][2].substring(3,5))] += areaDataArray[i][4];
                }

              }
              console.log(timeArray);
              console.log(moneyArray);

              var app = {};
              var myChart_R = echarts.init(document.getElementById('main'));

              var cellSize = [100, 100];
              var pieRadius =40;

              function getVirtulData() {
                  var date = +echarts.number.parseDate(beginDay);
                  var end = +echarts.number.parseDate(endDay);
                  var dayTime = 3600 * 24 * 1000;
                  var data = [];
                  for (var time = date; time < end; time += dayTime) {
                      data.push([
                          echarts.format.formatTime('yyyy-MM-dd', time),
                          Math.floor(Math.random() * 10000)
                      ]);
                  }
                  return data;
              }

              function getPieSeries(scatterData, chart) {
                  return echarts.util.map(scatterData, function (item, index) {
                      var center = chart.convertToPixel('calendar', item);
                      return {
                          id: index + 'pie',
                          type: 'pie',
                          center: center,
                          label: {
                              normal: {
                                  formatter: '{c}',
                                  position: 'inside'
                              }
                          },
                          radius: pieRadius,
                          data: [
                              {name: "所有场地共经营时长/小时", value: timeArray[tmp1++]},
                              {name: '总盈利/千元', value:  moneyArray[tmp2++]/1000}
                          ]
                      };
                  });
              }

              function getPieSeriesUpdate(scatterData, chart) {
                  return echarts.util.map(scatterData, function (item, index) {
                      var center = chart.convertToPixel('calendar', item);
                      return {
                          id: index + 'pie',
                          center: center
                      };
                  });
              }

              var scatterData = getVirtulData();

              option = {
                  title : {
                      show:true,//显示策略，默认值true,可选为：true（显示） | false（隐藏）
                      text: '场地总营业时间统计图【按月查看】\n',//主标题文本，'\n'指定换行
                      //subtext: '副标题',//副标题文本，'\n'指定换行
                      sublink: '',//副标题文本超链接
                      subtarget: null,//指定窗口打开副标题超链接，支持'self' | 'blank'，不指定等同为'blank'（新窗口）
                      x:'center',//水平安放位置，默认为'left'，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
                      y: '30px',//垂直安放位置，默认为top，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
                      textAlign: 'center',//水平对齐方式，默认根据x设置自动调整，可选为： left' | 'right' | 'center
                      padding: 5,//标题内边距，单位px，默认各方向内边距为5，接受数组分别设定上右下左边距
                      itemGap: 10,//主副标题纵向间隔，单位px，默认为10
                      textStyle: {//主标题文本样式
                          // {"fontSize": 18,"fontWeight": "bolder","color": "#333"}
                          fontFamily: 'Arial, Verdana, sans...',
                          fontSize: 30,
                          fontStyle: 'normal',
                          fontWeight: "bolder",
                          color:'#f00'
                      }
                  },
                  tooltip : {},
                  legend: {
                      data: ['所有场地共经营时长/小时', '总盈利/千元'],
                      bottom: 20
                  },
                  calendar: {
                      top: 'middle',
                      left: 'center',
                      orient: 'vertical',
                      cellSize: cellSize,
                      yearLabel: {
                          show: true,
                          textStyle: {
                              fontSize: 30
                          }
                      },
                      dayLabel: {
                          margin: 20,
                          firstDay: 1,
                          nameMap: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六']
                      },
                      monthLabel: {
                          show: true
                      },
                      range: chooseYear
                  },
                  series: [{
                      id: 'label',
                      type: 'scatter',
                      coordinateSystem: 'calendar',
                      symbolSize: 1,
                      label: {
                          normal: {
                              show: true,
                              formatter: function (params) {
                                  return echarts.format.formatTime('dd', params.value[0]);
                              },
                              offset: [-cellSize[0] / 2 + 10, -cellSize[1] / 2 + 10],
                              textStyle: {
                                  color: '#000',
                                  fontSize: 15
                              }
                          }
                      },
                      data: scatterData
                  }]
              };

              if (!app.inNode) {
                  var pieInitialized;
                  setTimeout(function () {
                      pieInitialized = true;
                      myChart_R.setOption({
                          series: getPieSeries(scatterData, myChart_R)
                      });
                  }, 10);

                  app.onresize = function () {
                      if (pieInitialized) {
                          myChart_R.setOption({
                              series: getPieSeriesUpdate(scatterData, myChart_R)
                          });
                      }
                  };
              }
              myChart_R.setOption(option);
              $(".selectedMonth").val(chooseMonth);
          })

})

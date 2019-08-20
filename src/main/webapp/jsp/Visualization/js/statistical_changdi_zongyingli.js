var url="http://localhost:8080/Badminton/ShowStatistical/StatisticalResultsJSON"
//二维数组存储数据
var areaDataArray = new Array();

var yingliData = new Array();
var changdiData = new Array();
var shijianData = new Array();

var flag = 0;
var flag2 = 1;
//使用getJSON方法取得JSON数据
    $.getJSON(
        url,
//处理数据 data指向的是返回来的JSON数据
        function(data){
            $.each(data,function(i,data){
                areaDataArray[i]=new Array();
                //场地ID、名字和价格
                areaDataArray[i].push(data.areaname);
                areaDataArray[i].push(data.areaname);
                // console.log(data.areaname)
                // console.log("数组"+areaDataArray[i][0])
                areaDataArray[i].push(data.price);
                // console.log(data.price)
                $(data.reservation).each(function(k,reservation){
                    //日期，开始和结束时间
                    areaDataArray[i].push(reservation.preDate.substring(5,10));
                    areaDataArray[i].push(reservation.starttime);
                    areaDataArray[i].push(reservation.stoptime);
                    // console.log(reservation.preDate)
                    // console.log(reservation.starttime)
                    // console.log(reservation.stoptime)
                });
                areaDataArray[i].push((areaDataArray[i][5]-areaDataArray[i][4])*areaDataArray[i][2]);
                areaDataArray[i].push(areaDataArray[i][5]-areaDataArray[i][4]);
            });
            console.log(areaDataArray);
            //按照场地排序
            areaDataArray.sort();
            //areaDataArray[][6]
            // var yingliData = new Array();
            // var changdiData = new Array();
            //var shijianData = new Array();

            for (var i = 0;i<areaDataArray.length-1;i++) {
                if (flag2 == 1) {
                    yingliData[flag] = 0
                    shijianData[flag] = 0
                }else {console.log( "/////////下一个数组///////")}

                if (areaDataArray[i][1] == areaDataArray[i + 1][1]) {
                    yingliData[flag] += areaDataArray[i][6];
                    shijianData[flag] += areaDataArray[i][7];
                    changdiData[flag] = areaDataArray[i][1]+"【"+areaDataArray[i][2]+"/小时】";
                    flag2 = 0;
                    console.log(changdiData[flag])
                    console.log(yingliData[flag])
                    console.log(shijianData[flag])
                } else {
                    flag++;
                    flag2 = 1;
                }
            }
            // console.log(yingliData)
            // console.log(shijianData)
            // console.log(changdiData)




            var myChart = echarts.init(document.getElementById('main'));
            option = {
                title : {
                    show:true,//显示策略，默认值true,可选为：true（显示） | false（隐藏）
                    text: '场地总营业时间及总盈利统计图\n',//主标题文本，'\n'指定换行
                    //subtext: '副标题',//副标题文本，'\n'指定换行
                    sublink: '',//副标题文本超链接
                    subtarget: null,//指定窗口打开副标题超链接，支持'self' | 'blank'，不指定等同为'blank'（新窗口）
                    x:'350px',//水平安放位置，默认为'left'，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
                    y: 'top',//垂直安放位置，默认为top，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
                    textAlign: 'center',//水平对齐方式，默认根据x设置自动调整，可选为： left' | 'right' | 'center
                    padding: 5,//标题内边距，单位px，默认各方向内边距为5，接受数组分别设定上右下左边距
                    itemGap: 10,//主副标题纵向间隔，单位px，默认为10
                    textStyle: {//主标题文本样式
                        // {"fontSize": 18,"fontWeight": "bolder","color": "#333"}
                        fontFamily: 'Arial, Verdana, sans...',
                        fontSize: 18,
                        fontStyle: 'normal',
                        fontWeight: 'normal',
                        fontWeight: "bolder",
                        color:'#f00'
                    }
                    },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        crossStyle: {
                            color: '#999'
                        }
                    }
                },
                toolbox: {
                    feature: {
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                legend: {
                    data: ['盈利', '运营时间']
                },

                xAxis: [
                    {
                        type: 'category',
                        data: changdiData,
                        axisPointer: {
                            type: 'shadow'
                        }
                    }

                ],
                axisLabel: {
                    interval: 0,
                    formatter:function(value) {
                        return value.split("|").join("\n")
                    }
                } ,
                yAxis: [

                    {
                        type: 'value',
                        name: '运营时间',
                        min: 0,
                        max: 25,
                        interval: 5,
                        axisLabel: {
                            formatter: '{value} h'
                        }
                    },
                    {
                        type: 'value',
                        name: '盈利',
                        min: 0,
                        max: 5000,
                        interval: 500,
                        axisLabel: {
                            formatter: '{value} 元'
                        }
                    }
                ],
                series: [

                    {
                        name: '运营时间',
                        type: 'bar',
                        data: shijianData
                    },
                    {
                        name: '盈利',
                        type: 'bar',
                        yAxisIndex: 1,
                        data: yingliData
                    }],
                label: [{
                    normal: {
                        textStyle: {
                            fontSize: 5
                        }
                    }
                }]

            }
            myChart.setOption(option);
        })








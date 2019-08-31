var url="http://localhost:8080/Badminton/Administrator/StatisticalResultsJSON"
//二维数组存储数据
var areaDataArray = new Array();
var riqiData = new Array();
var yingliData = new Array();
var shijianData = new Array();
var changdiData = new Array();



//使用getJSON方法取得JSON数据
$.getJSON(
    url,
//处理数据 data指向的是返回来的JSON数据
    function(data){
        $.each(data,function(i,data){
            areaDataArray[i]=new Array();
            //场地ID、名字和价格
            areaDataArray[i].push(data.areaId);
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

        });
        console.log(areaDataArray);
        var tmp_Data = '';
        for (var i = 0;i<areaDataArray.length;i++) {
            riqiData.push(areaDataArray[i][3])
            changdiData.push(areaDataArray[i][1])
            if (tmp_Data != areaDataArray[i][3]) {
                $("select[name=chooseData]").append("<option value="+areaDataArray[i][3]+">"+areaDataArray[i][3]+" </option>");
            }
            tmp_Data = areaDataArray[i][3]
        }
        $("select[name=chooseData]").change(function(){
            console.log("选择的日期:"+$("select[name=chooseData]").val())
            $("select[name=chooseArea]").children().remove();
            var tmpArea_Data = null;

            for (var i = 0; i < riqiData.length; i++) {

                // if($("select[name=chooseData]").children("option:selected").val() == riqiData[i] ){
                //     console.log("对应的场地："+changdiData[i]+"上一次场地："+tmpArea_Data)
                // }
                if($("select[name=chooseData]").children("option:selected").val() == riqiData[i] && tmpArea_Data != changdiData[i]){
                    // alert(tmpArea_Data)
                    $("select[name=chooseArea]").append("<option value="+changdiData[i]+">"+changdiData[i]+" </option>");
                    tmpArea_Data = changdiData[i]
                }

            }
        })
        console.log("日期："+riqiData)
        console.log("场地："+changdiData)

        for (var i = 0;i<areaDataArray.length;i++) {
            shijianData.push((areaDataArray[i][5]-areaDataArray[i][4])*areaDataArray[i][2])

        }
        console.log(shijianData)


        for (var i = 0;i<areaDataArray.length;i++) {
            yingliData.push(areaDataArray[i][5]-areaDataArray[i][4])
            // alert(yingliData[i])
        }

        $("#showChart").click(function(){
            var areaDayData = new Array(24).fill(0);
            $("#tip").css("display","block");
            for (var i = 0; i < areaDataArray.length; i++) {

                if(areaDataArray[i][1] == $("select[name=chooseArea]").val() && areaDataArray[i][3] == $("select[name=chooseData]").val())
                {
                    for(var myVal = areaDataArray[i][4] - 1 ; myVal < areaDataArray[i][5]-1 ; myVal++)
                    {
                        areaDayData[myVal] = 1;
                    }

                }
            }
            console.log("营业："+areaDayData);

            $("#main").children().remove();
            for (var i = 0; i < 24; i++) {
                if (areaDayData[i] == 1) {
                    $("#main").append("<div class='yingyeClass'>"+(i+1)+"</div>")
                }
                if (areaDayData[i] == 0) {
                    $("#main").append("<div class='timeShowClass'>"+(i+1)+"</div>")
                }
            }

        })
        $("select[name=chooseData]").find("option").eq(1).prop("selected", true);
        var tmp1Area_Data = '';
        for (var i = 0; i < riqiData.length; i++) {
            if($("select[name=chooseData]").children("option:selected").val() == riqiData[i] && tmp1Area_Data != changdiData[i]){
                $("select[name=chooseArea]").append("<option value="+changdiData[i]+">"+changdiData[i]+" </option>");
                tmp1Area_Data = changdiData[i]
            }

        }
        document.getElementById('showChart').click();
    })

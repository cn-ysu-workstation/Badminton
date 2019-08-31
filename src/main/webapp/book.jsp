<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/22
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/fore/foreHeader.jsp"%>
<style>
    .wz_banner form td{
        width: 70px;
    }
    .wz_banner form th{
        width: 100px;
    }
    .wz_banner a {
        cursor: pointer;
        text-decoration: underline;
        color: black;
    }
    .wz_banner form td,th {
        text-align: center;
        padding: 0 0 0 0;
        border-color: black;
        border-style: solid;
        border-width: 2px;
    }
    /*.空闲{*/
    /*    background: #00AAEE;*/
    /*}*/
    /*.占用{*/
    /*    background: yellow;*/
    /*}*/
</style>
<script>

    $(function () {
        var myDate = new Date;
        var year = myDate.getFullYear(); //获取当前年
        var mon = myDate.getMonth() + 1; //获取当前月
        mon = (mon<10 ? "0"+mon:mon);
        var date = myDate.getDate(); //获取当前日
        // $("#calendar").attr("value",year + "-" + mon + "-" + date);
        document.getElementById("list0").style.display = "";

        //“占用”项初始化
        var tmp1 = document.getElementsByClassName("占用");//3 占用

        // console.info("tmp1.length")
        // console.info(tmp1.length)
        for (var i = 0; i < tmp1.length; i++)
            tmp1[i].style.backgroundColor = 'yellow';
        // //“维护”项初始化
        var tmp2 = document.getElementsByClassName("待审核");//0 已付款
        for (var i = 0; i < tmp2.length; i++)
            tmp2[i].style.backgroundColor = 'gray';
        //“空闲”项初始化
        var tmp3 = document.getElementsByClassName("free");//-1 空闲/可预约
        // console.info("tmp3.length")
        // console.info(tmp3.length)
        for (var i = 0; i < tmp3.length; i++) {
            tmp3[i].style.backgroundColor = 'white';
            tmp3[i].style.cursor = "pointer";
        }
        //"未付款"项初始化
        var tmp4 = document.getElementsByClassName("未付款");//1 未付款
        for (var i = 0; i < tmp4.length; i++) {
            tmp4[i].style.backgroundColor = 'red';
            tmp4[i].innerText = '未付款';
            tmp4[i].style.color = 'red';
        }
        //“审核中”项初始化
        var tmp5 = document.getElementsByClassName("审核通过");//2 审核通过
        for (var i = 0; i < tmp5.length; i++) {
            tmp5[i].style.backgroundColor = 'dodgerblue';
            // tmp5[i].innerText = '审核通过';
            // tmp5[i].style.color = 'red';
        }


    })

</script>
<!DOCTYPE html>
</head>
<%@ include file="include/fore/foreNavigator.jsp"%>
<title>场馆预约</title>


        <div class="sub-content" style="margin: 20px 0; font-size: small">
            <div class="position-bar">
                当前位置：场地预约
            </div>



            <div class="wz_banner" style="margin-top: 20px">
                <table style="margin-top:20px; border: none">
                    <tbody>
                        <tr>
                            日期选择:<input  id="calendar" type="date" value="${curDate}"/>
                        </tr>
                    <tr>
                        <form id="form1" action="" hidden method="post"></form>
                        <input id="dateSelect"type="submit"  form="form1" value="查询"/>
                    </tr>
                    </tbody>
                </table>

                <script>

                    <%--document.getElementById("${place.name}").style.backgroundColor="#49afcd";--%>
                    <%--document.getElementById("${place.name}").style.color="white";--%>
                    <%--document.getElementById("${placeStadium.name}").style.backgroundColor="#49afcd";--%>
                    <%--document.getElementById("${placeStadium.name}").style.color="white";--%>
                    // document.getElementById("0").style.backgroundColor="#49afcd";
                    // document.getElementById("0").style.color="white";

                    function changeTable(x) {
                        //表格初始化
                        document.getElementById("list0").style.display = "none";
                        //日期初始化
                        document.getElementById("0").style.color = "";
                        document.getElementById("0").style.backgroundColor = "";
                        document.getElementById("1").style.color = "";
                        document.getElementById("1").style.backgroundColor = "";
                        document.getElementById("2").style.color = "";
                        document.getElementById("2").style.backgroundColor = "";
                        //显示项修改
                        var index = x.id;
                        document.getElementById(index).style.backgroundColor="#49afcd";
                        document.getElementById(index).style.color = "white";
                        document.getElementById("list"+index).style.display = "";
                    }

                    function submitCheck() {
                        var total = Number(document.getElementById('total').innerText);
                        console.log(total);
                        if (total == 0) {
                            window.alert("请选择预约项！");
                            return false;
                        }
                        return true;
                    }

                </script>

                <div style="height: 3px;background-color: #3C3C3C; margin: 10px 0"></div>

                <div style="float: right;">总费用：<span id="total">0</span>&nbsp;元</div>

                <div style="margin: 20px 0;">
                    注：
                    <span style="border:thin solid black; background:white">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;为可预约场地
&nbsp;                    <span style="border:thin solid black; background:grey">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;为审核中场地&nbsp;&nbsp;
                    <span style="border:thin solid black; background:red">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;为未付款场地&nbsp;&nbsp;
                    <span style="border:thin solid black; background:dodgerblue">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;为审核通过场地
                    <span style="border:thin solid black; background:yellow">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;为已被占用场地&nbsp;

                </div>

                <div>
                    <form id="bookForm" onsubmit="return submitCheck()" action="${pageContext.request.contextPath}/user/reserveArea?" method="post">
                        <table style="border-style: solid; border-bottom:none; border-width: 3px; border-collapse: collapse">
                            <tbody>
                            <tr style="text-align: center;">
                                <th >&nbsp;&nbsp;&nbsp;</th>
                                <td>08:00<br>-<br>09:00</td>
                                <td>09:00<br>-<br>10.00</td>
                                <td>10:00<br>-<br>11:00</td>
                                <td>11:00<br>-<br>12:00</td>
                                <td>12:00<br>-<br>13:00</td>
                                <td>13:00<br>-<br>14:00</td>
                                <td>14:00<br>-<br>15:00</td>
                                <td>15:00<br>-<br>16:00</td>
                                <td>16:00<br>-<br>17:00</td>
                                <td>17:00<br>-<br>18:00</td>
                                <td>18:00<br>-<br>19:00</td>
                                <td>19:00<br>-<br>20:00</td>
                                <td>20:00<br>-<br>21:00</td>
                            </tr>
                            </tbody>
                        </table>


                            <table id="list0" class="resTable" style="display:none; border-style: solid; border-top: none; border-width: 3px; border-collapse: collapse">
                                <c:forEach items="${areaCustomList}" var="list" varStatus="status">
<%--                            <c:forEach items="${list}" var="plan">--%>
                                <tr style="text-align: center; height: 40px" class="resTableRow">
                                    <th style="text-align: center;">
                                            ${list.areaname}

                                    </th>
                                <c:forEach items="${list.time_status}" var="item">

<%--                                    <c:set var="case"  value="${item}"/>--%>
                                        <c:if test="${item eq -1}">
                                            <c:set var="detail"  value="free"/>
                                        </c:if>
                                    <c:if test="${item eq 0}">
                                        <c:set var="detail"  value="待审核"/>
                                    </c:if>
                                        <c:if test="${item eq 1}">
                                            <c:set var="detail"  value="未付款"/>
                                        </c:if>
                                    <c:if test="${item eq 2}">
                                        <c:set var="detail"  value="审核通过"/>
                                    </c:if>
                                        <c:if test="${item eq 3}">
                                            <c:set var="detail"  value="占用"/>
                                        </c:if>

                                    <td class="${detail}" id="${list.areaId} " style="background: white" <%--onclick="clickTr(this)"--%>>
                                        <input type="hidden" <%--id="${item.id}" --%> value="${list.price}" name="">
<%--                                            ${detail}--%>
                                    </td>
                                </c:forEach>
                                </tr>
<%--                            </c:forEach>--%>
                                </c:forEach>
                            </table>

                        <div class="submitTR text-center" style="margin: 15px">
                            <td colspan="2" align="center">
                                <button type="submit" class="btn btn-success">提交</button>
                            </td>
                        </div>

                    </form>
                </div>
            </div>
        </div>

<script>
    $("#calendar").change(function(){
        $("#calendar").attr("value",$(this).val()); //赋值
        $("#form1").attr("action","${pageContext.request.contextPath}/user/searchAreaReservation?pDate="+$("#calendar").val());
        // alert( $("#form1").attr("action"))
        // alert($("#calendar").attr("value"));
    });
    $(".btn.btn-success").click(function(){
        var $total = Number(document.getElementById("total").innerText);
        // var $date=$("#calendar").attr("value");
        var $date=$("#calendar").val()
        // alert($("#calendar").attr("value"));
        // alert($("#calendar").val())
        // console.info($date)
        document.getElementById("bookForm").action +="preDate="+$date+"&"+"price="+$total+"&";
        // var $tableRow=$("#list0").find("tr");
        var $tableRow=$(".resTableRow");
        $tableRow.each(function () {
                var $tableData=$(this).children("td");
                $tableData.each(function (i) {
                    var $areaId=parseInt($(this).attr("id"))
                    // console.info($areaId);
                    // // console.info(index+1)
                    // console.info(i+8)

                    var $s = $(this).css('background-color');
                    var $color=$s.toString();
                    if ($color == 'rgb(127, 255, 0)') {
                        document.getElementById("bookForm").action += "areaId=" + $areaId + "&starttime=" + (i + 8) + "&";
                        console.info(document.getElementById("bookForm").action)
                    }
                })

        })
        console.info("end");
    })
    <%--$.ajax({--%>
        <%--//请求方式--%>
        <%--type:'get',--%>
        <%--//发送请求的地址--%>
        <%--url:"${pageContext.request.contextPath}/user/searchAreaReservation?pDate="+$("#calendar").val()--%>
        <%--,--%>
        <%--success:function(data){--%>
            <%--//请求成功函数内容--%>
            <%--alert(data)--%>
        <%--},--%>
        <%--error:function(jqXHR){--%>
            <%--//请求失败函数内容--%>
            <%--alert("sta"+jqXHR)--%>
        <%--}--%>
    <%--});--%>
    <%--$("#dateSelect").click(function(){--%>
        <%--// $url=$("form1").attr("value");--%>

        <%--$("#form1").attr("action","${pageContext.request.contextPath}/user/searchAreaReservation?pDate="+$("#calendar").val());--%>

        <%--alert( $("#form1").attr("action"))--%>
        <%--var form = document.getElementById('test_form');--%>
<%--//再次修改input内容--%>

        <%--form.submit();--%>

    <%--})--%>
    //空闲格的点击事件
    $(".free").click(function(){
        var s = this.style.backgroundColor;
        var total = Number(document.getElementById("total").innerText);
        // var price=this.firstElementChild;
        var price=$(this).children(":first").attr("value");
        if (s.toString() == 'white') {

            this.style.backgroundColor = '#7FFF00';
            total +=parseInt(price);
<%--            ${list.price};--%>

            // var input = id.getElementsByTagName("input");
            // input[0].name = input[0].value;
        } else {
            this.style.backgroundColor = 'white';
            total -=parseInt(price);

            // var input = id.getElementsByTagName("input");
            // input[0].name = "";
        }

        document.getElementById("total").innerHTML = total.toString();
        // console.info(document.getElementById("bookForm").action);
        // document.getElementById("bookForm").action = "?"+total;


    });
</script>
        <c:if test="${not empty flag}">
            <script>
                alert("预定成功，请尽快前往个人中心支付费用！");
            </script>
        </c:if>

    </div>
</div>

<%@include file="include/fore/foreFooter.jsp"%>
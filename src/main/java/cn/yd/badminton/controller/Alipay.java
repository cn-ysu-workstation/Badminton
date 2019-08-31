package cn.yd.badminton.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

/**
 * Servlet implementation class Alipay
 */
public class Alipay extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alipay() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {

		AlipayClient alipayClient = new
				DefaultAlipayClient ("https://openapi.alipaydev.com/gateway.do","2016100200643462","MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDFKcM9+sAGZR0VesklhNla13dnSwzDnDWwhdMORp418OuV9LHYznLwChdYrnpia45O9lGAYgiy1K+6Er+S4/WWXgLJy73MY+6XFDC2N+TCDPqGMunA/AD62j2wcX/pJf6a+zexK/zSzkbUtOZ3MZZ/DRaAanMjnDXJXAdMGeJ5othPQVNZ4pkXhxBK6pbGqmVHRa+WpC6uoM7cxCPzvg1494wO16TskW/idFaiShcwC1Kpuw7qNF/Pc+78WLmyUwZdb22J1msgP6T58gTHk3lpHyb2MbUQlAVuxKzvrZiVf4cd0P4uV4nN2vm0GVnchb8QY967q/kQQYT7D7AEuSnVAgMBAAECggEBALIML8uV2LktsKEIHAOsv9ggQizegm1XcMizYVBAB3mw0h6+NakTbopEoqasEcs1U/MMz7b/UNml5fdEHQqan9ollaEEQ6cDC6AVVJQJT6TJsadk7OEg8gWW9iSTqq4yaIUunjF6BrucGizWHFXBSyX6/LoE52teEth/KfvYWEP8bEllBavW0k1kLNny50rwu64LAacsG0CP7/UPrV54gFDDS6quBm95vW8JOWVQ8Nb8kaDkFFSe1wtPsHEcXnTo/JGTC5Wgndfc4fXTU9LI6fJQZmMDmo98on9j8XgB9DdKcekvSqHlCXAcCtp7nPD3eFidUUWEKuhEZTiR6OLoGJUCgYEA49myHZB2zDPb4USDgr9PyXp1Vrw4DKTNsCXHHs+FV8e8SPpNBEJf9hGfj8VMEBpO7NND/PVVgeQauxj9MIVBYUc7zZlca6kM1jU24Nsc/jshreF6SzFtRh/s2tkMnO1PikjxYCLFQtNoOowEABYTeAszdDOiaRaVccinOpNiBf8CgYEA3YWCwarl1Ar7UFKbcmMmp+ZOR1NDMIw6Ck6JQeXTZs0uP7XycNFLrjZZb4yigbTVM8fCa6lS5bad2tWPUJMmfxEgB32SQyZnA4LpdcNOYmOLIL8qWrbqAfyJ4P6YGyMsZYMIbPDI2xbjAh9q0nFohrfbrKlP4Z04dG50ej/N2CsCgYA7qcCbPz3sYNP929v3+7Kf1oItUSH4JZt6uZm3dq26+6FRFsHeEKdiHuFCW258dPcfyn5uGavnVFyvi26ZKvugxm9hefwacOzclpilLpsb803xYy6LzAiKKUfzUoyb9wQx+MHD47b1tbgARLOzdhRpBb3WesLXc8N0RQ+NJhSv7wKBgGrU1oh72Lb4TNch36G8u4nBggLX3tFs7xjFY2CKa/dqAGHtZ2yNI0hzIZKwajbPdPqx3ct6L2ZlOZ+t2p3rOWeSZLX4Ey+bN5bz7Y9Dj2vXweMbDlwNVrF6jywY3FZKEkEqfke7n8I5OWVurV+sHdLKnICabtHJts4/7qB+YNFdAoGBAIQ1FqN50Npoi0CJhNTUczefCAdkzI8rV/pNzQR6gNCVV6txMy9fyvlZyCTi7urn+4/DEIkSIge34oGy1qInF+pT+9g3IPj2roi43HUYs/QJbvbEfGh7+YxQNDb+OrqebhhE6NZ+UZ6QPlIpgnFWL8XmSMnAorL2wn/D25E8aaxB","json","utf-8",
				"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAltniyFzyIRyI0mkh6fl54S/ZyNE+yKS7TxF38zM+D3EH9AeZRnF1byd0372bUCxNB2L39rH4735B/CdkNrISczAynVVrMc0D30pdxcOyxfAUsepIRtRG/r0Xxob9vIosQqldf03cS1o4CRMN/14sjNF7jrX26lcrPnjI/KPQm1LhDVeIyBfTwlE+wjTU5HW/tTGN322S/9IdNHFSatwxaBHn2+ynN60t6n5qLDdhCviYjO5NmOzGpSPB+76vDSYrKr6NO8jvcU2v0bDyxM8ncY5LUVjwPqCNoXjrLL7vGXeoYoU68S5kK74Ro+ffFZtWzJzg/ByujKPYHJFNKicQIwIDAQAB","RSA2" );
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
	    alipayRequest.setReturnUrl("http://baidu.com");
	    alipayRequest.setNotifyUrl("http://localhost:8080/zf/AliNotify");
	    long sno=new Date().getTime();
	    alipayRequest.setBizContent("{" +
	        "    \"out_trade_no\":\""+sno+"\"," +
	        "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
	        "    \"total_amount\":88.89," +
	        "    \"subject\":\"Iphone6 16G\"," +
	        "    \"body\":\"Iphone6 16G\"," +
	        "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101112\"," +
	        "    \"extend_params\":{" +
	        "    \"sys_service_provider_id\":\"2088511833207847\"" +
	        "    }"+
	        "  }");
	    String form="";
	    try {
	        form = alipayClient.pageExecute(alipayRequest).getBody();
	    } catch (AlipayApiException e) {
	        e.printStackTrace();
	    }
	    httpResponse.setContentType("text/html;charset=" + "utf-8");
	    httpResponse.getWriter().write(form);
	    httpResponse.getWriter().flush();
	    httpResponse.getWriter().close();	
		
	}

}

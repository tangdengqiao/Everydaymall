package com.everydaymall.utils;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
/**
 * <p>
 * Title: HttpUtil.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2011
 * </p>
 * <p>
 * Company: HaiStand
 * </p>
 * 
 * @author NingLei
 * @date 2011-12-5
 * @version 1.0
 */

public class HttpUtil {

	private static Logger log = Logger.getLogger("sys");

	public static String post(String url, NameValuePair[] params) {
		String result;
		PostMethod method = new PostMethod(url);
		try {
			method.setRequestBody(params);
			method.getParams().setContentCharset("UTF8");
			HttpClient httpClient = new HttpClient();
			httpClient.executeMethod(method);
			result = method.getResponseBodyAsString();
			return result;
		} catch (HttpException e) {
			log.error("http util post error", e);
		} catch (IOException e) {
			log.error("http util post  io error", e);
		} finally {
			method.releaseConnection();
		}
		return null;
	}

	public static String post(String url) {
		String result;
		PostMethod method = new PostMethod(url);
		try {
			HttpClient httpClient = new HttpClient();
			httpClient.executeMethod(method);
			result = method.getResponseBodyAsString();
			return result;
		} catch (HttpException e) {
			log.error("http util post error", e);
		} catch (IOException e) {
			log.error("http util post  io error", e);
		} finally {
			method.releaseConnection();
		}
		return null;
	}
	/** 
     * 执行一个HTTP GET请求，返回请求响应的HTML 
     * 
     * @param url                 请求的URL地址 
     * @param queryString 请求的查询参数,可以为null 
     * @return 返回请求响应的HTML 
     */ 
    public static String doGet(String url, String queryString) { 
            String response = null; 
            HttpClient client = new HttpClient(); 
            HttpMethod method = new GetMethod(url); 
            try {

                    if (!StringUtils.getInstance().isEmpty(queryString))
                            method.setQueryString(URIUtil.encodeQuery(queryString)); 
                    client.executeMethod(method); 
                    if (method.getStatusCode() == HttpStatus.SC_OK) { 
                            response = method.getResponseBodyAsString(); 
                    } 
            } catch (URIException e) { 
                    log.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e); 
            } catch (IOException e) { 
                    log.error("执行HTTP Get请求" + url + "时，发生异常！", e); 
            } finally { 
                    method.releaseConnection(); 
            } 
            return response; 
    } 
}

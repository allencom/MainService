package com.gateway.gateway.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class TestFilter extends ZuulFilter {

 @Override
 public String filterType() {
  return "pre";
 }

 @Override
 public int filterOrder() {
  return 0;
 }

 @Override
 public boolean shouldFilter() {
  return true;
 }


 //拦截请求并做校验
 @Override
 public Object run() throws ZuulException {

  RequestContext ctx = RequestContext.getCurrentContext();
  HttpServletRequest request = ctx.getRequest();

  return null;
 }
}

package org.great.controller;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.great.bean.AdminBean;
import org.great.bean.LogBean;
import org.great.biz.ILogBiz;
import org.great.core.SystemLog;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class LogAopAction {
	// 注入service,用来将日志信息保存在数据库
	@Resource
	private ILogBiz logBizImp;

	// 常见日志实体对象
	LogBean log = new LogBean();

	// 配置接入点
	@Pointcut("execution(* org.great.controller..*.*(..))")
	private void controllerAspect() {
	}// 定义一个切入点

	/**
	 * 
	 * @Title: doBefore
	 * @Description: TODO 方法开始执行
	 * @author: wjx(wangj)
	 * @date 2018年10月6日下午10:48:45
	 */
	@Before("controllerAspect()")
	public void doBefore() {
		System.out.println("方法开始执行");
	}

	/***
	 * 
	 * @Title: after
	 * @Description: TODO void
	 * @author: wjx(wangj)
	 * @date 2018年10月6日下午10:50:31
	 */
	@After("controllerAspect()")
	public void after() {
		System.out.println("方法结束执行");
	}

	/**
	 * 
	 * @Title: doAfter
	 * @Description: TODO void
	 * @author: wjx(wangj)
	 * @date 2018年10月6日下午10:56:04
	 */
	@AfterReturning("controllerAspect()")
	public void doAfter() {
		System.out.println("进入after");
		/*
		 * if(log.getState()==1||log.getState()==-1){
		 * System.out.println(log.getState()); System.out.println(">>>>>>>>>>存入到数据库");
		 * }else { System.out.println(log); System.out.println(">>>>>>>>不存入到数据库"); }
		 */
	}

	/**
	 * 方法有异常时的操作
	 */
	@AfterThrowing("controllerAspect()")
	public void doAfterThrow() {
		System.out.println("例外通知-----------------------------------");
	}

	@Around("controllerAspect()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("进入拦截日志");

		// 获取登录用户账户
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		// 读取session中的用户
		AdminBean admin = (AdminBean) session.getAttribute("adminBean");
		if (null == admin) {
			log.setName("---");
		} else {
			String adminName = admin.getAdminName();
			log.setName(adminName);
		}

		// 获取请求ip
		String ip = getHostIp();
		log.setIp(ip);

		// 获取系统时间
		String time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
		log.setTime(time);
		// 方法通知前获取时间,为什么要记录这个时间呢？当然是用来计算模块执行时间的
		long start = System.currentTimeMillis();
		// 拦截的实体类，就是当前正在执行的controller
		Object target = pjp.getTarget();
		// 拦截的方法名称。当前正在执行的方法
		String methodName = pjp.getSignature().getName();
		// 拦截的方法参数
		Object[] args = pjp.getArgs();
		// 拦截的放参数类型
		Signature sig = pjp.getSignature();
		MethodSignature msig = null;
		System.out.println("进入拦截日志111111111111111111111111111111111222222");
		if (!(sig instanceof MethodSignature)) {
			throw new IllegalArgumentException("该注解只能用于方法");
		}
		msig = (MethodSignature) sig;
		Class[] parameterTypes = msig.getMethod().getParameterTypes();

		Object object = null;
		// 获得被拦截的方法
		Method method = null;
		try {
			method = target.getClass().getMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (null != method) {
			// 判断是否包含自定义的注解，说明一下这里的SystemLog就是我自己自定义的注解
			if (method.isAnnotationPresent(SystemLog.class)) {
				SystemLog systemlog = method.getAnnotation(SystemLog.class);
				log.setModule(systemlog.module());
				log.setMethod(systemlog.methods());
				try {
					object = pjp.proceed();
					long end = System.currentTimeMillis();
					// 将计算好的时间保存在实体中
					log.setResponseTime("" + (end - start));
					log.setCommite("执行成功！");
					// 保存进数据库
					System.out.println("log:" + log.toString());
					logBizImp.saveLog(log);
					log.setState((short) 1);
					System.out.println("打印成功：");
					System.out.println("打印成功：" + log.getState());
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					long end = System.currentTimeMillis();
					log.setResponseTime("" + (end - start));
					log.setCommite("执行失败");
					log.setState((short) -1);
					logBizImp.saveLog(log);
				}
			} else {// 没有包含注解
				object = pjp.proceed();
			}
		} else { // 不需要拦截直接执行
			object = pjp.proceed();
		}
		return object;
	}

	/**
	 * 获取ip地址
	 * 
	 * @param request
	 * @return
	 */
	private String getIp(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
			System.out.println("进入null");
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}

	public static String getHostIp() {
		String sIP = "";
		InetAddress ip = null;
		try {
			boolean bFindIP = false;
			Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				if (bFindIP)
					break;
				NetworkInterface ni = netInterfaces.nextElement();
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					ip = ips.nextElement();
					if (!ip.isLoopbackAddress() && ip.getHostAddress().matches("(\\d{1,3}\\.){3}\\d{1,3}")) {
						bFindIP = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != ip)
			sIP = ip.getHostAddress();
		return sIP;
	}

}

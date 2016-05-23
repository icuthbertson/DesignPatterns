package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SecurityProxy implements InvocationHandler {

	private Object obj;
	
	private SecurityProxy(Object obj) {
		this.obj = obj;
	}
	
	public static Object newInstance(Object obj) {
		return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new SecurityProxy(obj));
	}
	
	@Override
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {

		Object result = null;
		
		try {
			if(m.getName().contains("post")) {
				throw new IllegalAccessException("Posts are currrently not allowed");
			}
			else {
				result = m.invoke(obj, args);
			}
		} catch(InvocationTargetException e) {
			e.printStackTrace();
		} catch(Exception e) {
			throw new RuntimeException("Unexpected invocation exception: " + e.getMessage());
		}
		
		return result;
		
	}

}

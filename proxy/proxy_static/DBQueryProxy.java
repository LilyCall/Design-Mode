package design_mode.proxy.proxy_static;

//代理类
public class DBQueryProxy implements IDBQuery {
	private DBQuery real = null;

	@Override
	public String request() {
		//在真正需要的时候，才创建真实对象，创建过程可能很慢
		if (real == null) {
			real = new DBQuery();
		}
		//在多线程环境下，返回一个虚假类，类似于Future模式
		return real.request();
	}

}

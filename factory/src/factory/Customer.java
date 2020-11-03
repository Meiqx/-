package factory;


public class Customer {
	public static void main(String[] args) {
		Factory f = new XiaoMiFactory();
		f.createPhone().showPhone();
		Factory f1 = new HuaWeiFactory();
		f1.createPhone().showPhone();
		Factory f2 = new IPhoneFactory();
		f2.createPhone().showPhone();
	}
}

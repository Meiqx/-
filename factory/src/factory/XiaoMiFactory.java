package factory;

public class XiaoMiFactory extends Factory{

	@Override
	public Phone createPhone() {
		return new XiaoMi();
	}
	
}

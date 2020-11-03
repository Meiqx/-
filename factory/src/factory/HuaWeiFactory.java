package factory;

public class HuaWeiFactory extends Factory{
	@Override
	public Phone createPhone() {
		return new HuaWei();
	}
}

package factory;

public class IPhoneFactory extends Factory{

	@Override
	public Phone createPhone() {
		// TODO Auto-generated method stub
		return new IPhone();
	}
	
}

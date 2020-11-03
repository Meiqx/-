package day03;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class ExampleBean implements Serializable {
	@Override
	public String toString() {
		return "Hello world";
	}
	
}

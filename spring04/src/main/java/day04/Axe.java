package day04;

import java.io.Serializable;

import org.springframework.stereotype.Component;


@Component   //Ĭ������axe
public class Axe implements Tool,Serializable{
	private String name = "�����";

	@Override
	public String toString() {
		return name;
	}
	
}

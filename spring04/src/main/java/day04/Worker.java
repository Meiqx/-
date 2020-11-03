package day04;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("qiang")
@Lazy()
public class Worker implements Serializable{
	
	private String name = "��ͷǿ";
	//Spring �������ڼ�ɨ��Spring�����е��������
	//����������������Tool���ͼ��ݾ�ע�����
	//����������������ͼ��ݵ����,��ƥ�������
	//id�����Ƿ��������tool һ��,���һ�¾�ע�����,û��ƥ��ɹ��ͱ���
	
	//@Autowired	
	private Tool tool;
	
	@Autowired
	//@Resource
	private void setTool(Tool tool) {
		System.out.println("setTool");
		this.tool = tool;
	}
	
	public void worker() {
		System.out.println(name+"ʹ��"+tool+"����");
	}
}

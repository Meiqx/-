package day03;

public class Worker {
	private String name = "���";
	private Tool tool;
	
	
	public void work() {
		System.out.println(name+"ʹ��"+tool+"����");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Tool getTool() {
		return tool;
	}
	public void setTool(Tool tool) {
		this.tool = tool;
	}
	@Override
	public String toString() {
		return "Worker [name=" + name + ", tool=" + tool + "]";
	}
	
	
}

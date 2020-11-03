package day03;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DemoBean {
	private List<String> names;
	private Set<Integer> times;
	private double[] weight;
	private List<Date> date;
	private Map<String,String> table;
	
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	public Set<Integer> getTimes() {
		return times;
	}
	public void setTimes(Set<Integer> times) {
		this.times = times;
	}
	public double[] getWeight() {
		return weight;
	}
	public void setWeight(double[] weight) {
		this.weight = weight;
	}
	public List<Date> getDate() {
		return date;
	}
	public void setDate(List<Date> date) {
		this.date = date;
	}
	public Map<String, String> getTable() {
		return table;
	}
	public void setTable(Map<String, String> table) {
		this.table = table;
	}
	@Override
	public String toString() {
		return "DemoBean [names=" + names + ", times=" + times + ", weight=" + Arrays.toString(weight) + ", date="
				+ date + ", table=" + table + "]";
	}
	
	
	
}

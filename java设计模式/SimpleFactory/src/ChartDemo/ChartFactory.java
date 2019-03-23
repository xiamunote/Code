package ChartDemo;

public class ChartFactory {
	public static Chart getChart(String type){
		Chart chart =null;
		if(type.equalsIgnoreCase("histogram")){
			chart=new HistogramChart();	
		}
		else if(type.equalsIgnoreCase("pie")){
			chart= new PieChart();
		}
		else if(type.equalsIgnoreCase("line")){
			chart = new LineChart();
		}
	return chart;	
	}

}

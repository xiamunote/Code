package ChartDemo;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Chart chart = ChartFactory.getChart("PIE");
		String type = XMLUtil.getChartType();
		
		Chart chart =ChartFactory.getChart(type);
		chart.display();
	}

}

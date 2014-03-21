package edlogiq.neurongym;

public class Ani_calculator {

	double[] mean_of_avg = new double[18];
	double[] sig_of_avg = new double[18];
	double ANI;
	public Ani_calculator(double score ,int game_no )
	{
		mean_of_avg[1] = 300;
		sig_of_avg[1] = 30.0;
		mean_of_avg[2] = 78;
		sig_of_avg[2] = 7.8;
		mean_of_avg[3] = 51;
		sig_of_avg[3] = 5.1;
		mean_of_avg[4] = 60;
		sig_of_avg[4] = 6.0;
		mean_of_avg[5] = 70;
		sig_of_avg[5] = 7.0;
		mean_of_avg[6] = 300;
		sig_of_avg[6] = 30.0;
		ANI = 500+(50*((score - mean_of_avg[game_no])/sig_of_avg[game_no]));
		
	}
	public double get_ani()
	{
		return ANI;
	}
}

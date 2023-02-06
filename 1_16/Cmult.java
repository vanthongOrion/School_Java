package lesson1;

public class Cmult {
	public void CMULT(double x[], double y[], double z[]) {
		z[0] = x[0]*y[0]-x[1]*y[1];
		z[1] = x[0]*y[1]+x[1]*y[0];
	}

	public void CXN (int n, double x[], double z[]){
		double W0, W1;
		W0 = x[0];
		W1 = x[1];
		for (int k=1 ; k<n ;k++ ){
			z[0] = x[0] * W0 - x[1] * W1;
			z[1] = x[0] * W1 + x[1] * W0;
			W0 = z[0];
			W1 = z[1];
		}
	}

	public void CLOG(double x[], double y[]){
		y[0] = Math.log(Math.sqrt(x[0]*x[0] + x[1]*x[1]));
		y[1] = Math.atan2(x[1],x[0]);
	}

	public void CEXP(double x[] , double y[]){
		y[0] = Math.exp(x[0])*Math.cos(x[1]);
		y[1] = Math.exp(x[0])*Math.sin(x[1]);
	}

	public void CPOWER(double x[], double y[], double z[]){
		double V[] = new double[2];
		double W[] = new double[2];
		if(x[0] == 0.0 && x[1] == 0.0){
			z[0] = z[1] = 0.0;
		}else{
			CLOG(x,V);
			CMULT(y,V,W);
			CEXP(W,z);
		}
	}
}
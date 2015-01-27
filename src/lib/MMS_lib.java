  
package lib;

public class MMS_lib {

	private double lambda,mu,rho,alpha;
	private int s,r;
	
	public MMS_lib(double lambda, double mu, int s) {
		this.lambda = lambda;
		this.mu = mu;
		this.alpha = lambda/mu;
		this.rho = this.alpha/s;
		this.s = s;
		
	}
	public int getFactorial(int s){
		int f = 1;//ŠKæ‚Ì’l
		for(int i = s;i >= 0;i--){
			if(i == 0){
				f *=1;
			}else{
				f *=i;
			}
		}
		return f;
	}
	public double getP0(){
		double p0=0,p01=0,p02=0;
		for (int k = 0;k < this.s;k++){
			p01 += Math.pow(this.alpha, k)/getFactorial(k);
		}
		p02 += Math.pow(this.alpha, this.s)/getFactorial(this.s)/(1-this.rho);
		p0=1/(p01+p02);
		return p0;
			
		}
	public double getLq(){
		double lq;
		lq = Math.pow(this.s, this.s)*Math.pow(this.rho, this.s+1)*getP0()/getFactorial(this.s)/Math.pow(1-this.rho,2);
		return lq;
	}
	public double getL(){
		double l;
		l = getLq()+this.alpha;
		return l;
	}
	
	public double getWq(){
		double wq;
		wq = getLq()/this.lambda;
		return wq;
	}
	public double getW(){
		double w;
		w = getWq()+1/this.mu;
		return w;
	}
	public double getRho(){
		double rho;
		this.rho = this.alpha/s;
		return this.rho;
	}
	
		
//	public int getConbination(int s,int r){
	//	int c = 1;
	//	c = getFactorial(s)/getFactorial(r)/getFactorial(s-r);
	//	return(c);
				
	//}
	
}

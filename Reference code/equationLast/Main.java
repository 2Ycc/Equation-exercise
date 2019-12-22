package equationLast;

import java.io.IOException;

public class Main
{
	public static void main(String args[]) throws IOException {
		BinaryEquation[] res = new BinaryEquation[60];
		Exercise e = new Exercise();
		ToFile tofile = new ToFile(); 
		res = (BinaryEquation[]) e.mkEquation();
//		System.out.println(Object instanceof res);
		tofile.EquationOutputStream(res);
		tofile.EquationInputStream();
		for(int i=0; i<res.length; i++) {
	    	System.out.printf("%2d:%3d %c %2d=%3d\t\t",i+1,res[i].getOperand1(),res[i].getOperator(),res[i].getOperand2(),res[i].getValue());
	    	if((i+1)%5==0)
	    		System.out.println();
		}
	}
}

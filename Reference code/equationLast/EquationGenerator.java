package equationLast;

import java.util.Random;

public class EquationGenerator {//产生随机数（重点在于产生随机数），根据随机数构造加法或减法算式
	
	public int getOperand() { // 产生一个随机操作数
		int m;
		Random random = new Random();
		m = random.nextInt(101);
		return m;
	}

}

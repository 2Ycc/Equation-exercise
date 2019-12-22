package equationLast;
public  class AddEquation implements Equation  {//根据操作数计算加法结果
	
	private int m;			// 定义操作数1
	private int n;			// 定义操作数2
	private int result;		// 定义运算结果
	private char o ;			// 定义操作符
	
	// 有参构造方法创建对象
	public AddEquation(int operand1, int operand2 ) {
        this.m = operand1;
        this.n = operand2;
        this.result = m + n;
        this.o = '+';
        }
	
	@Override
	public int getOperand1() { // 实现接口方法，返回操作数1
		return m;
	}
	
	@Override
	public int getOperand2() { // 实现接口方法，返回操作数2
		return n;
	}
	
	@Override
	public int getResult() { // 实现接口方法，返回运算结果
		return result;
	}
	
	@Override
	public char getOperator() { // 实现接口方法，返回操作符
		return o;
	}
	
}

      





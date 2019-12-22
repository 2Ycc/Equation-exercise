package equationLast;

public class BinaryEquation implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // 序列化的版本号
	private int operand1;	   // 运算数1
	private int operand2;	   // 运算数2
	private char operator;	   // 操作符
	private int value;	   	   // 结果
	public static int equCount = 0;// 当前已有算式的数量
	public static final short UPPER=100;// 定义运算数的最大取值
	public static void equCountAdd() { // 进行算式数加一操作
		equCount++;					   // 当前算式数加一
	}
	public boolean equals (BinaryEquation equation) {		//检测算式是否重复
		return operand1==equation.getOperand1()&&
				operand2==equation.getOperand2()&&
				operator==equation.getOperator();
	}
	
	public static int getEquCount() {
		return equCount;			   // 返回当前算式数量
	}
	public int getOperand1() {
		return operand1;			   // 返回运算数1
	}
	public int getOperand2() {
		return operand2;			   // 返回运算数2
	}
	public char getOperator() {
		return operator;			   // 返回操作符
	}
	public int getValue() {
		 return value;			  	   // 返回结果
	}
	public void setOperand1(int x) {
		this.operand1 = x;			   // 运算数1赋值
	}
	public void setOperand2(int y) {
		this.operand2 = y;			   // 运算数2赋值
	}
	public void setOperator(char op) {
		this.operator = op;			   // 操作符赋值
	}
	public void setValue(int value) {
		this.value = value;			   // 结果计算
	}
	public  String toString() {		   // 返回算术式的字符串
		return ""+operand1+operator+operand2+"="+value;
	}

}


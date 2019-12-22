package construction_6_gui;
public class BinaryEquation implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // 序列化的版本号
	private int operand1;	   // 运算数1
	private int operand2;	   // 运算数2
	private char operator;	   // 操作符
	private int value;	   	   // 结果
	private String value_user;    // 用户计算的结果
	
	public static final short UPPER=100;// 定义运算数的最大取值
	
	public boolean equals (BinaryEquation equation) {		//检测算式是否重复
		return operand1==equation.getOperand1()&&
				operand2==equation.getOperand2()&&
				operator==equation.getOperator();
	}
	
	@Override
	public int hashCode() {		// 重写hashCode方法，返回的hashCode为算式的结果
		return this.value;
	}
	
	@Override
	public boolean equals(Object obj) { // 重写equals方法
        if (this == obj) {
        	return true;
        }
        if(obj != null && obj instanceof BinaryEquation) {
        	BinaryEquation other = (BinaryEquation)obj;
        	return other.operand1 == this.operand1 && other.operand2 == this.operand2;
        }
        else {
        	return false;
        }
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
	public String getValueToString() {
		 return ""+value;			  	   // 返回字符串类型的结果
	}
	public String getValue_User() {
		return this.value_user;		// 返回用户的结果计算
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
	public void setValue_User(String value) {
		this.value_user = value;		// 存储用户计算的结果
	}
	public String toString() {		   // 返回算术式的字符串
		return ""+operand1+operator+operand2;
	}

}

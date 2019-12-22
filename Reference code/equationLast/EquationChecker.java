package equationLast;

//检查加法/减法算式，操作数介于0-100，结果介于0-100（并且检测算式是否重复）
public class EquationChecker {
	
	//让构造函数为 private，这样该类就不会被实例化
	private EquationChecker(){}
	
	//创建 EquationChecker 的一个对象
	private static final EquationChecker Instance = new EquationChecker();
	
	//获取唯一可用的对象
	public static EquationChecker getInstance(){ 
		return Instance;
	}
	private int operand1[] = new int[60];	// 如果产生的算式满足条件且不重复，
	private int operand2[] = new int[60];	// 就将它的操作数存入数组，方便下次产生算式时比较
	
	public boolean equal(BinaryEquation equation) {	// 判断算式是否符合条件，且不重复
		if(equation.getValue()>=0&&equation.getValue()<=100) {	// 因为操作数是介于0-100的就只用判断结果是否在范围内即可
			for(int i=0; i<=Exercise.equationNum; i++) {	// 以当前产生的算式总量为界判断新算式是否重复
				if(equation.getOperand1() == operand1[i] && equation.getOperand2() == operand2[i])
					return false;					// 重复的话就返回false
			}
			operand1[Exercise.equationNum] = equation.getOperand1(); // 不充分就将新算式的操作数值存入数组
			operand2[Exercise.equationNum] = equation.getOperand2(); // 方便下次检测
			return true;											 // 返回true
	     }
		return false;	// 如果算式结果没有满足条件，就返回false
	}
}

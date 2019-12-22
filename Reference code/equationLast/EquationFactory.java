package equationLast;

public class EquationFactory  {//使用工厂模式，根据要求产生加法/减法算式

	public static Equation getEquation(String EquationType) { 
		EquationGenerator operand = new EquationGenerator(); // 实例化产生随机数的类
	
		if(EquationType == null){	// 如果传入的值为空，则返回null
	    	return null;
		}
		if(EquationType.equalsIgnoreCase("Add")){	// 如果传入"Add"，则返回一个加法算式的对象
			return (Equation) new AddEquation(operand.getOperand(),operand.getOperand());
		}
		else if(EquationType.equalsIgnoreCase("Sub")){	// 如果传入"Sub"，则返回一个减法算式的对象
			return (Equation) new SubEquation(operand.getOperand(),operand.getOperand());
		}
	  return null;
	}
}


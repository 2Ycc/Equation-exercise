package construction_6_gui;
import java.util.Random;
public class AddEquation extends BinaryEquation { //定义BinaryEquation的子类AddEquation
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Random random = new Random();
	public AddEquation() {
		int x = random.nextInt(UPPER)+1;
		int y = random.nextInt(UPPER)+1;
		setOperand1(x);   // 给运算数1赋值
		setOperand2(y);   // 给运算数2赋值
		setOperator('+'); // 给操作数赋值
		setValue(x+y);	  // 计算运算结果
	}
}

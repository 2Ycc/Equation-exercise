package equationLast;

import java.util.Random;

public class Exercise { // 产生通过EquationGenerator检查的算式60道
	public static final short MAX_NUM = 60; // 定义总算式数量
	public static int equationNum = 0;	// 定义当前产生的算式数量
	public static BinaryEquation res[] = new BinaryEquation[MAX_NUM];// 创建数组存放产生的算式对象
	
	public BinaryEquation[] mkEquation() {
		//获取EquationChecker 对象
		EquationChecker Checker1 = EquationChecker.getInstance();
		Random random = new Random();
		int num = random.nextInt(2);
		
		// 循环产生算式
		for (int i = 0; i < MAX_NUM; i++) {
			num = random.nextInt(2);
			if(num == 1) {
				BinaryEquation equation = (BinaryEquation) EquationFactory.getEquation("Add"); // 使用工厂模式创建加法对象
				if(Checker1.equal(equation)) {	// 判断产生的算式是否合格
					res[i] = equation;		// 算式合格，存入数组
					equationNum++;			// 当前算式数量加一
				}
				else i--;					// 算式不合格，重复循环
			}
			else {
				BinaryEquation equation = (BinaryEquation) EquationFactory.getEquation("Sub"); // 使用工厂模式创建减法对象
				if(Checker1.equal(equation)) {
					res[i] = equation;		// 算式合格，存入数组
					equationNum++;			// 当前算式数量加一
				}
				else i--;					// 算式不合格，重复循环
			}
				
		}
		
//		for(int i=0; i<MAX_NUM; i++) {		// 循环输出算式
//			System.out.printf("%2d:%3d%c%3d=%3d\t\t",i+1,res[i].getOperand1(),
//				res[i].getOperator(),res[i].getOperand2(),res[i].getResult());
//			if((i+1)%5 == 0)
//				System.out.println();
//		}
		return res;
		
	}
	
	

}

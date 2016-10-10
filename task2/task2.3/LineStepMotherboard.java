package task2_3;


public class LineStepMotherboard implements ILineStep{
	@Override
	public IProductPart buildProductPart() {
		IProductPart motherBoard = new MotherBoard();
		System.out.println("MotherBoard on LineStep");
		return motherBoard;
}
}

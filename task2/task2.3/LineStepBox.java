package task2_3;


public class LineStepBox implements ILineStep{
	@Override
	public IProductPart buildProductPart() {
		IProductPart box = new Box();
		System.out.println("Box on LineStep");
		return box;
}
}

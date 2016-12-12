package task2_3;


public class LineStepDisplay implements ILineStep{
	@Override
	public IProductPart buildProductPart() {
		IProductPart display = new Display();
		System.out.println("Display on LineStep");
		return display;
}
}

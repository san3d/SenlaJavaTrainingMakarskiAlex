package task2_3;

public class AssemblyLine implements IAssemblyLine{
	LineStepBox box;
	LineStepMotherboard motherBoard;
	LineStepDisplay display;

	public AssemblyLine(LineStepBox box, LineStepMotherboard motherBoard, LineStepDisplay display) {
	this.box=box;
	this.motherBoard=motherBoard;
	this.display=display;
	
	}
	
@Override
	public IProduct assembleProduct(IProduct product) {
		
		product.installFirstPart(box.buildProductPart());
		product.installSecondPart(motherBoard.buildProductPart());
		product.installThirdPart(display.buildProductPart());
		
		return product;
	}

}

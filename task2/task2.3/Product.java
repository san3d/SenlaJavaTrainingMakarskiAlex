package task2_3;

public class Product implements IProduct {
	IProductPart box;
	IProductPart motherBoard;
	IProductPart display;
	
	@Override
	public void installFirstPart(IProductPart part) {
		// TODO Auto-generated method stub
	this.box=part;	
	System.out.println("Part "+box.getClass()+ " is installed");	
	}

	@Override
	public void installSecondPart(IProductPart part) {
		// TODO Auto-generated method stub
		this.motherBoard=part;
		System.out.println("Part "+motherBoard.getClass()+ " is installed");		
	}

	@Override
	public void installThirdPart(IProductPart part) {
		// TODO Auto-generated method stub
		this.display=part;
		System.out.println("Part "+display.getClass()+ " is installed");		
	}
	
}

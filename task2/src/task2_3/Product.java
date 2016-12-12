package task2_3;

public class Product implements IProduct {

	@Override
	public void installFirstPart(IProductPart part) {
		// TODO Auto-generated method stub
	System.out.println("Part "+part.getClass()+ " is installed");	
	}

	@Override
	public void installSecondPart(IProductPart part) {
		// TODO Auto-generated method stub
		System.out.println("Part "+part.getClass()+ " is installed");		
	}

	@Override
	public void installThirdPart(IProductPart part) {
		// TODO Auto-generated method stub
		System.out.println("Part "+part.getClass()+ " is installed");		
	}
	
}

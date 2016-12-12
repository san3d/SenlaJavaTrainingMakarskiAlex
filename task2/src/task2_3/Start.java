package task2_3;

public class Start {
	public static void main(String[] args){
	
		System.out.println("Start!");
		LineStepBox box = new LineStepBox();
		LineStepMotherboard motherboard = new LineStepMotherboard();
		LineStepDisplay display = new LineStepDisplay();
		AssemblyLine notebookA = new AssemblyLine(box, motherboard, display);
		Product notebook = new Product();
		notebookA.assembleProduct(notebook);
		System.out.println(notebook.getClass() + " Finish!");
	
	}
}

package commands;

import model.Shape;
import model.ShapeRepository;

public class AddCommand extends AbstractComand{

	private Shape shape;
	private ShapeRepository repository;
	
	
	public AddCommand(Shape shape) {
		super();
		this.shape = shape;
		this.repository =ShapeRepository.getInstance();
	}

	@Override
	public void execute() {
		repository.addShape(shape);
	}

	@Override
	public void unexecute() {
		repository.removeShape(shape);	
	}

	@Override
	public String getDescription() { 
		String shape = this.shape.toString();
		return "Add->"+shape ;
	}

}

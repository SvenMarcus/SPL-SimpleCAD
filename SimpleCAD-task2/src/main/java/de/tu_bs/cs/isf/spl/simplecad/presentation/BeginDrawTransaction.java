package de.tu_bs.cs.isf.spl.simplecad.presentation;

public class BeginDrawTransaction {

    private final ShapeBuilderFactoryImpl builderFactory;
    private final String type;
    private final CanvasPresenter presenter;

    public BeginDrawTransaction(String type, CanvasPresenter presenter) {
        this.type = type;
        this.presenter = presenter;
        this.builderFactory = new ShapeBuilderFactoryImpl();
    }

    public void execute() {
        presenter.selectDrawMode(builderFactory.makeShapeBuilder(type));
    }

    public String getShapeType() {
        return type;
    }
}

import Interfaces.ILineStep;
import Interfaces.IProductPart;

public class EngineConstructor implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        Engine engine = new Engine();
        System.out.println(" Сборка " + engine);
        return engine;
    }

    @Override
    public String toString() {
        return "Этап сборки двигателей танка";
    }
}

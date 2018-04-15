import Interfaces.ILineStep;
import Interfaces.IProductPart;

public class BodyConstructor implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        Body body = new Body();
        System.out.println(" Сборка " + body);
        return body;
    }

    @Override
    public String toString() {
        return "Этап сборки корпусов танка";
    }
}

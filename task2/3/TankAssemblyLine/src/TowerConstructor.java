import Interfaces.ILineStep;
import Interfaces.IProductPart;

public class TowerConstructor implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        Tower tower = new Tower();
        System.out.println(" Сборка " + tower);
        return tower;
    }

    @Override
    public String toString() {
        return "Этап сборки башен танка";
    }
}

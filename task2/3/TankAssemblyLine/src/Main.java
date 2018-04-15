import Interfaces.ILineStep;
import Interfaces.IProduct;

public class Main {
    public static void main(String[] args) {
        ILineStep firstLineStep = new BodyConstructor();
        ILineStep secondLineStep = new EngineConstructor();
        ILineStep thirdLineStep = new TowerConstructor();
        System.out.println();

        AssemblyLine assemblyLine = new AssemblyLine(firstLineStep, secondLineStep, thirdLineStep);

        IProduct product;
        Tank tank = new Tank();
        product = assemblyLine.assembleProduct(tank);
    }

}

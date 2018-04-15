import Interfaces.IAssemblyLine;
import Interfaces.ILineStep;
import Interfaces.IProduct;
import Interfaces.IProductPart;

public class AssemblyLine implements IAssemblyLine {
    private ILineStep firstLineStep;
    private ILineStep secondLineStep;
    private ILineStep thirdLineStep;

    public AssemblyLine(ILineStep firstLineStep, ILineStep secondLineStep, ILineStep thirdLineStep) {
        // Инициализируем этапы сборочной линии
        this.firstLineStep = firstLineStep;
        this.secondLineStep = secondLineStep;
        this.thirdLineStep = thirdLineStep;
        System.out.println("Создание сборочной линии: " + this.toString());
    }

    @Override
    public IProduct assembleProduct(IProduct product) {
        // Создаем детали на этапах сборочной линии
        System.out.println("Сборка деталей: ");
        IProductPart firstProductPart = firstLineStep.buildProductPart();
        IProductPart secondProductPart = secondLineStep.buildProductPart();
        IProductPart thirdProductPart = thirdLineStep.buildProductPart();

        // Собираем продукт
        System.out.println("Установка деталей: ");
        product.installFirstPart(firstProductPart);
        product.installSecondPart(secondProductPart);
        product.installThirdPart(thirdProductPart);

        System.out.println("Получившийся продукт: " + product);
        return product;
    }

    @Override
    public String toString() {
        return "первый этап = "  + firstLineStep +
                ", второй этап = " + secondLineStep +
                ", третий этап = " + thirdLineStep;
    }
}

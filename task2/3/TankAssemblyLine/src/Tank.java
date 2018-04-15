import Interfaces.IProduct;
import Interfaces.IProductPart;

public class Tank implements IProduct {
    private IProductPart firstPart;
    private IProductPart secondPart;
    private IProductPart thirdPart;

    @Override
    public void installFirstPart(IProductPart productPart) {
        System.out.println(" Установка первой части - " + productPart.toString());
        this.firstPart = productPart;
    }

    @Override
    public void installSecondPart(IProductPart productPart) {
        System.out.println(" Установка второй части - " + productPart.toString());
        this.secondPart = productPart;
    }

    @Override
    public void installThirdPart(IProductPart productPart) {
        System.out.println(" Установка третей части - " + productPart.toString());
        this.thirdPart = productPart;
    }

    @Override
    public String toString() {
        return "Танк состоящий из: " +
                firstPart + ", " +
                secondPart + ", " +
                thirdPart;
    }
}

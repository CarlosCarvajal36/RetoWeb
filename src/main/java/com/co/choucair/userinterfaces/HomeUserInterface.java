package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class HomeUserInterface {

    private HomeUserInterface() {
        throw new UnsupportedOperationException("Utility/UI class - cannot be instantiated");
    }

    public static final Target CATEGORY_LAPTOS = Target.the("categoría Laptops").located(By.xpath("//a[text()='Laptops']"));
    public static final Target PRODUCT_LAPTOP_ITEM = Target.the("producto Sony vaio i5").located(By.linkText("Sony vaio i5"));
    public static final Target BTN_ADD_TO_CART = Target.the("botón agregar al carrito").located(By.xpath("//a[text()='Add to cart']"));
    public static final Target BTN_CART_MENU = Target.the("menú Carrito de compras").located(By.id("cartur"));
}
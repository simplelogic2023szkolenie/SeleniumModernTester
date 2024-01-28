package other;

import base.TestBase;
import org.testng.annotations.Test;

public class BasketTest extends TestBase {

    @Test
    public void shouldAddProductToBasket(){
        driver.get("http://146.59.32.4/index.php?id_product=6&rewrite=mug-the-best-is-yet-to-come&controller=product&id_lang=2");
    }
}

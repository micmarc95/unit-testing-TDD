package exercises;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.assertj.core.api.Assertions.*;


public class ShoppingCartTest {

    ShoppingCart shoppingCart;
    ProductOrder productOrder;

    @Before
    public void setUpShopingCart(){
        DatabaseAccessObject dao = new DatabaseAccessObject();
        shoppingCart = new ShoppingCart(dao);
        productOrder = new ProductOrder("Aparat Canon", 1, 1900);
    }

    @Test
    public void testIsCartEmpty(){

        try {
            shoppingCart.addProduct(null);
            fail();
        } catch (IllegalArgumentException e){
            Assert.assertEquals("Argument must be provided",e.getMessage());
        }catch (Exception e){
            fail();
        }

    }

    @Test
    public void testAlreadyInCart(){
        try{

            ProductOrder productOrder1 = new ProductOrder("aaa",1,2.00);
            ProductOrder productOrder2 = new ProductOrder("aaa",1,2.00);

            shoppingCart.addProduct(productOrder1);
            shoppingCart.addProduct(productOrder2);
            fail();
        } catch (ProductAlreadyInCartException e){
            Assert.assertEquals("Product aaa is already in the shopping cart", e.getMessage());
        } catch (Exception e){
            fail();
        }
    }

    @Test
    public void testIfAddOneProductSuccessfull(){

        // GIVEN
        ProductOrder productOrder = new ProductOrder("Aparat Canon", 1, 1900);
        // WHEN
        shoppingCart.addProduct(productOrder);
        // THEN
        assertEquals(shoppingCart.listProducts().size(), 1);
        Assertions.assertThat(shoppingCart.listProducts().contains(productOrder));
    }

    @Test
    public void testIfAddOneProductTwiceThrowsException(){
        shoppingCart.addProduct(productOrder);
        try {
            shoppingCart.addProduct(productOrder);
        } catch (ProductAlreadyInCartException e){
            assertEquals(
                    String.format("Product %s is already in the shopping cart",
                            productOrder.getProductName()), e.getMessage());
        } catch (Throwable t){
            fail();
        }
    }

    @Test
    public void testIfAddedProductIsSuccessfullyRemoved(){
        shoppingCart.addProduct(productOrder);
        shoppingCart.removeProduct(productOrder.getProductName());
        Assertions.assertThat(shoppingCart.listProducts()).doesNotContain(productOrder);
    }

}

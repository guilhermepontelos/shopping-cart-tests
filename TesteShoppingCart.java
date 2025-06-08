/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exercício simples de teste de unidade (ShoppingCart)
*
*/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class TesteShoppingCart {

  private ShoppingCart shoppingCart;

  @Before
  public void setUp() {
    shoppingCart = new ShoppingCart();
    shoppingCart.addItem(new Item("ESM", 65.0));
    shoppingCart.addItem(new Item("GoF", 120.0));
  }

  @Test
  public void testAddItem() {
    // Escreva aqui seu código de teste
  }

  @Test
  public void testRemoveItem() {
    // Escreva aqui seu código de teste
  }

  @Test
  public void testGetTotalPrice() {
    // Escreva aqui seu código de teste
  }

  @Test
  public void testClearCart() {
    // Escreva aqui seu código de teste
  }
}

/**
* Engenharia de Software Moderna - Testes   (Cap. 8)
* Prof. Marco Tulio Valente
*
* Exercício simples de teste de unidade (ShoppingCart)
*
*/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TesteShoppingCart {

  private ShoppingCart shoppingCart;
  private Item itemESM;
  private Item itemGoF;
  private Item itemRefactoring;

  @Before
  public void setUp() {
    shoppingCart = new ShoppingCart();
    itemESM = new Item("ESM", 65.0);
    itemGoF = new Item("GoF", 120.0);
    itemRefactoring = new Item("Refactoring", 90.0);

    shoppingCart.addItem(itemESM);
    shoppingCart.addItem(itemGoF);
  }

  @Test
  public void testAddItem() {
    assertEquals("O carrinho deve ter 2 itens após o setUp.", 2, shoppingCart.getItemCount());
    shoppingCart.addItem(itemRefactoring);
    assertEquals("O carrinho deve ter 3 itens após adicionar um novo.", 3, shoppingCart.getItemCount());
    assertTrue("O carrinho deve conter o item 'Refactoring'.", shoppingCart.getItems().contains(itemRefactoring));
  }

  @Test
  public void testRemoveItem() {
    assertEquals("O carrinho deve ter 2 itens antes da remoção.", 2, shoppingCart.getItemCount());
    shoppingCart.removeItem(itemESM);
    assertEquals("O carrinho deve ter 1 item após remover 'ESM'.", 1, shoppingCart.getItemCount());
    assertFalse("O carrinho não deve conter o item 'ESM'.", shoppingCart.getItems().contains(itemESM));
    shoppingCart.removeItem(itemRefactoring);
    assertEquals("A remoção de um item inexistente não deve alterar o número de itens.", 1, shoppingCart.getItemCount());
  }

  @Test
  public void testGetTotalPrice() {
    double expectedPrice = 65.0 + 120.0;
    assertEquals("O preço total deve ser 185.0.", expectedPrice, shoppingCart.getTotalPrice(), 0.001); // 0.001 é a variação permitida para comparação de pontos flutuantes

    shoppingCart.addItem(itemRefactoring);
    expectedPrice += 90.0;
    assertEquals("O preço total deve ser 275.0 após adicionar 'Refactoring'.", expectedPrice, shoppingCart.getTotalPrice(), 0.001);

    shoppingCart.removeItem(itemGoF);
    expectedPrice -= 120.0;
    assertEquals("O preço total deve ser 155.0 após remover 'GoF'.", expectedPrice, shoppingCart.getTotalPrice(), 0.001);
  }

  @Test
  public void testClearCart() {
    assertEquals("O carrinho deve ter 2 itens antes de limpar.", 2, shoppingCart.getItemCount());

    shoppingCart.clearCart();

    assertEquals("O carrinho deve estar vazio após clearCart.", 0, shoppingCart.getItemCount());
    assertTrue("A lista de itens deve estar vazia após clearCart.", shoppingCart.getItems().isEmpty());
  }

  @Test
  public void testGetItemCountInitial() {
    assertEquals("O carrinho deve ter 2 itens após o setUp inicial.", 2, shoppingCart.getItemCount());
  }

  @Test
  public void testGetItemsReturnsCorrectList() {
    List<Item> itemsInCart = shoppingCart.getItems();
    assertEquals("A lista deve ter 2 itens.", 2, itemsInCart.size());
    assertTrue("A lista deve conter 'ESM'.", itemsInCart.contains(itemESM));
    assertTrue("A lista deve conter 'GoF'.", itemsInCart.contains(itemGoF));
    assertEquals("A lista retornada deve ser a mesma instância interna.", shoppingCart.getItems(), itemsInCart);
  }

  @Test
  public void testTotalPriceEmptyCart() {
    ShoppingCart emptyCart = new ShoppingCart();
    assertEquals("O preço total de um carrinho vazio deve ser 0.0.", 0.0, emptyCart.getTotalPrice(), 0.001);
  }
}
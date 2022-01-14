package ru.job4j.design.lsp.storage;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class QualityControllerTest {

    @Test
    public void whenAddProductToTheShopAndTrash() {
        List<Food> foodList = new ArrayList<>();
        Food cheese = new Cheese(
                        "cheese",
                        LocalDate.of(2021, 1, 1),
                        LocalDate.of(2020, 1, 1),
                        20.0,
                        5
        );
        Food meat = new Meat(
                        "meat",
                        LocalDate.of(2022, 12, 1),
                        LocalDate.of(2020, 5, 3),
                        15.0,
                        40
        );
        foodList.add(cheese);
        foodList.add(meat);
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> storages = List.of(shop, trash);
        QualityController controller = new QualityController(storages);
        for (Food food : foodList) {
            controller.executeStorage(food);
        }
        List<Food> expectedTrash = new ArrayList<>();
        expectedTrash.add(cheese);
        List<Food> expectedShop = new ArrayList<>();
        expectedShop.add(meat);
        assertEquals(expectedShop, shop.getFoodList());
        assertEquals(expectedTrash, trash.getFoodList());
    }

    @Test
    public void whenAddProductToTheWarehouse() {
        List<Food> foodList = new ArrayList<>();
        Food salmon = new Fish(
                        "salmon",
                        LocalDate.of(2022, 2, 28),
                        LocalDate.of(2022, 1, 8),
                        200.0,
                        5
        );
        foodList.add(salmon);
        Storage warehouse = new Warehouse();
        List<Storage> storages = List.of(warehouse);
        QualityController controller = new QualityController(storages);
        for (Food food : foodList) {
            controller.executeStorage(food);
        }
        List<Food> expected = new ArrayList<>();
        expected.add(salmon);
        assertEquals(expected, warehouse.getFoodList());
    }

    @Test
    public void whenAddProductToTheShopWithDiscount() {
        List<Food> foodList = new ArrayList<>();
        Food edam = new Cheese(
                        "edam",
                        LocalDate.of(2022, 1, 30),
                        LocalDate.of(2021, 1, 8),
                        100.0,
                        15
        );
        foodList.add(edam);
        Storage shop = new Shop();
        List<Storage> storages = List.of(shop);
        QualityController controller = new QualityController(storages);
        for (Food food : foodList) {
            controller.executeStorage(food);
        }
        List<Food> expected = new ArrayList<>();
        expected.add(edam);
        assertEquals(expected, shop.getFoodList());
        assertThat(shop.getFoodList().get(0).getPrice(), is(85.0));
    }
}
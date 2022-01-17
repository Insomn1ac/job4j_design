package ru.job4j.design.lsp.storage;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class QualityControllerTest {

    @Test
    public void whenAddProductToTheShopAndTrash() {
        List<Food> foodList = new ArrayList<>();
        Food cheese = new Cheese(
                        "cheese",
                        LocalDate.now().minusDays(10),
                        LocalDate.now().minusYears(1),
                        20.0,
                        5
        );
        Food meat = new Meat(
                        "meat",
                        LocalDate.now().plusDays(20),
                        LocalDate.now().minusDays(10),
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
                        LocalDate.now().plusDays(40),
                        LocalDate.now().minusDays(5),
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
                        LocalDate.now().plusDays(20),
                        LocalDate.now().minusYears(1),
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

    @Test
    public void whenResortFoodFromWarehouseToShopThenWarehouseEmpty() {
        List<Food> foodList = new ArrayList<>();
        Food edam = new Cheese(
                "Edam",
                LocalDate.now().plusDays(120),
                LocalDate.now().minusDays(1),
                100,
                15
        );
        Food salmon = new Fish(
                "Salmon",
                LocalDate.now().plusDays(120),
                LocalDate.now().minusDays(1),
                200,
                5
        );
        foodList.add(edam);
        foodList.add(salmon);
        Storage shop = new Shop();
        Storage warehouse = new Warehouse();
        List<Storage> storages = List.of(shop, warehouse);
        QualityController controller = new QualityController(storages);
        for (Food food : foodList) {
            controller.executeStorage(food);
        }
        List<Food> expected = List.of(edam, salmon);
        assertEquals(expected, warehouse.getFoodList());
        edam.setExpiryDate(LocalDate.now().plusDays(2));
        salmon.setExpiryDate(LocalDate.now().plusDays(2));
        controller.resort();
        List<Food> newExpected = List.of(edam, salmon);
        assertEquals(newExpected, shop.getFoodList());
        assertEquals(warehouse.getFoodList(), Collections.emptyList());
    }
}
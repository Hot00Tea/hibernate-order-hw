package mate.academy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import mate.academy.lib.Injector;
import mate.academy.model.*;
import mate.academy.service.*;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.academy");

        OrderService orderService = (OrderService) injector.getInstance(OrderService.class);
        ShoppingCartService shoppingCartService = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        UserService userService = (UserService) injector.getInstance(UserService.class);

        User user = userService.findByEmail("test@example.com").get();
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);

        // Завершити замовлення
        Order order = orderService.completeOrder(shoppingCart);
        System.out.println("Order created: " + order);

        // Отримати історію замовлень
        List<Order> history = orderService.getOrdersHistory(user);
        history.forEach(System.out::println);
    }
}

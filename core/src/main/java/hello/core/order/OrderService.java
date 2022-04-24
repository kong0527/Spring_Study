package hello.core.order;

public interface OrderService {
    // order 결과 반환
    Order createOrder(Long memberId, String itemName, int itemPrice);
}

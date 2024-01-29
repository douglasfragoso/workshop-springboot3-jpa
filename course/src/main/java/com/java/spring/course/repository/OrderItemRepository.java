import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.course.model.OrderItem;
import com.java.spring.course.model.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
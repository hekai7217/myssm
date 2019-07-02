import com.lx.bean.UserAddress;
import com.lx.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * create by hekai  2019-06-30
 *
 * @desc
 */
public class MainApplication {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");

        OrderService orderService = ioc.getBean(OrderService.class);

        List<UserAddress> userAddresses = orderService.initOrder("1");

        userAddresses.forEach(e-> System.out.println(e.getUserAddress()));

        System.out.println("调用完成 ...");

        System.in.read();

    }
}

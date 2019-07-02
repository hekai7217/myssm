import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by hekai  2019-06-30
 *
 * @desc
 */
public class MainApplication {

    public static void main(String[] args) throws Exception{

        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");

        ioc.start();

        System.out.println("启动  服务...");

        System.in.read();

    }
}

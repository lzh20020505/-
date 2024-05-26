import com.example.pojo.Orders;
import com.example.pojo.Person;
import com.example.pojo.User;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;


/**
 * Mybatis关联查询映射测试类
 */
public class MybatisAssociatedTest {
    /**
     * 一对一嵌套查询：查询人及关联的身份证信息
     */
    @Test
    public void findPersonByIdTest() {
        // 1、通过工具类生成SqlSession对象
        SqlSession session = MybatisUtils.getSession();
        // 2.使用MyBatis嵌套查询的方式查询id为1的人的信息
        Person person = session.selectOne("com.example.mapper."
                                   + "PersonMapper.findPersonById", 1);
        // 3、输出查询结果信息
        System.out.println(person.toString());
        // 4、关闭SqlSession
        session.close();
    }
    
    /**
     * 一对以嵌套结果查询：查询人及关联的身份证信息
     */
    @Test
    public void findPersonByIdTest2() {
        // 1、通过工具类生成SqlSession对象
        SqlSession session = MybatisUtils.getSession();
        // 2.使用MyBatis嵌套结果的方法查询id为1的人的信息
        Person person = session.selectOne("com.example.mapper."
                                   + "PersonMapper.findPersonById2", 1);
        // 3、输出查询结果信息
        System.out.println(person.toString());
        // 4、关闭SqlSession
        session.close();
    }

    /**
     * 一对多嵌套查询：查询用户及关联的订单信息
     *
     *
     * 有bug
     *
     *
     */
    @Test
    public void findUserWithOrders1Test() {
        // 1、通过工具类生成SqlSession对象
        SqlSession session = MybatisUtils.getSession();
        // 2、查询id为1的用户信息
        User user = session.selectOne("com.example.mapper."
                + "UserMapper.findUserWithOrders1", 1);
        // 3、输出查询结果信息
        System.out.println(user.toString());
        // 4、关闭SqlSession
        session.close();
    }

    /**
     * 一对多嵌套结果查询：查询用户及关联的订单信息
     */
    @Test
    public void findUserWithOrders2Test() {
        // 1、通过工具类生成SqlSession对象
        SqlSession session = MybatisUtils.getSession();
        // 2、查询id为1的用户信息
        User user = session.selectOne("com.example.mapper."
                                + "UserMapper.findUserWithOrders2", 1);
        // 3、输出查询结果信息
        System.out.println(user.toString());
        // 4、关闭SqlSession
        session.close();
    }

    /**
     * 多对多嵌套查询：查询订单及所关联的商品信息
     */
    @Test
    public void findOrdersTest(){
        // 1、通过工具类生成SqlSession对象
        SqlSession session = MybatisUtils.getSession();
        // 2、查询id为1的订单中的商品信息
        Orders orders = session.selectOne("com.example.mapper."
                               + "OrdersMapper.findOrdersWithProduct", 1);
        // 3、输出查询结果信息
        System.out.println(orders.toString());
        // 4、关闭SqlSession
        session.close();
    }

    /**
     * 多对多嵌套结果查询：查询订单及所关联的商品信息
     */
    @Test
    public void findOrders2Test(){
        // 1、通过工具类生成SqlSession对象
        SqlSession session = MybatisUtils.getSession();
        // 2、查询id为1的订单中的商品信息
        Orders orders = session.selectOne("com.example.mapper."
                + "OrdersMapper.findOrdersWithPorduct2", 1);
        // 3、输出查询结果信息
        System.out.println(orders.toString());
        // 4、关闭SqlSession
        session.close();
    }
}

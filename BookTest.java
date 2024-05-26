import com.example.pojo.Book;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class BookTest {
    /**
     * 一级缓存测试
     */
    @Test
    public void findBookByIdTest1() {
        // 1.通过工具类生成SqlSession对象
        SqlSession session = MybatisUtils.getSession();
        // 2.使用session1查询id为1的图书的信息
        Book book1 = session.selectOne("com.example.mapper.BookMapper.findBookById", 1);
        System.out.println(book1.toString()); // 3.输出查询结果信息
        // 再次使用session查询id为1的图书的信息，同2、3步
        Book book2 = session.selectOne("com.example.mapper.BookMapper.findBookById", 1);
        System.out.println(book2.toString()); // 3.输出查询结果信息
        // 4.关闭SqlSession
        session.close();
    }

    @Test
    public void findBookByIdTest2() {
        // 1.通过工具类生成两个SqlSession对象，这里只展示了一个
        SqlSession session1 = MybatisUtils.getSession();
        // 2.使用session1查询id为1的图书的信息
        Book book1 = session1.selectOne("com.example.mapper.BookMapper.findBookById", 1);
        System.out.println(book1.toString()); // 3.输出查询结果信息
        // 4.关闭SqlSession1
        session1.close();
        // 1.通过工具类生成两个SqlSession对象，这里只展示了一个
        SqlSession session2 = MybatisUtils.getSession();
        // 2.使用session1查询id为1的图书的信息
        Book book2 = session2.selectOne("com.example.mapper.BookMapper.findBookById", 1);
        System.out.println(book2.toString()); // 3.输出查询结果信息
        // 4.关闭SqlSession1
        session2.close();
    }


}

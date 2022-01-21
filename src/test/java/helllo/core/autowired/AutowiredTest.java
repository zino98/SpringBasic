package helllo.core.autowired;

import helllo.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

public class AutowiredTest {

    @Test
    public void AutowiredOption() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(Testbean.class);

    }

    static class Testbean {

        @Autowired(required = false) // 출력 X
        public void setNoBean1(Member member) {
            System.out.println("member = " + member);
        }

        @Autowired   // null 출력
        public void setNoBean2(@Nullable Member member) {
            System.out.println("member = " + member);
        }
    }
}

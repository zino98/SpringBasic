package helllo.core.autowired;

import helllo.core.AutoAppConfig;
import helllo.core.discount.DiscountPolicy;
import helllo.core.member.Grade;
import helllo.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.calculate(member, 20000, "rateDiscountPolicy");

        //Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(discountPrice).isEqualTo(2000);
    }

    static class DiscountService {

        private final Map<String, DiscountPolicy> policyMap;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap) {
            this.policyMap = policyMap;
            System.out.println("policyMap = " + policyMap);
        }


       public int calculate(Member member, int price, String discountCode) {

            DiscountPolicy discountPolicy = policyMap.get(discountCode);

            return discountPolicy.discount(member, price);
        }
    }
}

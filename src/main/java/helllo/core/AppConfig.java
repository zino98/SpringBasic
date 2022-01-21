package helllo.core;

import helllo.core.discount.DiscountPolicy;
import helllo.core.discount.FixDiscountPolicy;
import helllo.core.member.MemberRepository;
import helllo.core.member.MemberService;
import helllo.core.member.MemberServiceImpl;
import helllo.core.member.MemoryMemberRepository;
import helllo.core.order.OrderService;
import helllo.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}

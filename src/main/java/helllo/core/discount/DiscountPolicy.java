package helllo.core.discount;

import helllo.core.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}

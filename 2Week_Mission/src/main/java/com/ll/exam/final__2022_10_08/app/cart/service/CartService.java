package com.ll.exam.final__2022_10_08.app.cart.service;

import com.ll.exam.final__2022_10_08.app.base.dto.RsData;
import com.ll.exam.final__2022_10_08.app.cart.entity.CartItem;
import com.ll.exam.final__2022_10_08.app.cart.repository.CartItemRepository;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartItemRepository;

    public List<CartItem> findMyCartItems(Member member) {
        return cartItemRepository.findAllByMember(member);
    }


    public RsData createCartItem(Member member, Product product) {
        try{
            CartItem cartItem = CartItem.builder()
                    .member(member)
                    .product(product)
                    .build();

            cartItemRepository.save(cartItem);
            return RsData.of("S-1", "장바구니를 생성하였습니다.", cartItem);
        }  catch (DataIntegrityViolationException e){
            return RsData.of("F-1", "이미 장바구니에 존재합니다.");
        }

    }

    public RsData deleteCartItem(Member member, Product product) {
        CartItem cartItem = cartItemRepository.findOneByProductAndMember(product, member)
                .orElse(null);

        if(cartItem == null){
            return RsData.of("F-0","장바구니에 존재하지 않습니다.");
        }
        cartItemRepository.delete(cartItem);

        return RsData.of("S-1", "%s를 삭제하였습니다.".formatted(cartItem.getProduct().getSubject()));
    }
}

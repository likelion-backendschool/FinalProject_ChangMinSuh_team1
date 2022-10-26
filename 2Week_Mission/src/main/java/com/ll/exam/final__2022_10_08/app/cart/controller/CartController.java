package com.ll.exam.final__2022_10_08.app.cart.controller;

import com.ll.exam.final__2022_10_08.app.base.dto.RsData;
import com.ll.exam.final__2022_10_08.app.base.exception.NotFoundException;
import com.ll.exam.final__2022_10_08.app.base.rq.Rq;
import com.ll.exam.final__2022_10_08.app.cart.entity.CartItem;
import com.ll.exam.final__2022_10_08.app.cart.service.CartService;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.product.entity.Product;
import com.ll.exam.final__2022_10_08.app.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("cart")
public class CartController {
    private final Rq rq;
    private final CartService cartService;
    private final ProductService productService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("list")
    public String getCartItems(
            Model model
    ){
        Member member = rq.getMember();

        List<CartItem> cartItems = cartService.findMyCartItems(member);

        model.addAttribute("carts", cartItems);
        return "cart/list";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("add/{productId}")
    public String createCartItems(
            Model model,
            @PathVariable Long productId
    ){
        Member member = rq.getMember();

        Product product = productService.findById(productId)
                .orElse(null);

        if(product == null){
            return rq.historyBack("해당 상품이 존재하지 않습니다.");
        }

        RsData cartItem = cartService.createCartItem(member, product);

        if(cartItem.isFail()){
            return rq.historyBack(cartItem.getMsg());
        }

        return Rq.redirectWithMsg("/product/list", cartItem.getMsg());

    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("remove/{productId}")
    public String deleteCartItem(
            Model model,
            @PathVariable Long productId
    ){
        Member member = rq.getMember();

        Product product = productService.findById(productId)
                .orElse(null);

        if(product == null){
            return rq.historyBack("해당 상품이 존재하지 않습니다.");
        }

        RsData cartItem = cartService.deleteCartItem(member, product);

        if(cartItem.isFail()){
            return rq.historyBack(cartItem.getMsg());
        }

        return Rq.redirectWithMsg("/cart/list", cartItem.getMsg());
    }
}

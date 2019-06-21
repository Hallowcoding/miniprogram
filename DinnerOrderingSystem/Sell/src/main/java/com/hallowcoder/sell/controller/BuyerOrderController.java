package com.hallowcoder.sell.controller;

import com.hallowcoder.sell.converter.OrderForm2OrderDTOConverter;
import com.hallowcoder.sell.dto.OrderDTO;
import com.hallowcoder.sell.enums.ResultEnum;
import com.hallowcoder.sell.exception.SellException;
import com.hallowcoder.sell.form.OrderForm;
import com.hallowcoder.sell.service.OrderService;
import com.hallowcoder.sell.utils.ResultVOUtil;
import com.hallowcoder.sell.viewobj.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * BuyerOrderController
 *
 * @author th
 * 2019/6/22 1:26
 **/
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    /** 创建订单 */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm = {}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (orderDTO.getOrderDetailList().isEmpty()) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    /** 订单列表 */

    /** 订单详情 */

    /** 取消订单 */

}

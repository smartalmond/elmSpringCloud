package com.elm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.elm.user.domain.po.DeliveryAddress;
import com.elm.user.mapper.DeliveryAddressMapper;
import com.elm.user.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    @Autowired
    private DeliveryAddressMapper deliveryAddressMapper;

    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        QueryWrapper<DeliveryAddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return deliveryAddressMapper.selectList(queryWrapper);
    }

    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        return deliveryAddressMapper.selectById(daId);
    }

    @Override
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        return deliveryAddressMapper.insert(deliveryAddress);
    }

    @Override
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        UpdateWrapper<DeliveryAddress> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("da_id", deliveryAddress.getDaId());
        if (deliveryAddress.getContactName() != null)
            updateWrapper.set("contact_name", deliveryAddress.getContactName());
        if (deliveryAddress.getContactSex() != null)
            updateWrapper.set("contact_sex", deliveryAddress.getContactSex());
        if (deliveryAddress.getContactTel() != null)
            updateWrapper.set("contact_tel", deliveryAddress.getContactTel());
        if (deliveryAddress.getAddress() != null)
            updateWrapper.set("address", deliveryAddress.getAddress());
        return deliveryAddressMapper.update(updateWrapper);
    }

    @Override
    public int removeDeliveryAddress(Integer daId) {
        return deliveryAddressMapper.deleteById(daId);
    }
}

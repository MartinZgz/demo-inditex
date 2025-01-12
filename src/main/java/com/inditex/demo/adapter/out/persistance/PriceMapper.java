package com.inditex.demo.adapter.out.persistance;

import com.inditex.demo.application.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper( PriceMapper.class );

    List<Price> mapListToDomainEntityList(List<PriceJPAEntity> priceJPAEntity);

    @Mapping(source = "id.productId", target = "productId")
    @Mapping(source = "id.priceList", target = "priceList")
    Price mapToDomainEntity(PriceJPAEntity priceJPAEntity);

}

package com.inditex.demo.adapter.out.persistance;

import com.inditex.demo.application.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper( PriceMapper.class );

    List<Price> mapListToDomainEntityList(List<PriceJPAEntity> priceJPAEntity);

    Price mapToDomainEntity(PriceJPAEntity priceJPAEntity);

}

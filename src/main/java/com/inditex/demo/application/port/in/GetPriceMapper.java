package com.inditex.demo.application.port.in;

import com.inditex.demo.application.domain.model.Brand;
import com.inditex.demo.application.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GetPriceMapper {

    GetPriceMapper INSTANCE = Mappers.getMapper( GetPriceMapper.class );

    GetPriceResponse mapFromDomainEntity(Price domainPrice);

    default int fromBrandToBrandId(Brand brand) {
        return brand.getBrandId();
    }
}

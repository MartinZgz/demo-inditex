package com.inditex.demo.adapter.out.persistance;

import com.inditex.demo.application.domain.exceptions.BrandNotFoundException;
import com.inditex.demo.application.domain.model.Brand;
import com.inditex.demo.application.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper( PriceMapper.class );

    List<Price> mapListToDomainEntityList(List<PriceJPAEntity> priceJPAEntity);

    @Mapping(source = "id.productId", target = "productId")
    @Mapping(source = "id.priceList", target = "priceList")
    @Mapping(source = "id.brandId", target = "brandId", qualifiedByName = "mapFromBrandIdToBrand")
    Price mapToDomainEntity(PriceJPAEntity priceJPAEntity);

    @Named("mapFromBrandIdToBrand")
    public static Brand mapFromBrandIdToBrand(int brandId) throws BrandNotFoundException {
        return Brand.fromBrandId(brandId);
    }
}

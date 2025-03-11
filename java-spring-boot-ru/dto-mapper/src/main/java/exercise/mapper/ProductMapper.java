package exercise.mapper;

// BEGIN
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ProductMapper {
    @Mapping(target = "title", source = "name")
	@Mapping(target = "price", source = "cost")
	@Mapping(target = "vendorCode", source = "barcode")
	public abstract ProductDTO map(Product product);
	
	@Mapping(target = "name", source = "title")
	@Mapping(target = "cost", source = "price")
	@Mapping(target = "barcode", source = "vendorCode")
	public abstract Product map(ProductCreateDTO dto);
	
	@Mapping(target = "cost", source = "price")
    public abstract void update(ProductUpdateDTO dto, @MappingTarget Product model);
}
// END

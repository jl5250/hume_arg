package cn.edu.cqu.cht.mapper;

import cn.edu.cqu.cht.model.PlacePrice;
import org.apache.ibatis.annotations.Param;

/**
 * @author WJL
 * @date 创建时间：2022年5月31日 20:41
 * @version 1.0
 */
public interface PlacePriceMapper {

    public PlacePrice selectByProvinceAndCityAndArea(
            @Param("province") String province,
            @Param("city") String city,
            @Param("area") String area);

}

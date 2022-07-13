package cn.edu.cqu.cht.mapper;

import cn.edu.cqu.cht.model.Orderlist;
import cn.edu.cqu.cht.model.Station;

import java.util.List;

/**
 * @author CHT
 * @date 创建时间：2018年5月8日 上午3:38:35
 * @version 1.0
 */
public interface StationMapper {
    /**
     * 根据id查找快递站
     *
     * @param stationId
     * @return
     */
    Station selectByStationId(Integer stationId);

    /**
     * 查找所有快递站
     *
     * @return
     */
    List<Station> selectAllStation();

    /**
     * 查询所有没被批准的快递站
     *
     * @return
     */
    List<Station> selectAllUnpassStation();

    /**
     * 添加快递站
     *
     * @param station
     * @return
     */
    int insertStation(Station station);

    /**
     * 根据id删除快递站
     *
     * @param station
     * @return
     */
    int updateByStationId(Station station);

    /**
     * 根据id删除快递站
     *
     * @param stationId
     * @return
     */
    int deleteByStationId(Integer stationId);

    /**
     * 同意快递站的加入
     *
     * @param stationId
     * @return
     */
    int passStation(Integer stationId);

    /**
     * 查询我站的快递单号
     *
     * @param stationId
     * @return
     */
	List<Orderlist> findMyOrders(Integer stationId);
}

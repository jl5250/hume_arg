package cn.edu.cqu.cht.service;

import cn.edu.cqu.cht.model.Orderlist;
import cn.edu.cqu.cht.model.Station;

import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 19:47
 */
public interface StationService {
    //查找所有快递站
    List<Station> findAllStations(int offset, int limit);

    //查询所有没被批准的快递站
    List<Station> findAllUnpassStations(int offset, int limit);

    //根据id查找快递站
    Station findByStationId(Integer stationId);

    //查找订单号
    List<Orderlist> findMyOrders(Integer stationId);

    //添加快递站
    boolean insertStation(Station station);

    //修改快递站的信息
    boolean updateStation(Station station);

    //根据id删除快递站
    boolean deleteByStationId(Integer stationId);

    //全手动输入添加
    boolean addStation(Integer stationId, String stationName, String province, String city, String area, String address, String principal, String phone);

    //同意快递站的加入
    boolean passStation(Integer stationId);
}


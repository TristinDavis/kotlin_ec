package com.niu1078.order.service

/**
 * author :ywq .
 * time: 2018/1/3:15:37.
 * desc :
 * action:
 */
import com.niu1078.order.data.protocol.ShipAddress
import rx.Observable

/*
    收货人信息 业务接口
 */
interface ShipAddressService {

    /*
        添加收货地址
     */
    fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String): Observable<Boolean>

    /*
    获取收货地址列表
 */
    fun getShipAddressList(): Observable<MutableList<ShipAddress>?>

    /*
     修改收货地址
  */
    fun editShipAddress(address: ShipAddress): Observable<Boolean>

    /*
    删除收货地址
 */
    fun deleteShipAddress(id: Int): Observable<Boolean>

}
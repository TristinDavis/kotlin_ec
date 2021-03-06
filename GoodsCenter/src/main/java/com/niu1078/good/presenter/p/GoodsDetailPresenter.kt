package com.niu1078.good.presenter.p

import com.niu1078.base.ext.excute
import com.niu1078.base.presenter.BasePresenter
import com.niu1078.base.rx.BaseSubscriber
import com.niu1078.good.data.protocol.Goods
import com.niu1078.good.presenter.view.GoodsDetailView
import com.niu1078.good.service.CartService
import com.niu1078.good.service.GoodsService
import javax.inject.Inject

/**
 * author :ywq .
 * time: 2017/12/29:16:30.
 * desc :商品详情 Presenter
 * action:
 */
class GoodsDetailPresenter  @Inject constructor(): BasePresenter<GoodsDetailView>() {
    @Inject
    lateinit var goodsService: GoodsService
    /*
    获取商品详情
     */
    fun getGoodsDetail(goodsId :Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoodsDetail(goodsId).excute(object : BaseSubscriber<Goods>(mView) {
            override fun onNext(t: Goods) {
                mView.onGoodsDetailResult(t)
            }
        }, lifecycleProvider)

    }
    @Inject
    lateinit var cartService: CartService

    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                goodsCount: Int, goodsSku: String){
        mView.showLoading()
        cartService.addCart(goodsId,goodsDesc,goodsIcon,goodsPrice,goodsCount,goodsSku)
                .excute(object : BaseSubscriber<Int>(mView) {
                    override fun onNext(t: Int) {
                        mView.onAddCartResult(t)
                    }
                }, lifecycleProvider)

    }
}
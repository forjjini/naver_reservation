
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PaymentPaymentManager from "./components/listers/PaymentPaymentCards"
import PaymentPaymentDetail from "./components/listers/PaymentPaymentDetail"

import ShopShopReservationManager from "./components/listers/ShopShopReservationCards"
import ShopShopReservationDetail from "./components/listers/ShopShopReservationDetail"


import ReservationShopManager from "./components/listers/ReservationShopCards"
import ReservationShopDetail from "./components/listers/ReservationShopDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/payments/payments',
                name: 'PaymentPaymentManager',
                component: PaymentPaymentManager
            },
            {
                path: '/payments/payments/:id',
                name: 'PaymentPaymentDetail',
                component: PaymentPaymentDetail
            },

            {
                path: '/shops/shopReservations',
                name: 'ShopShopReservationManager',
                component: ShopShopReservationManager
            },
            {
                path: '/shops/shopReservations/:id',
                name: 'ShopShopReservationDetail',
                component: ShopShopReservationDetail
            },


            {
                path: '/reservations/shops',
                name: 'ReservationShopManager',
                component: ReservationShopManager
            },
            {
                path: '/reservations/shops/:id',
                name: 'ReservationShopDetail',
                component: ReservationShopDetail
            },



    ]
})

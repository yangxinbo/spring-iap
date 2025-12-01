package com.github.zhongzichang.springiap.notification;

/**
 * App Store 服务器通知类型枚举.
 * <p>
 * 表示 App Store 服务器发送的各种通知类型，用于实时监控应用内购买事件。
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/notificationtype">NotificationType on developer.apple.com</a>
 */
public enum NotificationType {

  /**
   * 消耗型产品请求通知.
   * <p>
   * 当用户购买消耗型产品后，App Store 会发送此通知，要求服务器确认该产品已被消耗。
   */
  CONSUMPTION_REQUEST,

  /**
   * 续订偏好设置变更通知.
   * <p>
   * 当用户更改了自动续订订阅的偏好设置时发送此通知。
   */
  DID_CHANGE_RENEWAL_PREF,

  /**
   * 续订状态变更通知.
   * <p>
   * 当订阅的续订状态发生变化时发送此通知。
   */
  DID_CHANGE_RENEWAL_STATUS,

  /**
   * 续订失败通知.
   * <p>
   * 当订阅自动续订失败时发送此通知。
   */
  DID_FAIL_TO_RENEW,

  /**
   * 续订成功通知.
   * <p>
   * 当订阅成功自动续订时发送此通知。
   */
  DID_RENEW,

  /**
   * 订阅过期通知.
   * <p>
   * 当订阅过期时发送此通知。
   */
  EXPIRED,

  /**
   * 宽限期过期通知.
   * <p>
   * 当订阅的宽限期过期时发送此通知。
   */
  GRACE_PERIOD_EXPIRED,

  /**
   * 优惠券兑换通知.
   * <p>
   * 当用户兑换了订阅优惠券时发送此通知。
   */
  OFFER_REDEEMED,

  /**
   * 一次性购买通知.
   * <p>
   * 当用户购买一次性产品（消耗型或非消耗型应用内购买，或非续订订阅）时发送此通知。
   * <p>
   * 此通知类型在 App Store Server Notifications V2 中引入。
   */
  ONE_TIME_CHARGE,

  /**
   * 价格增长通知.
   * <p>
   * 当订阅价格增长且用户需要同意新价格时发送此通知。
   */
  PRICE_INCREASE,

  /**
   * 退款通知.
   * <p>
   * 当用户获得退款时发送此通知。
   */
  REFUND,

  /**
   * 退款被拒绝通知.
   * <p>
   * 当退款请求被拒绝时发送此通知。
   */
  REFUND_DECLINED,

  /**
   * 续订延长通知.
   * <p>
   * 当订阅的续订期被延长时发送此通知。
   */
  RENEWAL_EXTENDED,

  /**
   * 撤销通知.
   * <p>
   * 当订阅或购买被撤销时发送此通知。
   */
  REVOKE,

  /**
   * 订阅通知.
   * <p>
   * 当用户首次订阅或重新订阅时发送此通知。
   */
  SUBSCRIBED
}

package com.yt.tankgame.business

import com.yt.tankgame.View
import com.yt.tankgame.model.Direction

/**
 * <br>
 * function:
 * 运动接口
 * <p>
 * @author:Lyt
 * @date:2019/2/20 23:16
 * @since:v1.0
 * @desc:com.yt.tankgame
 */
interface Movable:View {
	//可移动物体存在方向
	val currentDirection: Direction

	//可移动物体需要移动的速度
	val speed: Int

	//判断移动物体是否和阻塞物体发生碰撞,返回的要碰撞的方向，若为null，则可以移动
	fun willCollision(blockable: Blockable): Direction?

	//通知碰撞
	fun notifyCollision(direction: Direction?,blockable: Blockable?)

}
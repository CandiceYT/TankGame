package com.yt.tankgame

/**
 * <br>
 * function: 显示的视图，定义显示规范
 * <p>
 * @author:Lyt
 * @date:2019/2/19 下午3:32
 * @since:v1.0
 * @desc:com.yt.tankgame
 */
interface View {
	//位置
	val x: Int
	val y: Int
	//宽高
	val width: Int
	val height: Int
	//显示
	fun draw()

}
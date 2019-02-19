package com.yt.tankgame.model

import com.yt.tankgame.GameConstants
import com.yt.tankgame.View
import org.itheima.kotlin.game.core.Painter

/**
 * <br>
 * function:
 * 水
 * <p>
 * @author:Lyt
 * @date:2019/2/19 下午3:08
 * @since:
 * @desc:com.yt.tankgame.model
 */
class Water(override val x: Int, override val y: Int) :View {

	//水的宽高
	override var width = GameConstants.BLOCK
	override var height = GameConstants.BLOCK
	//显示行为
	override fun draw() {
		Painter.drawImage("model/water.gif", x, y)
	}
}

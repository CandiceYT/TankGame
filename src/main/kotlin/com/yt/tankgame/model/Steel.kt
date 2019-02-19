package com.yt.tankgame.model

import com.yt.tankgame.GameConstants
import com.yt.tankgame.View
import org.itheima.kotlin.game.core.Painter


/**
 * <br>
 * function:
 * 铁墙
 * <p>
 * @author:Lyt
 * @date:2019/2/19 下午3:42
 * @since:v1.0
 * @desc:com.yt.tankgame.model
 */
class Steel(override val x: Int, override val y: Int) : View {

	override val width: Int = GameConstants.BLOCK
	override val height: Int = GameConstants.BLOCK

	override fun draw() {
		Painter.drawImage("model/steels.gif", x, y)
	}
}
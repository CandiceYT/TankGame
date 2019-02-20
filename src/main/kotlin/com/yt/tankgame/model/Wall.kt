package com.yt.tankgame.model

import com.yt.tankgame.GameConstants
import com.yt.tankgame.business.Blockable
import org.itheima.kotlin.game.core.Painter

/**
 * <br>
 * function:
 * 游戏中的砖墙
 * <p>
 * @author:Lyt
 * @date:2019/2/19 下午2:44
 * @since:
 * @desc:com.yt.tankgame
 */
class Wall(override val x: Int, override val y: Int) :Blockable {
	//墙的宽高
	override var width = GameConstants.BLOCK
	override var height = GameConstants.BLOCK
	//显示行为
	override fun draw() {
		Painter.drawImage("model/walls1.gif", x, y)
	}
}
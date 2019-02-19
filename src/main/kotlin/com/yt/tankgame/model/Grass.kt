package com.yt.tankgame.model

import com.yt.tankgame.GameConstants
import com.yt.tankgame.View
import org.itheima.kotlin.game.core.Painter

/**
 * <br>
 * function:
 * 草坪
 * <p>
 * @author:Lyt
 * @date:2019/2/19 下午2:53
 * @since:
 * @desc:com.yt.tankgame
 */
class Grass(override val x: Int, override val y: Int) :View {
	//草坪的宽高
	override val width: Int=GameConstants.BLOCK
	override val height: Int=GameConstants.BLOCK
	//显示行为
	override fun draw() {
		Painter.drawImage("model/grass.png", x, y)
	}
}
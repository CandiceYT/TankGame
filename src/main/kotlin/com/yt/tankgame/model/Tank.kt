package com.yt.tankgame.model

import com.yt.tankgame.GameConstants
import com.yt.tankgame.business.Blockable
import com.yt.tankgame.business.Movable
import org.itheima.kotlin.game.core.Painter

/**
 * <br>
 * function:
 * 我方坦克
 * <p>
 * @author:Lyt
 * @date:2019/2/19 下午4:28
 * @since:v1.0
 * @desc:com.yt.tankgame.model
 */
class Tank(override var x: Int, override var y: Int) : Movable {
	//坦克碰到的错误方向
	lateinit var badDirection: Direction

	override fun notifyCollision(direction: Direction?, blockable: Blockable?) {
//		接受碰撞消息
		badDirection = direction!!
	}

	//有问题ß
	override fun willCollision(blockable: Blockable): Direction? {
//		检测碰撞
		val collision: Boolean = when {
			//如果阻挡物在运动物的上方
			blockable.y + blockable.height <= y -> false
			//如果阻挡物在运动物的下方
			y + height <= blockable.y -> false
			//如果阻挡物在运动物的左方
			blockable.x + blockable.width <= x -> false
			else -> x + width > blockable.x
		}
       //TODO  当我方坦克周围没有阻挡物，意思走else条件，但是会出现坦克不能移动的现象，即走else条件的时候，返回的方向值不能为null
		return if (collision) currentDirection else null
	}


	override val width: Int = GameConstants.BLOCK
	override val height: Int = GameConstants.BLOCK

	//不同方向，坦克不一样
	override var currentDirection = Direction.UP
	//坦克移动的速度
	override var speed = 16

	override fun draw() {
		val imgPath = when (currentDirection) {
			Direction.UP -> "tank/p1tankU.gif"
			Direction.DOWM -> "tank/p1tankD.gif"
			Direction.LEFT -> "tank/p1tankL.gif"
			Direction.RIGHT -> "tank/p1tankR.gif"
		}
		Painter.drawImage(imgPath, x, y)
	}

	/**
	 *  坦克移动
	 *
	 * @author lei
	 * @date   2019/2/19 下午4:48
	 * @return
	 * @since  v1.0
	 */
	fun move(direction: Direction) {
//		判断是否要往碰撞的方向走,坦克就不走了
		if (direction == badDirection) {
			return
		}
		//只改变方向时，坐标不发生变化
		if (this.currentDirection != direction) {
			this.currentDirection = direction
			return
		}

		//坦克的坐标发生变化，根据不同方向，改变不同的坐标
		when (currentDirection) {
			Direction.UP -> {
				y -= speed
			}
			Direction.DOWM -> {
				y += speed
			}
			Direction.LEFT -> {
				x -= speed
			}
			Direction.RIGHT -> {
				x += speed
			}
		}

		//越界判断
		if (x < 0) x = 0
		if (x > GameConstants.windowWidth - width) x = GameConstants.windowWidth - width
		if (y < 0) y = 0
		if (y > GameConstants.windowHeight - height) y = GameConstants.windowHeight - height
	}
}
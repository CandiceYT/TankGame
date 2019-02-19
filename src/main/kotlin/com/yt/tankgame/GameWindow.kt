package com.yt.tankgame

import com.yt.tankgame.model.*
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import org.itheima.kotlin.game.core.Window
import java.io.File

/**
 * <br>
 * function:
 * 游戏窗口
 * <p>
 * @author:Lyt
 * @date:2019/2/19 上午9:44
 * @since:
 * @desc:
 */
class GameWindow : Window(title = "坦克大战1.0", icon = "tank/p1tankU.gif", width = GameConstants.windowWidth, height = GameConstants.windowHeight) {
	var views = arrayListOf<View>()
	private lateinit var tank:Tank
	//创建窗口
	override fun onCreate() {
		//创建地图，通过读文件的方式创建地图
		createMap()
		tank= Tank(GameConstants.BLOCK*10,GameConstants.BLOCK*12)
		views.add(tank)
	}

	/**
	 * 创建地图，通过读文件的方式创建地图
	 * @author lei
	 * @date   2019/2/19 下午4:38
	 * @return
	 * @since  v1.0
	 */
	private fun createMap() {
		val file = File(javaClass.getResource("/map/1.map").path)
		val readLines = file.readLines()
		var lineNum = 0
		readLines.forEach { line ->
			var columNum = 0
			line.toCharArray().forEach { colum ->
				when (colum) {
					'砖' -> views.add(Wall(columNum * GameConstants.BLOCK, lineNum * GameConstants.BLOCK))
					'铁' -> views.add(Steel(columNum * GameConstants.BLOCK, lineNum * GameConstants.BLOCK))
					'水' -> views.add(Water(columNum * GameConstants.BLOCK, lineNum * GameConstants.BLOCK))
					'草' -> views.add(Grass(columNum * GameConstants.BLOCK, lineNum * GameConstants.BLOCK))
				}
				columNum++
			}
			lineNum++
		}
	}

	//窗口渲染时候回调
	override fun onDisplay() {
		//绘制图像
       views.forEach {
		   it.draw()
	   }
	}

	//事件处理
	override fun onKeyPressed(event: KeyEvent) {
		when (event.code) {
           KeyCode.W ->tank.move(Direction.UP)
           KeyCode.S ->tank.move(Direction.DOWM)
           KeyCode.A ->tank.move(Direction.LEFT)
           KeyCode.D ->tank.move(Direction.RIGHT)
		}
	}

	//业务逻辑刷新
	override fun onRefresh() {

	}
}
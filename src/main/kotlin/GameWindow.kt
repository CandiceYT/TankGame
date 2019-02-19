import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import org.itheima.kotlin.game.core.Composer
import org.itheima.kotlin.game.core.Painter
import org.itheima.kotlin.game.core.Window

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
class GameWindow : Window() {
	//创建窗口
	override fun onCreate() {
		println("创建窗口")
	}

	//窗口渲染时候回调
	override fun onDisplay() {
		//绘制图片
		Painter.drawImage("p1tankU.gif", 200, 200)
        //绘制颜色
		Painter.drawColor(Color.WHITE, 20, 20, 100, 100)
		//绘制文本
		Painter.drawText("您好", 50, 50)
	}

	//事件处理
	override fun onKeyPressed(event: KeyEvent) {
		when (event.code) {
			KeyCode.ENTER -> println("点击了enter键")
			KeyCode.K -> Composer.play("blast.wav")
		}
	}

	//业务逻辑刷新
	override fun onRefresh() {

	}
}
import javafx.application.Application

/**
 * <br>
 * function:
 * 程序入口
 * <p>
 * @author:Lyt
 * @date:2019/2/19 上午9:45
 * @since:
 * @desc:
 */
object Main {
	@JvmStatic
	fun main(args:Array<String>){
		Application.launch(GameWindow::class.java)
	}
}
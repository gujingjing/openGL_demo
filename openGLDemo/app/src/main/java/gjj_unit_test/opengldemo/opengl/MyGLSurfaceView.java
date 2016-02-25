package gjj_unit_test.opengldemo.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

/**
 * 作者：gjj on 2016/2/25 10:54
 * 邮箱：Gujj512@163.com
 */
public class MyGLSurfaceView extends GLSurfaceView{

    public MyGLSurfaceView(Context context) {
        super(context);
        init();
    }

    public MyGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public void init(){
        setRenderer(new MyRenderer());//你需要扩展这个类，在它的构造方法中设置渲染器：
        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);//如果使用OpenGL ES 2.0，还需要加一句声明：
        //还有一个可选的设置是，把渲染模式改为 GLSurfaceView.RENDERMODE_WHEN_DIRTY ，这样仅在你的数据有变化时重新进行渲染。
        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
//        除非你调用requestRender()，这个设置会阻止帧被重画，有些情况下这样效率更高。
// 注意上面语句的顺序，反了可能会出错
    }
}

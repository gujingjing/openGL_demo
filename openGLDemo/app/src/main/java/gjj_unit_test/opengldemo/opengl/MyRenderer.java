package gjj_unit_test.opengldemo.opengl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import java.nio.IntBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * 作者：gjj on 2016/2/25 10:35
 * 邮箱：Gujj512@163.com
 */
public class MyRenderer implements GLSurfaceView.Renderer {

    int one=0x10000;
    private  int[] triggerBuffer=new int[]{
            0,one,0,     //上顶点
            -one,-one,0,    //左顶点
            one,-one,0    //右下点
    };

    private int[] colorBuffer=new int[]{
            one,0,0,one,
            0,one,0,one,
            0,0,one,one
    };
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // Set the background frame color
//        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        /**
         * glHint 用于告诉 OpenGL 我们希望进行最好的透视修正，这会轻微地影响性能，但会使得透视图更好看。
         glClearColor 设置清除屏幕时所用的颜色，色彩值的范围从 0.0f~1.0f 大小从暗到这的过程。
         glShadeModel 用于启用阴影平滑度。阴影平滑通过多边形精细地混合色彩，并对外部光进行平滑。
         glDepthFunc 为将深度缓存设想为屏幕后面的层，它不断地对物体进入屏幕内部的深度进行跟踪。
         glEnable 启用深度测试。
         */
        // 启用阴影平滑
        gl.glShadeModel(GL10.GL_SMOOTH);
        // 黑色背景
        gl.glClearColor(0, 0, 0, 0);
        // 设置深度缓存
        gl.glClearDepthf(1.0f);
        // 启用深度测试
        gl.glEnable(GL10.GL_DEPTH_TEST);
        // 所作深度测试的类型
        gl.glDepthFunc(GL10.GL_LEQUAL);
        // 告诉系统对透视进行修正
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
//        GLES20.glViewport(0, 0, width, height);
        /**
         * gl.glMatrixMode(GL10.GL_PROJECTION); 指明接下来的代码将影响 projection matrix （投影矩阵），投影矩阵负责为场景增加透视度。
         gl.glLoadIdentity(); 此方法相当于我们手机的重置功能，它将所选择的矩阵状态恢复成原始状态，调用  glLoadIdentity(); 之后为场景设置透视图。
         gl.glMatrixMode(GL10.GL_MODELVIEW);   指明任何新的变换将会影响 modelview matrix （模型观察矩阵）。
         gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10); 此方法，前面4个参数用于确定窗口的大小，而后面两个参数分别是在场景中所能绘制深度的起点和终点。
         */
        float ratio = (float) width / height;
        //设置OpenGL场景的大小
        gl.glViewport(0, 0, width, height);
        //设置投影矩阵
        gl.glMatrixMode(GL10.GL_PROJECTION);
        //重置投影矩阵
        gl.glLoadIdentity();
        // 设置视口的大小
        gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
        // 选择模型观察矩阵
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        // 重置模型观察矩阵
        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // 清除屏幕和深度缓存
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        // 重置当前的模型观察矩阵
        gl.glLoadIdentity();


        gl.glTranslatef(-1.5f, 0.0f, -6.0f);//??????????????????
        //设置旋转
//        gl.glRotatef(rotateTri, 0.0f, 1.0f, 0.0f);

        //设置定点数组
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        //设置颜色数组
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        gl.glColorPointer(4, GL10.GL_FIXED, 0,  OpenGLUtil.bufferUtil(colorBuffer));
        // 设置三角形顶点
        gl.glVertexPointer(3, GL10.GL_FIXED, 0, OpenGLUtil.bufferUtil(triggerBuffer));
        //绘制三角形
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

        //绘制三角形结束
        gl.glFinish();
    }
}

#什么是OpenGL

OpenGL是一个专业的3D程序接口,OpenGL 的前身是 SGI 公司为其图形工作站开的 IRIS GL。IRIS GL 是一个工业标准的3D图形软件接口，功能虽然强大但是移植性不好，于是 SGI 公司便在 IRIS GL 的基础上开发OpenGL
具体详细的介绍请 [点击这里](http://detail.zol.com.cn/product_param/index3397.html)
#Android OpenGL ES 简介
    Android系统使用 OpenGL 的标准接口来支持3D图形功能，android 3D 图形系统也分为 java 框架和本地代                  码两部分。本地代码主要实现的 OpenGL接口的库，在 Java 框架层，      javax.microedition.khronos.opengles 是 java 标准的 OpenGL包，android.opengl包提供了OpenGL系统和 Android GUI 系统之间的联系。

#Android 支持 OpenGL 列表
1. GL
2. GL 10
3. GL 10 EXT
4. GL 11
5. GL 11 EXT
6. GL 11 ExtensionPack

我们将使用 GL10 这个类开始接触 OpenGL ，探索3D 领域。

#GLSurfaceView
    GLSurfaceView是Android应用程序中实现OpenGl画图的重要组成部分。GLSurfaceView中封装了一个Surface。而android平台下关于图像的现实，差不多都是由Surface来实现的。

#Renderer
    有了GLSurfaceView之后，就相当于我们有了画图的纸。现在我们所需要做的就是如何在这张纸上画图。所以我们需要一支笔。
    Renderer是GLSurfaceView的内部静态接口，它就相当于在此GLSurfaceView上作画的笔。我们通过实现这个接口来“作画”。最后通过GLSurfaceView的setRenderer(GLSurfaceView.Renderer renderer)方法，就可以将纸笔关联起来了。
    实现Renderer需要实现它的三个接口：onSurfaceCreated(GL10 gl, EGLConfig config)、 onSurfaceChanged(GL10 gl, int width, int height)、onDrawFrame(GL10 gl)。下面就这三个接口的具体意义做个简单的介绍。

1. **onSurfaceCreated**

>此方法看名字就知道它是在Surface创建的时候被调用的。因此我们可以在这个函数的实现中做一些初始                       化的工作。例如取出文房四宝、铺好画布、调好颜料之类的。它的函数原型如下：public abstract void     onSurfaceCreated (GL10 gl, EGLConfig config)第二个参数在文档中没有关于它的任何public方法和域。因此我们可以不用管它。第一个参数非常重要。如果说Renderer是画笔的话，那么这个gl参数，就可以说是我们的手了。如何操作这支画笔，都是它说了算！所以我们绝大部分时候都是通过这个叫做gl的手来指挥Renderer画图的。

2. **onSurfaceChanged**

>当GLSurfaceView大小改变时，对应的Surface大小也会改变。值得注意的是，在Surface刚创建的时候，它的size其实是0，也就是说在画第一次图之前它也会被调用一次的。（而且对于很多时候，Surface的大小是不会改变的，那么此函数就只在创建之初被调用一次而已）
>原型如下：
public abstract void onSurfaceChanged (GL10 gl, int width, int height)
同样的，画图的手是必需的。
另外值得注意的是，它告诉了我们这张纸有多高多宽。这点很重要。因为在onSurfaceCreated的时候我们是不知道纸的宽高的，所以有一些和长宽相关的初始化工作还得在此函数中来做。

3. **onDrawFrame**

>好了，我们的初始化工作做得差不多了，那么现在就是该真刀真枪画画的时候了！此函数就是真正给你画画用的。每调用一次就画一幅图。可能的疑问是这个函数什么时候会被调
用呢？最开始的时候肯定是会被调用的。以后会有两种模式供你选择：

>RENDERMODE_CONTINUOUSLY
RENDERMODE_WHEN_DIRTY
第一种模式（RENDERMODE_CONTINUOUSLY）：
连续不断的刷，画完一幅图马上又画下一幅。这种模式很明显是用来画动画的；


>第二种模式（RENDERMODE_WHEN_DIRTY）：
只有在需要重画的时候才画下一幅。这种模式就比较节约CPU和GPU一些，适合用来画不经常需要刷新的情况。多说一句，系统如何知道需要重画了呢？当然是你要告诉它……
调用GLSurfaceView的requestRender ()方法，告诉它，你脏了。


>这两种模式在什么地方设置呢? GLSurfaceView的setRenderMode(int renderMode)方法。可以供你设置你需要的刷新模式。


>还是来看看这个函数的原型吧： public abstract void onDrawFrame (GL10 gl) 很简单，只有手。

[参考文档1](http://www.cnblogs.com/mengdd/archive/2013/05/02/3055649.html)
[参考文档2](http://blog.csdn.net/jason0539/article/details/9164885)
[参考文档3](http://www.cnblogs.com/TerryBlog/archive/2010/07/09/1774475.html)

[github项目地址]()

package gjj_unit_test.opengldemo;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import gjj_unit_test.opengldemo.opengl.GLRender;
import gjj_unit_test.opengldemo.opengl.MyRenderer;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GLSurfaceView gview=new GLSurfaceView(this);
        gview.setRenderer(new MyRenderer());
//        gview.setRenderer(new GLRender());
        setContentView(gview);
    }

}

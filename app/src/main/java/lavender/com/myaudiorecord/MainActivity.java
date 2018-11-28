package lavender.com.myaudiorecord;

import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isRecord = false;
    private AudioRecorder audioRecorder;

    private TextView timeTips;
    private RelativeLayout micLayout;
    private ImageView mic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioRecorder = new AudioRecorder();
        initView();
        initEvent();
    }


    public void initView() {
        timeTips = (TextView) findViewById(R.id.tv_video_time);
        micLayout = (RelativeLayout) findViewById(R.id.mic_img_relative);
        mic = (ImageView) findViewById(R.id.mic_img);
        timeTips.setVisibility(View.INVISIBLE);
    }

    public void initEvent() {
        micLayout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        isRecord = !isRecord;
        if (isRecord) {
            mic.setSelected(true);
            Toast.makeText(this, "start", Toast.LENGTH_SHORT).show();
            timeTips.setVisibility(View.VISIBLE);
            audioRecorder.startAudioRecording();
        } else {
            mic.setSelected(false);
            Toast.makeText(this, "stop", Toast.LENGTH_SHORT).show();
            timeTips.setVisibility(View.INVISIBLE);
            audioRecorder.stopAudioRecording();
        }
//        String path= Environment.getExternalStorageDirectory().getAbsolutePath();
//        final AudioCodec audioCodec=AudioCodec.newInstance();
//        audioCodec.setEncodeType(MediaFormat.MIMETYPE_AUDIO_MPEG);
//        audioCodec.setIOPath(path + "/test.aac", path + "/test.mp3");
//        audioCodec.prepare();
//        audioCodec.startAsync();
//        audioCodec.setOnCompleteListener(new AudioCodec.OnCompleteListener() {
//            @Override
//            public void completed() {
//                audioCodec.release();
//            }
//        });
    }
}

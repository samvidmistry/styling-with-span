package in.samvidinfotech.spanstyles;

import android.content.res.ColorStateList;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Toast;

import in.samvidinfotech.spanstyles.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        SpannableString relative = new SpannableString("This text is relatively small or large");
        relative.setSpan(new RelativeSizeSpan(1.5f), relative.length() - 5, relative.length(), 0);
        relative.setSpan(new RelativeSizeSpan(0.5f), relative.length() - 14, relative.length() - 9,
                0);
        mBinding.relative.setText(relative);

        SpannableString color = new SpannableString("String with red background");
        color.setSpan(new BackgroundColorSpan(Color.RED), color.length() - "background".length(),
                color.length(), 0);
        mBinding.background.setText(color);

        SpannableString bullet = new SpannableString("String with bullet point");
        bullet.setSpan(new BulletSpan(5, Color.RED), 0, bullet.length(), 0);
        mBinding.bullet.setText(bullet);

        SpannableString clickable = new SpannableString("To see click demo, click here");
        clickable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(widget.getContext(), "You just clicked there", Toast.LENGTH_LONG)
                        .show();
            }
        }, clickable.length() - "click here".length(), clickable.length(), 0);
        mBinding.clickable.setMovementMethod(new LinkMovementMethod());
        mBinding.clickable.setText(clickable);

        SpannableString image = new SpannableString("String with <- image");
        int start = image.length() - " <- image".length();
        image.setSpan(new ImageSpan(this, R.mipmap.ic_launcher), start, start+1, 0);
        mBinding.image.setText(image);

        SpannableString appearance = new SpannableString("String with different appearance and link appearance");
        appearance.setSpan(new TextAppearanceSpan("serif", 0, 30,
                ColorStateList.valueOf(Color.WHITE), ColorStateList.valueOf(Color.BLUE)), 22,
                32, 0);
        appearance.setSpan(new BackgroundColorSpan(Color.RED), 22, 32, 0);
        appearance.setSpan(new TextAppearanceSpan("serif", 0, 30,
                        ColorStateList.valueOf(Color.WHITE), ColorStateList.valueOf(Color.BLUE)),
                37, appearance.length(), 0);
        appearance.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(widget.getContext(), "That is a link", Toast.LENGTH_SHORT).show();
            }
        }, appearance.length() - "link appearance".length(), appearance.length(), 0);
        mBinding.appearance.setMovementMethod(new LinkMovementMethod());
        mBinding.appearance.setText(appearance);

        SpannableString url = new SpannableString("Click here to open a URL");
        url.setSpan(new URLSpan("http://www.samvidinfotech.in"), 0, "click here".length(), 0);
        mBinding.url.setMovementMethod(new LinkMovementMethod());
        mBinding.url.setText(url);
    }
}

package com.mckinsey.academy.xblocks.utils;

        import android.text.Html;
        import android.text.Spanned;

/**
 * Created by Tabish Hussain on 8/23/2017.
 */

public class XBlockUtils {

    // https://stackoverflow.com/questions/37904739/html-fromhtml-deprecated-in-android-n
    @SuppressWarnings("deprecation")
    public static Spanned getTextFromHTML(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }
}
